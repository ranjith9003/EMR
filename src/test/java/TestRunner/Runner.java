package TestRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/Feature",        // Path to your .feature files
    glue = {
        "StepDefinition",        // UI step definitions
        "api",                   // API validation steps
        "Hooks"                  // Hooks (Before, After, etc.)
    },	
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-html-report.html", // Cucumber's native HTML report
        "json:target/cucumber-reports/cucumber.json",             // Cucumber's native JSON report
        "utilities.ExtentReportListener"                          // Your custom Extent Report Listener
    },
    monochrome = true,                             // Cleaner console output
    dryRun = false,                                // Set to true to check step mappings without running
    tags = "@clinicalChemistry"                                // Tags to filter scenarios to run
)

public class Runner {

}
