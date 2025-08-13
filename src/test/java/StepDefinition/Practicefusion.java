package StepDefinition;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.PracticeFusionLocatorPage;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ScenarioContext;

import java.util.ArrayList;
import java.util.List;
import Hooks.PlaywrightHooks; // Import the PlaywrightHooks from the Hooks package

public class Practicefusion {
    // Use the updated locator page class name
    private final PracticeFusionLocatorPage locatorsPage;
    private int numberOfTestsSelected; // Added to store the count of tests
    List<String> selectedTests = new ArrayList<>(); // ✅ This is what was missing


    public Practicefusion() {
        // Initialize the locator page with the Playwright Page from PlaywrightHooks
        this.locatorsPage = new PracticeFusionLocatorPage(PlaywrightHooks.page);
    }

    @Given("Launch the practice fusion url")
    public void launch_the_practice_fusion_url() {
        PlaywrightHooks.page.navigate("https://partner.practicefusion.com/apps/ehr/index.html#/login");
        System.out.println("Launched Practice Fusion URL.");
    }

    @When("enter the username and password in practicefusion")
    public void enter_the_username_and_password_in_practicefusion() {
        locatorsPage.usernameInput().fill("sundar@labsquire.com"); // Hardcoded username
        locatorsPage.passwordInput().fill("practiceFusion@2468"); // Hardcoded password
        System.out.println("Entered username and password.");
    }

    @When("click on the login button in practice fusion")
    public void click_on_the_login_button_in_practice_fusion() {
        locatorsPage.loginButton().click();
        System.out.println("Clicked on Login button.");
    }

    @When("click on the charts")
    public void click_on_the_charts() throws Throwable{
        locatorsPage.chartsLink().click();
        Thread.sleep(2000);
        System.out.println("Clicked on Charts link.");
    }

