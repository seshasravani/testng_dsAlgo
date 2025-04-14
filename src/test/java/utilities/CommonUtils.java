package utilities;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import io.netty.handler.timeout.TimeoutException;

public class CommonUtils {
	
	/*
	 * public static void clickElement(By locator) { WebDriver driver =
	 * DriverManager.getDriver(); driver.findElement(locator).click(); }
	 */
	
	public static void clickElement(By locator) {
	    waitForElementToBeClickable(locator).click();
	}
	
	public static void clickElementWithWait(By locator, Duration timeout) {
        WebDriver driver = DriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
	
	   public static String getTextForElement(By locator) {
	        WebDriver driver = DriverManager.getDriver();
	        return driver.findElement(locator).getText();
	    }
	   
	   public static boolean isElementVisible(By locator, Duration timeout) {
	        WebDriver driver = DriverManager.getDriver();
	        WebDriverWait wait = new WebDriverWait(driver, timeout);
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            return true;
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }
	   
	   public static boolean isElementDisplayed(By locator) {
		    WebDriver driver = DriverManager.getDriver();
		    return driver.findElement(locator).isDisplayed();
		}
	   
		/*
		 * public static int getElementCount(By locator) { WebDriver driver =
		 * DriverManager.getDriver(); return driver.findElements(locator).size(); }
		 */
	   
	   public static String getPageTitle() {
		    WebDriver driver = DriverManager.getDriver();
		    return driver.getTitle();
		}
	   
	   public static WebElement waitForElementToBeClickable(By locator) {
		    WebDriver driver = DriverManager.getDriver();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
	   
	   public static void clickWhenClickable(By locator) {
		    WebDriver driver = DriverManager.getDriver();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		}
	   
	   public static void scrollIntoView(By locator) {
		    WebDriver driver = DriverManager.getDriver();
		    WebElement element = driver.findElement(locator);
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		}
	   
	   public static boolean isElementVisible(By locator, int timeoutSeconds) {
		    try {
		        WebDriver driver = DriverManager.getDriver();
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
		}
	   
	   public static String getElementText(By locator) {
		    return DriverManager.getDriver().findElement(locator).getText();
		}
	   
	   public static int getElementCount(By locator) {
		    return DriverManager.getDriver().findElements(locator).size();
		}
	   
	   public static String getTextFromElementAtIndex(By locator, int index) {
		    return DriverManager.getDriver().findElements(locator).get(index).getText();
		}
	   
	   public static void enterText(By locator, String text) {
		    WebDriver driver = DriverManager.getDriver();
		    WebElement element = waitForElementToBeClickable(locator);
		    element.clear();
		    element.sendKeys(text);
		}
	    
	   public static String getValidationMessage(By primary, By fallback) {
		    WebDriver driver = DriverManager.getDriver();
		    try {
		        WebElement element = driver.findElement(primary);
		        if (element.isDisplayed()) {
		            return element.getText().trim();
		        }
		    } catch (Exception e) {
		        LoggerLoad.warn("Primary message not found: " + e.getMessage());
		    }

		    try {
		        WebElement element = driver.findElement(fallback);
		        if (element.isDisplayed()) {
		            return element.getText().trim();
		        }
		    } catch (Exception e) {
		        LoggerLoad.warn("Fallback message not found: " + e.getMessage());
		    }

		    return "No validation message available";
		}
	   
	   public static String validatePageTitle() {
		    WebDriver driver = DriverManager.getDriver();
		    return driver.getTitle();
		}

	   public static boolean validateElementDisplayed(By locator) {
		    try {
		        WebElement element = DriverManager.getDriver().findElement(locator);
		        return element.isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;  // Element is not found, return false
		    }
		}

	 	   
	   public static Integer getElementSize(By locator) {
		    WebDriver driver = DriverManager.getDriver();
		    int count = driver.findElements(locator).size();
		    LoggerLoad.info("Found " + count + " elements for locator: " + locator.toString());
		    return count;
		}
	}
	   
		/*
		 * public static int getElementCount(By locator) { WebDriver driver =
		 * DriverManager.getDriver(); int count = driver.findElements(locator).size();
		 * LoggerLoad.info("Found " + count + " elements for locator: " +
		 * locator.toString()); return count; }
		 */
	   
	

	
