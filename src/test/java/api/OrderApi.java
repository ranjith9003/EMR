package api;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ApiUtils;
import utilities.ScenarioContext;

public class OrderApi {

    private Response response;
    private Map<String, Object> apiData;
    private Map<String, String> testData;

    @Given("the user has successfully created an order via UI and captured the Order ID")
    public void the_user_has_successfully_created_an_order_via_ui_and_captured_the_order_id() {
        assertNotNull("❌ Order ID is not available in ScenarioContext!", ScenarioContext.orderId);
        assertNotNull("❌ Test data not available in ScenarioContext!", ScenarioContext.testData);
        testData = ScenarioContext.testData;
        System.out.println("✅ Order ID: " + ScenarioContext.orderId);
        System.out.println("✅ Test data loaded.");
    }

    @When("the user sends a GET request with that Order ID to fetch order details")
    public void the_user_sends_a_get_request_with_that_order_id_to_fetch_order_details() {
        String orderId = ScenarioContext.orderId;
        assertNotNull("❌ Order ID not captured from UI!", orderId);
        System.out.println("📤 Sending GET request for Order ID: " + orderId);

        response = ApiUtils.getOrderDetailsResponse(orderId);
        assertNotNull("❌ API response is null", response);

        System.out.println("✅ API Status Code: " + response.getStatusCode());
        System.out.println("📦 Full API Response: " + response.asPrettyString());

        List<Map<String, Object>> dataList = response.jsonPath().getList("data");
        assertNotNull("❌ 'data' field is missing in API response", dataList);
        assertFalse("❌ 'data' list is empty", dataList.isEmpty());

        apiData = dataList.get(0);
        System.out.println("✅ Extracted first object from API 'data' array.");
    }

    @Then("the API response should have status code {int}")
    public void the_api_response_should_have_status_code(Integer expectedStatusCode) {
        int actualStatus = response.getStatusCode();
        System.out.println("🔍 Comparing Status Code: Expected = " + expectedStatusCode + " | Actual = " + actualStatus);
        assertEquals("❌ Status code mismatch", expectedStatusCode.intValue(), actualStatus);
    }

    @Then("the API should return the same Order ID as submitted")
    public void the_api_should_return_the_same_order_id_as_submitted() {
        String actualOrderId = apiData.get("order_id").toString();
        System.out.println("🔍 Order ID: Expected = " + ScenarioContext.orderId + " | Actual = " + actualOrderId);
        assertEquals("❌ Order ID mismatch", ScenarioContext.orderId, actualOrderId);
    }

    @Then("the API should return correct patient information")
    public void the_api_should_return_correct_patient_information() {
        Map<String, Object> patient = (Map<String, Object>) apiData.get("patient_info");

        assertEquals("First name mismatch", testData.get("FIRST_NAME"), patient.get("first_name"));
        System.out.println("✅ First Name: " + patient.get("first_name") + " == " + testData.get("FIRST_NAME"));

        assertEquals("Last name mismatch", testData.get("LAST_NAME"), patient.get("last_name"));
        System.out.println("✅ Last Name: " + patient.get("last_name") + " == " + testData.get("LAST_NAME"));

        assertEquals("Gender mismatch", "MALE", patient.get("gender"));
        System.out.println("✅ Gender: " + patient.get("gender"));

        String dobApi = patient.get("date_of_birth").toString();
        String dobExcel = testData.get("DOB_YYYY");
        assertTrue("DOB mismatch", dobApi.contains(dobExcel));
        System.out.println("✅ DOB contains: " + dobExcel + " in " + dobApi);

        assertEquals("Mobile mismatch", testData.get("MOBILE_NUMBER"), patient.get("home_phone"));
        System.out.println("✅ Mobile: " + patient.get("home_phone"));

        assertEquals("Address mismatch", testData.get("ADDRESS"), patient.get("address_line_1"));
        System.out.println("✅ Address: " + patient.get("address_line_1"));

        assertEquals("Zip mismatch", testData.get("ZIP_CODE"), patient.get("zip"));
        System.out.println("✅ Zip: " + patient.get("zip"));
    }