    @When("click on the add patients")
    public void click_on_the_add_patients() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.addPatientButton().click();
        Thread.sleep(1000);
        System.out.println("Clicked on Add Patient button.");
    }
    @When("he user enters the first name")
    public void he_user_enters_the_first_name() throws Throwable {
        Thread.sleep(2000);
        String firstName = "TEST";
        ScenarioContext.extractedFirstName =firstName;  // ✅ Save to static field in ScenarioContext
        ScenarioContext.set("First_Name", ScenarioContext.extractedFirstName);  // ✅ Store in test data for easy access
        locatorsPage.firstNameInput().fill(firstName);
        System.out.println("Entered first name: " + firstName);
        System.out.println("🧠 ScenarioContext Hash: " + ScenarioContext.class.hashCode());

    }

    @When("the user enters the last name")
    public void the_user_enters_the_last_name() throws Throwable {
        Thread.sleep(2000);
        String lastName = "Patient";
        locatorsPage.lastNameInput().fill(lastName);
        System.out.println("Entered last name: " + lastName);
    }

    @When("the user enters the gender")
    public void the_user_enters_the_gender() throws Throwable {
        Thread.sleep(2000);
        locatorsPage.maleRadio().click();  // Assuming Male is selected
        System.out.println("Selected gender: Male");
    }

    @When("the user enters the DOB")
    public void the_user_enters_the_dob() throws Throwable {
        Thread.sleep(2000);
        String dob = "01/01/1990";
        locatorsPage.dobInput().fill(dob);
        System.out.println("Entered DOB: " + dob);
    }
    @When("click on the mobile number")
    public void click_on_the_mobile_number() throws Throwable {
        Thread.sleep(2000);
        String mobile = "1234567899";
        locatorsPage.mobileNumberInput().fill(mobile);
        System.out.println("Entered mobile number: " + mobile);
    }
    @When("click on the email id")
    public void click_on_the_email_id() throws Throwable {
        Thread.sleep(2000);
        String email = "test@yopmail.com";
        locatorsPage.emailInput().fill(email);
        System.out.println("Entered email ID: " + email);
    }
    @When("the user enters the address")
    public void the_user_enters_the_address() throws Throwable {
        Thread.sleep(2000);
        String address = "Texas";
        locatorsPage.addressInput().fill(address);
        System.out.println("Entered address: " + address);
    }


    @When("the user enters the zipcode")
    public void the_user_enters_the_zipcode() throws Throwable {
        Thread.sleep(2000);
        String zip = "12345";
        locatorsPage.zipcodeInput().fill(zip);
        System.out.println("Entered zipcode: " + zip);
    }
    @When("the user enters the save button")
    public void the_user_enters_the_save_button() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.saveButton().click();
        System.out.println("Clicked on Save button.");
    }

    @When("click on the action button")
    public void click_on_the_action_button() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.actionsDropdown().click();
        System.out.println("Clicked on Actions dropdown.");
    }

    @When("click on add lab order")
    public void click_on_add_lab_order() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.addLabOrderOption().click();
        System.out.println("Clicked on Add Lab Order option.");
    }

    @When("click on the Vendor for order")
    public void click_on_the_vendor_for_order() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.labSelectDropdown().click();
        System.out.println("Clicked on Vendor dropdown.");
    }

    @When("click on the particular dlw order")
    public void click_on_the_particular_dlw_order() throws Throwable{
        Thread.sleep(2000);
        locatorsPage.vendorDlwOption().click();
        System.out.println("Clicked on particular DLW order.");
    }
    @When("I select the following tests for order:")
    public void i_select_the_following_tests_for_order(DataTable dataTable) throws InterruptedException {
        List<String> testNames = dataTable.asList();
        this.selectedTests = new ArrayList<>(testNames); // ✅ Save for later use

        for (String fullTestName : testNames) {
            this.numberOfTestsSelected = testNames.size();

            String testPortion = fullTestName.contains("-")
                    ? fullTestName.substring(fullTestName.indexOf("-") + 1).trim()
                    : fullTestName;

            Locator inputField = locatorsPage.testsSearchInput();
            inputField.clear();
            Thread.sleep(1000);

            inputField.pressSequentially(fullTestName);
            Thread.sleep(2000);

            Locator exactMatch = PlaywrightHooks.page.getByText(fullTestName, new Page.GetByTextOptions().setExact(true));

            if (exactMatch.count() > 0) {
                exactMatch.first().click();
                System.out.println("✅ Selected test using full name: " + fullTestName);
            } else {
                inputField.clear();
                inputField.pressSequentially(testPortion);
                Thread.sleep(2000);

                Locator suggestion = PlaywrightHooks.page.getByText(fullTestName);
                if (suggestion.count() > 0) {
                    suggestion.first().click();
                    System.out.println("✅ Selected test using partial input: " + fullTestName);
                } else {
                    System.out.println("❌ Test not found in dropdown: " + fullTestName);
                }
            }
        }
    }

    @When("select the diagnoses")
    public void select_the_diagnoses() throws Throwable {
        locatorsPage.diagnosesInput().click();
        Thread.sleep(2000);
        String diagnosis = "B18.2";
        locatorsPage.diagnosesInput().pressSequentially(diagnosis);
        Thread.sleep(4000);
        locatorsPage.diagnosesParticular().click();
        ScenarioContext.set("diagnosisCode", diagnosis);

        System.out.println("Selected diagnosis: " + diagnosis);

        for (int i = 0; i < numberOfTestsSelected; i++) {
            System.out.println("Click Send/Next button (attempt " + (i + 1) + ")");
            try {
                Thread.sleep(2000);
                locatorsPage.sendButton().click();
            } catch (PlaywrightException e) {
                System.out.println("Send/Next button not clickable at attempt " + (i + 1));
                break;
            }
        }
    }


    @When("click the order summary")
    public void click_the_order_summary() throws Throwable{
        locatorsPage.orderSummaryButton().click();
        System.out.println("Clicked on Order Summary.");
    }

    @When("click on the ordering provider")
    public void click_on_the_ordering_provider() throws Throwable{
        locatorsPage.orderingProviderDropdown().click();
        locatorsPage.particularOrderingProvider().click();
        System.out.println("Clicked on Ordering Provider.");
    }

    @When("click on the primary ordering provider")
    public void click_on_the_primary_ordering_provider() throws Throwable{
        locatorsPage.primaryOrderingProviderDropdown().click();
        locatorsPage.particularPrimaryOrderingProvider().click();
        System.out.println("Clicked on Primary Ordering Provider.");
    }

    @When("click on send")
    public void click_on_send() throws Throwable{
        locatorsPage.sendButton().click(); // This is the first 'next-btn' after provider selection
        locatorsPage.nextSendButton().click(); // This is the second 'next-btn'
       // locatorsPage.printButton().click(); // Assuming this is part of the final send action
        System.out.println("Clicked on Send button and initiated print.");
    }
    @Then("extracting the EMR from that page after placing the order")
    public void extracting_the_emr_from_that_page_after_placing_the_order() throws Throwable {
        Thread.sleep(2000);
        locatorsPage.profile().click();
        Thread.sleep(2000);
        locatorsPage.recordId().waitFor(new Locator.WaitForOptions().setTimeout(5000));

        String emrId = locatorsPage.recordId().textContent().trim();
        System.out.println("Extracted EMR ID: " + emrId);

        ScenarioContext.extractedEmrId = "D-HILLSPC-" + emrId;  // ✅ Save to static field in ScenarioContext
        ScenarioContext.set("EMR_ID", ScenarioContext.extractedEmrId);  // ✅ Store in test data for easy access

        System.out.println("Extracted Full EMR ID: " + ScenarioContext.extractedEmrId);
        Thread.sleep(10000);
    }




}