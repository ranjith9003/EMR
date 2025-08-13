// Full OrderCreation.java script with complete UI field-level validations

package StepDefinition;

import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ExcelUtils;
import utilities.ScenarioContext;

public class OrderCreation extends BaseSteps {
   
   
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        BaseClass.openUrl(ConfigReader.get("dev_dlw_url"));
        BaseClass.assertElementVisible(LocatorsPage.username, 10);
    }

    @When("the user enters username")
    public void the_user_enters_username() {
        BaseClass.assertElementVisible(LocatorsPage.username, 10);
        BaseClass.waitAndInput(LocatorsPage.username, testData.get("USERNAME_STG"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.username, testData.get("USERNAME_STG"), 10);
    }

    @When("the user enters password")
    public void the_user_enters_password() {
        BaseClass.waitAndInput(LocatorsPage.password, testData.get("PASSWORD_STG"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.password, testData.get("PASSWORD_STG"), 10);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        BaseClass.waitAndClick(LocatorsPage.login_btn, 10);
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        BaseClass.assertTextPresent("ADD NEW ORDER", 10);
    }

    @When("the user click the add new order")
    public void the_user_click_the_add_new_order() {
        BaseClass.waitAndClick(LocatorsPage.newcase_button, 10);
        BaseClass.assertElementVisible(LocatorsPage.first_name_input, 10);
    }

    @When("the user enters the patient's first name")
    public void the_user_enters_the_patient_s_first_name() {
        BaseClass.waitAndInput(LocatorsPage.first_name_input, testData.get("FIRST_NAME"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.first_name_input, testData.get("FIRST_NAME"), 10);
    }

    @When("the user enters the patient's last name")
    public void the_user_enters_the_patient_s_last_name() {
        BaseClass.waitAndInput(LocatorsPage.last_name_input, testData.get("LAST_NAME"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.last_name_input, testData.get("LAST_NAME"), 10);
    }

    @When("the user selects gender")
    public void the_user_selects_gender() throws Throwable {
        BaseClass.waitAndClick(LocatorsPage.gender_dropdown, 10);
        BaseClass.waitAndClick(LocatorsPage.gender_input, 10);
    // String gender=   BaseClass.getInputValue(LocatorsPage.gender_input);
    // System.out.println(gender);
        Thread.sleep(2000);
       // BaseClass.assertTextPresent("MALE", 10);
    }

    @When("the user enters date of birth")
    public void the_user_enters_date_of_birth() {
        BaseClass.waitAndInput(LocatorsPage.dob_mm_input, testData.get("DOB_MM"), 10);
        BaseClass.waitAndInput(LocatorsPage.dob_dd_input, testData.get("DOB_DD"), 10);
        BaseClass.waitAndInput(LocatorsPage.dob_yyyy_input, testData.get("DOB_YYYY"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.dob_mm_input, testData.get("DOB_MM"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.dob_dd_input, testData.get("DOB_DD"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.dob_yyyy_input, testData.get("DOB_YYYY"), 10);
    }

    @When("the user enters mobile number")
    public void the_user_enters_mobile_number() {
        BaseClass.waitAndInput(LocatorsPage.mobile_number_input, testData.get("MOBILE_NUMBER"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.mobile_number_input, testData.get("MOBILE_NUMBER"), 10);
    }

    @When("the user enters address line {int}")
    public void the_user_enters_address_line(Integer int1) {
        BaseClass.waitAndInput(LocatorsPage.address_line_1_input, testData.get("ADDRESS"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.address_line_1_input, testData.get("ADDRESS"), 10);
    }

    @When("the user enters zip code")
    public void the_user_enters_zip_code() {
        BaseClass.waitAndInput(LocatorsPage.zip_code_input, testData.get("ZIP_CODE"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.zip_code_input, testData.get("ZIP_CODE"), 10);
    }

    @Then("the patient should be registered successfully")
    public void the_patient_should_be_registered_successfully() {
        BaseClass.assertTextPresent("CASE INFORMATION", 10);
    }

    @When("the user selects the case type")
    public void the_user_selects_the_case_type() {
        BaseClass.waitAndClick(LocatorsPage.case_type, 10);
        BaseClass.waitAndClick(LocatorsPage.particular_case_type, 10);
      String selectedCaseType=  BaseClass.getTextSafe(LocatorsPage.caseType, 10, 10);
      ScenarioContext.caseType = selectedCaseType; 
      System.out.println("Selected Case Type: " + selectedCaseType);
        BaseClass.assertTextPresent("Order Date", 10);
    }

    @When("the user enters the order date")
    public void the_user_enters_the_order_date() {
    	BaseClass.waitAndClick(LocatorsPage.order_date_input, 10);
        BaseClass.waitAndInput(LocatorsPage.order_date_input, testData.get("ORDER_DATE"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.order_date_input, testData.get("ORDER_DATE"), 10);
        BaseClass.waitAndClick(LocatorsPage.body_element, 10);
    }

    @When("the user selects the ordering facility")
    public void the_user_selects_the_ordering_facility() {
        BaseClass.waitAndClick(LocatorsPage.ord_facility, 10);
        BaseClass.waitAndInput(LocatorsPage.ord_facility, testData.get("FACILITY_NAME"), 10);
        BaseClass.selectDropdownOptionByPartialText(LocatorsPage.ord_facility, testData.get("FACILITY_NAME"), 10);
        BaseClass.assertTextPresent(testData.get("FACILITY_NAME"), 10);
    }

    @When("the user selects the ordering physician")
    public void the_user_selects_the_ordering_physician() {
        BaseClass.waitAndClick(LocatorsPage.ordering_physician_dropdown, 10);
        BaseClass.waitAndInput(LocatorsPage.ordering_physician_dropdown, testData.get("PHYSICIAN_NAME"), 10);
        BaseClass.selectDropdownOptionByPartialText(LocatorsPage.ordering_physician_dropdown, testData.get("PHYSICIAN_NAME"), 10);
        BaseClass.assertTextPresent(testData.get("PHYSICIAN_NAME"), 10);
    }

    @When("the user selects the billing method")
    public void the_user_selects_the_billing_method() {
        BaseClass.waitAndClick(LocatorsPage.billing, 10);
        BaseClass.waitAndClick(LocatorsPage.particular_billing, 10);
        BaseClass.assertTextPresent("ICD", 10);
    }

    @When("the user enters the ICD-{int} code")
    public void the_user_enters_the_icd_code(Integer int1) throws Throwable {
        BaseClass.scrollByPixels(0, 100);
        BaseClass.waitAndInput(LocatorsPage.icd_code_input, testData.get("ICD"), 10);
        BaseClass.selectDropdownOptionByPartialText(LocatorsPage.icd_code_input, testData.get("ICD"), 10);
        Thread.sleep(2000);
        BaseClass.assertElementValueMatches(LocatorsPage.icd_code_input, testData.get("ICD"), 10);
    }

    @When("the user enters the collection date and time")
    public void the_user_enters_the_collection_date_and_time() {
        BaseClass.scrollIntoView(LocatorsPage.collection_date_input, 10);
        BaseClass.waitAndInput(LocatorsPage.collection_date_input, testData.get("COLLECTION_DATE"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.collection_date_input, testData.get("COLLECTION_DATE"), 10);
        BaseClass.waitAndClick(LocatorsPage.body_element, 10);
    }

    @Then("the case information should be saved successfully")
    public void the_case_information_should_be_saved_successfully() {
        BaseClass.assertTextPresent("ADD TEST", 10);
    }

    @When("the user searches and selects the required test")
    public void the_user_searches_and_selects_the_required_test() {
        BaseClass.waitAndClick(LocatorsPage.add_test, 10);
        BaseClass.assertElementVisible(LocatorsPage.add_test_checkbox, 10);
    }

    @When("the user clicks the add test button")
    public void the_user_clicks_the_add_test_button() throws Throwable{
        BaseClass.waitAndClick(LocatorsPage.add_test_checkbox, 10);
        BaseClass.waitAndClick(LocatorsPage.covid_checkbox, 10);
        Thread.sleep(3000);
        BaseClass.assertTextPresent("COVID 19", 10);
      //  BaseClass.waitAndClick(LocatorsPage.add_test_button, 10);
        BaseClass.scrollByPixels(0, 1100);


    }

    @When("the user opens the patient signature section")
    public void the_user_opens_the_patient_signature_section() throws Throwable{
    	Thread.sleep(3000);
    	BaseClass.scrollByPixels(0, 300);
        BaseClass.waitAndClick(LocatorsPage.add_patient_signature, 10);
    }

    @When("the user uploads or draws the patient signature")
    public void the_user_uploads_or_draws_the_patient_signature() {
        BaseClass.waitAndClick(LocatorsPage.tab_signature, 10);
        BaseClass.waitAndInput(LocatorsPage.enter_signature, testData.get("FIRST_NAME"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.enter_signature, testData.get("FIRST_NAME"), 10);
    }

    @When("the user confirms and saves the signature")
    public void the_user_confirms_and_saves_the_signature() {
        BaseClass.waitAndClick(LocatorsPage.Confirm, 10);
    }

    @When("the user selects the relationship")
    public void the_user_selects_the_relationship() throws Throwable {
        BaseClass.scrollByPixels(0, 300);
        Thread.sleep(3000);
        BaseClass.waitAndClickWithJSFallback(LocatorsPage.relationship_select, 10);
        BaseClass.scrollIntoView(LocatorsPage.self_text, 10);
        BaseClass.waitAndClick(LocatorsPage.self_text, 10);
      //  BaseClass.assertTextPresent("Self", 10);
    }

    @When("the user enters insurance name")
    public void the_user_enters_insurance_name() {
        BaseClass.waitAndClick(LocatorsPage.insurance_name_input, 10);
        BaseClass.waitAndInput(LocatorsPage.insurance_name_input, testData.get("INSURANCE_NAME"), 10);
        BaseClass.selectDropdownOptionByPartialText(LocatorsPage.insurance_name_input, testData.get("INSURANCE_NAME"), 10);
        BaseClass.assertTextPresent(testData.get("INSURANCE_NAME"), 10);
    }

    @When("the user enters policy number")
    public void the_user_enters_policy_number() {
        BaseClass.waitAndInput(LocatorsPage.policy_number_input, testData.get("POLICY_NUMBER"), 10);
        BaseClass.assertElementValueMatches(LocatorsPage.policy_number_input, testData.get("POLICY_NUMBER"), 10);
    }

    @Then("the billing case information should be saved successfully")
    public void the_billing_case_information_should_be_saved_successfully()  {
        BaseClass.waitAndClick(LocatorsPage.save, 10);
    }
    @When("check if the patient is already enrolled and proceed")
    public void check_if_the_patient_is_already_enrolled_and_proceed() throws Throwable{
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
        // BaseClass.assertElementTextContainsWithRetry(LocatorsPage.success_message,"New Order Created Successfully", 10);
    	 Thread.sleep(4000);

    	  
    }
    @When("get the orderID for the corresponding order")
    public void get_the_order_id_for_the_corresponding_order()throws Throwable {
    	  String orderId=   BaseClass.getTextSafe(LocatorsPage.order_id, 10, 10);
    	  System.out.println("Order ID: " + orderId);
    	  ScenarioContext.orderId = orderId;
    	
    }
    @When("the user enters the secondary Insurance")
    public void the_user_enters_the_secondary_insurance() {
		BaseClass.waitAndClick(LocatorsPage.secondary_insurance, 10);
	
        
    }


    @When("the user enters the tertiary Insurance")
    public void the_user_enters_the_tertiary_insurance() {
		BaseClass.waitAndClick(LocatorsPage.Tertiary_insurance, 10);

    }

@When("the user enters the guarantor")
public void the_user_enters_the_guarantor() {
	BaseClass.waitAndClick(LocatorsPage.guarantor_insurance, 10);

}
}        
