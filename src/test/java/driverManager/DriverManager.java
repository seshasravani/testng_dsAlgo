package driverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	// ThreadLocal to ensure separate WebDriver instances for each test thread
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    public WebDriver driver;

    public WebDriver initializeBrowser(String browser) throws Exception {

        if (threadDriver.get() == null) {  // Only initialize if driver is not already set
            switch (browser.toLowerCase()) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    driver = new EdgeDriver(edgeOptions);
                    break;
                default:
                    throw new Exception("Browser not supported: " + browser);
            }

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            threadDriver.set(driver);  // Assign driver to thread-local storage
        }
        return threadDriver.get();
    }

    // Close the driver for the current thread
    public void closeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit();
            threadDriver.remove(); // Clean up the thread-local variable
        }
    }

    // Get the WebDriver instance for the current thread
    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    // Delete all cookies for the current thread's driver
    public void deleteAllCookies() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }
}