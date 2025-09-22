package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ScenarioContext;

public class CreateAccession extends BaseSteps {
	@When("click on labsquire order")
	public void click_on_labsquire_order() {
	   BaseClass.waitAndClickWithJSFallback(LocatorsPage.labsquire_order, 10);
	}
	@When("click on the order id")
	public void click_on_the_order_id() throws Throwable {
		String order_id=BaseClass.getTextSafe(LocatorsPage.order_id, 10);
		 String order_ID =ScenarioContext.orderId;
			Thread.sleep(3000);
			BaseClass.scrollIntoView(LocatorsPage.order_id, 10);
			System.out.println("Order ID: " + order_id);
			System.out.println("ScenarioContext Order ID: " + order_ID);
			// Validate that the order ID from the page matches the one stored in
			// ScenarioContext
			BaseClass.assertTextEquals(order_id, order_ID, true, true);// Store the Order ID in ScenarioContext
		   BaseClass.waitAndClick(LocatorsPage.order_id, 10);

		
	}
	@When("click on save accession")
	public void click_on_save_accession() throws Throwable {
		Thread.sleep(3000);
		BaseClass.scrollByPixels(0, 1000);
		Thread.sleep(3000);
	  // BaseClass.scrollIntoView(LocatorsPage.create_accession, 10);
		BaseClass.waitAndClick(LocatorsPage.save_accession, 20);
		//BaseClass.assertTextPresent("Accession created successfully", 20);
		BaseClass.waitAndClick(LocatorsPage.save_accession_EMR_confirmation, 20);
		Thread.sleep(9000);

		
	}
	@When("get the accession id after the order is converted into case")
	public void get_the_accession_id_after_the_order_is_converted_into_case() throws Throwable{
		
		 BaseClass.waitForVisibility(LocatorsPage.all_cases, 20);
	     BaseClass.waitAndClickWithJSFallback(LocatorsPage.all_cases, 20);
	     Thread.sleep(9000);
		String accessionId = BaseClass.getTextSafe(LocatorsPage.accession_ID_DLW, 10, 10);
		System.out.println("Accession ID: " + accessionId);
		ScenarioContext.accessionId = accessionId; // Store the Accession ID in ScenarioContext
		//BaseClass.assertTextPresent("Accession created successfully", 10);
		System.out.println("✅ Accession created successfully!");
	}


	@Then("the First Name is displayed with correct value")
	public void the_first_name_is_displayed_with_correct_value() {

			BaseClass.waitForVisibility(LocatorsPage.first_name_verification, 10);
	        BaseClass.assertElementValueMatches(LocatorsPage.first_name_verification, testData.get("FIRST_NAME"), 10);
	        System.out.println("First Name is displayed with correct value: " + BaseClass.getTextSafe(LocatorsPage.first_name_verification, 10, 10));
	        System.out.println("✅ First Name is displayed with correct value!");
	}
	@Then("the Middle Name is displayed with correct value")
	public void the_middle_name_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Last Name is displayed with correct value")
	public void the_last_name_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Gender is displayed with correct value")
	public void the_gender_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Date of Birth is displayed with correct value")
	public void the_date_of_birth_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the EMR is displayed with correct value")
	public void the_emr_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Mobile Number is displayed with correct value")
	public void the_mobile_number_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Phone Number is displayed with correct value")
	public void the_phone_number_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Email is displayed with correct value")
	public void the_email_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Address Line {int} is displayed with correct value")
	public void the_address_line_is_displayed_with_correct_value(Integer int1) {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the County is displayed with correct value")
	public void the_county_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Zip is displayed with correct value")
	public void the_zip_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the State is displayed with correct value")
	public void the_state_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the City is displayed with correct value")
	public void the_city_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Race is displayed with correct value")
	public void the_race_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Ethnicity is displayed with correct value")
	public void the_ethnicity_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Medical Record Id is displayed with correct value")
	public void the_medical_record_id_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Case Type is displayed with correct value")
	public void the_case_type_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the STAT Case is displayed with correct value")
	public void the_stat_case_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Order Date is displayed with correct value")
	public void the_order_date_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Ordering Facility is displayed with correct value")
	public void the_ordering_facility_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Ordering Facility Branch is displayed with correct value")
	public void the_ordering_facility_branch_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Ordering Physician is displayed with correct value")
	public void the_ordering_physician_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Referring Physician is displayed with correct value")
	public void the_referring_physician_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Bill To is displayed with correct value")
	public void the_bill_to_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Order ID is displayed with correct value")
	public void the_order_id_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the ICD-{int} \\(Indicative) is displayed with correct value")
	public void the_icd_indicative_is_displayed_with_correct_value(Integer int1) {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Collection Date is displayed with correct value")
	public void the_collection_date_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Temperature is displayed with correct value")
	public void the_temperature_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}
	@Then("the Specimen Types are displayed with correct value")
	public void the_specimen_types_are_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Test Information is displayed with correct value")
	public void the_test_information_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Collection Date & Time is displayed with correct value")
	public void the_collection_date_time_is_displayed_with_correct_value() {
		//BaseClass.waitForVisibility(LocatorsPage., 10);


	}
	@Then("the Received Date & Time is displayed with correct value")
	public void the_received_date_time_is_displayed_with_correct_value() {

		//BaseClass.waitForVisibility(LocatorsPage., 10);

	}





}
