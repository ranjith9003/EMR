package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ScenarioContext;

public class ClinicalChemistry extends BaseSteps {
	
	@When("the user selects the Clinical chemistry case type for cases")
	public void the_user_selects_the_clinical_chemistry_case_type_for_cases() {
		
		BaseClass.waitAndClick(LocatorsPage.case_type, 10);
		BaseClass.waitAndClick(LocatorsPage.particular_case_type_clinicalchemistry, 10);
		String selectedCaseType = BaseClass.getTextSafe(LocatorsPage.caseType, 10, 10);
		//ScenarioContext.caseType = selectedCaseType;
		System.out.println("Selected Case Type: " + selectedCaseType);
	   
		
	}
	@When("the user selects the specimen types")
	public void the_user_selects_the_specimen_types() {
		BaseClass.scrollByPixels(0, 500);
		BaseClass.waitAndClick(LocatorsPage.specimen_types, 10);
		BaseClass.waitAndClick(LocatorsPage.particular_specimen_type, 10);

		
	}
	@When("the user searches and selects the required test for clinical chemistry")
	public void the_user_searches_and_selects_the_required_test_for_clinical_chemistry() {
        BaseClass.waitAndClick(LocatorsPage.add_test, 10);
        BaseClass.waitAndClick(LocatorsPage.add_test_checkbox_allTest, 10);
        BaseClass.waitAndClick(LocatorsPage.BMP_all, 10);


	}
	@Then("validating all the test names are present or not")
	public void validating_all_the_test_names_are_present_or_not() {
		//BaseClass.printSpanTexts(LocatorsPage.After_select_test_BMP, "After selection");
		//BaseClass.compareChildSpanTexts( LocatorsPage.Before_select_test_BMP, LocatorsPage.After_select_test_BMP, false, false, false);
	}

@When("the user clicks the add test button in clinical chemistry")
public void the_user_clicks_the_add_test_button_in_clinical_chemistry() {
   
	 BaseClass.waitAndClick(LocatorsPage.covid_checkbox, 10);
       BaseClass.scrollByPixels(0, 1100);
}



}
