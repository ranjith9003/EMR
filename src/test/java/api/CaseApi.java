package api;

import static org.junit.Assert.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ApiUtils;
import utilities.ScenarioContext;

public class CaseApi {

    private Response response;
    private Map<String, Object> apiData;
    private Map<String, String> testData;

    @Given("the user has successfully created a case via UI and captured the accession ID")
    public void the_user_has_successfully_created_a_case_via_ui_and_captured_the_accession_id() {
        assertNotNull("❌ Accession ID is not available in ScenarioContext!", ScenarioContext.accessionId);
        assertNotNull("❌ Test data not available!", ScenarioContext.testData);
        testData = ScenarioContext.testData;
    }

    @When("the user sends a GET request with that accession ID to fetch order details")
    public void the_user_sends_a_get_request_with_that_accession_id_to_fetch_order_details() {
        String accessionId = ScenarioContext.accessionId;
        assertNotNull("❌ Accession ID is null!", accessionId);

        response = ApiUtils.getCaseDetailsResponse(accessionId);
        assertNotNull("❌ API response is null", response);

        List<Map<String, Object>> dataList = response.jsonPath().getList("data");
        assertNotNull("❌ 'data' field is missing", dataList);
        assertFalse("❌ 'data' is empty", dataList.isEmpty());

        apiData = dataList.get(0);
    }

  

    @Then("the API should return the same accession ID as submitted")
    public void the_api_should_return_the_same_accession_id_as_submitted() {
        String apiAccessionId = String.valueOf(apiData.get("accession_id"));
        String expectedAccessionId = ScenarioContext.accessionId;

        System.out.println("🔍 Accession ID: Expected = " + expectedAccessionId + " | Actual = " + apiAccessionId);
        assertEquals("❌ Accession ID mismatch", expectedAccessionId, apiAccessionId);
    }

   
   

  
    @Then("the API should return the correct received date")
    public void the_api_should_return_the_correct_received_date() {
        validateDateField("received_date", testData.get("RECEIVED_DATE"));
    }

    // ✅ Common reusable method to convert and validate date fields
    private void validateDateField(String apiField, String expectedDateRaw) {
        try {
            // 1. Clean input from Excel
            expectedDateRaw = expectedDateRaw.replaceAll(" +", " ").trim(); // handles extra spaces
            DateTimeFormatter excelFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a", Locale.ENGLISH);
            LocalDateTime indiaTime = LocalDateTime.parse(expectedDateRaw, excelFormat);

            // 2. Convert IST (Asia/Kolkata) to UTC
            ZonedDateTime indiaZoned = indiaTime.atZone(ZoneId.of("Asia/Kolkata"));
            ZonedDateTime utcZoned = indiaZoned.withZoneSameInstant(ZoneOffset.UTC);
            String expectedUTC = utcZoned.toLocalDateTime().toString().substring(0, 16); // yyyy-MM-ddTHH:mm

            String actualApiDate = apiData.get(apiField).toString();
            String actualUTC = actualApiDate.substring(0, 16); // from API: 2025-03-11T03:30:00.000Z → 2025-03-11T03:30

            System.out.println("🕓 Comparing " + apiField + " | Expected UTC: " + expectedUTC + " | Actual: " + actualUTC);
            assertEquals("❌ " + apiField + " mismatch", expectedUTC, actualUTC);

        } catch (Exception e) {
            fail("❌ Failed to parse or compare " + apiField + ": " + e.getMessage());
        }
    }
}
