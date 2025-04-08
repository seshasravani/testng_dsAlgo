package Listeners;

import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driverManager.DriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
        saveTextLog("Test FAILED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveTextLog("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        saveTextLog("Test STARTED: " + result.getName());
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

  
    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
}
