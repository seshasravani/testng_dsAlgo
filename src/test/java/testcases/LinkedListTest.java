package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LinkedListPom;
import pageObjectModel.LoginPom;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class LinkedListTest extends BaseClass {
	
	public HomePom hp;
	public IntroductionPagePom ip;
	public DataStructureIntroPom dsIntro;
	public LinkedListPom ls;
	public TryEditorDsPom tp;
	public LoginPom login;
	public ExcelReader excelReader;
	
	
	@BeforeMethod
	public void loginToLinkedList() {
		
		    hp = new HomePom();
		    ip = new IntroductionPagePom();
		    dsIntro = new DataStructureIntroPom();
		    ls  = new LinkedListPom();
		    tp = new TryEditorDsPom();
		    login = new LoginPom();
		    excelReader = new ExcelReader();
		    
		    hp.ClickHomePageGetStartedButton();
		    ip.clickOnSignInlink();
		    login.dsAlgoLogin();
		    ip.clickOnLinkedListGetStartedBtn();
		    
	}
	
	
	@Test(priority=1)
	public void testLinkedListLaunchPage() {
		Assert.assertEquals("Linked List", ip.getPageTitle());

}
	
	@Test(priority=2)
	public void testLLIntroPage() {
		ls.clicklsIntroductionLink();
		Assert.assertEquals("Introduction", dsIntro.validatePageTitle());
		LoggerLoad.info("Introduction page displayed");
	
	}
	

	@Test(priority=3)
	public void testLLIntroPageTryHerBtn() {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsIntroductionLink();
		LoggerLoad.info("Introduction link clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		LoggerLoad.info("Run Button displayed");
	
	}
	
	@Test(priority=4)
	public void testLLIntroTryBtnNoCode () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsIntroductionLink();
		LoggerLoad.info("Introduction link clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Alert  or error displayed");
		
	}
	
	 @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
	    public void testLLIntroTryBtnInvalidCode(String code, String expectedResult) {
	        ChainTestListener.log("Verifying code execution for Linked List Page");
	        ip.clickDropdownToggle();
			LoggerLoad.info("Dropdown Toggle clicked");
			ip.clickDropdownItemLinkedList();
			LoggerLoad.info("Linked List Drop item selected");
			ls.clicklsIntroductionLink();
			LoggerLoad.info("Introduction link clicked");
			tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			       
	        TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);
	        
	        tp.clickRunButton();
	        
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
	    }
	    
	    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
	    public void testLLIntroTryBtnValidCode(String code, String expectedResult) {
	    	 ChainTestListener.log("Verifying code execution for Linked List Page");
		        ip.clickDropdownToggle();
				LoggerLoad.info("Dropdown Toggle clicked");
				ip.clickDropdownItemLinkedList();
				LoggerLoad.info("Linked List Drop item selected");
				ls.clicklsIntroductionLink();
				LoggerLoad.info("Introduction link clicked");
				tp.clickTryHereBtn();
				LoggerLoad.info("TryHere Button clicked");
				       
		        TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
	        
	        String consoleOutput = tp.getOutputText();
			Assert.assertNotNull(consoleOutput, "Console output should not be null.");
			LoggerLoad.info("Console output: " + consoleOutput);
			Assert.assertNotNull(tp.getOutputText());
	    
	    }	

	
	//  #---------------------(Creating Linked LIst page)------------------------------
	
	@Test(priority=7)
	public void testClickCreateLLLink () {
		ip.clickDropdownToggle();
	LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsCreatingLinkedLIstLink();
		LoggerLoad.info("Creating Linked List Link Clicked");
	Assert.assertEquals("Creating Linked LIst", dsIntro.validatePageTitle());
	LoggerLoad.info("Creating Linked List page opened");
		
	}
	
	
@Test(priority=8)
	public void testCreateLLLinkTryBtnNoCode () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
	LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsCreatingLinkedLIstLink();
		LoggerLoad.info("Creating Linked List Link Clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
	tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
	Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Alert  or error displayed");
		
	}
