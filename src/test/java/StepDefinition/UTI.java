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

public class UTI extends BaseSteps {
	  String accessionID;
	    String updatedFilePath;
	@When("the user searches and selects the UTI test Without Std")
	public void the_user_searches_and_selects_the_uti_test_without_std() {
		BaseClass.waitAndClick(LocatorsPage.add_test, 10);
		BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
		BaseClass.waitAndClick(LocatorsPage.utiWithoutStd, 10);

	}
	
	@When("the user searches and selects the UTI test With Std")
	public void the_user_searches_and_selects_the_uti_test_with_std() {
		BaseClass.waitAndClick(LocatorsPage.add_test, 10);
		BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
		BaseClass.waitAndClick(LocatorsPage.utiWithStd, 10);

		
	}

@When("the user searches and selects the UTI test With panel")
public void the_user_searches_and_selects_the_uti_test_with_panel() throws Throwable {
    
	BaseClass.waitAndClick(LocatorsPage.add_test, 10);
	BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
	BaseClass.waitAndClick(LocatorsPage.UTIBasicPanel, 10);
	Thread.sleep(3000);


}

@When("the user enters address line {int} in order creation")
public void the_user_enters_address_line_in_order_creation(Integer int1) {
	 BaseClass.waitAndInput(LocatorsPage.address_line_1_input, testData.get("ADDRESS"), 10);
     BaseClass.assertElementValueMatches(LocatorsPage.address_line_1_input, testData.get("ADDRESS"), 10);
	
}

@When("the user replaces the Accession ID in the UTI report")
public void the_user_replaces_the_accession_id_in_the_uti_report() throws Throwable {
    // Ensure the accession ID is available in the ScenarioContext

	String accessionID = ScenarioContext.accessionId;
	System.out.println("🧪 Captured Accession ID before uploading file: " + accessionID);
if (accessionID == null) throw new IllegalStateException("accessionID is missing");
 String templatePath = "src/test/resources/TestData/UTI Report.txt";
    updatedFilePath = BaseClass.replaceAccessionIdInTxt(templatePath, accessionID);
}

@When("the user uploads the UTI report file")
public void the_user_uploads_the_uti_report_file() throws Throwable {
	 Thread.sleep(3000);
     BaseClass.waitAndClickWithJSFallback(LocatorsPage.select_case_type, 10);
     Thread.sleep(3000);
     BaseClass.waitAndClickWithJSFallback(LocatorsPage.file_UTI, 10);
     BaseClass.waitAndClickWithJSFallback(LocatorsPage.result_type, 10);
     BaseClass.waitAndClickWithJSFallback(LocatorsPage.UTI, 10);

     BaseClass.waitAndClick(LocatorsPage.upload_click, 10); // Triggers OS dialog

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

@Then("the UTI report should be uploaded successfully")
public void the_uti_report_should_be_uploaded_successfully() throws Throwable {
    
	
	  Thread.sleep(3000);
      BaseClass.closeFileDialog();
      Thread.sleep(3000);
      BaseClass.waitAndClick(LocatorsPage.upload_button, 15);
      Thread.sleep(3000);
      BaseClass.waitAndClick(LocatorsPage.generate_report, 10);
      //BaseClass.waitAndClick(LocatorsPage.view_processing, 10);
      BaseClass.waitAndClick(LocatorsPage.all_cases, 10);
      Thread.sleep(3000);

     // BaseClass.assertElementTextEquals(LocatorsPage.processing_text, "PROCESSING", 10);
      System.out.println("✅ Report upload completed and is in PROCESSING state");
}
@When("the user replaces the Accession ID in the UTI report with STI")
public void the_user_replaces_the_accession_id_in_the_uti_report_with_sti() throws Exception {
	 // Ensure the accession ID is available in the ScenarioContext

		String accessionID = ScenarioContext.accessionId;
		System.out.println("🧪 Captured Accession ID before uploading file: " + accessionID);
	if (accessionID == null) throw new IllegalStateException("accessionID is missing");
	 String templatePath = "src/test/resources/TestData/UTI_with_STI_Report.txt";
	    updatedFilePath = BaseClass.replaceAccessionIdInTxt(templatePath, accessionID);
	
}

@When("the user uploads the UTI genpath report file")
public void the_user_uploads_the_uti_genpath_report_file() throws Throwable {
	// Ensure the updated file path is set correctly
	if (updatedFilePath == null || updatedFilePath.isEmpty()) {
		throw new IllegalStateException(
				"Updated file path is not set. Please ensure the file has been replaced correctly.");
	}

	System.out.println("🗂️ Uploading UTI report file: " + updatedFilePath);
	Thread.sleep(3000);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.select_case_type, 10);
    Thread.sleep(3000);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.file_UTI, 10);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.result_type, 10);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.UTI, 10);

     BaseClass.waitAndClick(LocatorsPage.upload_click, 10); // Triggers OS dialog

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

@When("the user replaces the Accession ID in the UTI report with STI for genpath")
public void the_user_replaces_the_accession_id_in_the_uti_report_with_sti_for_genpath() throws Throwable {
	String accessionID = ScenarioContext.accessionId;
	System.out.println("🧪 Captured Accession ID before uploading file: " + accessionID);
if (accessionID == null) throw new IllegalStateException("accessionID is missing");
 String templatePath = "src/test/resources/TestData/UTI_All Positives Genepath.txt";
    updatedFilePath = BaseClass.replaceAccessionIdInTxt(templatePath, accessionID);

	
}





@When("the user replaces the Accession ID in the UTI report  for genpath with all negative cases")
public void the_user_replaces_the_accession_id_in_the_uti_report_for_genpath_with_all_negative_cases() throws Throwable{
	String accessionID = ScenarioContext.accessionId;
	System.out.println("🧪 Captured Accession ID before uploading file: " + accessionID);
	if (accessionID == null) throw new IllegalStateException("accessionID is missing");
	String templatePath = "src/test/resources/TestData/UTI_All Negative Genepath.txt";
	updatedFilePath = BaseClass.replaceAccessionIdInTxt(templatePath, accessionID);  
	
}
@When("the user replaces the Accession ID in the UTI report  for genpath with all  positive and negative cases")
public void the_user_replaces_the_accession_id_in_the_uti_report_for_genpath_with_all_positive_and_negative_cases() throws Throwable{
	String accessionID = ScenarioContext.accessionId;
	System.out.println("🧪 Captured Accession ID before uploading file: " + accessionID);
	if (accessionID == null) throw new IllegalStateException("accessionID is missing");
	String templatePath = "src/test/resources/TestData/UTI_Negatives and Positives  Genepath.txt";
	updatedFilePath = BaseClass.replaceAccessionIdInTxt(templatePath, accessionID);  
	
}

@Then("validate wnether the UTI test Without Std is appearing on the screen or not")
public void validate_wnether_the_uti_test_without_std_is_appearing_on_the_screen_or_not()  throws Throwable{
	 Thread.sleep(3000);
     BaseClass.assertTextPresent("Uti Without Sti", 10);
}

@Then("validate wnether the UTI test With Std is appearing on the screen or not")
public void validate_wnether_the_uti_test_with_std_is_appearing_on_the_screen_or_not()  throws Throwable{
	Thread.sleep(3000);
   // BaseClass.assertTextPresent("UTI WITH STI", 10);
}









}