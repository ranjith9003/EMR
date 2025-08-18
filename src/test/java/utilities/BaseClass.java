package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseClass {

    // --- CRITICAL CHANGE: Declaring static WebDriver here ---
    public static WebDriver driver;
    // --- END CRITICAL CHANGE ---

  
    public static WebElement getWebElement(By locator, Duration timeout) {
        return waitForElementToBeVisible(locator, timeout);
    }
    // --- END NEW REUSABLE GET METHOD ---


    public static void openUrl(String url) {
        driver.get(url);
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public static void uploadUsingRobot(String filePath) throws AWTException {
        // Copy the file path to the clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Use Robot to paste the file path and press Enter
        Robot robot = new Robot();
        robot.delay(1000); // Wait for the file dialog to appear

        // Press CTRL + V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter to confirm the file selection
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
        public static String replaceAccessionIdInCsv(String csvFilePath, String newAccessionId) throws IOException {
            Path path = Paths.get(csvFilePath);
            String fileName = path.getFileName().toString();
            String updatedFileName = fileName.replace(".csv", "_" + newAccessionId + ".csv");
            Path updatedFilePath = path.getParent().resolve(updatedFileName);

            // Updated regex: 2-3 letters + 9 digits
            Pattern accessionPattern = Pattern.compile("[A-Z]{2,3}\\d{9}");

            try (
                BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                BufferedWriter writer = Files.newBufferedWriter(updatedFilePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = accessionPattern.matcher(line);
                    String updatedLine = matcher.replaceAll(newAccessionId);
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

            System.out.println("✅ CSV accession content replaced and saved at: " + updatedFilePath);
            return updatedFilePath.toAbsolutePath().toString();
        }
        public static String replaceAccessionIdInTxt(String txtFilePath, String newAccessionId) throws IOException {
            Path path = Paths.get(txtFilePath);
            String fileName = path.getFileName().toString();
            
            // Change extension to include accession ID
            String updatedFileName;
            if (fileName.endsWith(".txt")) {
                updatedFileName = fileName.replace(".txt", "_" + newAccessionId + ".txt");
            } else {
                updatedFileName = fileName + "_" + newAccessionId + ".txt";
            }
            
            Path updatedFilePath = path.getParent().resolve(updatedFileName);

            // Regex pattern for 2-3 uppercase letters followed by 9 digits
            Pattern accessionPattern = Pattern.compile("[A-Z]{2,3}\\d{9}");

            try (
                BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                BufferedWriter writer = Files.newBufferedWriter(updatedFilePath, StandardCharsets.UTF_8, StandardOpenOption.CREATE)
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = accessionPattern.matcher(line);
                    String updatedLine = matcher.replaceAll(newAccessionId);
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

            System.out.println("✅ TXT accession content replaced and saved at: " + updatedFilePath);
            return updatedFilePath.toAbsolutePath().toString();
        }


    public static void closeFileDialog() {
        try {
            Robot robot = new Robot();
            Thread.sleep(1000); // Allow dialog to fully render
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            System.out.println("❎ File dialog closed using ESC key.");
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to close file dialog using Robot.", e);
        }
    }
    public static String getTextSafe(WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            String text = element.getText().trim();
            System.out.println("✅ Text retrieved: " + text);
            return text;
        } catch (Exception e) {
            System.err.println("❌ Failed to retrieve text from element: " + e.getMessage());
            return "";
        }
    }
    public static void assertTextEquals(String actual, String expected, boolean ignoreCase, boolean trimText) {
        if (actual == null || expected == null) {
            throw new AssertionError("❌ One or both strings are null. Actual: [" + actual + "] | Expected: [" + expected + "]");
        }

        String actualProcessed = trimText ? actual.trim() : actual;
        String expectedProcessed = trimText ? expected.trim() : expected;

        boolean result = ignoreCase
                ? actualProcessed.equalsIgnoreCase(expectedProcessed)
                : actualProcessed.equals(expectedProcessed);

        if (!result) {
            throw new AssertionError("❌ Assertion Failed:\nExpected: [" + expectedProcessed + "]\nActual:   [" + actualProcessed + "]");
        } else {
            System.out.println("✅ Assertion Passed: " + actualProcessed + " == " + expectedProcessed);
        }
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void navigateForward() {
        driver.navigate().forward();
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static void closeBrowser() {
        driver.close();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void click(WebElement element) {
        element.click();
    }
    public static boolean compareChildSpanTexts(WebElement container1, WebElement container2,
            boolean ignoreOrder, boolean ignoreCase, boolean trimText) {
try {
// Find all <span> children under each container
List<WebElement> list1Elements = container1.findElements(By.tagName("span"));
List<WebElement> list2Elements = container2.findElements(By.tagName("span"));

List<String> list1Texts = extractTextList(list1Elements, trimText, ignoreCase);
List<String> list2Texts = extractTextList(list2Elements, trimText, ignoreCase);

if (ignoreOrder) {
return new HashSet<>(list1Texts).equals(new HashSet<>(list2Texts));
} else {
return list1Texts.equals(list2Texts);
}

} catch (Exception e) {
System.err.println("❌ Error comparing span texts: " + e.getMessage());
return false;
}
}

/**
* Extracts text from a list of WebElements with optional trimming and case conversion.
*/
private static List<String> extractTextList(List<WebElement> elements, boolean trim, boolean toLower) {
List<String> texts = new ArrayList<>();
for (WebElement el : elements) {
String text = el.getText();
if (trim) text = text.trim();
if (toLower) text = text.toLowerCase();
texts.add(text);
}
return texts;
}

public static void printSpanTexts(WebElement container, String label) {
    try {
        List<WebElement> spans = container.findElements(By.tagName(".//span"));
        System.out.println("🔹 " + label + " (" + spans.size() + " items):");
        for (WebElement span : spans) {
            String text = span.getText().trim();
            if (!text.isEmpty()) {
                System.out.println("• " + text);
            }
        }
    } catch (Exception e) {
        System.err.println("❌ Failed to print span texts for: " + label);
        e.printStackTrace();
    }
}

public static void waitAndClick(WebElement element, int timeoutInSeconds) {
    int maxRetries = 3;
    int retryCount = 0;
    boolean isClicked = false;

    while (retryCount < maxRetries && !isClicked) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

            // Step 1: Wait until the element is clickable
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("✅ Element is clickable: " + element);

            // Step 2: Click the element
            element.click();
            System.out.println("✅ Clicked the element successfully.");

            // Step 3: Optional wait for UI stability
            Thread.sleep(1000); // small wait

            // Step 4: Optional - Post-click condition (customize below if needed)
            // For example: check for modal/dialog or page change
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someExpectedElementAfterClick")));

            isClicked = true; // If no exception, assume success

        } catch (Exception e) {
            retryCount++;
            System.err.println("❌ Attempt " + retryCount + " failed to click element: " + element);
            e.printStackTrace();

            if (retryCount == maxRetries) {
                throw new RuntimeException("Clicking element failed after " + maxRetries + " attempts: " + e.getMessage());
            }

            try {
                Thread.sleep(1000); // Wait before retrying
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

    public static void waitForUploadCompletion(WebElement element, int timeoutSeconds) {
        try {
            Thread.sleep(2000); // Buffer time to allow OS dialog or processing to settle

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("✅ Upload completed, element is now visible: " + element.toString());
        } catch (Exception e) {
            throw new RuntimeException("❌ Upload did not complete or element is not visible: " + element.toString(), e);
        }
    }

    public static void waitAndInput(WebElement element, String text, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
    public static void selectTests(List<String> testNames) {
        for (String testName : testNames) {
            try {
                // Dynamic XPath based on label text
                String xpath = "//label[.//span[normalize-space(text())='" + testName + "']]"
                             + "//input[@type='checkbox' and not(@disabled)]";

                // Use BaseClass driver
                List<WebElement> elements = BaseClass.driver.findElements(By.xpath(xpath));

                if (elements.isEmpty()) {
                    System.out.println("❌ Test not found in UI: " + testName);
                    continue;
                }

                // Pick only the displayed element (avoid duplicates like 1 of 11)
                WebElement checkbox = elements.stream()
                                              .filter(WebElement::isDisplayed)
                                              .findFirst()
                                              .orElse(null);

                if (checkbox == null) {
                    System.out.println("❌ No visible checkbox found for: " + testName);
                    continue;
                }

                // Click if not already selected
                if (!checkbox.isSelected()) {
                    BaseClass.waitAndClick(checkbox, 5); // ✅ reuse waitAndClick
                    System.out.println("✔ Selected: " + testName);
                } else {
                    System.out.println("ℹ Already selected: " + testName);
                }

            } catch (Exception e) {
                System.err.println("⚠ Failed to select test: " + testName + " | " + e.getMessage());
            }
        }
    }
    public static void waitUntilPageReady(WebElement keyElement, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            // 1️⃣ Wait for document.readyState = complete
            wait.until(webDriver -> 
                ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
            );

            // 2️⃣ Wait for key element to be visible (ensures UI content is ready)
            wait.until(ExpectedConditions.visibilityOf(keyElement));

            System.out.println("✅ Page is fully loaded and key element is visible: " + keyElement.toString());
        } catch (Exception e) {
            System.err.println("❌ Timeout waiting for page and element: " + keyElement.toString());
            throw e;
        }
    }


    public static void waitAndClickWithRetries(WebElement element, int timeoutInSeconds, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                System.out.println("✅ Attempt " + (attempts + 1) + " - Element ready: " + describeElement(element));
                element.click();
                return;
            } catch (Exception e) {
                System.err.println("⚠️ Attempt " + (attempts + 1) + " failed: " + e.getMessage());
                attempts++;
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
        throw new RuntimeException("❌ Failed to click after " + maxRetries + " attempts: " + describeElement(element));
    }
    public static void waitAndClickWithJSFallback(WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            try {
                element.click();
                System.out.println("✅ Clicked normally: " + describeElement(element));
            } catch (Exception clickException) {
                System.err.println("⚠️ Standard click failed. Trying JS click: " + describeElement(element));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
            }
        } catch (Exception e) {
            System.err.println("❌ Click (with JS fallback) failed: " + describeElement(element));
            throw new RuntimeException(e);
        }
    }
    public static void pressEnter(WebElement element) {
        try {
            if (element != null) {
                element.sendKeys(Keys.ENTER);
                System.out.println("✅ ENTER key sent to element.");
            } else {
                BaseClass.driver.findElement(By.tagName("body")).sendKeys(Keys.ENTER);
                System.out.println("✅ ENTER key sent to <body>.");
            }
        } catch (Exception e) {
            System.err.println("❌ Failed to press ENTER key.");
            e.printStackTrace();
            throw e;
        }
    }
    public static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Proper thread handling
            System.out.println("Wait interrupted: " + e.getMessage());
        }
    }

    public void waitForTextToBePresent(WebElement element, String expectedText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    }

    public static String describeElement(WebElement element) {
        if (element == null) {
            return "[Element is null]";
        }

        try {
            String tag = element.getTagName();
            String text = element.getText();
            String clazz = element.getAttribute("class");
            String id = element.getAttribute("id");
            return String.format("[Tag: %s, Text: %s, ID: %s, Class: %s]", tag, text, id, clazz);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            return "[Stale element reference]";
        } catch (Exception e) {
            return "[Unable to describe element: " + e.getMessage() + "]";
        }
    }
    /**
     * Validates the text displayed after selecting a value from a custom dropdown.
     *
     * @param displayElement The WebElement where the selected value appears (e.g., dropdown field).
     * @param expectedText   The expected visible text (e.g., "Covid-19").
     */
    public static void validateDropdownSelectedValue(WebElement displayElement, String expectedText) {
        if (displayElement == null) {
            throw new IllegalArgumentException("Display element is null. Cannot perform validation.");
        }

        String actualText = displayElement.getText().trim();
        System.out.println("🔍 Validating dropdown selection: expected = '" + expectedText + "', actual = '" + actualText + "'");

        Assert.assertEquals(actualText, expectedText, "❌ Dropdown value mismatch.");
    }

    public static void selectFromAutocompleteDropdownWithWait(WebElement element, String value, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            System.out.println("🔹 Typing value into autocomplete: " + value);
            element.clear();
            element.sendKeys(value);

            Thread.sleep(1000); // Allow dropdown suggestions to load

            element.sendKeys(Keys.ARROW_DOWN);
            element.sendKeys(Keys.ENTER);

            System.out.println("✅ Value selected via ARROW_DOWN + ENTER");

        } catch (Exception e) {
            System.err.println("❌ Failed to select from autocomplete: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static String getInputValue(WebElement element) {
        return element.getAttribute("value").trim();
    }
    public static void selectDropdownOptionByVisibleText(WebElement inputField, String optionText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            inputField.clear();
            inputField.sendKeys(optionText); // Type the text

            // Wait for dropdown option to appear and click it
            By optionLocator = By.xpath("//span[text()='" + optionText + "']");
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
            option.click();

            System.out.println("✅ Successfully selected: " + optionText);
        } catch (Exception e) {
            System.err.println("❌ Failed to select dropdown option: " + optionText);
            e.printStackTrace();
        }
    }
    public static void selectDropdownOptionByPartialText(WebElement inputField, String partialText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            inputField.clear();
            inputField.sendKeys(partialText); // Type the text into the dropdown input

            // Wait for matching option that contains the given text
            By optionLocator = By.xpath("//span[contains(text(),'" + partialText + "')]");
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
            option.click();

            System.out.println("✅ Successfully selected dropdown option containing: " + partialText);
        } catch (Exception e) {
            System.err.println("❌ Could not select dropdown option containing: " + partialText);
            e.printStackTrace();
        }
    }

    public static void input(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clear(WebElement element) {
        element.clear();
    }


public static String getValueFromElement(WebElement element, int timeoutInSeconds) {
    try {
        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));

        // Get the value attribute
        String value = element.getAttribute("value");
        if (value != null && !value.isEmpty()) {
            System.out.println("✅ Value fetched from element: " + value);
            return value;
        } else {
            System.out.println("⚠️ Element is visible but value is empty.");
        }
    } catch (Exception e) {
        System.out.println("❌ Failed to fetch value from element: " + e.getMessage());
    }

    throw new AssertionError("❌ Unable to fetch value from the element within the timeout.");
}

public static String getTextSafe(WebElement element, int timeoutInSeconds, int maxRetries) {
    int attempts = 0;

    while (attempts < maxRetries) {
        try {
            // Wait for the element to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));

            // Get and trim the text
            String text = element.getText().trim();

            if (!text.isEmpty()) {
                System.out.println("✅ Text fetched from element: " + text);
                return text;
            } else {
                System.out.println("⚠️ Attempt " + (attempts + 1) + ": Element is visible but text is empty.");
            }
        } catch (TimeoutException e) {
            System.out.println("⏳ Retry " + (attempts + 1) + " failed: TimeoutException - " + e.getMessage());
        } catch (StaleElementReferenceException e) {
            System.out.println("⏳ Retry " + (attempts + 1) + " failed: StaleElementReferenceException - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("⏳ Retry " + (attempts + 1) + " failed: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }

        attempts++;

        // Wait before the next retry
        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Retry sleep interrupted", ie);
        }
    }

    // If no valid text found after all retries
    throw new AssertionError("❌ Failed to fetch non-empty text from element after " + maxRetries + " attempts.");
}

    public static String getText(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    public static void waitUntilSuccess(Runnable action, int maxRetries, int delayInSeconds) {
        int attempts = 0;

        while (attempts < maxRetries) {
            try {
                action.run();
                System.out.println("✅ Action succeeded on attempt: " + (attempts + 1));
                return;
            } catch (Exception e) {
                System.out.println("⏳ Retry " + (attempts + 1) + " failed: " + e.getClass().getSimpleName() + " - " + e.getMessage());
            }

            attempts++;

            // Optional sleep between retries
            try {
                Thread.sleep(delayInSeconds * 1000L);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Retry sleep interrupted", ie);
            }
        }

        throw new AssertionError("❌ Action failed after " + maxRetries + " retries.");
    }

    public static String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public static boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public static List<WebElement> getElements(By locator) { // Driver param removed
        return driver.findElements(locator);
    }

    public static void selectByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    
    public void retryClick(WebElement element, int attempts, int intervalMs) throws Throwable {
        for (int i = 0; i < attempts; i++) {
            try {
                waitForVisibility(element, i);
                element.click();
                return;
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("Unable to click after retries: " + element);
    }

    public String runProcessAndGetOutput(String exePath, String script, String arg) {
        try {
            Process process = new ProcessBuilder(exePath, script, arg).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("AutoIt upload failed: " + e.getMessage());
        }
    }


   
    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static List<WebElement> getAllDropdownOptions(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    public static WebElement waitForElementToBeVisible(By locator, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForUrlContains(String partialUrl, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public static boolean waitForTitleContains(String partialTitle, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.titleContains(partialTitle));
    }

    public static WebElement waitForElementToContainText(By locator, String text, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = getWebElement(locator, timeout); // Using the new getWebElement
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        return element;
    }

    public static boolean waitForElementToDisappear(By locator, Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static Alert waitForAlert(Duration timeout) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public static WebElement fluentWait(By locator, int timeoutSeconds, int pollingMillis) { // Driver param removed
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(pollingMillis))
            .ignoring(NoSuchElementException.class);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForPresenceOfElement(By locator, int timeoutSeconds) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForNumberOfWindows(int count, int timeoutSeconds) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            return wait.until(ExpectedConditions.numberOfWindowsToBe(count));
        } catch (TimeoutException e) {
            System.out.println("Number of windows did not become " + count + " within " + timeoutSeconds + " seconds.");
            return false;
        }
    }

    public static boolean waitForAttributeValue(By locator, String attribute, String expectedValue, int timeoutSeconds) { // Driver param removed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            return wait.until(ExpectedConditions.attributeToBe(locator, attribute, expectedValue));
        } catch (TimeoutException e) {
            System.out.println("Element " + locator + " attribute '" + attribute + "' did not become '" + expectedValue + "' within " + timeoutSeconds + " seconds.");
            return false;
        }
    }

    public static void waitForPageLoadComplete(Duration timeout) { // Driver param removed
        new WebDriverWait(driver, timeout).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public static void acceptAlert() { // Driver param removed
        driver.switchTo().alert().accept();
    }

    public static void dismissAlert() { // Driver param removed
        driver.switchTo().alert().dismiss();
    }

    public static String getAlertText() { // Driver param removed
        return driver.switchTo().alert().getText();
    }

    public static void sendTextToAlert(String text) { // Driver param removed
        driver.switchTo().alert().sendKeys(text);
    }

    public static void switchToFrameByIndex(int index) { // Driver param removed
        driver.switchTo().frame(index);
    }

    public static void switchToFrameByIdOrName(String nameOrId) { // Driver param removed
        driver.switchTo().frame(nameOrId);
    }

    public static void switchToFrameByWebElement(WebElement frameElement) { // Driver param removed
        driver.switchTo().frame(frameElement);
    }

    public static void switchToDefaultContent() { // Driver param removed
        driver.switchTo().defaultContent();
    }

    public static void takeScreenshot(String fileName) { // Driver param removed
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    public static void takeScreenshotOfElement(WebElement element, String fileName) {
        File src = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshots/element_" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println("Failed to save element screenshot: " + e.getMessage());
        }
    }

    public static void takeScreenshotWithTimestamp(String prefix) { // Driver param removed
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        try {
            FileUtils.copyFile(src, new File("screenshots/" + prefix + "_" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void assertElementDisplayed(WebElement element, String elementName) {
        if (element != null && element.isDisplayed()) {
            System.out.println("✅ '" + elementName + "' is displayed.");
        } else {
            throw new AssertionError("❌ '" + elementName + "' is not displayed.");
        }
    }

    public static String getScreenshotAsBase64() { // Driver param removed
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static Object executeScript(String script, Object... args) { // Driver param removed
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script, args);
    }

    public static void clickUsingJS(WebElement element) { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void setValueUsingJS(WebElement element, String value) { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);
    }

    public static void scrollToBottom() { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToTop() { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
    }

    public static void scrollByOffset(int x, int y) { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public static void scrollIntoView(WebElement element, int timeoutInSeconds) {
        WebDriver driver = BaseClass.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Wait for element to be visible before scrolling
            wait.until(ExpectedConditions.visibilityOf(element));

            // Attempt scrollIntoView first
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
            Thread.sleep(300);  // Small pause after scroll

            System.out.println("✅ Scrolled to element using scrollIntoView: " + describeElement(element));
            return;
        } catch (Exception e1) {
            System.err.println("⚠️ scrollIntoView failed, trying fallback scroll... " + e1.getMessage());
        }

        try {
            // Try downward pixel scroll
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(300);
            wait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("✅ Scrolled to element using downward pixel scroll: " + describeElement(element));
            return;
        } catch (Exception e2) {
            System.err.println("⚠️ Downward scroll failed: " + e2.getMessage());
        }

        try {
            // Try upward pixel scroll
            js.executeScript("window.scrollBy(0, -300);");
            Thread.sleep(300);
            wait.until(ExpectedConditions.visibilityOf(element));

            System.out.println("✅ Scrolled to element using upward pixel scroll: " + describeElement(element));
            return;
        } catch (Exception e3) {
            System.err.println("❌ All scroll attempts failed for element: " + describeElement(element));
            e3.printStackTrace();
            throw new RuntimeException("Scroll to element failed after trying all methods for " + timeoutInSeconds + " seconds");
        }
    }

    public static WebElement safeScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;

        try {
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            Thread.sleep(300);
            return element;
        } catch (Exception e1) {
            System.out.println("⚠️ scrollIntoView failed: " + e1.getMessage());
        }

        try {
            js.executeScript("window.scrollBy(0, 300);");
            Thread.sleep(300);
            return element;
        } catch (Exception e2) {
            System.out.println("⚠️ Downward scroll failed: " + e2.getMessage());
        }

        try {
            js.executeScript("window.scrollBy(0, -300);");
            Thread.sleep(300);
            return element;
        } catch (Exception e3) {
            System.err.println("❌ All scroll attempts failed: " + e3.getMessage());
        }

        return element; // Still return it even if scroll fails
    }

    public static void scrollByPixels(int xPixels, int yPixels) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BaseClass.driver;
            js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xPixels, yPixels);
            System.out.println("✅ Scrolled by x: " + xPixels + ", y: " + yPixels);
        } catch (Exception e) {
            System.err.println("❌ Failed to scroll by pixels: x=" + xPixels + ", y=" + yPixels);
            e.printStackTrace();
            throw new RuntimeException("Pixel scrolling failed.");
        }
    }
    public static void highlightElement(WebElement element) { // Driver param removed
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static void clearLocalStorage() { // Driver param removed
        ((JavascriptExecutor) driver).executeScript("window.localStorage.clear();");
    }

    public static void setLocalStorageItem(String key, String value) { // Driver param removed
        ((JavascriptExecutor) driver).executeScript(String.format("window.localStorage.setItem('%s', '%s');", key, value));
    }

    public static String getLocalStorageItem(String key) { // Driver param removed
        return (String) ((JavascriptExecutor) driver).executeScript(String.format("return window.localStorage.getItem('%s');", key));
    }

    public static void hoverOverElement(WebElement element) { // Driver param removed
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public static void dragAndDrop(WebElement source, WebElement target) { // Driver param removed
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }

    public static void dragAndDropByOffset(WebElement source, int xOffset, int yOffset) { // Driver param removed
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(source, xOffset, yOffset).perform();
    }

    public static void doubleClick(WebElement element) { // Driver param removed
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void rightClick(WebElement element) { // Driver param removed
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    public static void sendKeyToElement(WebElement element, Keys key) {
        element.sendKeys(key);
    }

   

    public static void pressTab(WebElement element) {
        element.sendKeys(Keys.TAB);
    }

    public static void performComplexMouseAction(Consumer<Actions> actionSequence) { // Driver param removed
        Actions actions = new Actions(driver);
        actionSequence.accept(actions);
        actions.build().perform();
    }

    public static void switchToNewTab() { // Driver param removed
        String currentHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void switchToNewWindow() { // Driver param removed
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public static void closeChildAndSwitchBack() { // Driver param removed
        String mainWindow = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle).close();
            }
        }
        driver.switchTo().window(mainWindow);
    }

    public static void closeCurrentTabAndSwitchToMain() { // Driver param removed
        String originalHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
        driver.switchTo().window(originalHandle);
    }

    public static void switchToWindowByTitle(String title) { // Driver param removed
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    public static void switchToWindowByUrl(String url) { // Driver param removed
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains(url)) {
                break;
            }
        }
    }

    public static void setPageLoadTimeout(Duration timeout) { // Driver param removed
        driver.manage().timeouts().pageLoadTimeout(timeout);
    }

    public static List<String> getAllLinksOnPage() { // Driver param removed
        List<String> links = new ArrayList<>();
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        for (WebElement linkElement : linkElements) {
            String href = linkElement.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                links.add(href);
            }
        }
        return links;
    }
    public static void assertDropdownValueSelected(WebElement dropdown, String expectedValue, int timeout) {
        waitForVisibility(dropdown, timeout);
        Select select = new Select(dropdown);
        String selected = select.getFirstSelectedOption().getText().trim();
        if (!selected.equalsIgnoreCase(expectedValue)) {
            throw new AssertionError("❌ Dropdown mismatch! Expected: " + expectedValue + ", but got: " + selected);
        }
    }


    public static void addCookie(String name, String value) { // Driver param removed
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    public static Set<Cookie> getAllCookies() { // Driver param removed
        return driver.manage().getCookies();
    }

    public static Cookie getCookieByName(String name) { // Driver param removed
        return driver.manage().getCookieNamed(name);
    }

    public static void deleteCookie(String name) { // Driver param removed
        driver.manage().deleteCookieNamed(name);
    }

    public static void deleteAllCookies() { // Driver param removed
        driver.manage().deleteAllCookies();
    }

    public static boolean isTextPresent(String text) { // Driver param removed
        return driver.getPageSource().contains(text);
    }

    public static boolean isElementPresent(By locator) { // Driver param removed
        return driver.findElements(locator).size() > 0;
    }

    public static boolean isElementVisible(WebElement element, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isClickable(By locator, Duration timeout) { // Driver param removed
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
 // Wait until element is visible
    public static void waitForVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait until element is clickable
    public static void waitForClickability(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Assert that an element is visible
    public static void assertElementVisible(WebElement element, int timeoutInSeconds) {
        try {
            waitForVisibility(element, timeoutInSeconds);
            System.out.println("✅ Element is visible: " + element.toString());
        } catch (TimeoutException e) {
            throw new AssertionError("❌ Element NOT visible within " + timeoutInSeconds + " seconds: " + element.toString());
        }
    }

    // Assert that a specific text is present in the page source within timeout
    public static void assertTextPresent(String expectedText, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));
            System.out.println("✅ Text found in page: " + expectedText);
        } catch (TimeoutException e) {
            throw new AssertionError("❌ Text NOT found in page within " + timeoutInSeconds + " seconds: " + expectedText);
        }
    }

    // Assert element is visible with scroll first (optional)
    public static void assertElementVisibleWithScroll(WebElement element, int timeoutInSeconds) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            waitForVisibility(element, timeoutInSeconds);
            System.out.println("✅ Element is visible after scroll: " + element.toString());
        } catch (TimeoutException e) {
            throw new AssertionError("❌ Element NOT visible after scroll within " + timeoutInSeconds + " seconds: " + element.toString());
        }
    }
    public static void assertElementValueMatches(WebElement element, String expectedValue, int timeout) {
        waitForVisibility(element, timeout);
        String actualValue = element.getAttribute("value");

        // Normalize both to avoid mismatches like 2 vs 02
        String normalizedExpected = expectedValue.trim().replaceFirst("^0+(?!$)", "");
        String normalizedActual = actualValue.trim().replaceFirst("^0+(?!$)", "");

        if (!normalizedExpected.equals(normalizedActual)) {
            throw new AssertionError("❌ Value mismatch! Expected: " + expectedValue + ", but got: " + actualValue);
        } else {
            System.out.println("✅ Value match: " + expectedValue);
            System.out.println("Actual value: " + actualValue + " | Expected Value: " + expectedValue);
        }
    }
    public static void pressEscapeKey() {
        try {
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();
            System.out.println("🔄 ESC key pressed to close dropdown or modal.");
        } catch (Exception e) {
            System.err.println("⚠️ Failed to press ESC key: " + e.getMessage());
        }
    }

    // Assert that the element's text matches expected
    public static void assertElementTextEquals(WebElement element, String expectedText, int timeoutInSeconds) {
        try {
            waitForVisibility(element, timeoutInSeconds);
            String actualText = element.getText().trim();
            if (!actualText.equals(expectedText)) {
                throw new AssertionError("❌ Text mismatch: Expected [" + expectedText + "] but found [" + actualText + "]");
            } else {
                System.out.println("✅ Text matches: " + expectedText);
            }
        } catch (TimeoutException e) {
            throw new AssertionError("❌ Element text not found within " + timeoutInSeconds + " seconds for validation: " + expectedText);
        }
    }


    public static String getCssValue(WebElement element, String propertyName) {
        return element.getCssValue(propertyName);
    }

    public static boolean verifyCurrentUrl(String expectedUrl) { // Driver param removed
        return driver.getCurrentUrl().equals(expectedUrl);
    }

    public static boolean verifyElementText(WebElement element, String expectedText) {
        String actualText = element.getText();
        return actualText.contains(expectedText);
    }

    public static boolean isCheckboxSelected(WebElement element) {
        return element.isSelected();
    }
    public static void assertElementTextContainsWithRetry(WebElement element, String expected, int timeout) {
        int attempts = 0;
        int maxAttempts = 2;

        while (attempts < maxAttempts) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

                // Wait until element is visible and text is present
                wait.until(ExpectedConditions.visibilityOf(element));
                wait.until(ExpectedConditions.textToBePresentInElement(element, expected));

                String actual = element.getText().trim();

                if (!actual.contains(expected)) {
                    throw new AssertionError(
                        "❌ Text mismatch!\nExpected to contain: [" + expected + "]\nActual: [" + actual + "]"
                    );
                }

                System.out.println("✅ Text verified successfully.\nExpected: [" + expected + "]\nActual: [" + actual + "]");
                return; // success

            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ Attempt " + (attempts + 1) + " failed due to stale element. Retrying...");
                attempts++;
            } catch (TimeoutException e) {
                throw new AssertionError(
                    "❌ Timeout after " + timeout + "s\nExpected text: [" + expected + "] was not found in element."
                );
            }
        }

        throw new AssertionError(
            "❌ Failed after " + maxAttempts + " retries.\nExpected text: [" + expected + "] was not found in element."
        );
    }


    public static boolean validateElementText(By locator, String expectedText) { // Driver param removed
        String actual = getWebElement(locator, Duration.ofSeconds(10)).getText().trim();
        return actual.equals(expectedText);
    }

    public static boolean validateTextContains(By locator, String partialText) { // Driver param removed
        String actual = getWebElement(locator, Duration.ofSeconds(10)).getText().trim();
        return actual.contains(partialText);
    }

    public static boolean validateAttributeContains(By locator, String attribute, String expectedValue) { // Driver param removed
        String actual = getWebElement(locator, Duration.ofSeconds(10)).getAttribute(attribute);
        return actual != null && actual.contains(expectedValue);
    }

    public static boolean validateCurrentUrl(String expectedUrl) { // Driver param removed
        return driver.getCurrentUrl().equals(expectedUrl);
    }

    public static boolean validatePageTitle(String expectedTitle) { // Driver param removed
        return driver.getTitle().equals(expectedTitle);
    }

    public static boolean validatePageTitleContains(String partialTitle) { // Driver param removed
        return driver.getTitle().contains(partialTitle);
    }

    public static boolean dropdownContainsOption(By locator, String expectedOption) { // Driver param removed
        Select select = new Select(driver.findElement(locator));
        return select.getOptions().stream()
                     .anyMatch(opt -> opt.getText().trim().equalsIgnoreCase(expectedOption));
    }

    public static boolean validateSelectedOption(By locator, String expectedOption) { // Driver param removed
        Select select = new Select(driver.findElement(locator));
        return select.getFirstSelectedOption().getText().trim().equalsIgnoreCase(expectedOption);
    }

    public static boolean validateTableContainsText(By tableLocator, String searchText) { // Driver param removed
        List<WebElement> rows = driver.findElements(By.xpath(tableLocator + "//tr"));
        for (WebElement row : rows) {
            if (row.getText().contains(searchText)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateElementCount(By locator, int expectedCount) { // Driver param removed
        return driver.findElements(locator).size() == expectedCount;
    }

    public static boolean isElementNotPresent(By locator) { // Driver param removed
        return driver.findElements(locator).isEmpty();
    }

    public static boolean isCheckboxChecked(By locator) { // Driver param removed
        WebElement checkbox = getWebElement(locator, Duration.ofSeconds(10)); // Using getWebElement
        return checkbox.isSelected();
    }

    public static void assertElementText(By locator, String expected) { // Driver param removed
        String actual = getWebElement(locator, Duration.ofSeconds(10)).getText().trim(); // Using getWebElement
        org.junit.Assert.assertEquals(expected, actual);
    }

    public static List<String> getAllTextsFromElements(By locator) { // Driver param removed
        List<WebElement> elements = driver.findElements(locator);
        List<String> texts = new ArrayList<>();
        for (WebElement element : elements) {
            texts.add(element.getText().trim());
        }
        return texts;
    }

    public static int getTableRowCount(By tableLocator) { // Driver param removed
        return driver.findElements(By.xpath(tableLocator + "//tr")).size();
    }

    public static String getTableCellValue(By tableLocator, int row, int col) { // Driver param removed
        return driver.findElement(By.xpath("(" + tableLocator + "//tr)[" + row + "]/td[" + col + "]")).getText();
    }

    public static By getDynamicLocator(String xpathFormat, String value) {
        return By.xpath(String.format(xpathFormat, value));
    }

    // Excel methods (remain as is, as they don't use 'driver' directly)
    // Note: You'll need to manage Workbook/Sheet/filePath externally and pass them.
    public static Sheet setSheet(Workbook workbook, String sheetName) {
        return workbook.getSheet(sheetName);
    }

    public static int getRowCount(Sheet sheet) {
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColumnCount(Sheet sheet, int rowNum) {
        Row row = sheet.getRow(rowNum);
        return (row != null) ? row.getLastCellNum() : 0;
    }

    public static String getCellData(Sheet sheet, int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";
        Cell cell = row.getCell(colNum);
        return getFormattedCellValue(cell);
    }

    public static void setCellData(Sheet sheet, String filePath, int rowNum, int colNum, String value) {
        try {
            Row row = sheet.getRow(rowNum);
            if (row == null) row = sheet.createRow(rowNum);

            Cell cell = row.getCell(colNum);
            if (cell == null) cell = row.createCell(colNum);

            cell.setCellValue(value);
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                sheet.getWorkbook().write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> getSheetDataAsListOfMap(Sheet sheet) {
        List<Map<String, String>> dataList = new ArrayList<>();
        int rowCount = getRowCount(sheet);

        if (rowCount <= 1) return dataList;

        Row headerRow = sheet.getRow(0);
        int colCount = headerRow.getLastCellNum();
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> rowMap = new LinkedHashMap<>();
            for (int j = 0; j < colCount; j++) {
                String key = getFormattedCellValue(headerRow.getCell(j));
                String value = getFormattedCellValue(row.getCell(j));
                rowMap.put(key, value);
            }
            dataList.add(rowMap);
        }
        return dataList;
    }

    public static String getFormattedCellValue(Cell cell) {
        if (cell == null) return "";
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public static void closeWorkbook(Workbook workbook) {
        try {
            if (workbook != null) workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Object[]> getSheetDataAs2DArray(Workbook workbook, String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            System.err.println("Sheet '" + sheetName + "' not found in workbook.");
            return new ArrayList<>();
        }
        List<Object[]> data = new ArrayList<>();
        int rowCount = getRowCount(sheet);

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            int colCount = getColumnCount(sheet, i);
            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                rowData[j] = getCellData(sheet, i, j);
            }
            data.add(rowData);
        }
        return data;
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] files = dir.listFiles();
        if (files == null) {
            System.err.println("Download directory does not exist or is not a directory: " + downloadPath);
            return false;
        }
        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getBrowserConsoleLogs() { // Driver param removed
        List<String> logMessages = new ArrayList<>();
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (org.openqa.selenium.logging.LogEntry entry : logEntries) {
            logMessages.add(entry.getLevel() + " " + entry.getMessage());
        }
        return logMessages;
    }

    public static String getCurrentDate(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String getCurrentDateTime(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    public static String addDays(int days, String format) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern(format));
    }

    public static String subtractDays(int days, String format) {
        return LocalDate.now().minusDays(days).format(DateTimeFormatter.ofPattern(format));
    }

    public static String addMonths(int months, String format) {
        return LocalDate.now().plusMonths(months).format(DateTimeFormatter.ofPattern(format));
    }

    public static String subtractMonths(int months, String format) {
        return LocalDate.now().minusMonths(months).format(DateTimeFormatter.ofPattern(format));
    }

    public static String reformatDate(String inputDate, String fromFormat, String toFormat) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(fromFormat);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(toFormat);
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);
        return date.format(outputFormatter);
    }

    public static boolean isDateBefore(String date1, String date2, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate d1 = LocalDate.parse(date1, formatter);
        LocalDate d2 = LocalDate.parse(date2, formatter);
        return d1.isBefore(d2);
    }

    public static boolean isDateAfter(String date1, String date2, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate d1 = LocalDate.parse(date1, formatter);
        LocalDate d2 = LocalDate.parse(date2, formatter);
        return d1.isAfter(d2);
    }

    public static String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    public static void retryingClick(By locator, int attempts) { // Driver param removed
        int tries = 0;
        while (tries < attempts) {
            try {
                WebElement element = waitForElementToBeClickable(locator, Duration.ofSeconds(10));
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                tries++;
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }
    }

    public static int getElementCount(By locator) { // Driver param removed
        return driver.findElements(locator).size();
    }

    public static void uploadFile(By locator, String absoluteFilePath) { // Driver param removed
        driver.findElement(locator).sendKeys(absoluteFilePath);
    }

    public static void typePassword(By locator, String password) { // Driver param removed
        WebElement element = getWebElement(locator, Duration.ofSeconds(10));
        element.clear();
        element.sendKeys(password);
        System.out.println("Password entered [MASKED]");
    }
}