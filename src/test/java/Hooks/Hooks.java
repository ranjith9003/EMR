package Hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utilities.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Hooks {

    private static ExtentReports extent;
    private static Map<String, ExtentTest> featureMap = new HashMap<>();
    private static ThreadLocal<ExtentTest> scenarioNode = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return scenarioNode.get();
    }

    @Before
    public void setUp(Scenario scenario) throws IOException {
        ScenarioContext.scenario = scenario;

        // 📊 Setup Extent Report
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/extent-report.html");
        //    spark.loadXMLConfig(ClassLoader.getSystemResource("extent-config.xml").getPath());

            spark.config().setReportName("EMR Test Execution Report");
            spark.config().setDocumentTitle("EMR Automation Report");
            spark.config().setTimelineEnabled(true);
            spark.config().setOfflineMode(true); // ✅ offline CSS/JS for portability
            spark.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
            extent.setSystemInfo("Browser", System.getProperty("browser", "chrome"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
        }

        // 🧭 Initialize WebDriver
        String browser = System.getProperty("browser", "chrome");
        WebDriver driver = DriverFactory.getDriver(browser);
        BaseClass.driver = driver;

        Collection<String> tags = scenario.getSourceTagNames();

        if (tags.contains("@keepBrowserOpen")) {
            try {
                String currentUrl = driver.getCurrentUrl();
                if (currentUrl == null || !currentUrl.contains("login")) {
                    driver.get(ConfigReader.get("app.url"));
                }
            } catch (Exception e) {
                driver.get(ConfigReader.get("app.url"));
            }
        }

        // 🧾 Resolve feature name
        String uri = scenario.getUri() != null ? scenario.getUri().toString() : "default.feature";
        String featureName = uri.substring(uri.lastIndexOf("/") + 1).replace(".feature", "");

        Map<String, String> tagToSheetKey = Map.of(
            "@case", "excel.sheetName_case",
            "@order", "excel.sheetName",
            "@accession", "excel.sheetName_accession",
            "@covidflu", "excel.sheetName_covidflu",
            "@UTICase", "excel.sheetName_UTI_case",
            "@UTIorder", "excel.sheetName_UTI_order",
            "@clinicalChemistry", "excel.sheetName_CC_order",
            "@urinalysis", "excel.sheetName_urinalysis"
        );

        String sheet = ConfigReader.get("excel.sheetName_default");
        for (String tag : tags) {
            String lowerTag = tag.toLowerCase();
            for (Map.Entry<String, String> entry : tagToSheetKey.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(lowerTag)) {
                    sheet = ConfigReader.get(entry.getValue());
                    if (sheet == null || sheet.isEmpty()) {
                        System.err.println("⚠️ Sheet not found for key: " + entry.getValue());
                        sheet = ConfigReader.get("excel.sheetName");
                    }
                    break;
                }
            }
        }

        // 📥 Excel Load Logic
        try {
            String path = ConfigReader.get("excel.filePath");
            String rowIndexProp = System.getProperty("execution.counter");

            if (rowIndexProp != null) {
                ScenarioContext.isBulkMode = true;
                int rowIndex = Integer.parseInt(rowIndexProp);
                ScenarioContext.testData = ExcelUtils.getRowData(path, sheet, rowIndex + 1);
                System.out.println("📘 Bulk Mode via execution.counter: Loaded Row Index " + rowIndex);
            } else {
                Optional<String> rowTag = tags.stream()
                    .filter(tag -> tag.toLowerCase().startsWith("@row=")).findFirst();

                if (rowTag.isPresent()) {
                    ScenarioContext.isBulkMode = false;
                    int row = Integer.parseInt(rowTag.get().substring(5));
                    ScenarioContext.testData = ExcelUtils.getRowData(path, sheet, row);
                    System.out.println("📘 Row Tag: Loaded Row " + row);
                } else {
                    int rowIndex = Integer.parseInt(ConfigReader.get("excel.rowNum"));
                    ScenarioContext.testData = ExcelUtils.getRowData(path, sheet, rowIndex);
                    System.out.println("📘 Default Row: Loaded Row " + rowIndex);
                }
            }

        } catch (Exception e) {
            System.err.println("❌ Excel Load Failed: " + e.getMessage());
            ScenarioContext.testData = new HashMap<>();
        }

        // 🧾 Extent Report Scenario Block
        try {
            ExtentTest featureTest = featureMap.computeIfAbsent(featureName,
                    k -> extent.createTest("Feature: " + k));
            ExtentTest scenarioTest = featureTest.createNode("Scenario: " + scenario.getName());

            if (!tags.isEmpty()) {
                scenarioTest.assignCategory(tags.toArray(new String[0]));
            }

            scenarioTest.assignAuthor("AutomationTeam");
            scenarioNode.set(scenarioTest);
        } catch (Exception e) {
            System.err.println("⚠️ Extent Report Initialization Failed: " + e.getMessage());
        }
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (getTest() != null) {
            if (scenario.isFailed()) {
                getTest().log(Status.FAIL, "🔴 Step failed.");
            } else {
                getTest().log(Status.PASS, "🟢 Step passed.");
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            WebDriver driver = BaseClass.driver;

            if (driver != null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                String base64 = ts.getScreenshotAs(OutputType.BASE64);

                File screenshotDir = new File("target/extent-reports/screenshots");
                if (!screenshotDir.exists()) screenshotDir.mkdirs();

                String fileName = scenario.getName().replaceAll("[^a-zA-Z0-9.-]", "_") + "_" + UUID.randomUUID() + ".png";
                try (FileOutputStream out = new FileOutputStream(new File(screenshotDir, fileName))) {
                    out.write(screenshot);
                }

                if (getTest() != null) {
                    getTest().addScreenCaptureFromBase64String(base64, "📸 Screenshot");
                }
                scenario.attach(screenshot, "image/png", "Screenshot");
            }

            if (getTest() != null) {
                if (scenario.isFailed()) {
                    getTest().log(Status.FAIL, "❌ Scenario Failed");
                } else {
                    getTest().log(Status.PASS, "✅ Scenario Passed");
                }
            }

        } catch (Exception e) {
            if (getTest() != null) {
                getTest().log(Status.WARNING, "⚠️ Error in tearDown: " + e.getMessage());
            } else {
                System.err.println("⚠️ Error in tearDown (Extent not initialized): " + e.getMessage());
            }
        } finally {
            if (!scenario.getSourceTagNames().contains("@keepBrowserOpen")) {
                DriverFactory.quitDriver();
            }
            scenarioNode.remove();
        }
    }

    @AfterAll
    public static void afterAll() {
        try {
            if (extent != null) {
                extent.flush();
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