@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 9)
public void testCreateLLLinkTryBtnInvalidCode(String code, String expectedResult) {
	ip.clickDropdownToggle();
	LoggerLoad.info("Dropdown Toggle clicked");
	ip.clickDropdownItemLinkedList();
    LoggerLoad.info("Linked List Drop item selected");
	ls.clicklsCreatingLinkedLIstLink();
	LoggerLoad.info("Creating Linked List Link Clicked");
	tp.clickTryHereBtn();
	LoggerLoad.info("TryHere Button clicked");

    TryEditorPage tryEditor = new TryEditorPage();
    ChainTestListener.log("Executing code: " + code);
    tryEditor.enteringCode(code);
    
    tp.clickRunButton();
    
    Assert.assertEquals(true, tp.handleAlert());
	LoggerLoad.info("Alert displayed");
}

@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 10)
public void testCreateLLLinkTryBtnValidCode(String code, String expectedResult) {
    ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    ls.clicklsCreatingLinkedLIstLink();
	LoggerLoad.info("Creating Linked List Link Clicked");
	tp.clickTryHereBtn();
	LoggerLoad.info("TryHere Button clicked");

    TryEditorPage tryEditor = new TryEditorPage();
    ChainTestListener.log("Executing code: " + code);
    tryEditor.enteringCode(code);
    
    tp.clickRunButton();
    
    String consoleOutput = tp.getOutputText();
	Assert.assertNotNull(consoleOutput, "Console output should not be null.");
	LoggerLoad.info("Console output: " + consoleOutput);
	Assert.assertNotNull(tp.getOutputText());

}	
	//  #---------------------------------(Types of Linked List page)-----------------------------------------
	
	@Test(priority=11)
	public void testLLTypesofLLpage () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsTypesOfLinkedListLink();
		LoggerLoad.info("Types of Linked List page link clicked");
		Assert.assertEquals("Types of Linked List", dsIntro.validatePageTitle());
		LoggerLoad.info("Types of Linked List page displayed");
		
	}

	@Test(priority=12)
	public void testTypesofLLpageTryHerBtn () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsTypesOfLinkedListLink();
		LoggerLoad.info("Types of Linked List page link clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		LoggerLoad.info("Run Button displayed");
	}
	
	 @Test(priority = 13)
   public void testTypesofLLpageTryHerBtnNoCode () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsTypesOfLinkedListLink();
		LoggerLoad.info("Types of Linked List page link clicked");
		tp.clickTryHereBtn();
   	LoggerLoad.info("TryHere Button clicked");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		LoggerLoad.info("Run Button displayed");
   	tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
   	LoggerLoad.info("No Alert  or error displayed");
	}
	
	 @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 14)
    public void testTypesofLLpageTryHerBtnInvalidCode (String code, String expectedResult) {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		ls.clicklsTypesOfLinkedListLink();
		LoggerLoad.info("Types of Linked List page link clicked");
		tp.clickTryHereBtn();
		
		TryEditorPage tryEditor = new TryEditorPage();
        ChainTestListener.log("Executing code: " + code);
        tryEditor.enteringCode(code);
        
        tp.clickRunButton();
        
        Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
    }
	
	 @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 15)
	    public void testTypesofLLpageTryHerBtnValidCode (String code, String expectedResult) {
			ip.clickDropdownToggle();
			LoggerLoad.info("Dropdown Toggle clicked");
			ip.clickDropdownItemLinkedList();
			LoggerLoad.info("Linked List Drop item selected");
			ls.clicklsTypesOfLinkedListLink();
			LoggerLoad.info("Types of Linked List page link clicked");
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
	

//   #---------------------------------(Implement Linked List in Python)-----------------------------------------

	@Test(priority=16)
	public void testImplementLLInPython () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
	    ls.clicklsImplementLinkedListInPythonLink();
	    LoggerLoad.info("Implement Linked List in Python link clicked");
	    Assert.assertEquals("Implement Linked List in Python", dsIntro.validatePageTitle());
		LoggerLoad.info("Implement Linked List in Python page displayed");
		
	}	
	
	
	@Test(priority=17)
	public void testImplementLLInPythonTryHerBtn () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
	    ls.clicklsImplementLinkedListInPythonLink();
	    LoggerLoad.info("Implement Linked List in Python link clicked");
	    tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		LoggerLoad.info("Run Button displayed");
		
	}	
	

	@Test(priority=18)
	public void testImplementLLInPythonTryHerBtnNoCode  () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
	    ls.clicklsImplementLinkedListInPythonLink();
	    LoggerLoad.info("Implement Linked List in Python link clicked");
	    tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
	    tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Alert  or error displayed");
		
	}
	  @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 19)
	  public void testImplementLLInPythonTryHerBtnInvalidCode  (String code, String expectedResult) {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
	    ls.clicklsImplementLinkedListInPythonLink();
	    LoggerLoad.info("Implement Linked List in Python link clicked");
	    tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);
	        
	    tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		  Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
		
	}
	  
	  @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 20)
	  public void testImplementLLInPythonTryHerBtnValidCode  (String code, String expectedResult) {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
	    ls.clicklsImplementLinkedListInPythonLink();
	    LoggerLoad.info("Implement Linked List in Python link clicked");
	    tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);
	        
	    tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		 String consoleOutput = tp.getOutputText();
			Assert.assertNotNull(consoleOutput, "Console output should not be null.");
			LoggerLoad.info("Console output: " + consoleOutput);
			Assert.assertNotNull(tp.getOutputText());
	    
	}


