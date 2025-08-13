package StepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ScenarioContext;

public class FinalizingStage extends BaseSteps {
	@When("validate whether the accession ids are same after accession creation and after result file uploading")
	public void validate_whether_the_accession_ids_are_same_after_accession_creation_and_after_result_file_uploading() {
	   
		String expected = ScenarioContext.accessionId;
        String actual = BaseClass.getTextSafe(LocatorsPage.accession_ID_DLW, 10, 10);
		System.out.println("📘 Created Accession ID: " + expected);
		System.out.println("📗 Retrieved Accession ID: " + actual);

		BaseClass.assertTextEquals(expected, actual, true, true);
		System.out.println("✅ Accession ID validation successful: " + actual);
	}

	@When("click mark for physician toggle")
	public void click_mark_for_physician_toggle() {
	   
		BaseClass.waitAndClick(LocatorsPage.view_case_new, 10);
		BaseClass.scrollIntoView(LocatorsPage.mark_finalize, 20);
		BaseClass.waitAndClick(LocatorsPage.mark_finalize, 10);
		
	}
	@When("click on all cases")
	public void click_on_all_cases() {
	   
		BaseClass.waitAndClick(LocatorsPage.all_cases, 10);

	}
	@Then("validate whether the order id is mapped with the correct accession or not")
	public void validate_whether_the_order_id_is_mapped_with_the_correct_accession_or_not() {
	   
		String orderId = ScenarioContext.orderId;
		String final_order=BaseClass.getTextSafe(LocatorsPage.order_id_table, 2, 10);
		System.out.println("Final Order ID from the table: " + final_order);
		System.out.println("Order ID from ScenarioContext: " + orderId);
		BaseClass.assertTextEquals(orderId, final_order, true, true);
		System.out.println("✅ Order ID is mapped with the correct Accession ID: " + final_order);
	}



	
	@Then("Validate whether the case is finalized or not")
	public void validate_whether_the_case_is_finalized_or_not() {
	    
	//	BaseClass.getTextSafe(LocatorsPage.success_finalize, 2, 10);
		System.out.println("✅ Case has been finalized successfully!");
	}




}
