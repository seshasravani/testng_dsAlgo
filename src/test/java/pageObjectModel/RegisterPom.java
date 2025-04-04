package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class RegisterPom {
	
	
	public WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //

	public By getStartedButton = By.className("btn"); // Get Started Button
	public By registerLink_getStartedPage = By.xpath("//div[2]/ul/a[2]");// register link from get started page
	public By usernameTextBox = By.xpath("//div[@class='col-sm']/form/input[2][@name='username']"); 
	public By passwordTextBox = By.xpath("//div[@class='col-sm']/form/input[3][@name='password1']");
	public By confirmPasswordTextBox = By.xpath("//div[@class='col-sm']/form/input[4][@name='password2']"); 
	public By registerBtn_RegPage = By.xpath("//input[@value='Register']"); 
	public By loginLink = By.xpath("//div[2]/a[@href='/login']"); 
	public By signInLink = By.xpath("//div[@class='navbar-nav']/ul/a[@href='/login']");// link for login
	public By registerSuccessMsg = By.xpath("//div[contains(@class,'alert alert-primary')]");
	private By passwordMismatchOnRegPage = By.xpath("//div[@class='alert alert-primary']");
	
	public void openURL() {
		driver.get("https://dsportalapp.herokuapp.com/");
	}

	public void clickGetStartedBtn() {
		driver.findElement(getStartedButton).click();
	}

	public void clickRegisterLink_getStartedPage() {
		driver.findElement(registerLink_getStartedPage).click();
	}

	public void clickRegisterBtn_RegisterPage() {
		driver.findElement(registerBtn_RegPage).click();
	}

	public void enterUsername(String username) throws IOException {
		driver.findElement(usernameTextBox).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void enterPasswordConfirmation(String confirmPswd) {
		driver.findElement(confirmPasswordTextBox).sendKeys(confirmPswd);
	}

	public void fillRegistrationForm(String sheetname, int row)
			throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {

		List<Map<String, String>> testdata = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx", sheetname);
		System.out.println("registertestdata ---------> "+testdata);
		String username = testdata.get(row).get("username");
		enterUsername(username);
		String password = testdata.get(row).get("password");
		enterPassword(password);
		String passwordConfirm = testdata.get(row).get("password confirmation");
		enterPasswordConfirmation(passwordConfirm);
	}

   
	public void clickLoginLink() {
		driver.findElement(loginLink).click();
	}

	public void clickSignInLink() {
		driver.findElement(signInLink).click();
		LoggerLoad.info("sign in link clicked ---------> "+signInLink);
	}

	public String displayPasswordMismatchError() {
		return driver.findElement(passwordMismatchOnRegPage).getText();
	}

	public boolean checkIfRegisterSuccessMsgIsDisplayed() {
		return driver.findElement(registerSuccessMsg).isDisplayed();
	}

	public String successMsg() {
		return driver.findElement(registerSuccessMsg).getText();
	}

	public String activeElementBrowserValidation() // Capture error - Please fill out this field
	{
		return driver.findElement(usernameTextBox).getAttribute("validationMessage");
	}

	public void Land_On_RegistrationPage() {
		this.openURL();
		this.clickGetStartedBtn();
		this.clickRegisterLink_getStartedPage();
	}

	
	public String switchToElementAndGetValidationMessage() {
	    WebElement activeElement = null;
	    String actualAlertMsg = null;

	    try {
	        activeElement = driver.switchTo().activeElement();
	        actualAlertMsg = activeElement.getAttribute("validationMessage");
	        System.out.println("ValidationMessage: " + actualAlertMsg);
	    } catch (StaleElementReferenceException e) {
	        
	        System.out.println("Stale element reference caught. Retrying...");
	        activeElement = driver.switchTo().activeElement();
	        actualAlertMsg = activeElement.getAttribute("validationMessage");
	        System.out.println("ValidationMessage: " + actualAlertMsg);
	    }
	    
	    return actualAlertMsg;
	}

}