////  #---------------------------------(Traversal)-----------------------------------------	
	@Test(priority=21)
	public void testLLTraversalLink () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsTraversalLink();
		 LoggerLoad.info("Traversal link clicked");
		 Assert.assertEquals("Traversal", dsIntro.validatePageTitle());
		 LoggerLoad.info("Traversal page displayed");
		
	}
	

	@Test(priority=22)
	public void testLLTraversalLinkTryHerBtn () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsTraversalLink();
		 LoggerLoad.info("Traversal link clicked");
		 tp.clickTryHereBtn();
		 LoggerLoad.info("TryHere Button clicked");
		 Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		 LoggerLoad.info("Run Button displayed");
	}
	
	@Test(priority=23)
	public void testLLTraversalLinkTryHerBtnNoCode () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsTraversalLink();
		 LoggerLoad.info("Traversal link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
		    tp.clickRunButton();
			LoggerLoad.info("Run Button clicked");
			Assert.assertEquals(false, tp.isAlertPresent());
			LoggerLoad.info("No Alert  or error displayed");
	}
	
	
	   @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 24)
	   public void testLLTraversalLinkTryHerBtnInvalidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsTraversalLink();
		 LoggerLoad.info("Traversal link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        Assert.assertEquals(true, tp.handleAlert());
				LoggerLoad.info("Alert displayed");
	}
	   
	   @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 25)
	   public void testLLTraversalLinkTryHerBtnValidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsTraversalLink();
		 LoggerLoad.info("Traversal link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        String consoleOutput = tp.getOutputText();
				Assert.assertNotNull(consoleOutput, "Console output should not be null.");
				LoggerLoad.info("Console output: " + consoleOutput);
				Assert.assertNotNull(tp.getOutputText());
		    
	}
	
//  #---------------------------------(Insertion)-----------------------------------------

	@Test(priority=26)
	public void testLLInsertionLink () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
		 Assert.assertEquals("Insertion", dsIntro.validatePageTitle());
		 LoggerLoad.info("Insertion page displayed");
		
	}
		
	@Test(priority=27)
	public void testLLInsertionLinkTryHerBtn () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
		 tp.clickTryHereBtn();
		 LoggerLoad.info("TryHere Button clicked");
		 Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		 LoggerLoad.info("Run Button displayed");
	}
	
	@Test(priority=28)
	public void testLLInsertionLinkTryHerBtnNoCode () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
		    tp.clickRunButton();
			LoggerLoad.info("Run Button clicked");
			Assert.assertEquals(false, tp.isAlertPresent());
			LoggerLoad.info("No Alert  or error displayed");
	}
		
	  @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 29)
	   public void testLLInsertionLinkTryHerBtnInvalidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        Assert.assertEquals(true, tp.handleAlert());
				LoggerLoad.info("Alert displayed");
	}
	   
	   @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 30)
	   public void testLLInsertionLinkTryHerBtnValidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        String consoleOutput = tp.getOutputText();
				Assert.assertNotNull(consoleOutput, "Console output should not be null.");
				LoggerLoad.info("Console output: " + consoleOutput);
				Assert.assertNotNull(tp.getOutputText());
		    
	}
	

