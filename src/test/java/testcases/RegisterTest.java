
package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.RegisterPom;
import utilities.TestDataProvider;

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

    
    @Test(dataProvider = "RegisterPageData1", dataProviderClass = TestDataProvider.class)
    public void enterRegisterDetails(String username, String password, String passwordconfirmation, String expectedResult)
            throws TimeoutException {

        
        regPage.clickRegisterLink_getStartedPage();

        regPage.enteringcode(username, password, passwordconfirmation);
        regPage.clickRegisterBtn_RegisterPage();

        String actualMessage = regPage.credentialsResult(username, password, passwordconfirmation, expectedResult);
        		      
        Assert.assertEquals(actualMessage, expectedResult, "Register message does not match expected result!");
    }

	}

	    
	    
	  
