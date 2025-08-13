package StepDefinition;

import io.cucumber.java.en.When;
import utilities.BaseClass;

public class UTICase extends BaseSteps {
	@When("the user selects the UTI case type for cases")
	public void the_user_selects_the_uti_case_type_for_cases() throws Throwable {
		Thread.sleep(5000);
		BaseClass.waitAndClick(LocatorsPage.case_type, 10);
		Thread.sleep(2000);
		BaseClass.waitAndClick(LocatorsPage.particular_case_type_UTI, 10);

		
	}
	@When("the user searches and selects the UTI test Without Std - Atila panels")
	public void the_user_searches_and_selects_the_uti_test_without_std_atila_panels() throws Throwable {
		BaseClass.waitAndClick(LocatorsPage.add_test, 10);
		BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
		BaseClass.waitAndClick(LocatorsPage.UTIBasicPanel, 10);
		Thread.sleep(3000);


		
		
	}
	@When("the user clicks the add test button to add")
	public void the_user_clicks_the_add_test_button_to_add() {
	    
		BaseClass.waitAndClickWithJSFallback(LocatorsPage.add_test_button_new, 10);
        BaseClass.scrollByPixels(0, 1100);

		
	}

	@When("click on convert to  case")
	public void click_on_convert_to_case() throws Throwable{
		 try {
	 	        // Check if the 'Next' button is visible
	 	        if (BaseClass.isElementVisible(LocatorsPage.convert_to_case, 10)) {
	 	        	Thread.sleep(2000);
	 	            BaseClass.waitAndClick(LocatorsPage.convert_to_case, 10);
	 	            System.out.println("✅Case is converted successfully!");
	 	           BaseClass.waitAndClick(LocatorsPage.reason_for_convert, 10);
	 	          BaseClass.waitAndInput(LocatorsPage.reason_for_convert, "Test", 0);
	 	          BaseClass.waitAndClick(LocatorsPage.submit, 10);
	 	          Thread.sleep(3000);
	 	        } else {
	 	            System.out.println("🆕 There is no need  of converting case");
	 	            // You can add alternate handling here
	 	        }
	 	    } catch (Exception e) {
	 	        System.err.println("⚠️ Exception during converting case check: " + e.getMessage());
	 	    }
        
	}



}
