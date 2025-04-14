package pageObjectModel;


import java.util.Properties;
import org.openqa.selenium.By;
import utilities.CommonUtils;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LoginPom {

	ExcelReader excelReader = new ExcelReader();
	
	Properties prop = ConfigReader.initializeprop();

	public By usernameTextBox = By.id("id_username");
	public By passwordTextBox = By.id("id_password");
	public By loginBtn = By.xpath("//input[@value='Login']");
	public static By loggedinmessage = By.xpath("//div[contains(text(),'You are logged in')]");
    private static By alertMessage = By.cssSelector(".alert.alert-primary");

	public void enterUsernameTxt(String username) {
		CommonUtils.enterText(usernameTextBox, username);

	}

	public void enterPasswordTxt(String password) {
		CommonUtils.enterText(passwordTextBox, password);
	}

	public void clickloginBtn() {
		CommonUtils.clickElement(loginBtn);
	}

	public void loginWithValidCredentials(String username, String password) throws InterruptedException {
		
	       CommonUtils.enterText(usernameTextBox, username);
	        CommonUtils.enterText(passwordTextBox, password);
	        CommonUtils.clickElement(loginBtn);
	}

	public void dsAlgoLogin() {
			
		CommonUtils.enterText(usernameTextBox, prop.getProperty("username"));
        CommonUtils.enterText(passwordTextBox, prop.getProperty("password"));
        CommonUtils.clickElement(loginBtn);

	}

	
	public String loggedinmessage() {
		 return CommonUtils.getTextForElement(loggedinmessage);
	}

		 
	public static String getLoginValidationMessage1() {
	    try {
	       return CommonUtils.getValidationMessage(loggedinmessage, alertMessage);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return "Error retrieving message"; 
	    }
	}

	public String credentialsResult(String username, String password) {
	    try {
	        if (username == null || username.trim().isEmpty()) {
	            return CommonUtils.getValidationMessage(usernameTextBox, usernameTextBox);
	        } else if (password == null || password.trim().isEmpty()) {
	           return CommonUtils.getValidationMessage(passwordTextBox, passwordTextBox);
	        }

	       return CommonUtils.getTextForElement(By.cssSelector(".alert.alert-primary")).trim();
	    } catch (Exception e) {
	        LoggerLoad.warn("Could not retrieve validation message: " + e.getMessage());
	        return "No validation message available";
	    }
	}

}