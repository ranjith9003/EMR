package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;

public class Validations extends BaseSteps {
	@Then("verify whether we are receiving error message or not")
	public void verify_whether_we_are_receiving_error_message_or_not() throws Throwable {
	   
		BaseClass.getTextSafe(LocatorsPage.first_name_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.first_name_error, 0));
		BaseClass.assertTextPresent("First Name is Required!", 10);
		Thread.sleep(3000);
	}

	@Then("verify whether we are receiving error message or not for last name")
	public void verify_whether_we_are_receiving_error_message_or_not_for_last_name() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.Last_name_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Last_name_error, 0));
		BaseClass.assertTextPresent("Last Name is Required!", 10);
		Thread.sleep(3000);
	    
	}


	@Then("verify whether we are receiving error message or not for gender")
	public void verify_whether_we_are_receiving_error_message_or_not_for_gender() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.gender_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.gender_error, 0));
		BaseClass.assertTextPresent("Gender is Required!", 10);
		Thread.sleep(3000);
	    
	}

	@Then("verify whether we are receiving error message or not for date of birth")
	public void verify_whether_we_are_receiving_error_message_or_not_for_date_of_birth() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.DOB_Date_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.DOB_Date_error, 0));
		BaseClass.assertTextPresent("Date of Birth is Required!", 10);
		Thread.sleep(3000);
	    
	}

	@Then("verify whether we are receiving error message or not for mobile number")
	public void verify_whether_we_are_receiving_error_message_or_not_for_mobile_number() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.Mobile_number_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Mobile_number_error, 0));
		BaseClass.assertTextPresent("Mobile Number is Required!", 10);
		Thread.sleep(3000);
	    
	}
	@Then("verify whether we are receiving error message or not for address")
	public void verify_whether_we_are_receiving_error_message_or_not_for_address() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.address_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.address_error, 0));
		BaseClass.assertTextPresent(" is Required!", 10);
		Thread.sleep(3000);
	    
	}

	@Then("verify whether we are receiving error message or not for case type")
	public void verify_whether_we_are_receiving_error_message_or_not_for_case_type() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.case_type_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.case_type_error, 0));
		BaseClass.assertTextPresent("Case Types is Required!", 10);
		Thread.sleep(3000);
	    
	}

	@Then("verify whether we are receiving error message or not for order date")
	public void verify_whether_we_are_receiving_error_message_or_not_for_order_date() throws Throwable{
		BaseClass.getTextSafe(LocatorsPage.Order_date_error, 10);
		System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Order_date_error, 0));
		BaseClass.assertTextPresent("Invalid Ordering Date", 10);
		Thread.sleep(3000);
	    
	}

@Then("verify whether we are receiving error message or not for ordering facility")
public void verify_whether_we_are_receiving_error_message_or_not_for_ordering_facility() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.Ordering_facility__error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Ordering_facility__error, 0));
	BaseClass.assertTextPresent("Ordering Facility is Required!", 10);
	Thread.sleep(3000);
    
}

@Then("verify whether we are receiving error message or not for ICD-{int}")
public void verify_whether_we_are_receiving_error_message_or_not_for_icd(Integer int1) throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.ICD_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.ICD_error, 10));
	BaseClass.assertTextPresent("ICD 10 Codes is Required!", 10);
	Thread.sleep(3000);
    
}
@Then("verify whether we are receiving error message or not for specimen types")
public void verify_whether_we_are_receiving_error_message_or_not_for_specimen_types() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.specimen_type_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.specimen_type_error, 10));
	BaseClass.assertTextPresent("Sample Types are Required!", 10);
	Thread.sleep(10000);
    
}
@Then("verify whether we are receiving error message or not for collection date and time")
public void verify_whether_we_are_receiving_error_message_or_not_for_collection_date_and_time() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.collection_date_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.collection_date_error, 10));
	BaseClass.assertTextPresent("Mobile Number is Required!", 10);
	Thread.sleep(3000);
    
}

@Then("verify whether we are receiving error message or not for panel")
public void verify_whether_we_are_receiving_error_message_or_not_for_panel() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.Test_info_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Test_info_error, 10));
	BaseClass.assertTextPresent("Tests Info is Required!", 10);
	Thread.sleep(3000);
    
}
@When("verify whether user receiving error message or not for relationship")
public void verify_whether_user_receiving_error_message_or_not_for_relationship() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.relationship_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.relationship_error, 0));
	BaseClass.assertTextPresent("Relationship is Required!", 10);
	Thread.sleep(3000);
    
}

@When("verify whether user receiving error message or not for insurance name")
public void verify_whether_user_receiving_error_message_or_not_for_insurance_name() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.insurance_carrier_code_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.insurance_carrier_code_error, 0));
	BaseClass.assertTextPresent("Insurance Carrier Code is Required!", 10);
	Thread.sleep(10000);
    
}

@When("the user searches and selects the UTI test Without Std and nnot clicking the add concern panel")
public void the_user_searches_and_selects_the_uti_test_without_std_and_nnot_clicking_the_add_concern_panel() {
	BaseClass.waitAndClick(LocatorsPage.add_test, 10);

	
}
@Then("verify whether we are receiving error message or not for add test")
public void verify_whether_we_are_receiving_error_message_or_not_for_add_test() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.Test_info_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Test_info_error, 10));
	BaseClass.assertTextPresent("Tests Info is Required!", 10);
	Thread.sleep(3000);
	
	
}



@When("verify whether user receiving error message or not for policy number")
public void verify_whether_user_receiving_error_message_or_not_for_policy_number() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.Policy_number_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Policy_number_error, 0));
	BaseClass.assertTextPresent("Policy Number is Required!", 10);
	Thread.sleep(3000);
    
}
@Then("verify whether we are receiving error message or not for zip code")
public void verify_whether_we_are_receiving_error_message_or_not_for_zip_code() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.zipcode_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.zipcode_error, 0));
	BaseClass.assertTextPresent("Zip Code is Required!", 10);
	Thread.sleep(3000);
}
@Then("verify whether we are receiving error message or not for ordering pysician")
public void verify_whether_we_are_receiving_error_message_or_not_for_ordering_pysician() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.ordering_physician_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.ordering_physician_error, 0));
	BaseClass.assertTextPresent("Ordering Physician is Required!", 10);
	Thread.sleep(3000);
}

@Then("verify whether we are receiving error message or not for billing method")
public void verify_whether_we_are_receiving_error_message_or_not_for_billing_method() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.bill_to_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.bill_to_error, 0));
	BaseClass.assertTextPresent("Billing Type is Required!", 10);
	Thread.sleep(3000);
}

@When("verify whether user receiving error message or not for add test")
public void verify_whether_user_receiving_error_message_or_not_for_add_test() throws Throwable{
	BaseClass.getTextSafe(LocatorsPage.Mobile_number_error, 10);
	System.out.println("Error message is: " + BaseClass.getTextSafe(LocatorsPage.Mobile_number_error, 0));
	BaseClass.assertTextPresent("Mobile Number is Required!", 10);
	Thread.sleep(3000);
	
}















}
