package baseClass;
import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import driverManager.DriverManager;
import utilities.ConfigReader;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

public class BaseClass {

    public WebDriver driver;

    private DriverManager drivermanager = new DriverManager();
    private static Properties prop1;

    @BeforeSuite(alwaysRun = true)
    public void setupSuite() {
        prop1 = ConfigReader.initializeprop();
        System.out.println("Before Suite: Config properties initialized.");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setup(@Optional("") String browser, Method method) {
        try {
            System.out.println("Browser received from testng.xml: " + browser);

            if (browser == null || browser.trim().isEmpty()) {
                browser = prop1.getProperty("browser");
                System.out.println("Using default browser from properties: " + browser);
            }

            drivermanager.initializeBrowser(browser);
            driver = DriverManager.getDriver();

            driver.manage().deleteAllCookies();
            driver.get(prop1.getProperty("url"));

            // ✅ Start ExtentTest for each test method
            ExtentTestManager.startTest(method.getName(), "Test method: " + method.getName());

        } catch (Exception e) {
            System.out.println("Error in setup(): " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest(ITestResult result) {
        // ✅ Log result in Extent Report
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().pass("Test Passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentTestManager.getTest().skip("Test Skipped");
        }

        driver.quit();
        DriverManager.removeDriver();
    }

    public static WebDriver getDriver() {
        WebDriver driver = DriverManager.getDriver();
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is null. Ensure setup() is called before tests.");
        }
        return driver;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        ExtentManager.getInstance().flush(); // ✅ Write everything to ExtentReport.html
    }
}