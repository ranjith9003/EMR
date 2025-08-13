package utilities;

import java.util.Map;
import io.cucumber.java.Scenario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ScenarioContext {
    public static Scenario scenario;
    public static Map<String, String> testData;
    public static String orderId; 
    public static String caseType; 
    public static String accessionId;
    public static String labsquireOrderNumber;
    public static List<Map<String, String>> bulkTestData;
    public static int executionCounter = 0;
    public static boolean isBulkMode = false;
    public static String extractedEmrId;
    
    public static String extractedFirstName;

 // ✅ Utility methods for key-value storage
    public static void set(String key, String value) {
        if (testData == null) {
            testData = new HashMap<>();
        }
        testData.put(key, value);
    }

    public static String get(String key) {
        if (testData != null) {
            return testData.get(key);
        }
        return null;
    }

    public static void clear() {
        if (testData != null) {
            testData.clear();
        }
    }

	// ✅ Correctly placed inside the class
// ✅ Correctly placed inside the class
}
