package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverManager.DriverManager;
import utilities.CommonUtils;
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
		CommonUtils.clickElement(getStartedButton);
	}

	public void clickRegisterLink_getStartedPage() {
		CommonUtils.clickElement(registerLink_getStartedPage);
	}

	public void clickRegisterBtn_RegisterPage() {
		CommonUtils.clickElement(registerBtn_RegPage);
	}

	public void enterUsername(String username) throws IOException {
		CommonUtils.enterText(usernameTextBox, username);
	}

	public void enterPassword(String password) {
		CommonUtils.enterText(passwordTextBox, password);
	}

	public void enterPasswordConfirmation(String confirmPswd) {
		CommonUtils.enterText(confirmPasswordTextBox, confirmPswd);
	}

	public void fillRegistrationForm(String username, String password, String passwordconfirmation)
			throws InterruptedException, IOException {
		enterUsername(username);
		enterPassword(password);
		enterPasswordConfirmation(passwordconfirmation);
	}

	public void clickLoginLink() {
		CommonUtils.clickElement(loginLink);
	}

	public void clickSignInLink() {
		CommonUtils.clickElement(signInLink);
		LoggerLoad.info("sign in link clicked ---------> " + signInLink);
	}

	public String displayPasswordMismatchError() {
		return CommonUtils.getTextForElement(passwordMismatchOnRegPage);
	}

	public boolean checkIfRegisterSuccessMsgIsDisplayed() {
		return CommonUtils.isElementDisplayed(registerSuccessMsg);
	}

	public String successMsg() {
		return CommonUtils.getTextForElement(registerSuccessMsg);
	}

	public String activeElementBrowserValidation() {
		return driver.findElement(usernameTextBox).getAttribute("validationMessage");
	}

	public void Land_On_RegistrationPage() {
		this.openURL();
		this.clickGetStartedBtn();
		this.clickRegisterLink_getStartedPage();
	}

	public String switchToElementAndGetValidationMessage() {
		String actualAlertMsg = "";
		try {
			actualAlertMsg = driver.switchTo().activeElement().getAttribute("validationMessage");
			System.out.println("ValidationMessage: " + actualAlertMsg);
		} catch (Exception e) {
			System.out.println("Error retrieving validation message: " + e.getMessage());
		}
		return actualAlertMsg;
	}

	public String credentialsResult(String username, String password, String passwordconfirmation,
			String expectedResult) {
		String actualMessage = "";
		try {
			if (username.isEmpty() || password.isEmpty() || passwordconfirmation.isEmpty()) {
				actualMessage = CommonUtils.getValidationMessage(usernameTextBox, usernameTextBox).trim();
				System.out.println("Validation Message (Empty Field): " + actualMessage);
				actualMessage = actualMessage.replaceAll("\\.+$", "").trim();
			} else {
				actualMessage = CommonUtils.getTextForElement(By.xpath(
						"//div[contains(@class, 'alert alert-primary') and contains(text(), 'The two password fields didn’t match')]"))
						.trim();
				System.out.println("Error Message Displayed: " + actualMessage);
				if (actualMessage.contains("The two password fields didn’t match")) {
					actualMessage = "password_mismatch:The two password fields didn’t match.";
				}
			}
		} catch (Exception e) {
			System.out.println("Error Element not found: " + e.getMessage());
		}
		System.out.println("🔹 Actual Message Retrieved: [" + actualMessage + "]");
		return actualMessage;
	}

	public void enteringcode(String username, String password, String passwordconfirmation) {
		try {
			CommonUtils.enterText(By.xpath("//input[@type='text' and @name='username' and @id='id_username']"),
					username);
			CommonUtils.enterText(By.xpath("//input[@type='password' and @name='password1' and @id='id_password1']"),
					password);
			CommonUtils.enterText(By.xpath("//input[@type='password' and @name='password2' and @id='id_password2']"),
					passwordconfirmation);

			System.out.println("Entered Username: " + username);
			System.out.println("Entered Password: " + password);
			System.out.println("Entered Password Confirmation: " + passwordconfirmation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
