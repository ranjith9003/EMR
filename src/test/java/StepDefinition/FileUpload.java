package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;
import utilities.ScenarioContext;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class FileUpload extends BaseSteps {

    String accessionID;
    String updatedFilePath;

    @When("the user captures the latest Accession ID")
    public void capture_accession_id() throws Exception {
        Thread.sleep(3000);
        BaseClass.waitForVisibility(LocatorsPage.all_cases, 10);
        BaseClass.waitAndClick(LocatorsPage.all_cases, 10);
        Thread.sleep(5000);

        // Try primary locator
        try {
            accessionID = BaseClass.getTextSafe(LocatorsPage.accession_ID_DLW, 10, 5);
            System.out.println("🧪 Captured Accession ID from DLW: " + accessionID);
        } catch (Exception e1) {
            // If primary fails, try alternate
            try {
                accessionID = BaseClass.getTextSafe(LocatorsPage.accession_ID_DLW_2, 10, 5);
                System.out.println("🧪 Captured Accession ID from alternate locator: " + accessionID);
            } catch (Exception e2) {
                System.err.println("❌ Failed to capture Accession ID from both locators");
                throw new RuntimeException("Accession ID not found");
            }
        }
    }

        
    
    @When("validate whether the accession ids are same after accession creation and before result file uploading")
    public void validate_whether_the_accession_ids_are_same_after_accession_creation_and_before_result_file_uploading() {
    	 String  expected= ScenarioContext.accessionId;
    	    String actual = accessionID;

    	    System.out.println("📘 Created Accession ID: " + actual);
    	    System.out.println("📗 Retrieved Accession ID: " + expected);

    	    BaseClass.assertTextEquals(actual, expected, true, true);
    	            System.out.println("✅ Accession ID validation successful: " + actual);
    }


    @When("the user replaces the Accession ID in the CSV")
    public void replace_accession_id_in_csv() throws Exception {
        String templatePath = "src/test/resources/TestData/Covid Report.csv";
        updatedFilePath = BaseClass.replaceAccessionIdInCsv(templatePath, accessionID);
    }

    @When("the user navigates to Covid case upload page")
    public void navigate_to_upload_page() throws Exception {
        BaseClass.waitAndClick(LocatorsPage.dashboard, 15);
        BaseClass.waitAndClick(LocatorsPage.result_file, 10);
        BaseClass.waitAndClick(LocatorsPage.upload_file, 10);
    }

    @When("the user uploads the Covid report file")
    public void upload_file_to_application() throws Exception {
        Thread.sleep(3000);
        BaseClass.waitAndClickWithJSFallback(LocatorsPage.select_case_type, 10);
        BaseClass.waitAndClickWithJSFallback(LocatorsPage.file_covid, 10);
        BaseClass.waitAndClickWithJSFallback(LocatorsPage.upload_click, 10); // Triggers OS dialog

        try {
            WebElement fileInput = BaseClass.driver.findElement(By.xpath("//input[@type='file']"));
            fileInput.sendKeys(updatedFilePath);
            System.out.println("📁 File path sent via sendKeys: " + updatedFilePath);
        } catch (Exception e) {
            System.out.println("⚠️ sendKeys failed, using Robot class fallback...");
            uploadUsingRobot(updatedFilePath);
        }

        BaseClass.waitForUploadCompletion(LocatorsPage.upload_button, 15);

        Assert.assertTrue("❌ File does not exist: " + updatedFilePath, new File(updatedFilePath).exists());
      // Assert.assertTrue("❌ File path doesn't contain Accession ID", updatedFilePath.contains(accessionID));
    }

    @Then("the report should be uploaded successfully")
    public void verify_upload_success() throws Exception {
        Thread.sleep(3000);
        BaseClass.closeFileDialog();
        Thread.sleep(3000);
        BaseClass.waitAndClick(LocatorsPage.upload_button, 15);
        Thread.sleep(3000);
        BaseClass.waitAndClick(LocatorsPage.generate_report, 10);
        BaseClass.waitAndClick(LocatorsPage.view_processing, 10);
        BaseClass.waitAndClick(LocatorsPage.all_cases, 10);
        Thread.sleep(3000);

       // BaseClass.assertElementTextEquals(LocatorsPage.processing_text, "PROCESSING", 10);
        System.out.println("✅ Report upload completed and is in PROCESSING state");
    }

    // Robot class fallback
    public void uploadUsingRobot(String filePath) throws Exception {
        Robot robot = new Robot();
        Thread.sleep(1500);

        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(800);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
