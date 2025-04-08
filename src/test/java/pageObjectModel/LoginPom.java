package pageObjectModel;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;

import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LoginPom {

	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	Properties prop = ConfigReader.initializeprop();

	public By usernameTextBox = By.id("id_username");
	public By passwordTextBox = By.id("id_password");
	public By loginBtn = By.xpath("//input[@value='Login']");

	public By loggedinmessage = By.xpath("//div[contains(text(),'You are logged in')]");

	public void enterUsernameTxt(String username) {
		driver.findElement(usernameTextBox).sendKeys(username);

	}

	public void enterPasswordTxt(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void clickloginBtn() {
		driver.findElement(loginBtn).click();
	}

	public void loginWithValidCredentials(String username, String password) throws InterruptedException {
		driver.findElement(usernameTextBox).sendKeys(username);
		driver.findElement(passwordTextBox).sendKeys(password);
		driver.findElement(loginBtn).click();
	}

	public void dsAlgoLogin() {

		driver.findElement(usernameTextBox).sendKeys((prop.getProperty("username")));
		driver.findElement(passwordTextBox).sendKeys((prop.getProperty("password")));
		driver.findElement(loginBtn).click();

	}

	public void passwordTextField(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public String loggedinmessage() {
		return ((WebElement) loggedinmessage).getText();
	}

	public String getLoginValidationMessage1() {
		try {
			WebElement successMsg = driver.findElement(loggedinmessage);
			if (successMsg.isDisplayed()) {
				return successMsg.getText().trim();
			}
		} catch (Exception e) {

		}

		try {
			WebElement alert = driver.findElement(By.cssSelector(".alert.alert-primary"));
			if (alert.isDisplayed()) {
				return alert.getText().trim();
			}
		} catch (Exception e) {

		}

		return "No validation message available";
	}

	public String credentialsResult(String username, String password) {
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
		}
	}

}