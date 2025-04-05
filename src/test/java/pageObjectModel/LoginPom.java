package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverManager;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;


public class LoginPom {

	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	Properties prop =  ConfigReader.initializeprop();
		
	public By usernameTextBox = By.id("id_username");
	public By passwordTextBox = By.id("id_password");
	public By loginBtn =   By.xpath("//input[@value='Login']");
	public By alertMsg = By.cssSelector(".alert.alert-primary");
	
	
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
    
    //Common login method for DS Algo portal 
    public void dsAlgoLogin() {
    	
    driver.findElement(usernameTextBox).sendKeys((prop.getProperty("username")));
	driver.findElement(passwordTextBox).sendKeys((prop.getProperty("password")));
	driver.findElement(loginBtn).click();
	
}
	 
	public void passwordTextField(String password) {
			driver.findElement(passwordTextBox).sendKeys(password);
		}

		public void enterLoginFormFields(String sheetname, int row)
				throws InvalidFormatException, IOException, InterruptedException {
			LoggerLoad.info("Inside enterLoginFormFields");
	
			List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", sheetname);
			LoggerLoad.info("logintestdata");
		
			
			String username = testdata.get(row).get("username");
			enterUsernameTxt(username);
			LoggerLoad.info("Fetched username from Excel: " + username);
			
			String password = testdata.get(row).get("password");
			LoggerLoad.info("Fetched password from Excel: " + password);
			enterPasswordTxt(password);
		}	
		
		//For Data Provider -> read data from excel 
		
		public void enterLoginDetailsforDP(String username, String password) {
		    if (username != null && !username.isEmpty()) {
		        enterUsernameTxt(username);
		    }
		    if (password != null && !password.isEmpty()) {
		        enterPasswordTxt(password);
		    }
		}

}