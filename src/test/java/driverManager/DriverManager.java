//package driverManager;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//public class DriverManager {
//
//	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//
//	public WebDriver initializeBrowser(String browser) {
//		if (browser == null || browser.isEmpty()) {
//			throw new IllegalArgumentException("Browser name must not be null or empty.");
//		}
//
//		try {
//			switch (browser.toLowerCase()) {
//			case "chrome":
//				tlDriver.set(new ChromeDriver());
//				break;
//			case "firefox":
//				tlDriver.set(new FirefoxDriver());
//				break;
//			case "edge":
//				tlDriver.set(new EdgeDriver());
//				break;
//			default:
//				throw new IllegalArgumentException("Unsupported browser: " + browser);
//			}
//		} catch (Exception e) {
//			System.err.println("Error initializing browser: " + e.getMessage());
//			throw e;
//		}
//
//		WebDriver driver = getDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		return driver;
//	}
//
//	public static WebDriver getDriver() {
//		WebDriver driver = tlDriver.get();
//		if (driver == null) {
//			throw new IllegalStateException("WebDriver is not initialized. Did you call initializeBrowser?");
//		}
//		return driver;
//	}
//
//	public static void removeDriver() {
//		WebDriver driver = tlDriver.get();
//		if (driver != null) {
//			driver.quit();
//			tlDriver.remove();
//		}
//	}
//}



package driverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	// Flag to toggle between local and grid
	private static final boolean RUN_ON_GRID = true;

	// Replace this with your actual Grid Hub URL
	private static final String GRID_URL = "http://selenium-hub.selenium-grid.svc.cluster.local:4444/wd/hub";

	public WebDriver initializeBrowser(String browser) {
		if (browser == null || browser.isEmpty()) {
			throw new IllegalArgumentException("Browser name must not be null or empty.");
		}

		try {
			switch (browser.toLowerCase()) {
				case "chrome":
					if (RUN_ON_GRID) {
						ChromeOptions chromeOptions = new ChromeOptions();
						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), chromeOptions));
					} else {
						tlDriver.set(new org.openqa.selenium.chrome.ChromeDriver());
					}
					break;

				case "firefox":
					if (RUN_ON_GRID) {
						FirefoxOptions firefoxOptions = new FirefoxOptions();
						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), firefoxOptions));
					} else {
						tlDriver.set(new org.openqa.selenium.firefox.FirefoxDriver());
					}
					break;

				case "edge":
					if (RUN_ON_GRID) {
						EdgeOptions edgeOptions = new EdgeOptions();
						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), edgeOptions));
					} else {
						tlDriver.set(new org.openqa.selenium.edge.EdgeDriver());
					}
					break;

				default:
					throw new IllegalArgumentException("Unsupported browser: " + browser);
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Malformed Grid URL: " + GRID_URL, e);
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

