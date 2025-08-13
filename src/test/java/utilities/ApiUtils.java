package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

    // Optionally: Store token in a config or load dynamically
    private static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY4NjNkMjY0OTQ0MjAyZjdmNmRiMDQyYyIsImVtYWlsIjoicmFuaml0aEBnbWFpbC5jb20iLCJ1c2VyX3R5cGUiOiJMQUJfTUFOQUdFUiIsImZpcnN0X25hbWUiOiJSYW5qaXRoIiwibGFzdF9uYW1lIjoiS3VtYXIiLCJpYXQiOjE3NTIyNDEzNDksImV4cCI6MTc1Mjg0NjE0OX0.lHb9lbcYLULirpJH-SF85UcML3WDMahMT_jIXrq9ID4"
    		; // 🔒 Replace with your actual token or read from config

    public static Response getOrderDetailsResponse(String orderId) {
        String baseUrl = "https://staging-dlw-api.labsquire.com/v2.0/orders";
        String fullUrl = baseUrl + "?page=1&order_id=" + orderId;

        System.out.println("🌐 Sending GET request to: " + fullUrl);

        try {
            Response response = RestAssured
                    .given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", AUTH_TOKEN)
                        .relaxedHTTPSValidation()
                    .when()
                        .get(fullUrl)
                    .then()
                        .extract()
                        .response();

            System.out.println("📥 Response Code: " + response.getStatusCode());
            return response;

        } catch (Exception e) {
            System.err.println("❌ API call failed: " + e.getMessage());
            throw e;
        }
    }
    public static Response getAccessionDetail(String labsquireOrderNmber) {
        String baseUrl = "https://staging-dlw-api.labsquire.com/v2.0/orders/";
        String fullUrl = baseUrl +labsquireOrderNmber;

        System.out.println("🌐 Sending GET request to: " + fullUrl);

        try {
            Response response = RestAssured
                    .given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", AUTH_TOKEN)  // Make sure AUTH_TOKEN is initialized
                        .relaxedHTTPSValidation()
                    .when()
                        .get(fullUrl)
                    .then()
                        .extract()
                        .response();

            System.out.println("📥 Response Code: " + response.getStatusCode());
            return response;

        } catch (Exception e) {
            System.err.println("❌ API call failed: " + e.getMessage());
            throw e;
        }
    }
    public static Response getCaseDetailsResponse(String accessionId) {
        String baseUrl = "https://staging-dlw-api.labsquire.com/v2.0/cases";
        String fullUrl = baseUrl + "?page=1&limit=25&accession_id=" + accessionId;

        System.out.println("🌐 Sending GET request to: " + fullUrl);

        try {
            Response response = RestAssured
                    .given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", AUTH_TOKEN)  // Make sure AUTH_TOKEN is initialized
                        .relaxedHTTPSValidation()
                    .when()
                        .get(fullUrl)
                    .then()
                        .extract()
                        .response();

            System.out.println("📥 Response Code: " + response.getStatusCode());
            return response;

        } catch (Exception e) {
            System.err.println("❌ API call failed: " + e.getMessage());
            throw e;
        }
    }
}
