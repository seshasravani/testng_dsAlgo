package driverManager;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initializeBrowser(String browser) {
		if (browser == null || browser.isEmpty()) {
			throw new IllegalArgumentException("Browser name must not be null or empty.");
		}

		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				tlDriver.set(new ChromeDriver());
				break;
			case "firefox":
				tlDriver.set(new FirefoxDriver());
				break;
			case "edge":
				tlDriver.set(new EdgeDriver());
				break;
			default:
				throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		} catch (Exception e) {
			System.err.println("Error initializing browser: " + e.getMessage());
			throw e;
		}

		WebDriver driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static WebDriver getDriver() {
		WebDriver driver = tlDriver.get();
		if (driver == null) {
			throw new IllegalStateException("WebDriver is not initialized. Did you call initializeBrowser?");
		}
		return driver;
	}

	public static void removeDriver() {
		WebDriver driver = tlDriver.get();
		if (driver != null) {
			driver.quit();
			tlDriver.remove();
		}
	}
}
