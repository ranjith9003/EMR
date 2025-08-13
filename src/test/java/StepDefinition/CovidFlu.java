package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;
import utilities.ScenarioContext;
import utilities.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class CovidFlu extends BaseSteps {

    String accessionID;
    String updatedFilePath;

	@When("the user selects the case type as covidflu")
	public void the_user_selects_the_case_type_as_covidflu() {
		 BaseClass.waitAndClick(LocatorsPage.case_type, 10);
	        BaseClass.waitAndClick(LocatorsPage.particular_case_type_Flu, 10);
	       // String value= BaseClass.getValueFromElement(LocatorsPage.particular_case_type_Flu, 10);
	       // System.out.println("Selected case type: " + value);
	     // String selectedCaseType=  BaseClass.getTextSafe(LocatorsPage.particular_case_type_Flu, 10, 10);
	      //ScenarioContext.caseType = selectedCaseType; 
	      //  BaseClass.waitAndClick(LocatorsPage.body_element, 10);

	        BaseClass.assertTextPresent("Order Date", 10);
		
	}

@When("the user clicks the add test button for covidflu")
public void the_user_clicks_the_add_test_button_for_covidflu() throws Throwable{
	  BaseClass.waitAndClick(LocatorsPage.add_test_checkbox, 10);
      BaseClass.waitAndClick(LocatorsPage.covid_checkbox, 10);
      Thread.sleep(3000);
      BaseClass.assertTextPresent("COVID AND FLU", 10);
    //  BaseClass.waitAndClick(LocatorsPage.add_test_button, 10);
      BaseClass.scrollByPixels(0, 1100);


}


	@When("the user replaces the Accession ID of covidflu in the CSV")
	public void the_user_replaces_the_accession_id_of_covidflu_in_the_csv() throws IOException {
		String accessionID = ScenarioContext.accessionId;
		if (accessionID == null) throw new IllegalStateException("accessionID is missing");
		 String templatePath = "src/test/resources/TestData/Covid flu_Report.csv";
	        updatedFilePath = BaseClass.replaceAccessionIdInCsv(templatePath, accessionID);
	}





	@When("the user uploads the Covidflu report file")
	public void the_user_uploads_the_covidflu_report_file() throws Exception {
		 Thread.sleep(3000);
	        BaseClass.waitAndClickWithJSFallback(LocatorsPage.select_case_type, 10);
	        BaseClass.waitAndClickWithJSFallback(LocatorsPage.covidfFlu_file, 10);
	        BaseClass.waitAndClickWithJSFallback(LocatorsPage.upload_click, 10); // Triggers OS dialog

	        try {
	            WebElement fileInput = BaseClass.driver.findElement(By.xpath("//input[@type='file']"));
	            fileInput.sendKeys(updatedFilePath);
	            System.out.println("📁 File path sent via sendKeys: " + updatedFilePath);
	        } catch (Exception e) {
	            System.out.println("⚠️ sendKeys failed, using Robot class fallback...");
	          BaseClass.uploadUsingRobot(updatedFilePath);
	        }

	        BaseClass.waitForUploadCompletion(LocatorsPage.upload_button, 15);

	        Assert.assertTrue("❌ File does not exist: " + updatedFilePath, new File(updatedFilePath).exists());
	       // Assert.assertTrue("❌ File path doesn't contain Accession ID", updatedFilePath.contains(accessionID));
	    }
		
	}





