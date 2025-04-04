
package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import driverManager.DriverManager;
import utilities.ConfigReader;
import utilities.ExcelReader1;
//import utilities.ExcelReader1;

public class LoginPom {

	WebDriver driver = DriverManager.getDriver();
	ExcelReader1 excelReader1 = new ExcelReader1();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	Properties prop =  ConfigReader.initializeprop();
	
	//X paths for web elements on login page 
	
	
	public By usernameTextBox = By.id("id_username");
	public By passwordTextBox = By.id("id_password");
	public By loginBtn =   By.xpath("//input[@value='Login']");
	
	//public By loginBtn = By.xpath("//a[@href='/login']");
	//public By loginBtn = By.xpath("input[type='submit']");
	
	public By alertMsg = By.cssSelector(".alert.alert-primary");
	
	//enter user name text box 
	public void enterUsernameTxt(String username) {
		driver.findElement(usernameTextBox).sendKeys(username);
		
	}
	//enter password text box
	public void enterPasswordTxt(String password) {
	    	driver.findElement(passwordTextBox).sendKeys(password);
	    }
	//click login button 
	public void clickloginBtn() {
	    	driver.findElement(loginBtn).click();
	    }
	
	//Login with valid user and password details 
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
				throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
			System.out.println("Inside enterLoginFormFields");
			//List<Map<String, String>> testdata = excelReader1.getData("src/test/resources/Excel/TestData.xlsx", sheetname);
		//	List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", sheetname);
		//	System.out.println("logintestdata ---------> "+testdata);
			
			//Fetch and log the user name
			//String username = testdata.get(row).get("username");
		//	System.out.println("Fetched username from Excel: " + username);
		//	enterUsernameTxt(username);
			
			//Fetch and log the password (optional, sensitive data warning)			
		//	String password = testdata.get(row).get("password");
		//	System.out.println("Fetched password from Excel: " + password);
		//	enterPasswordTxt(password);
		}	

}
