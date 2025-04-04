package testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.RegisterPom;

public class LoginTest extends BaseClass {

	public LoginPom login;
	public HomePom hp;
	public IntroductionPagePom ip;
	public RegisterPom regPage;

	@BeforeMethod
	public void loginToDSPortal() {

		login = new LoginPom();
		hp = new HomePom();
		ip = new IntroductionPagePom();
		regPage = new RegisterPom();

		hp.ClickHomePageGetStartedButton();
		ip.clickOnSignInlink();
		// login.dsAlgoLogin();
	}

	@Test(priority = 6)
	public void signInDSValidCredentials() {
		login.dsAlgoLogin();

	}

	// Test method using the data provider
	@Test(priority = 1, dataProvider = "alertMessagesForEmptyFields")
	public void testLoginButtonWithEmptyCredentials(String expectedAlertMessage)
			throws IOException, InterruptedException, OpenXML4JException {

		// Assuming the "login" method fills the form and clicks the login button.
		login.enterLoginFormFields("login", 0); // Fill fields with data from the Excel file
		login.clickloginBtn(); // Click login button

		// Switch to the alert or validation message and fetch it.
		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();

		// Validate that the actual alert message contains the expected error text
		// (instead of an exact match)
		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage), "The error message did not match.");
	}

	// DataProvider method to supply the alert messages
	@DataProvider(name = "alertMessagesForEmptyFields")
	public Object[][] getAlertMessagesForEmptyFields() {
		return new Object[][] { { "Please fill out this field." } // Common message when fields are empty

		};
	}

	@Test(priority = 2, dataProvider = "alertMessagesForMissingUsername")
	public void testLoginButtonWithMissingUsername(String expectedAlertMessage)
			throws IOException, InterruptedException, OpenXML4JException {

		// Assuming the "login" method fills the form and clicks the login button.
		login.enterLoginFormFields("login", 0); // Fill fields with data from the Excel file
		login.clickloginBtn(); // Click login button

		// Switch to the alert or validation message and fetch it.
		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();

		// Validate that the actual alert message contains the expected error text
		// (instead of an exact match)
		Assert.assertTrue(actualAlertMsg.contains(expectedAlertMessage), "The error message did not match.");
	}

// DataProvider method to supply the alert messages
	@DataProvider(name = "alertMessagesForMissingUsername")
	public Object[][] getAlertMessagesForMissingUsernameField() {
		return new Object[][] { { "Please fill out this field." } // Common message when fields are empty

		};

	}

}
