package baseClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driverManager.DriverManager;  // Import DriverManager
import utilities.ConfigReader;

public class BaseClass {

    public WebDriver driver;  // Declare WebDriver instance
    public static String browser;  // Store browser type for reference
    private DriverManager driverManager = new DriverManager();  // Create instance of DriverManager

    // Initialize WebDriver before any tests start
    @BeforeClass(alwaysRun = true)
    @Parameters("browser")  // Allows browser parameter to be passed from TestNG XML
    public void setUp(@Optional("chrome") String browser) throws Throwable {
        // Load configuration from config.properties
        ConfigReader.loadConfig();

        // Store the browser value (optional if needed for further use)
        this.browser = browser;

        // Initialize WebDriver using DriverManager (not Driver_SetUp)
        driver = driverManager.initializeBrowser(browser);  // Calling the DriverManager's method

        // Ensure the WebDriver is initialized correctly
        if (driver == null) {
            throw new Exception("Failed to initialize WebDriver.");
        }

        // Optionally, navigate to the base URL if specified in config
        String url = ConfigReader.getUrl();
        if (url != null && !url.isEmpty()) {
            driver.get(url);  // Navigate to the URL if provided
        }
    }

    // Cleanup after all tests are completed
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Close the WebDriver if it's initialized
//        if (driver != null) {
//            System.out.println("Closing driver...");
//            driver.quit();  // Quit the WebDriver session
//            driver = null;  // Set to null to release reference
        }
 //   }

    // Cleanup after each test to clear cookies
    @AfterMethod(alwaysRun = true)
    public void clearCookies() {
        // Delete cookies if driver is initialized
        if (driver != null) {
            driver.manage().deleteAllCookies();  // Clear cookies for each test
            System.out.println("Cookies cleared.");
        }
    }
}



