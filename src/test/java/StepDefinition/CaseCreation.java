package StepDefinition;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.ScenarioContext;

public class CaseCreation extends BaseSteps {

 
    @Given("the user is on the login page of DLW")
    public void the_user_is_on_the_login_page_of_dlw() {
		driver.get(ConfigReader.get("dev_dlw_url"));
		//LocatorsPage.loginPageTitle();
    }
    @When("the user click the add new case")
    public void the_user_click_the_add_new_case() {
        BaseClass.waitAndClick(LocatorsPage.newcase_button, 10);

    }
    @Then("the user should be logged in successfully for creating case")
    public void the_user_should_be_logged_in_successfully_for_creating_case() throws Throwable{
        BaseClass.assertTextPresent("NEW CASE", 10);
        Thread.sleep(3000);

    }
    @When("the user enters address line {int} in case")
    public void the_user_enters_address_line_in_case(Integer int1) {
    	 BaseClass.waitAndInput(LocatorsPage.address_line_1, testData.get("ADDRESS"), 10);
         BaseClass.assertElementValueMatches(LocatorsPage.address_line_1, testData.get("ADDRESS"), 10);
    	
    }
    @When("the user selects the case type for cases")
    public void the_user_selects_the_case_type_for_cases() {
       
		BaseClass.waitAndClick(LocatorsPage.case_type, 10);
		BaseClass.waitAndClick(LocatorsPage.particular_case_type, 10);
		 String selectedCaseType=  BaseClass.getTextSafe(LocatorsPage.caseType, 10, 10);
	      ScenarioContext.caseType = selectedCaseType; 
		
    }

    @When("the user enters the  collection date")
    public void the_user_enters_the_collection_date() throws Throwable{
    	BaseClass.waitAndClick(LocatorsPage.collection_date_input, 10);
    	Thread.sleep(2000);
   	 BaseClass.waitAndInput(LocatorsPage.collection_date_input, testData.get("COLLECTION_DATE"), 10);
    	BaseClass.assertElementValueMatches(LocatorsPage.collection_date_input, testData.get("COLLECTION_DATE"), 10);
    	
    }//BaseClass.waitAndClick(LocatorsPage.collection_date_select, 10);    }
    @When("the user enters the  received date")
    public void the_user_enters_the_received_date() {
    	BaseClass.waitAndClick(LocatorsPage.received_date_input, 10);
      	 BaseClass.waitAndInput(LocatorsPage.received_date_input, testData.get("RECEIVED_DATE"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.received_date_input, testData.get("RECEIVED_DATE"), 10);

    }
    @When("the user enters the ICD-{int} code in case")
    public void the_user_enters_the_icd_code_in_case(Integer int1) {
     	 BaseClass.waitAndInput(LocatorsPage.icd_code_select, testData.get("ICD"), 10);
         BaseClass.selectDropdownOptionByPartialText(LocatorsPage.icd_code_select, testData.get("ICD"), 10);
         BaseClass.assertElementValueMatches(LocatorsPage.icd_code_select, testData.get("ICD"), 10);

//new case created successfully
    	
    }
    @When("check if the case is already created and proceed")
    public void check_if_the_case_is_already_created_and_proceed() {
    	 try {
 	        // Check if the 'Next' button is visible
 	        if (BaseClass.isElementVisible(LocatorsPage.success_next, 10)) {
 	            BaseClass.waitAndClick(LocatorsPage.success_next, 10);
 	            System.out.println("✅ Already registered person");
 	        } else {
 	            System.out.println("🆕 User is a new patient");
 	            // You can add alternate handling here
 	        }
 	    } catch (Exception e) {
 	        System.err.println("⚠️ Exception during enrollment check: " + e.getMessage());
 	    }
      //   BaseClass.assertElementTextContainsWithRetry(LocatorsPage.success_message, "New Case Created Successfully", 10);


 	  
 }
    @Then("the new case information should be saved successfully")
    public void the_new_case_information_should_be_saved_successfully() {
    	BaseClass.scrollByPixels(0, 500);
       
    	 BaseClass.waitAndClick(LocatorsPage.save, 10);
    }

    @When("get the accession Id from the created case")
    public void get_the_accession_id_from_the_created_case() {
       
		String accessionId = BaseClass.getTextSafe(LocatorsPage.accession_id_table, 10);
		System.out.println("Accession ID: " + accessionId);
		ScenarioContext.accessionId = accessionId; // Store globally for other steps
    }






   
}
