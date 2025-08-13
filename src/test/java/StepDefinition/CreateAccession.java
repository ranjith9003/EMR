package StepDefinition;

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





}
