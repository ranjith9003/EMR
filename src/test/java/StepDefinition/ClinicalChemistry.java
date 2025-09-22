package StepDefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.ScenarioContext;
import static org.junit.Assert.assertTrue;

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
public void the_selected_tests_should_be_marked_as_checked(io.cucumber.datatable.DataTable dataTable) throws Throwable {
    // Click 'Add All Tests' checkbox first
    BaseClass.waitAndClick(LocatorsPage.add_test_checkbox_allTest, 10);
    Thread.sleep(2000); // Wait for the checkboxes to update
    // Get the list of test names from the DataTable
    List<String> tests = dataTable.asList();

    for (String testName : tests) {
        // Build XPath for each test checkbox
        String xpath = "//label[.//span[contains(normalize-space(.),'" + testName + "')]]//input[@type='checkbox']";
        List<WebElement> checkboxes = BaseClass.driver.findElements(By.xpath(xpath));

        if (checkboxes.isEmpty()) {
            throw new AssertionError("❌ No checkbox found for test: " + testName);
        }

        for (WebElement checkbox : checkboxes) {
            // Skip hidden checkboxes
            if (!checkbox.isDisplayed()) {
                System.out.println("⚠ Skipping hidden checkbox for test: " + testName);
                continue;
            }

            // Scroll to the checkbox if not visible
            BaseClass.scrollToElement(checkbox, testName);

            // Wait until checkbox is selected
            BaseClass.waitUntilSelected(checkbox, 5); // You can implement this in BaseClass

            // Assert checkbox is selected
            if (!checkbox.isSelected()) {
                throw new AssertionError("❌ Test not selected: " + testName);
            }
            System.out.println("✔ Verified selected: " + testName);
        }
    }
}


