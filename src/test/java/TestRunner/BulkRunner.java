package TestRunner;

import utilities.ConfigReader;
import utilities.ExcelAllRows;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BulkRunner {

    public static void main(String[] args) throws IOException, InterruptedException {
        String excelPath = ConfigReader.get("excel.filePath_microgen");
        String sheet = ConfigReader.get("excel.sheetName");
        List<Map<String, String>> allRows = ExcelAllRows.getAllRows(excelPath, sheet);

        int actualRowIndex = 0;

        for (int i = 0; i < allRows.size(); i++) {
            Map<String, String> row = allRows.get(i);

            boolean isEmptyRow = row.values().stream()
                .allMatch(value -> value == null || value.trim().isEmpty());

            if (isEmptyRow) {
                System.out.println("⚠️ Skipping empty row: Excel row " + (i + 2)); // +2 = actual Excel row (header + 1)
                continue;
            }

           // System.out.println("\n🚀 Running Scenario for Excel Row: " + (i + 2));
            String rowIndex = String.valueOf(i); // no +1 here

            ProcessBuilder processBuilder = new ProcessBuilder(
                "java",
                "-Dcucumber.filter.tags=@allRows",
                "-Dexecution.counter=" + rowIndex,
                "-cp", System.getProperty("java.class.path"),
                "io.cucumber.core.cli.Main",
                "--glue", "StepDefinition",
                "--glue", "Hooks",
                "src/test/resources/Feature",
                "--plugin", "pretty",
                "--plugin", "utilities.ExtentReportListener",   // <-- ADD Extent plugin
                "--plugin", "html:target/cucumber-reports/bulk-row-" + (actualRowIndex + 1),
                "--plugin", "json:target/jsonReports/bulk-row-" + (actualRowIndex + 1) + ".json"
            );

            processBuilder.inheritIO();
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                System.err.println("All Rows are executed successfully");
            }

            actualRowIndex++;
        }
    }
}
