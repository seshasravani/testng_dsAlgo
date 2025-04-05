package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LinkedListPom;
import pageObjectModel.LoginPom;
import pageObjectModel.TryEditorDsPom;
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
	
	//  #---------------------(Creating Linked LIst page)------------------------------
	
//		@Test(priority=5)
//		public void testLLIntroTryBtnInvalidCode () {
//			ip.clickDropdownToggle();
//			LoggerLoad.info("Dropdown Toggle clicked");
//			ip.clickDropdownItemLinkedList();
//			LoggerLoad.info("Linked List Drop item selected");
//			ls.clicklsIntroductionLink();
//			LoggerLoad.info("Introduction link clicked");
//			tp.clickTryHereBtn();
//			LoggerLoad.info("TryHere Button clicked");
//			
//			try {
//
//				tp.enterTryHereCode("tryEditorCode", 1);
//				tp.clickRunButton();
//			} catch (Exception e) {
//				System.err.println("Error while entering code or clicking Run: " + e.getMessage());
//			}
//			Assert.assertEquals(true, tp.handleAlert());
//			LoggerLoad.info("Alert displayed");
//		}
	
//	
//	//@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "llInValidcodeTopics", dataProviderClass = TestDataProvider.class)
//	@Test(priority = 10, dataProvider = "invalidCodeData", dataProviderClass = TestDataProvider.class)
//	public void testAlertLLIntroTryBtnInvalidCode () {
//		ip.clickDropdownToggle();
//		LoggerLoad.info("Dropdown Toggle clicked5");
//		ip.clickDropdownItemLinkedList();
//		LoggerLoad.info("Linked List Drop item selected5");
//		ls.clicklsIntroductionLink();
//		LoggerLoad.info("Introduction link clicked");
//		tp.clickTryHereBtn();
//		LoggerLoad.info("TryHere Button clicked");
//		
//		try {
//		tp.enterTryHereCode("tryEditorCode");
//			tp.clickRunButton();
//		} catch (Exception e) {
//			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
//		}
//		Assert.assertEquals(true, tp.handleAlert());
//		LoggerLoad.info("Alert displayed");
//	}
	
	@Test(priority=5)
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
	
	
	@Test(priority=6)
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
	
	//  #---------------------------------(Types of Linked List page)-----------------------------------------
	
	@Test(priority=7)
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
	
	
	
	@Test(priority=8)
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

	
	@Test(priority=9)
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
//    #---------------------------------(Implement Linked List in Python)-----------------------------------------
	
	@Test(priority=10)
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
	
	
	@Test(priority=11)
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
	
	
	@Test(priority=12)
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
	
//  #---------------------------------(Traversal)-----------------------------------------
	
	
	@Test(priority=13)
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
	
	
	@Test(priority=14)
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
	
	@Test(priority=15)
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
	
//  #---------------------------------(Insertion)-----------------------------------------
	
	@Test(priority=16)
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
	
	
	@Test(priority=17)
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
	
	@Test(priority=18)
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
	
//  #---------------------------------(Deletion)-----------------------------------------

	@Test(priority=16)
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
	
	
	@Test(priority=17)
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
	
	@Test(priority=18)
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
	
	

	@Test(priority=19)
	public void testLLPracticeQnsLink () {
		 ip.clickDropdownToggle();
		 LoggerLoad.info("Dropdown Toggle clicked");
		 ip.clickDropdownItemLinkedList();
		 LoggerLoad.info("Linked List Drop item selected");
		
			
	}
	
	
	
	
	 @Test(priority = 120, dataProvider = "validCodeForTraversal", dataProviderClass = TestDataProvider.class)
	    public void testRunValidCodeTraversalPage(String validCode) {
	        ip.clickDropdownToggle();
	        LoggerLoad.info("Dropdown Toggle clicked");
	        ip.clickDropdownItemLinkedList();
	        LoggerLoad.info("Linked List Drop item selected");
	        ls.clicklsTraversalLink();
	        LoggerLoad.info("Traversal link clicked");
	        tp.clickTryHereBtn();
	        LoggerLoad.info("TryHere Button clicked");

	        try {
	            tp.enterTryHereCode(validCode);
	            tp.clickRunButton();
	        } catch (Exception e) {
	            System.err.println("Error while entering code or clicking Run: " + e.getMessage());
	        }

	        String consoleOutput = tp.getOutputText();
			Assert.assertNotNull(consoleOutput, "Console output should not be null.");
			LoggerLoad.info("Console output: " + consoleOutput);
			Assert.assertNotNull(tp.getOutputText());
	    }
	}
	


