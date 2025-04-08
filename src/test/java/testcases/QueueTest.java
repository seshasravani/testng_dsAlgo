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
import pageObjectModel.QueuePom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class QueueTest extends BaseClass {

    public DataStructureIntroPom dsIntro; 
    public HomePom hp; 
    public TryEditorDsPom tp; 
    public IntroductionPagePom ip; 
    public LoginPom login; 
    public ScrollAndClick sc; 
    public QueuePom queue;

    @BeforeMethod
    public void loginToQueue() throws InterruptedException {
        dsIntro = new DataStructureIntroPom();
        queue = new QueuePom();
        hp = new HomePom();
        tp = new TryEditorDsPom();
        ip = new IntroductionPagePom();
        login = new LoginPom();
        sc = new ScrollAndClick(driver);
        
        hp.ClickHomePageGetStartedButton();
	    ip.clickOnSignInlink();
	    login.dsAlgoLogin();
	    queue.getStartedQueue();
	    
    }

    @Test(priority = 1)
    public void testQueueLaunchPage() {
    	Assert.assertTrue(queue.validateElementDisplayed(queue.queueTitle));
		Assert.assertEquals(queue.getTextForElement(queue.queueTitle), "Queue");
		LoggerLoad.info("title is+" + "Queue");
	
    }
  
  //TC02	
  	@Test(priority=2)
  	public void operationsinQueue() throws InterruptedException {
  		queue.operationsinQueue();
  		LoggerLoad.info("Implementation of Queue in Python link Clicked");
  		Assert.assertEquals(queue.getTextForElement(queue.OperationsinQueue), "Implementation of Queue in Python");
		LoggerLoad.info("title is+" + "Implementation of Queue in Python");
  		
         }
  	
  	
  	@Test(priority=3)
	public void operationsinQueueTryHereLink() throws InterruptedException {
  		queue.operationsinQueue();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=4)
	public void operationsinQueueTryHereNoCode() throws InterruptedException {
  		queue.operationsinQueue();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
  		public void operationsinQueueTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		queue.operationsinQueue();
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
  	public void operationsinQueueTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
  	queue.operationsinQueue();
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
  	public void queueRepresent() throws InterruptedException {
  		queue.queueRepresent();
  		LoggerLoad.info("Implementation using collections.deque");
  		Assert.assertEquals(queue.getTextForElement(queue.QueueRepresent), "Implementation using collections.deque");
		LoggerLoad.info("title is+" + "Implementation using collections.deque");
  		
         }
  	
  	
  	@Test(priority=8)
	public void queueRepresentTryHereLink() throws InterruptedException {
  		queue.queueRepresent();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=9)
	public void queueRepresentTryHereNoCode() throws InterruptedException {
  		queue.queueRepresent();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 10)
  		public void queueRepresentTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		queue.queueRepresent();
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
  	public void queueRepresentTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	queue.queueRepresent();
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
  	public void queueArray() throws InterruptedException {
  		queue.queueArray();
  		LoggerLoad.info("Implementation using array");
  		Assert.assertEquals(queue.getTextForElement(queue.QueueArray), "Implementation using array");
		LoggerLoad.info("title is+" + "Implementation using array");
  		
         }
  	
  	
  	@Test(priority=13)
	public void queueArrayTryHereLink() throws InterruptedException {
  		queue.queueArray();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=14)
	public void queueArrayTryHereNoCode() throws InterruptedException {
  		queue.queueArray();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 15)
  		public void queueArrayTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		queue.queueArray();
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
  	public void queueArrayTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	queue.queueArray();
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
  	public void queueOperations() throws InterruptedException {
  		queue.queueOperations();
  		LoggerLoad.info("Queue Operations");
  		Assert.assertEquals(queue.getTextForElement(queue.QueueOperations), "Queue Operations");
		LoggerLoad.info("title is+" + "Queue Operations");
  		
         }
  	
  	
  	@Test(priority=18)
	public void queueOperationsTryHereLink() throws InterruptedException {
  		queue.queueOperations();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=19)
	public void queueOperationsTryHereNoCode() throws InterruptedException {
  		queue.queueOperations();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 20)
  		public void queueOperationsTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		queue.queueOperations();
  			tp.clickTryHereBtn();
  			 TryEditorPage tryEditor = new TryEditorPage();
  		//        ChainTestListener.log("Executing code: " + code);
  		        tryEditor.enteringCode(code);	        
  		        tp.clickRunButton();
  		        Assert.assertEquals(true, tp.handleAlert());
  				LoggerLoad.info("Alert displayed");
  		    }
  //TC06 	
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 21)
  	public void queueOperationsTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	queue.queueOperations();
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
  	@Test(priority=22)
  	public void queuePractice() throws InterruptedException {
  		queue.queueOperations();
  		queue.QueuePractice();
  		LoggerLoad.info("Practice Questions");
  		Assert.assertEquals("Practice Questions", queue.validatePageTitle());		
		LoggerLoad.info("stack.validatePageTitle()->" + queue.validatePageTitle());
         }
  	
    
}