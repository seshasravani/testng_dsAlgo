package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import io.netty.handler.timeout.TimeoutException;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.RegisterPom;
import utilities.TestDataProvider;

public class LoginTest extends BaseClass {
    
    public LoginPom login;
    public HomePom hp; 
    public IntroductionPagePom ip; 
    public RegisterPom regPage;
    
    @BeforeMethod
    public void DSloginPageLaunch() {
        login = new LoginPom();
        hp = new HomePom();
        ip = new IntroductionPagePom();
        regPage = new RegisterPom();
        
        hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
    }


    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void loginTest(String username, String password, String expectedResult) throws InterruptedException {
        LoginPom loginPage = new LoginPom();

        if (username != null && !username.isEmpty()) {
            loginPage.enterUsernameTxt(username);
        }
        if (password != null && !password.isEmpty()) {
            loginPage.enterPasswordTxt(password);
        }

        loginPage.clickloginBtn();

        String actualResult = loginPage.getLoginValidationMessage1();  // Or credentialsResult()
        Assert.assertEquals(actualResult.trim(), expectedResult.trim(), "Validation message mismatch!");
    }

}
