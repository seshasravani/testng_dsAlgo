package pageObjectModel;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LoginPom {

	ExcelReader excelReader = new ExcelReader();
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	Properties prop = ConfigReader.initializeprop();

	public By usernameTextBox = By.id("id_username");
	public By passwordTextBox = By.id("id_password");
	public By loginBtn = By.xpath("//input[@value='Login']");
	public static By loggedinmessage = By.xpath("//div[contains(text(),'You are logged in')]");
    private static By alertMessage = By.cssSelector(".alert.alert-primary");

	public void enterUsernameTxt(String username) {
		//driver.findElement(usernameTextBox).sendKeys(username);
		CommonUtils.enterText(usernameTextBox, username);

	}

	public void enterPasswordTxt(String password) {
		//driver.findElement(passwordTextBox).sendKeys(password);
		CommonUtils.enterText(passwordTextBox, password);
	}

	public void clickloginBtn() {
		//driver.findElement(loginBtn).click();
		CommonUtils.clickElement(loginBtn);
	}

	public void loginWithValidCredentials(String username, String password) throws InterruptedException {
		/*
		 * driver.findElement(usernameTextBox).sendKeys(username);
		 * driver.findElement(passwordTextBox).sendKeys(password);
		 * driver.findElement(loginBtn).click();
		 */
		
	       CommonUtils.enterText(usernameTextBox, username);
	        CommonUtils.enterText(passwordTextBox, password);
	        CommonUtils.clickElement(loginBtn);
	}

	public void dsAlgoLogin() {

		/*
		 * driver.findElement(usernameTextBox).sendKeys((prop.getProperty("username")));
		 * driver.findElement(passwordTextBox).sendKeys((prop.getProperty("password")));
		 * driver.findElement(loginBtn).click();
		 */
		
		CommonUtils.enterText(usernameTextBox, prop.getProperty("username"));
        CommonUtils.enterText(passwordTextBox, prop.getProperty("password"));
        CommonUtils.clickElement(loginBtn);

	}

	/*
	 * public void passwordTextField(String password) {
	 * driver.findElement(passwordTextBox).sendKeys(password); }
	 */

	public String loggedinmessage() {
		//return ((WebElement) loggedinmessage).getText();
		 return CommonUtils.getTextForElement(loggedinmessage);
	}

	/*
	 * public String getLoginValidationMessage1() { try { WebElement successMsg =
	 * driver.findElement(loggedinmessage); if (successMsg.isDisplayed()) { return
	 * successMsg.getText().trim(); } } catch (Exception e) {
	 * 
	 * }
	 */
	
	/*
	 * public String getLoginValidationMessage() { private By loggedinmessage =
	 * By.id("loggedinmessage"); // Replace with actual locator private By
	 * alertMessage = By.cssSelector(".alert.alert-primary"); return
	 * CommonUtils.getValidationMessage(loggedinmessage, alertMessage ); }
	 */
	 
	public static String getLoginValidationMessage1() {
	    try {
	        // Attempt to get the validation message from CommonUtils
	        return CommonUtils.getValidationMessage(loggedinmessage, alertMessage);
	    } catch (Exception e) {
	        e.printStackTrace();  // Log the exception for debugging
	        return "Error retrieving message";  // Return a default error message
	    }
	}

	
	
	/*
	 * public String getLoginValidationMessage1() { try { WebElement successMsg =
	 * driver.findElement(loggedinmessage); if (successMsg.isDisplayed()) { return
	 * successMsg.getText().trim(); } } catch (Exception e) {
	 * LoggerLoad.warn("Error finding logged-in message: " + e.getMessage()); }
	 * 
	 * try { WebElement alert =
	 * driver.findElement(By.cssSelector(".alert.alert-primary")); if
	 * (alert.isDisplayed()) { return alert.getText().trim(); } } catch (Exception
	 * e) { LoggerLoad.warn("Error finding alert message: " + e.getMessage()); }
	 * 
	 * return "No validation message available"; }
	 */


	/*public String credentialsResult(String username, String password) {
		try {
			if (username == null || username.trim().isEmpty()) {
				WebElement usernameField = driver.findElement(usernameTextBox);
				return usernameField.getAttribute("validationMessage");
			} else if (password == null || password.trim().isEmpty()) {
				WebElement passwordField = driver.findElement(passwordTextBox);
				return passwordField.getAttribute("validationMessage");
			}

			WebElement alertMessage = driver.findElement(By.cssSelector(".alert.alert-primary"));
			return alertMessage.getText().trim();
		} catch (Exception e) {
			LoggerLoad.warn("Could not retrieve validation message: " + e.getMessage());
			return "No validation message available";
		}*/
	 
	public String credentialsResult(String username, String password) {
	    try {
	        if (username == null || username.trim().isEmpty()) {
	            // Use CommonUtils to get the validation message for the username field
	            return CommonUtils.getValidationMessage(usernameTextBox, usernameTextBox);
	        } else if (password == null || password.trim().isEmpty()) {
	            // Use CommonUtils to get the validation message for the password field
	            return CommonUtils.getValidationMessage(passwordTextBox, passwordTextBox);
	        }

	        // Use CommonUtils to get the text of the alert message
	        return CommonUtils.getTextForElement(By.cssSelector(".alert.alert-primary")).trim();
	    } catch (Exception e) {
	        LoggerLoad.warn("Could not retrieve validation message: " + e.getMessage());
	        return "No validation message available";
	    }
	}



}