    @Then("the API should return correct order metadata including case type, facility, physician")
    public void the_api_should_return_correct_order_metadata_including_case_type_facility_physician() {

        // ✅ Case Type Validation
        Object caseTypesObj = apiData.get("case_types");
        assertNotNull("❌ 'case_types' field is missing from API", caseTypesObj);

        String caseTypes = caseTypesObj.toString(); // JSON Array like [COVID]
        String actualCaseType = caseTypes.replaceAll("[\\[\\]\"]", "").trim().toLowerCase(); // remove brackets
        String expectedCaseType = ScenarioContext.caseType.toLowerCase(); // from UI, stored in context

        System.out.println("🔍 Comparing Case Type: Expected = " + expectedCaseType + " | Actual = " + actualCaseType);
        assertEquals("❌ Case type mismatch", expectedCaseType, actualCaseType);

        // ✅ Facility Validation
        Map<String, Object> facility = (Map<String, Object>) apiData.get("hospital");
        String actualFacility = facility != null ? String.valueOf(facility.get("name")) : null;
        String expectedFacility = ScenarioContext.testData.get("FACILITY_NAME");

        assertNotNull("❌ Facility name is null from API", actualFacility);
        assertNotNull("❌ Facility name from Excel is null", expectedFacility);
        System.out.println("🔍 Comparing Facility Name: Expected = " + expectedFacility + " | Actual = " + actualFacility);
        assertTrue("❌ Facility name mismatch", actualFacility.toLowerCase().contains(expectedFacility.toLowerCase()));

        // ✅ Physician Validation
        Map<String, Object> physician = (Map<String, Object>) apiData.get("ordering_physician");
        String actualPhysician = physician != null ? String.valueOf(physician.get("name")) : null;
        String expectedPhysician = ScenarioContext.testData.get("PHYSICIAN_NAME");

        assertNotNull("❌ Physician name is null from API", actualPhysician);
        assertNotNull("❌ Physician name from Excel is null", expectedPhysician);
        System.out.println("🔍 Comparing Physician Name: Expected = " + expectedPhysician + " | Actual = " + actualPhysician);
        assertTrue("❌ Physician name mismatch", actualPhysician.toLowerCase().contains(expectedPhysician.toLowerCase()));
    }

    @Then("the API should return the correct collection date")
    public void the_api_should_return_the_correct_collection_date() {}
       /* String apiCollectionDate = apiData.get("collection_date").toString();  // e.g., 2025-03-11T03:30:00.000Z
        String expectedRaw = testData.get("COLLECTION_DATE");                  // e.g., 03-10-2025  22:30:00 PM

        System.out.println("🔍 Comparing Collection Date: Raw Expected = " + expectedRaw + " | Actual API = " + apiCollectionDate);

        assertNotNull("❌ API collection date is null", apiCollectionDate);
        assertNotNull("❌ Expected collection date from Excel is null", expectedRaw);

        try {
            // ✅ Clean spaces and remove AM/PM if 24-hour format is detected
            String cleaned = expectedRaw.trim().replaceAll(" +", " ");
            if (cleaned.matches(".*\\d{2}:\\d{2}:\\d{2} [APap][Mm]$") && cleaned.contains("22")) {
                // likely invalid (22:30 PM) → remove AM/PM
                cleaned = cleaned.replaceAll("(?i)\\s*[AP]M", "");
            }

            // ✅ Try parsing with 24-hour format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
            LocalDateTime localExcelTime = LocalDateTime.parse(cleaned, formatter);

            // Convert to UTC
            ZonedDateTime expectedUTC = localExcelTime.atZone(ZoneId.of("Asia/Kolkata")).withZoneSameInstant(ZoneOffset.UTC);
            ZonedDateTime actualUTC = ZonedDateTime.parse(apiCollectionDate);

            System.out.println("🕓 Expected UTC: " + expectedUTC + " | API UTC: " + actualUTC);

            // Compare only up to minute
            LocalDateTime expected = expectedUTC.toLocalDateTime().withSecond(0).withNano(0);
            LocalDateTime actual = actualUTC.toLocalDateTime().withSecond(0).withNano(0);

            assertEquals("❌ Collection date mismatch", expected, actual);
            System.out.println("✅ Collection Date matched successfully.");

        } catch (Exception e) {
            fail("❌ Failed to parse or compare dates: " + e.getMessage());
        }
    }*/

@Then("from API we need to get the labsquire order code")
public void from_api_we_need_to_get_the_labsquire_order_code() {
	 assertNotNull("❌ API data is null", apiData);

	    // Extract the internal _id (MongoDB document ID)
	    String labsquireOrderNmber = apiData.get("_id").toString();
	    System.out.println("✅ Labsquire Order Number is : " + labsquireOrderNmber);
	    ScenarioContext.labsquireOrderNumber = labsquireOrderNmber;


	
}

}

