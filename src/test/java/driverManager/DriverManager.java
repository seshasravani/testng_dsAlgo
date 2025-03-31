package driverManager;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	// ThreadLocal to ensure separate WebDriver instances for each test thread
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
	public WebDriver driver;

	public WebDriver  initializeBrowser(String browser) throws Exception {

				if (threadDriver.get() == null) {  // Only initialize if driver is not already set
            switch (browser.toLowerCase()) {
                case "chrome":
                	
                	WebDriverManager.chromedriver().clearDriverCache();
                	
                	  driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().clearDriverCache();;  // Automatically manage the correct version
                    driver = new FirefoxDriver();
                    
                    break;
                case "edge":
                    WebDriverManager.edgedriver().create();  // Automatically manage the correct version
                    driver = new EdgeDriver();
                    break;
                default:
                    throw new Exception("Browser not supported: " + browser);
            }
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        threadDriver.set(driver);  // Assign driver to thread-local storage
	    }
	    return threadDriver.get();

	}

	// Close the driver for the current thread
	public void closeDriver() {
//		if (threadDriver.get() != null) {
//			threadDriver.get().quit();
//			threadDriver.remove(); // Clean up the thread-local variable
//		}
	}

	// Get the WebDriver instance for the current thread
	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	// Delete all cookies for the current thread's driver
	public void deleteAllCookies() {
		if (threadDriver.get() != null) {
			threadDriver.get().manage().deleteAllCookies();
		}
	}
}