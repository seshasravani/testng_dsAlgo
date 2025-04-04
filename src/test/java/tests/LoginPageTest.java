package tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.RegisterPom;


public class LoginPageTest extends BaseClass{
	
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
	    login.dsAlgoLogin();
	}

	@Test(priority=6)
	public void signInDSValidCredentials() {
	
	login.dsAlgoLogin();
						
	}
	@Parameters("expectedAlertMessage")
	@Test(priority=1)
	public void testLoginButtonWithEmptyCredentials(String expectedAlertMessage) throws InvalidFormatException, IOException, OpenXML4JException, InterruptedException {
		
		login.enterLoginFormFields("login", 6);
		login.clickloginBtn();	
		String actualAlertMsg = regPage.switchToElementAndGetValidationMessage();
		Assert.assertEquals(actualAlertMsg, expectedAlertMessage);
						
	}
	
}
