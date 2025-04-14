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
import pageObjectModel.StackPom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class StackTest extends BaseClass {

    public DataStructureIntroPom dsIntro; 
    public HomePom hp; 
    public TryEditorDsPom tp; 
    public IntroductionPagePom ip; 
    public LoginPom login; 
    public ScrollAndClick sc; 
    public StackPom stack;

    @BeforeMethod
    public void loginToStack() throws InterruptedException {
        dsIntro = new DataStructureIntroPom();
        stack = new StackPom();
        hp = new HomePom();
        tp = new TryEditorDsPom();
        ip = new IntroductionPagePom();
        login = new LoginPom();
        sc = new ScrollAndClick(driver);
        
        hp.ClickHomePageGetStartedButton();
	    ip.clickOnSignInlink();
	    login.dsAlgoLogin();
	    stack.getStartedStack();
	    
    }

    @Test(priority = 1)
    public void testStackLaunchPage() {
    	Assert.assertTrue(stack.validateElementDisplayed(stack.stackTitle));
		Assert.assertEquals(stack.getTextForElement(stack.stackTitle), "Stack");
		LoggerLoad.info("title is+" + "Stack");
	
    }
  
  //TC02	
  	@Test(priority=2)
  	public void operationsinStack() throws InterruptedException {
  		stack.operationsinStack();
  		LoggerLoad.info("Operations in Stack");
  		Assert.assertEquals(stack.getTextForElement(stack.OperationsinStack), "Operations in Stack");
		LoggerLoad.info("title is+" + "Operations in Stack");
  		
         }
  	
  	
  	@Test(priority=3)
	public void operationsinStackTryHereLink() throws InterruptedException {
  		stack.operationsinStack();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=4)
	public void operationsinStackTryHereNoCode() throws InterruptedException {
  		stack.operationsinStack();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
  		public void operationsinStackTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		stack.operationsinStack();
  			tp.clickTryHereBtn();
  			 TryEditorPage tryEditor = new TryEditorPage();
  		//        ChainTestListener.log("Executing code: " + code);
  		        tryEditor.enteringCode(code);	        
  		        tp.clickRunButton();
  		        Assert.assertEquals(true, tp.handleAlert());
  				LoggerLoad.info("Alert displayed");
  		    }
  //TC06 	
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
  	public void operationsinStackTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
  	stack.operationsinStack();
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

    
    //TC07
  	@Test(priority=7)
  	public void stackRepresent() throws InterruptedException {
  		stack.StackRepresent();
  		LoggerLoad.info("Implementation");
  		Assert.assertEquals(stack.getTextForElement(stack.StackRepresent), "Implementation");
		LoggerLoad.info("title is+" + "Implementation");
  		
         }
  	
  	
  	@Test(priority=8)
	public void stackRepresentTryHereLink() throws InterruptedException {
  		stack.StackRepresent();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=9)
	public void stackRepresentTryHereNoCode() throws InterruptedException {
  		stack.StackRepresent();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 10)
  		public void stackRepresentTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		stack.StackRepresent();
  			tp.clickTryHereBtn();
  			 TryEditorPage tryEditor = new TryEditorPage();
  		//        ChainTestListener.log("Executing code: " + code);
  		        tryEditor.enteringCode(code);	        
  		        tp.clickRunButton();
  		        Assert.assertEquals(true, tp.handleAlert());
  				LoggerLoad.info("Alert displayed");
  		    }
  //TC06 	
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 11)
  	public void stackRepresentTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	stack.StackRepresent();
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
    
    
    //TC07
  	@Test(priority=12)
  	public void StackApplications() throws InterruptedException {
  		stack.StackApplications();
  		LoggerLoad.info("Applications");
  		Assert.assertEquals(stack.getTextForElement(stack.StackApplications), "Applications");
		LoggerLoad.info("title is+" + "Applications");
  		
         }
  	
  	
  	@Test(priority=13)
	public void stackApplicationsTryHereLink() throws InterruptedException {
  		stack.StackApplications();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=14)
	public void StackApplicationsTryHereNoCode() throws InterruptedException {
  		stack.StackApplications();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 15)
  		public void StackApplicationsTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		stack.StackApplications();
  			tp.clickTryHereBtn();
  			 TryEditorPage tryEditor = new TryEditorPage();
  		//        ChainTestListener.log("Executing code: " + code);
  		        tryEditor.enteringCode(code);	        
  		        tp.clickRunButton();
  		        Assert.assertEquals(true, tp.handleAlert());
  				LoggerLoad.info("Alert displayed");
  		    }
  //TC06 	
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 16)
  	public void StackApplicationsTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	stack.StackApplications();
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
    
    
    
   
    
    //TC07
  	@Test(priority=17)
  	public void stackPractice() throws InterruptedException {
    	stack.StackApplications();
  		stack.StackPractice();
  		LoggerLoad.info("Practice Questions");
  		Assert.assertEquals("Practice Questions", stack.validatePageTitle());		
		LoggerLoad.info("stack.validatePageTitle()->" + stack.validatePageTitle());
	
         }
    
}