//  #---------------------------------(Deletion)-----------------------------------------

	@Test(priority=31)
	public void testLLDeletionLink () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsDeletionLink();
		 LoggerLoad.info("Deletion link clicked");
		 Assert.assertEquals("Deletion", dsIntro.validatePageTitle());
		 LoggerLoad.info("Deletion page displayed");
		
	}
	
	@Test(priority=32)
	public void testLLDeletionLinkTryHereBtn () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsDeletionLink();
		 LoggerLoad.info("Deletion link clicked");
		 tp.clickTryHereBtn();
		 LoggerLoad.info("TryHere Button clicked");
		 Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
		 LoggerLoad.info("Run Button displayed");
	}
	
	@Test(priority=33)
	public void testLLDeletionLinkTryHereBtnNoCode () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsDeletionLink();
		 LoggerLoad.info("Deletion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
		    tp.clickRunButton();
			LoggerLoad.info("Run Button clicked");
			Assert.assertEquals(false, tp.isAlertPresent());
			LoggerLoad.info("No Alert  or error displayed");
	}
	
	 @Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 34)
	   public void testLLDeletionLinkTryHereBtnInvalidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsDeletionLink();
		 LoggerLoad.info("Deletion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        Assert.assertEquals(true, tp.handleAlert());
				LoggerLoad.info("Alert displayed");
	}
	   
	   @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 35)
	   public void testLLDeletionLinkTryHereBtnValidCode (String code, String expectedResult) {
	   ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		 ls.clicklsDeletionLink();
		 LoggerLoad.info("Deletion link clicked");
		  tp.clickTryHereBtn();
			LoggerLoad.info("TryHere Button clicked");
			
			  TryEditorPage tryEditor = new TryEditorPage();
		        ChainTestListener.log("Executing code: " + code);
		        tryEditor.enteringCode(code);
		        
		        tp.clickRunButton();
		        
		        String consoleOutput = tp.getOutputText();
				Assert.assertNotNull(consoleOutput, "Console output should not be null.");
				LoggerLoad.info("Console output: " + consoleOutput);
				Assert.assertNotNull(tp.getOutputText());
		    
	}
	

//	 #-------------#Practice Questions page scenarios from all sub pages under Linked List DS-------------------------------------------------------------------------

	@Test(priority=36)
	public void testLLIntroductionPagePracticeQnsLink () {
	     ls.clicklsIntroductionLink();
		 LoggerLoad.info("Introduction Link clicked");
		 ls.clickpracticequestions();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
		
			}
	

	@Test(priority=37)
	public void testLLCreatingLLPagePracticeQnsLink () {
	     ls.clicklsCreatingLinkedLIstLink();
		 LoggerLoad.info("Creating Linked LIst Link clicked");
		 ls.clickpracticequestions();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
		
			
	}
	
	@Test(priority=38)
	public void testLLTypesofLLPracticeQnsLink () {
	     ls.clicklsTypesOfLinkedListLink();
		 LoggerLoad.info("Types of Linked List Link clicked");
		 ls.clickpracticequestions();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
		
		
	}

	@Test(priority=39)
	public void testLLImplementLLInPythonLLPracticeQnsLink () {
	     ls.clicklsImplementLinkedListInPythonLink();
		 LoggerLoad.info("Implement Linked List in Python link clicked");
		 ls.clickpracticequestions();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());
	}	
		@Test(priority=40)
		public void testLLTraversalPracticeQnsLink () {
	     ls.clicklsTraversalLink();
			 LoggerLoad.info("Traversal link clicked");
			 ls.clickpracticequestions();
			LoggerLoad.info("Practice Questions Link Clicked");
			Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
			LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());		
		}
	
		@Test(priority=41)
	public void testLLInsertionPracticeQnsLink () {
		     ls.clicklsInsertionLink();
		 LoggerLoad.info("Insertion link clicked");
			 ls.clickpracticequestions();
			LoggerLoad.info("Practice Questions Link Clicked");
			Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		
			LoggerLoad.info("dsIntro.validatePageTitle()->" + dsIntro.validatePageTitle());		
		}		
			@Test(priority=42)
			public void testLLDeletionPracticeQnsLink () {
			     ls.clicklsDeletionLink();
			     LoggerLoad.info("Deletion link clicked");
				 ls.clickpracticequestions();
				 LoggerLoad.info("Practice Questions Link Clicked");
				 Assert.assertEquals("Assessment", dsIntro.validatePageTitle());		

	}
	
}

