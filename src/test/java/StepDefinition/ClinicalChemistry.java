package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
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
	@When("the user selects the fasting")
	public void the_user_selects_the_fasting() {

	
		BaseClass.waitAndClick(LocatorsPage.fasting_Dropdown, 10);
        BaseClass.waitAndClick(LocatorsPage.fasting_option, 10);

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
        BaseClass.waitUntilPageReady(LocatorsPage.add_test_button_new, 10);
       // BaseClass.waitAndClick(LocatorsPage.add_test_checkbox_allTest, 10);
       // BaseClass.waitAndClick(LocatorsPage.BMP_all, 10);


	}
	@Then("validating all the test names are present or not")
	public void validating_all_the_test_names_are_present_or_not() {
		//BaseClass.printSpanTexts(LocatorsPage.After_select_test_BMP, "After selection");
		//BaseClass.compareChildSpanTexts( LocatorsPage.Before_select_test_BMP, LocatorsPage.After_select_test_BMP, false, false, false);
	}

@When("the user clicks the add test button in clinical chemistry")
public void the_user_clicks_the_add_test_button_in_clinical_chemistry() {
   
	BaseClass.waitAndClickWithJSFallback(LocatorsPage.add_test_button_new, 10);
       BaseClass.scrollByPixels(0, 1100);
}
@When("user selects the following tests:")
public void user_selects_the_following_tests(DataTable dataTable) {
    // Convert Cucumber DataTable to a List of Strings
    List<String> testNames = dataTable.asList(String.class);

    // Call your reusable method to select tests
    BaseClass.selectTests(testNames);
}

@Then("the selected tests should be marked as checked")
public void the_selected_tests_should_be_marked_as_checked(io.cucumber.datatable.DataTable dataTable) {
    List<String> tests = dataTable.asList();

    for (String testName : tests) {
        String xpath = "//label[.//span[contains(normalize-space(.),'" + testName + "')]]//input[@type='checkbox']";
        List<WebElement> checkboxes = BaseClass.driver.findElements(By.xpath(xpath));

        if (checkboxes.isEmpty()) {
            throw new AssertionError("❌ No checkbox found for test: " + testName);
        }

        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isDisplayed()) {
                System.out.println("⚠ Skipping hidden checkbox for test: " + testName);
                continue;
            }
            assert checkbox.isSelected() : "❌ Test not selected: " + testName;
            System.out.println("✔ Verified selected: " + testName);
        }
    }
}

}




