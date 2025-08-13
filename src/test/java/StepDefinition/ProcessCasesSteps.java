package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;

public class ProcessCasesSteps extends BaseSteps{


@Given("I launch the Labsquire application")
public void i_launch_the_labsquire_application() {

	BaseClass.openUrl("https://staging-dlw.labsquire.com/");
}
@Given("I login with username  and password")
public void i_login_with_username_and_password() {
    BaseClass.waitAndInput(LocatorsPage.username,"superadmin" , 10);
    BaseClass.waitAndInput(LocatorsPage.password, "1234567", 10);
    BaseClass.waitAndClick(LocatorsPage.login_btn, 10);
	
}
@When("I filter cases by Ordering Facility")
public void i_filter_cases_by_ordering_facility() {
    BaseClass.waitAndClick(LocatorsPage.process_filter, 10);
	
}
@Then("I should see the filtered results containing")
public void i_should_see_the_filtered_results_containing() {
BaseClass.waitAndClick(LocatorsPage.filter_search, 10);	
BaseClass.waitAndClick(LocatorsPage.ord_facility, 10);	
BaseClass.waitAndInput(LocatorsPage.ord_facility, "Testing ordering facility", 10);
BaseClass.waitAndClick(LocatorsPage.testing_ordering_facility, 10);	

}
@Then("I move all cases to validation with reason")
public void moveAllCasesToValidation() {

   
     
    }
}

