package Hooks;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.nio.file.Paths;

public class PlaywrightHooks {
    private static Playwright playwright;
    private static BrowserContext browserContext;
    public static Page page;

    // The persistent profile directory is now set to C:\AutomationProfiles\TestUser
    private static final String USER_DATA_DIRECTORY = "C:\\AutomationProfiles\\TestUser"; // <-- UPDATED THIS LINE

    @Before
    public void setup() {
        playwright = Playwright.create();
        
        // Launch a persistent browser context using the specified profile path
        // Playwright will create this directory if it doesn't exist, and reuse it if it does.
        browserContext = playwright.chromium().launchPersistentContext(Paths.get(USER_DATA_DIRECTORY),
            new BrowserType.LaunchPersistentContextOptions()
                .setHeadless(false) // Set to true for headless mode
                .setViewportSize(null) // Essential for --start-maximized to work as expected
                .setArgs(java.util.Arrays.asList("--start-maximized")));

        // Get the first page in the context or create a new one
        if (browserContext.pages().size() > 0) {
            page = browserContext.pages().get(0);
        } else {
            page = browserContext.newPage();
        }
        System.out.println("Playwright browser context setup complete. Using profile: " + USER_DATA_DIRECTORY);
    }

    @After
    public void teardown() {
        if (browserContext != null) {
            browserContext.close();
            System.out.println("Playwright browser context closed.");
        }
        if (playwright != null) {
            playwright.close();
            System.out.println("Playwright instance closed.");
        }
    }
}