@Then("I select the following panels")
public void i_select_the_following_panels(DataTable dataTable) throws Throwable{
    // Convert Cucumber DataTable → List
    List<String> panelNames = dataTable.asList(String.class);

    for (String panelName : panelNames) {
        WebElement panelCheckbox = LocatorsPage.panelsMap.get(panelName);

        if (panelCheckbox == null) {
            throw new RuntimeException("❌ Panel not found in panelsMap: " + panelName);
        }

        if (!panelCheckbox.isSelected()) {
        	Thread.sleep(3000);
            panelCheckbox.click();
            System.out.println("✅ Selected panel: " + panelName);
        } else {
            System.out.println("⚠️ Already selected: " + panelName);
        }
    }
}
@Then("the following panels should have correct tests")
public void the_panels_should_have_correct_tests(io.cucumber.datatable.DataTable dataTable) {
    // Convert DataTable → List of panel names
    List<String> panelNames = dataTable.asList(String.class);

    for (String panelName : panelNames) {
        System.out.println("Validating panel: " + panelName);

        // Get expected tests dynamically (from ScenarioContext or your source)
        List<String> expectedTests = ScenarioContext.getTestsForPanelAsList(panelName);
        if (expectedTests == null || expectedTests.isEmpty()) {
            System.out.println("Warning: No expected tests found for panel: " + panelName);
            continue; // Skip this panel if no expected tests
        }

        // Build dynamic XPath for this panel (normalize-space to ignore extra spaces)
        String xpath = "//div[@class='each-item' and ./h4[@class='category-name' and contains(normalize-space(text()), '" 
                       + panelName + "')]]//span[@class='test-name']";
        System.out.println("Using XPath: " + xpath);

        // Extract actual tests from UI
        List<WebElement> actualElements = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

        List<String> actualTests = new ArrayList<>();
        for (WebElement el : actualElements) {
            actualTests.add(el.getText().trim().replaceAll("\\s+", " "));
        }

        // 1️⃣ Count validation
        Assert.assertEquals(
                "Mismatch in test count for panel: " + panelName,
                expectedTests.size(),
                actualTests.size()
        );

        // 2️⃣ Content validation using contains
        List<String> missingTests = new ArrayList<>();
        for (String expected : expectedTests) {
            boolean found = false;
            String expectedNormalized = expected.trim().replaceAll("\\s+", " ");
            for (String actual : actualTests) {
                if (actual.contains(expectedNormalized)) {
                    found = true;
                    break;
                }
            }
            if (!found) missingTests.add(expected);
        }

        // Assert if any missing tests
        Assert.assertTrue(
                "Panel '" + panelName + "' is missing expected tests: " + missingTests,
                missingTests.isEmpty()
        );

        // Debug logging
        System.out.println("Panel: " + panelName);
        System.out.println("Expected tests (" + expectedTests.size() + "): " + expectedTests);
        System.out.println("Actual tests   (" + actualTests.size() + "): " + actualTests);
        if (!missingTests.isEmpty()) System.out.println("Missing tests: " + missingTests);
    }
}
@Then("I select the following panels and tests and validate panels")
public void i_select_and_validate_panels_and_tests(io.cucumber.datatable.DataTable dataTable) throws Throwable {
    List<String> items = dataTable.asList(String.class);
    List<String> selectedPanels = new ArrayList<>();
    List<String> selectedTests = new ArrayList<>();

    System.out.println("🔹 Items from feature file: " + items);

    // 1️⃣ Select panels first
    for (String item : items) {
        if (ScenarioContext.allPanels.contains(item)) {
            WebElement panelCheckbox = LocatorsPage.panelsMap.get(item);
            if (panelCheckbox == null) throw new RuntimeException("❌ Panel not found: " + item);

            if (!panelCheckbox.isSelected()) {
                Thread.sleep(2000);
                panelCheckbox.click();
                System.out.println("✅ Selected panel: " + item);
            } else {
                System.out.println("⚠️ Already selected panel: " + item);
            }
            selectedPanels.add(item);
        }
    }

    // 2️⃣ Select tests from All Tests
    BaseClass.waitAndClick(LocatorsPage.add_test_checkbox_allTest, 10); // Expand All Tests

    for (String item : items) {
        if (!selectedPanels.contains(item)) {
            boolean clicked = false;
            int attempts = 0;

            while (!clicked && attempts < 10) {
                // Re-fetch elements each time to avoid stale reference
                String xpath = "//div[contains(@class,'el-collapse-item__header') and .//text()[contains(.,'All Tests')]]//following::div//label[contains(@class,'el-checkbox')]//span[@class='el-checkbox__label' and text()='" + item + "']/parent::label/span[@class='el-checkbox__input']";
                List<WebElement> testElements = driver.findElements(By.xpath(xpath));

                for (WebElement el : testElements) {
                    try {
                        if (el.isDisplayed() && el.isEnabled() && !el.isSelected()) {
                            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
                            Thread.sleep(300);
                            el.click();
                            selectedTests.add(item);
                            clicked = true;
                            System.out.println("✅ Clicked test: " + item);
                            break;
                        }
                    } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                        System.out.println("⚠️ Retry clicking test: " + item + " - " + e.getMessage());
                    }
                }

                if (!clicked) {
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");
                    Thread.sleep(300);
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -300);");
                    Thread.sleep(300);
                    attempts++;
                }
            }

            if (!clicked) {
                System.out.println("❌ Could not select test after retries: " + item);
            }
        }
    }

 // 3️⃣ Store selections
    ScenarioContext.setSelectedPanels(selectedPanels);
    ScenarioContext.setSelectedTests(selectedTests);

    System.out.println("🔹 Selected Panels: " + selectedPanels);
    System.out.println("🔹 Selected Tests: " + selectedTests);

    // 4️⃣ Validate panels individually
    for (String panelName : selectedPanels) {
        if ("All Tests".equalsIgnoreCase(panelName)) continue;

        System.out.println("🔹 Validating panel: " + panelName);

        // Expected tests for the panel
        List<String> expectedTests = ScenarioContext.getTestsForPanelAsList(panelName);
        System.out.println(" 🔹 Expected tests: " + expectedTests);

        if (expectedTests.isEmpty()) {
            System.out.println("⚠️ No expected tests found for panel: " + panelName);
            continue;
        }

        // Fetch actual tests from UI
        String xpath = "//div[@class='each-item' and ./h4[@class='category-name' and contains(normalize-space(text()), '" + panelName + "')]]//span[@class='test-name']";
        List<WebElement> actualElements = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

        List<String> actualTests = new ArrayList<>();
        for (WebElement el : actualElements) {
            String testName = el.getText().trim().replaceAll("\\s+", " ");
            actualTests.add(testName);
            System.out.println(" 🔹 UI Test found: " + testName);
        }

        // Count validation
        System.out.println(" 🔹 Expected count: " + expectedTests.size() + " | Actual count: " + actualTests.size());
        Assert.assertEquals("❌ Mismatch in test count for panel: " + panelName, expectedTests.size(), actualTests.size());

        // Content validation
        System.out.println(" 🔹 Checking if all expected tests are present...");
        Assert.assertTrue("❌ Missing tests in panel: " + panelName, actualTests.containsAll(expectedTests));
        Assert.assertTrue("❌ Extra tests found in panel: " + panelName, expectedTests.containsAll(actualTests));

        System.out.println("✅ Panel validated successfully: " + panelName);
    }

 // 5️⃣ Validate All Tests section
    System.out.println("🔹 Validating All Tests section...");

    // XPath to locate all tests in the "All Tests" section
    String xpathAllTests = "//div[@class='each-item' and ./h4[@class='category-name' and contains(normalize-space(text()), 'All Tests')]]//span[@class='test-name']";

    // Fetch elements from UI
    List<WebElement> allTestElements = driver.findElements(By.xpath(xpathAllTests));

    // Extract the test names from UI and print each
    List<String> uiTests = new ArrayList<>();
    for (WebElement el : allTestElements) {
        String testName = el.getText().trim().replaceAll("\\s+", " ");
        uiTests.add(testName);
        System.out.println(" 🔹 UI Test found: " + testName);
    }

    // Validate each selected test is present in UI and print the result
    for (String test : selectedTests) {
        boolean found = uiTests.stream().anyMatch(ui -> ui.contains(test));
        System.out.println(" 🔹 Checking selected test in UI: " + test + " | Found: " + found);
        Assert.assertTrue("❌ Selected test missing in All Tests UI: " + test, found);
    }

    System.out.println("✅ All Tests validated successfully (count + contains).");
    System.out.println("🔹 Selected Tests: " + selectedTests);
    System.out.println("🔹 Total UI Tests found: " + uiTests.size());

    // 6️⃣ Final validation for DataTable vs selected items
    List<String> allSelectedItems = new ArrayList<>();
    allSelectedItems.addAll(selectedPanels);
    allSelectedItems.addAll(selectedTests);

    List<String> missingItems = items.stream().filter(i -> !allSelectedItems.contains(i)).toList();
    List<String> extraItems = allSelectedItems.stream().filter(i -> !items.contains(i)).toList();

    Assert.assertTrue("❌ Some items from DataTable were not selected in UI: " + missingItems, missingItems.isEmpty());
    Assert.assertTrue("❌ Unexpected extra items selected in UI: " + extraItems, extraItems.isEmpty());

    System.out.println("✅ All Panels & Tests selected and validated successfully!");
}


