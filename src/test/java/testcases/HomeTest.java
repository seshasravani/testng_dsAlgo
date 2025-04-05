package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import utilities.LoggerLoad;

public class HomeTest extends BaseClass {
	
	 
	public HomePom hp;
	public IntroductionPagePom ip;
	
	//Verify that user is able to view options for Data Structures drop down on home page without Sign in
	
	@BeforeMethod
	public void logintoHomePage() {
		
	     hp = new HomePom();
	     ip = new IntroductionPagePom();
	     hp.ClickHomePageGetStartedButton();
	}
	
	//Verify that user is able to view options for Data Structures dropdown on home page without Sign in
	@Test(priority=1)
	public void testDSDropdownOptions() {
		ip.clickDropdownToggle();
	    LoggerLoad.info("Drop Down toggle clicked");
		Assert.assertEquals(ip.getElementCnt(ip.dsDropdown), 6);
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 0), "Arrays");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 1), "Linked List");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 2), "Stack");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 3), "Queue");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 4), "Tree");
		Assert.assertEquals(ip.getTextForArrayElements(ip.dsDropdown, 5), "Graph");
		
	}

	//Select Array Drop Down item before sign in 
	@Test(priority=2)
	public void testSelectArrayDropDownItem() {
		
		ip.clickDropdownToggle();
        LoggerLoad.info("Drop Down toggle clicked");
		ip.clickDropdownItemArray();
        LoggerLoad.info("Drop Down Array option clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	
	}
	
	//Select Linked List Drop Down item before sign in 
	@Test(priority=2)
	public void testSelectLinkedListDropDownItem() {
	
	ip.clickDropdownToggle();
    LoggerLoad.info("Drop Down toggle clicked");
	ip.clickDropdownItemLinkedList();
    LoggerLoad.info("Drop Down Linked List option clicked");
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	
	}
	
	@Test(priority=3)
	public void testSelectStackDropDownItem() {
		ip.clickDropdownToggle();
		LoggerLoad.info("Drop Down toggle clicked");
		ip.clickDropdownItemStack();
		LoggerLoad.info("Drop Down Stack option clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=4)
	public void testSelectQueueDropDownItem() {
		ip.clickDropdownToggle();
		LoggerLoad.info("Drop Down toggle clicked");
		ip.clickDropdownItemQueue();
		LoggerLoad.info("Drop Down Queue option clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=5)
	public void testSelectTreeDropDownItem() {
		ip.clickDropdownToggle();
		LoggerLoad.info("Drop Down toggle clicked");
		ip.clickDropdownItemTree();
		LoggerLoad.info("Drop Down Tree option clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=6)
	public void testSelectGrapheDropDownItem() {
		ip.clickDropdownToggle();
		LoggerLoad.info("Drop Down toggle clicked");
		ip.clickDropdownItemGraph();
		LoggerLoad.info("Drop Down Graph option clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=6)
	public void testGetStartedButtonOnDsIntroPage() {
		ip.clickOnDataStructuresGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for DS-Intro");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=7)
	public void testGetStartedButtonOnArrayPage() {
		ip.clickOnArrayGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Array");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=8)
	public void testGetStartedButtonLinkedListPage() {
		ip.clickOnLinkedListGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Linked List");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=9)
	public void testGetStartedButtonOnStackPage() {
		ip.clickOnStackGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Stack");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=10)
	public void testGetStartedButtonOnQueuePage() {
		ip.clickOnQueueGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Queue");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=11)
	public void testGetStartedButtonOnTreePage() {
		ip.clickOnTreeGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Tree");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	
	@Test(priority=12)
	public void testGetStartedButtonOnGraphPage() {
		ip.clickOnGraphGetStartedBtn();
		LoggerLoad.info("Get Started Button clicked for Graph");
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}

}
