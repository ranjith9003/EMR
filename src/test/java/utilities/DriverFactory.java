package utilities;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
 
import java.time.Duration;
 
public class DriverFactory {
 
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
 
    public static WebDriver getDriver(String browserName) {

        if (driver.get() == null) {

            boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
 
            switch (browserName.toLowerCase()) {

                case "chrome":

                    WebDriverManager.chromedriver().setup();

                    ChromeOptions chromeOptions = new ChromeOptions();

                    if (isHeadless) {

                        chromeOptions.addArguments("--headless=new", "--window-size=1920,1080");

                    }

                    driver.set(new ChromeDriver(chromeOptions));

                    break;
 
                case "firefox":

                    WebDriverManager.firefoxdriver().setup();

                    FirefoxOptions firefoxOptions = new FirefoxOptions();

                    if (isHeadless) {

                        firefoxOptions.addArguments("--headless");

                    }

                    driver.set(new FirefoxDriver(firefoxOptions));

                    break;
 
                case "edge":

                    WebDriverManager.edgedriver().setup();

                    EdgeOptions edgeOptions = new EdgeOptions();

                    if (isHeadless) {

                        edgeOptions.addArguments("headless");

                        edgeOptions.addArguments("window-size=1920,1080");

                    }

                    driver.set(new EdgeDriver(edgeOptions));

                    break;
 
                default:

                    throw new IllegalArgumentException("Unsupported browser: " + browserName);

            }
 
            driver.get().manage().window().maximize();

            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }

        return driver.get();

    }
 
    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();

        }

    }

}  
 