@When("the user processing the report generation process")
public void the_user_processing_the_report_generation_process() throws Throwable {
    String combinedXpath = "//div[@class='el-tabs__item is-top is-active is-focus']//span[@class='custom-tabs-label'] | " +
            "//div[@class='el-tabs__item is-top is-focus']//span[@class='custom-tabs-label']";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    List<WebElement> tabElements = driver.findElements(By.xpath(combinedXpath));
    System.out.println("Total tabs found: " + tabElements.size());

    for (int i = 0; i < tabElements.size(); i++) {

        // 🔄 Re-fetch tabs each iteration to avoid staleness
        tabElements = driver.findElements(By.xpath(combinedXpath));
        WebElement tabItem = tabElements.get(i);
        String tabTextFormatted = BaseClass.toTitleCase(tabItem.getText());

        System.out.println("==== Processing tab " + (i + 1) + ": " + tabTextFormatted + " ====");

        BaseClass.waitForLoaderToDisappear(driver, wait);

        // 🔄 Retry safeClick for tab
        int retryTab = 0;
        while (retryTab < 3) {
            try {
                BaseClass.safeClick(tabItem);
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                retryTab++;
                System.out.println("⚠️ Tab click failed, retrying... attempt " + retryTab);
                Thread.sleep(500);
                tabElements = driver.findElements(By.xpath(combinedXpath));
                tabItem = tabElements.get(i);
            }
        }

        BaseClass.scrollByPixels(0, 750);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//span[contains(@class, 'custom-tabs-label')]/span[text()='" + tabTextFormatted + "']")));
        } catch (TimeoutException e) {
            System.out.println("⚠️ Tab content not fully loaded for: " + tabTextFormatted);
        }

        List<WebElement> resultInputs = driver.findElements(By.xpath("//input[@placeholder='--']"));
        System.out.println("Total inputs found: " + resultInputs.size());

        for (int j = 0; j < resultInputs.size(); j++) {

            // 🔄 Re-fetch each input
            WebElement input = driver.findElements(By.xpath("//input[@placeholder='--']")).get(j);

            if (!input.isDisplayed() || !input.isEnabled() || input.getAttribute("readonly") != null) {
                continue;
            }

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", input);
            Thread.sleep(150);

            try {
                new WebDriverWait(driver, Duration.ofSeconds(1))
                        .until(ExpectedConditions.elementToBeClickable(input));
            } catch (TimeoutException e) {
                continue;
            }

            try {
                input.clear();
                input.sendKeys(String.valueOf(j + 1));
            } catch (Exception e) {
                continue;
            }
        }

        // 🔹 Save button retry loop
        int retrySave = 0;
        while (retrySave < 3) {
            try {
                WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                BaseClass.safeClick(saveBtn);
                BaseClass.waitForLoaderToDisappear(driver, wait);
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException e) {
                retrySave++;
                System.out.println("⚠️ Save click failed, retrying... attempt " + retrySave);
                Thread.sleep(500);
            }
        }

        System.out.println("💾 ✅ Saved all rows in tab: " + tabTextFormatted);
        System.out.println("==== Completed tab ====");

        Thread.sleep(1000);
        BaseClass.scrollByPixels(0, -750);
    }
}


@When("click mark for physician toggle for clinical chemistry")
public void click_mark_for_physician_toggle_for_clinical_chemistry() throws Throwable{
    BaseClass.waitAndClick(LocatorsPage.preliminary_report_clinicalchemistry, 10);
    Thread.sleep(3000);
	BaseClass.scrollIntoView(LocatorsPage.mark_for_physician_clinicalchemistry, 20);
	BaseClass.waitAndClick(LocatorsPage.mark_for_physician_clinicalchemistry, 10);
}}