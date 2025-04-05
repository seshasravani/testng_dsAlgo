package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.RegisterPom;
import utilities.ExcelReader;
import utilities.TestDataProvider;


public class LoginTest extends BaseClass {

	private LoginPom login;
	private HomePom hp;
	private IntroductionPagePom ip;
	private RegisterPom regPage;
	
	private static final String EXCEL_PATH = "src/test/resources/Excel/TestData.xlsx";
	ExcelReader excelReader = new ExcelReader();

	@BeforeMethod
	public void loginToDSPortal() {
		login = new LoginPom();
		hp = new HomePom();
		ip = new IntroductionPagePom();
		regPage = new RegisterPom();

		hp.ClickHomePageGetStartedButton();
		ip.clickOnSignInlink();
	}

	@Test(priority = 6)
	public void signInDSValidCredentials() {
		login.dsAlgoLogin();
	}

	@Test(priority = 1, dataProvider = "alertMessagesForEmptyFields", dataProviderClass = TestDataProvider.class)
	public void testLoginWithEmptyCredentials(String username, String password, String expectedAlertMessage) {
	    // Use dynamic data from the DataProvider
	    login.enterLoginDetailsforDP(username, password); // Now, it uses the username and password from the Excel data
	    login.clickloginBtn();

	    // Fetch the actual alert message and assert it with the expected one
	    String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
	    Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage),
	            "Expected: " + expectedAlertMessage + ", but got: " + actualAlertMsg);
	}
	
}


//
//	@Test(priority = 2, dataProvider = "alertMessagesForMissingUsername", dataProviderClass = TestDataProvider.class)
//	public void testLoginButtonWithMissingUsername(String expectedAlertMessage)
//			throws IOException, InterruptedException, OpenXML4JException {
//		login.enterLoginFormFields("login", 0);
//		login.clickloginBtn();
//
//		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
//		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage),
//				"Expected: " + expectedAlertMessage + ", but got: " + actualAlertMsg);
//	}
//
//	@Test(priority = 3, dataProvider = "loginTestData", dataProviderClass = DataProviderClass.class)
//	public void validateLoginFunctionality(String username, String password, String expectedMessage)
//			throws IOException, InterruptedException, OpenXML4JException {
//		login.enterUsernameTxt(username);
//		login.enterPasswordTxt(password);
//		login.clickloginBtn();
//
//		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
//		Assert.assertTrue(actualAlertMsg.contains(expectedMessage),
//				"Expected: " + expectedMessage + ", but got: " + actualAlertMsg);
//	}
//}
//































//package testcases;
//
//import java.io.IOException;
//
//import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//
//import baseClass.BaseClass;
//import pageObjectModel.HomePom;
//import pageObjectModel.IntroductionPagePom;
//import pageObjectModel.LoginPom;
//import pageObjectModel.RegisterPom;
//
//public class LoginTest extends BaseClass {
//
//	public LoginPom login;
//	public HomePom hp;
//	public IntroductionPagePom ip;
//	public RegisterPom regPage;
//
//	@BeforeMethod
//	public void loginToDSPortal() {
//
//		login = new LoginPom();
//		hp = new HomePom();
//		ip = new IntroductionPagePom();
//		regPage = new RegisterPom();
//
//		hp.ClickHomePageGetStartedButton();
//		ip.clickOnSignInlink();
//		// login.dsAlgoLogin();
//	}
//
//	@Test(priority = 6)
//	public void signInDSValidCredentials() {
//		login.dsAlgoLogin();
//
//	}
//
//	// Test method using the data provider
//	@Test(priority = 1, dataProvider = "alertMessagesForEmptyFields")
//	public void testLoginButtonWithEmptyCredentials(String expectedAlertMessage)
//			throws IOException, InterruptedException, OpenXML4JException {
//
//		// Assuming the "login" method fills the form and clicks the login button.
//		login.enterLoginFormFields("login", 0); // Fill fields with data from the Excel file
//		login.clickloginBtn(); // Click login button
//
//		// Switch to the alert or validation message and fetch it.
//		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
//
//		// Validate that the actual alert message contains the expected error text
//		// (instead of an exact match)
//		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage), "The error message did not match.");
//	}
//
//	// DataProvider method to supply the alert messages
//	@DataProvider(name = "alertMessagesForEmptyFields")
//	public Object[][] getAlertMessagesForEmptyFields() {
//		return new Object[][] { { "Please fill out this field." } // Common message when fields are empty
//
//		};
//	}
//
//	@Test(priority = 2, dataProvider = "alertMessagesForMissingUsername")
//	public void testLoginButtonWithMissingUsername(String expectedAlertMessage)
//			throws IOException, InterruptedException, OpenXML4JException {
//
//		// Assuming the "login" method fills the form and clicks the login button.
//		login.enterLoginFormFields("login", 0); // Fill fields with data from the Excel file
//		login.clickloginBtn(); // Click login button
//
//		// Switch to the alert or validation message and fetch it.
//		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
//
//		// Validate that the actual alert message contains the expected error text
//		// (instead of an exact match)
//		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage), "The error message did not match.");
//	}
//
//// DataProvider method to supply the alert messages
//	@DataProvider(name = "alertMessagesForMissingUsername")
//	public Object[][] getAlertMessagesForMissingUsernameField() {
//		return new Object[][] { { "Please fill out this field." } // Common message when fields are empty
//
//		};
//
//	}
//
//}
