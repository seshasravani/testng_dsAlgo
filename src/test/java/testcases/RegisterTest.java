package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.RegisterPom;
import utilities.ExcelReader;
import utilities.TestDataProvider;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public class RegisterTest extends BaseClass {

    RegisterPom regPage;
    HomePom hp;
    IntroductionPagePom ip;

    @BeforeMethod
    public void setup() {
        regPage = new RegisterPom();
        hp = new HomePom();
        ip = new IntroductionPagePom();

        hp.ClickHomePageGetStartedButton();

    }
//
//    @Test(dataProvider = "RegisterPageData1", dataProviderClass = TestDataProvider.class)
//    public void enterRegisterDetails(String username, String password, String passwordconfirmation, String expectedResult)
//	        throws TimeoutException {
//	    ChainTestListener.log("Starting Register Page test with username: " + username);
//	    regPage.clickRegisterLink_getStartedPage();
//	    
//	    ChainTestListener.log("Entering credentials: Username: " + username + ", Password: " + password);
//
//	    regPage.enteringcode(username, password, passwordconfirmation);
//	    
//	    regPage.clickRegisterBtn_RegisterPage();
//	    
//	    String actualMessage = regPage.credentialsResult(username, password, passwordconfirmation, expectedResult);
//	    ChainTestListener.log("Actual Message: " + actualMessage);
//	    ChainTestListener.log("Expected Message: " + expectedResult);
//	    Assert.assertEquals(actualMessage, expectedResult, "Register message does not match expected result!"); 
//	    if(actualMessage.equals(expectedResult)) {
//	        ChainTestListener.log("Registration successful with expected result.");
//	    } else {
//	        ChainTestListener.log("Registration failed. Unexpected result.");
//	    }
    
    @Test(dataProvider = "RegisterPageData1", dataProviderClass = TestDataProvider.class)
    public void enterRegisterDetails(String username, String password, String passwordconfirmation, String expectedResult)
            throws TimeoutException {

        ChainTestListener.log("Starting Register Page test with username: " + username);
        regPage.clickRegisterLink_getStartedPage();

        regPage.enteringcode(username, password, passwordconfirmation);
        regPage.clickRegisterBtn_RegisterPage();

        String actualMessage = regPage.credentialsResult(username, password, passwordconfirmation, expectedResult);
        
        ChainTestListener.log("Actual Message: " + actualMessage);
        ChainTestListener.log("Expected Message: " + expectedResult);
        
        Assert.assertEquals(actualMessage, expectedResult, "Register message does not match expected result!");
    }

	}

	    
	    
	  