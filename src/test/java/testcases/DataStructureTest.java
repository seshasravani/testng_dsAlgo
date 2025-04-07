package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.ExtentTestManager;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class DataStructureTest extends BaseClass {

    public DataStructureIntroPom dsIntro; 
    public HomePom hp; 
    public TryEditorDsPom tp; 
    public IntroductionPagePom ip; 
    public LoginPom login; 
    public ScrollAndClick sc; 
    public TryEditorPage tryeditor;

  

    @BeforeMethod
    public void loginToDSIntroduction() {
      
        dsIntro = new DataStructureIntroPom();
        hp = new HomePom();
        tp = new TryEditorDsPom();
        ip = new IntroductionPagePom();
        login = new LoginPom();
        sc = new ScrollAndClick(driver);
        tryeditor = new TryEditorPage();
       
        
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
    //retryAnalyzer=Listeners.MyRetryAnalyzer.class
    public void testDSIntroTimeComplexityLink() {
    	  //ExtentTestManager.getTest();
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
    
    @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
    public void testDSIntroTimeComplexityTryHereWithInvalidCode(String code, String expectedResult) {
    	
        ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
        sc.clickTimeComplexityLink();
        tp.clickTryHereBtn();

        TryEditorPage tryEditor = new TryEditorPage();
        ChainTestListener.log("Executing code: " + code);
        tryEditor.enteringCode(code);
        
        tp.clickRunButton();
        
        Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
    }
    
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
        public void testDSIntroTimeComplexityTryHereWithValidCode(String code, String expectedResult) {
    	 
        ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
        sc.clickTimeComplexityLink();
        tp.clickTryHereBtn();

        TryEditorPage tryEditor = new TryEditorPage();
        ChainTestListener.log("Executing code: " + code);
        tryEditor.enteringCode(code);
        
        tp.clickRunButton();
        
        String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
    
    }	
	@Test(priority = 7)
    		//retryAnalyzer=Listeners.MyRetryAnalyzer.class)
    //retryAnalyzer=Listeners.MyRetryAnalyzer.class
    
    public void testDSIntroPracticeQnsLink() {
		  
    	sc.clickTimeComplexityLink();
    	LoggerLoad.info("TimeComplexity Link Clicked");
		dsIntro.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
    }
     
   }