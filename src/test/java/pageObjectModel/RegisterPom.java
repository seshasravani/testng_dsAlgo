package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class RegisterPom {
	
	
	public WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); //

	public By getStartedButton = By.className("btn"); // Get Started Button
	
	public By registerLink_getStartedPage = By.linkText("Register");
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
	
	
	public void fillRegistrationForm(String username, String password, String passwordconfirmation)
	        throws InterruptedException, IOException {

	    enterUsername(username);
	    enterPassword(password);
	    enterPasswordConfirmation(passwordconfirmation);
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
	
	public String credentialsResult(String username, String password, String passwordconfirmation, String expectedResult) throws TimeoutException {
	    String actualMessage = "";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        if (username.isEmpty() || password.isEmpty() || passwordconfirmation.isEmpty()) {
	            WebElement activeElement = driver.switchTo().activeElement();
	            actualMessage = activeElement.getAttribute("validationMessage").trim();
	            System.out.println("Validation Message (Empty Field): " + actualMessage);
	            actualMessage = actualMessage.replaceAll("\\.+$", "").trim();
	        } else {
	        
	            try {
	                WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[contains(@class, 'alert alert-primary') and contains(text(), 'The two password fields didn’t match')]")
	                ));

	                actualMessage = errorElement.getText().trim();
	                System.out.println("Error Message Displayed: " + actualMessage);

	             
	                if (actualMessage.contains("The two password fields didn’t match")) {
	                    actualMessage = "password_mismatch:The two password fields didn’t match.";
	                }
	            } catch (TimeoutException e) {
	                System.out.println("Timeout: Error message not found within 10 seconds.");
	            }
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Error Element not found: " + e.getMessage());
	    }

	    System.out.println("🔹 Actual Message Retrieved: [" + actualMessage + "]");
	    return actualMessage;
	}
	
	public void enteringcode(String username, String password, String passwordconfirmation) {
		try {
			WebElement usernamecode = driver.findElement(By.xpath("//input[@type='text' and @name='username' and @id='id_username']"));
			usernamecode.clear();
			usernamecode.sendKeys(username);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement passwordcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password' and @name='password1' and @id='id_password1']")));
			
			passwordcode.clear();
			passwordcode.sendKeys(password);
			
			WebElement passwordconfirmcode = driver.findElement(By.xpath("//input[@type='password' and @name='password2' and @id='id_password2']"));
			passwordconfirmcode.clear();
			passwordconfirmcode.sendKeys(passwordconfirmation);
			
			
			System.out.println("Entered Username: " + username);
			System.out.println("Entered Password: " + password);
			System.out.println("Entered Password Confirmation: " + passwordconfirmation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}


	
	}

