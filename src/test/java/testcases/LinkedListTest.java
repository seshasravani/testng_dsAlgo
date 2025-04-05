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
	
	
	//@Test(retryAnalyzer = RetryAnalyzer.class, dataProvider = "llInValidcodeTopics", dataProviderClass = TestDataProvider.class)
	@Test(priority = 5, dataProvider = "invalidCodeData", dataProviderClass = TestDataProvider.class)
	public void testAlertLLIntroTryBtnInvalidCode () {
		ip.clickDropdownToggle();
		LoggerLoad.info("Dropdown Toggle clicked5");
		ip.clickDropdownItemLinkedList();
		LoggerLoad.info("Linked List Drop item selected5");
		ls.clicklsIntroductionLink();
		LoggerLoad.info("Introduction link clicked");
		tp.clickTryHereBtn();
		LoggerLoad.info("TryHere Button clicked");
		
		try {
		tp.enterTryHereCode("tryEditorCode");
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}
		
	
	
}

