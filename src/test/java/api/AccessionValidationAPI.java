package api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ApiUtils;
import utilities.ScenarioContext;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AccessionValidationAPI {
	 private Response response;
	    private Map<String, Object> apiData;
	    private Map<String, String> testData;
	    @When("the user sends a GET request with that labsquire order number to fetch order details")
	    public void the_user_sends_a_get_request_with_that_labsquire_order_number_to_fetch_order_details() {
	        String labsquireOrderNumber = ScenarioContext.labsquireOrderNumber;
	        assertNotNull("❌ labsquireOrderNumber is null!", labsquireOrderNumber);

	        response = ApiUtils.getAccessionDetail(labsquireOrderNumber);
	        assertNotNull("❌ API response is null", response);

	        System.out.println("✅ API Status Code: " + response.getStatusCode());
	        System.out.println("📦 Full API Response: " + response.asPrettyString());

	        // ✅ FIXED LINE
	        apiData = response.jsonPath().getMap("data");
	        assertNotNull("❌ 'data' object is missing in API response", apiData);

	        System.out.println("✅ Extracted 'data' object from API response.");
	    }

	    @Then("the API response should have status code {int} or not")
	    public void the_api_response_should_have_status_code_or_not(Integer expectedStatusCode) {
	        assertNotNull("❌ API response is null", response);

	        int actualStatus = response.getStatusCode();
	        int expected = expectedStatusCode.intValue(); // unbox to primitive int

	        assertEquals("❌ Status code mismatch", expected, actualStatus);
	    }



		
	
	@Then("the API should return the correct Accession id")
	public void the_api_should_return_the_correct_accession_id() {
       // String actual_accessionId = apiData.get("data.accession_data[0].accession_id").toString();
       // System.out.println("The actual accession ID is : "+ actual_accessionId);
        //assertEquals("❌ Order ID mismatch", ScenarioContext.accessionId, actual_accessionId);

		    List<Map<String, Object>> accessionList = (List<Map<String, Object>>) apiData.get("accession_data");

		    assertNotNull("❌ 'accession_data' is missing in API response", accessionList);
		    assertFalse("❌ 'accession_data' is empty", accessionList.isEmpty());

		    Map<String, Object> accession = accessionList.get(0);
		    String actualAccessionId = accession.get("accession_id").toString();

		    assertEquals("❌ Accession ID mismatch", ScenarioContext.accessionId, actualAccessionId);
		    System.out.println("✅ Accession ID: " + actualAccessionId + " == " + ScenarioContext.accessionId);
		}
		
	}



	


