package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;
import utilities.LoggerLoad;

public class DataStructureTest extends BaseClass {

    public DataStructureIntroPom dsIntro; 
    public HomePom hp; 
    public TryEditorDsPom tp; 
    public IntroductionPagePom ip; 
    public LoginPom login; 
    public ScrollAndClick sc; 

    @BeforeMethod
    public void loginToDSIntroduction() {
        dsIntro = new DataStructureIntroPom();
        hp = new HomePom();
        tp = new TryEditorDsPom();
        ip = new IntroductionPagePom();
        login = new LoginPom();
        sc = new ScrollAndClick(driver);
        
        hp.ClickHomePageGetStartedButton();
	    ip.clickOnSignInlink();
	    login.dsAlgoLogin();
        dsIntro.clickGetStartedBtn();
    }

    @Test(priority = 1)
    public void testDSIntroLaunchPage() {
    	Assert.assertTrue(dsIntro.validateElementDisplayed(dsIntro.dsPageTitle));
		Assert.assertEquals(dsIntro.getTextForElement(dsIntro.dsPageTitle), "Data Structures-Introduction");
		LoggerLoad.info("title is+" + "Data Structures-Introduction");
	
    }
    
    @Test(priority = 2)
    public void testDSIntroTimeComplexityLink() {
    	sc.clickTimeComplexityLink();
		LoggerLoad.info("Time Complexity Link is clicked");
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Time Complexity"),
				"Page title does not contain 'Time Complexity'. Found: " + pageTitle);
		LoggerLoad.info("Title is: " + pageTitle);
	
    }
    
    @Test(priority = 3)
    public void testDSIntroTimeComplexityTryHereLink() {
    	sc.clickTimeComplexityLink();
		LoggerLoad.info("TimeComplexity Link Clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("Try Here Button Clicked");
		
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));

    }
    
    @Test(priority = 4)
    public void testDSIntroTimeComplexityTryHereLinkNoCode() {
    	sc.clickTimeComplexityLink();
		LoggerLoad.info("TimeComplexity Link Clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("Try Here Button Clicked");
		tp.clickRunButton();
		LoggerLoad.info("Run Button Clicked");
		
		Assert.assertEquals(false, tp.isAlertPresent());
    }
    
    @Test(priority = 5)
    public void testDSIntroPracticeQnsLink() {
    	sc.clickTimeComplexityLink();
    	LoggerLoad.info("TimeComplexity Link Clicked");
		dsIntro.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
    }
    
//    @Test(dataProvider = "invalidCodeData", priority = 5)
//    public void the_user_clicks_run_button_with_invalidcode_from_sheetname_and_row(String sheetName, Integer rowNumber) {
//        dsIntro.clickGetStartedBtn();
//        LoggerLoad.info("DS Get Started Btn Clicked");
//
//        sc.clickTimeComplexityLink();
//        LoggerLoad.info("TimeComplexity Link Clicked");
//
//        tp.clickTryHereBtn();
//        LoggerLoad.info("Try Here Button Clicked");
//
//        try {
//            tp.enterTryHereCode(sheetName, rowNumber); // now dynamically passed
//            tp.clickRunButton();
//        } catch (Exception e) {
//            System.err.println("Error while entering code or clicking Run: " + e.getMessage());
//        }
//    }
    
}