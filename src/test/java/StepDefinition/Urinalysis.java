package StepDefinition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ScenarioContext;
import java.time.Duration;

public class Urinalysis extends BaseSteps {

@When("the user selects the case type as urinalysis")
public void the_user_selects_the_case_type_as_urinalysis() {

	  BaseClass.waitAndClick(LocatorsPage.case_type, 10);
      BaseClass.waitAndClick(LocatorsPage.particular_case_type_urinalysis, 10);
    String selectedCaseType=  BaseClass.getTextSafe(LocatorsPage.caseType, 10, 10);
    ScenarioContext.caseType = selectedCaseType; 
    System.out.println("Selected Case Type: " + selectedCaseType);
      BaseClass.assertTextPresent("Order Date", 10);

}
@When("the user searches and selects the required test of urinalysis casetype")
public void the_user_searches_and_selects_the_required_test_of_urinalysis_casetype() {

	BaseClass.waitAndClick(LocatorsPage.add_test, 10);
	BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
	BaseClass.waitAndClick(LocatorsPage.Urinalysis_reflex_to_UTI_without_STD, 10);
	BaseClass.waitAndClick(LocatorsPage.add_test_button_new, 10);
	
}
@When("the user searches and selects the required test of urinalysis with STI casetype")
public void the_user_searches_and_selects_the_required_test_of_urinalysis_with_sti_casetype() {

	BaseClass.waitAndClick(LocatorsPage.add_test, 10);
	BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
	BaseClass.waitAndClick(LocatorsPage.Urinalysis_reflex_to_UTI_with_STD, 10);
	BaseClass.waitAndClick(LocatorsPage.add_test_button_new, 10);
}
@When("the user searches and selects the required test of urinalysis")
public void the_user_searches_and_selects_the_required_test_of_urinalysis() {
	BaseClass.waitAndClick(LocatorsPage.add_test, 10);
	BaseClass.waitAndClick(LocatorsPage.select_panels, 10);
	BaseClass.waitAndClick(LocatorsPage.Urinalysis, 10);
	BaseClass.waitAndClick(LocatorsPage.add_test_button_new, 10);

	
}
@When("click on the file generating process")
public void click_on_the_file_generating_process() {

BaseClass.waitAndClick(LocatorsPage.view_case_new, 10);

}





@When("click on start resulting")
public void click_on_start_resulting() {
	BaseClass.scrollIntoView(LocatorsPage.start_resulting, 10);
	BaseClass.waitAndClickWithJSFallback(LocatorsPage.start_resulting, 10);
}

@When("enter the values for the tests which are available for urinalysis")
public void enter_the_values_for_the_tests_which_are_available_for_urinalysis() throws Throwable {
    Thread.sleep(3000); // initial wait if page is heavy

    int expectedElementCount = 10; // set expected number of inputs

    // Validate input size
    int actualElementCount = LocatorsPage.allInputs.size();
    if (actualElementCount < expectedElementCount) {
        throw new AssertionError("❌ Expected at least " + expectedElementCount + " input fields, but found only " + actualElementCount);
    } else {
        System.out.println("✅ Input field count check passed. Found: " + actualElementCount);
    }

    for (int i = 0; i < expectedElementCount; i++) {
        WebElement input = LocatorsPage.allInputs.get(i);
        String expectedValue = String.valueOf(i + 1);

        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(input));

            BaseClass.scrollIntoView(input, 5);

            input.clear();
            input.sendKeys(expectedValue);

            String actualValue = input.getAttribute("value");
            if (expectedValue.equals(actualValue)) {
                System.out.println("✅ UI input verified at index " + i + ": " + actualValue);
            } else {
                System.err.println("❌ UI input mismatch at index " + i + ". Expected: " + expectedValue + ", Found: " + actualValue);
                throw new AssertionError("❌ UI value mismatch at index " + i);
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to interact with input at index " + i);
            e.printStackTrace();
            throw new RuntimeException("Error interacting with input field at index " + i);
        }
    }

    Thread.sleep(5000);
    BaseClass.scrollByOffset(0, 1000);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.save_urinalysis, 10);
    BaseClass.scrollByOffset(0, -1000);
    Thread.sleep(3000);
    BaseClass.waitAndClickWithJSFallback(LocatorsPage.generate_report_urinalysis, 10);
}
@When("click on mark for physician")
public void click_on_mark_for_physician() throws Throwable {
	Thread.sleep(3000);
	BaseClass.scrollIntoView(LocatorsPage.mark_finalize, 20);
	BaseClass.waitAndClick(LocatorsPage.mark_finalize, 10);
	System.out.println("✅ Marked for Physician successfully!");






}

}
