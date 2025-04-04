package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;

public class HomePageTest extends BaseClass {
	 
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
		ip.clickDropdownItemArray();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	
	}
	
	//Select Array Drop Down item before sign in 
	@Test(priority=2)
	public void testSelectLinkedListDropDownItem() {
	
	ip.clickDropdownToggle();
	ip.clickDropdownItemLinkedList();
	Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
	Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
	Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
	
	}
	
	@Test(priority=3)
	public void testSelectStackDropDownItem() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemStack();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=4)
	public void testSelectQueueDropDownItem() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemQueue();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=5)
	public void testSelectTreeDropDownItem() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemTree();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=6)
	public void testSelectGrapheDropDownItem() {
		ip.clickDropdownToggle();
		ip.clickDropdownItemGraph();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
		
	}
	
	@Test(priority=6)
	public void testGetStartedButtonOnDsIntroPage() {
		ip.clickOnDataStructuresGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=7)
	public void testGetStartedButtonOnArrayPage() {
		ip.clickOnArrayGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=8)
	public void testGetStartedButtonLinkedListPage() {
		ip.clickOnLinkedListGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=9)
	public void testGetStartedButtonOnStackPage() {
		ip.clickOnStackGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=10)
	public void testGetStartedButtonOnQueuePage() {
		ip.clickOnQueueGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	@Test(priority=11)
	public void testGetStartedButtonOnTreePage() {
		ip.clickOnTreeGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}
	
	
	@Test(priority=12)
	public void testGetStartedButtonOnGraphPage() {
		ip.clickOnGraphGetStartedBtn();
		Assert.assertTrue(ip.validateElementDisplayed(ip.authenticationmsg));
		Assert.assertEquals(ip.getTextForElement(ip.authenticationmsg), "You are not logged in");
		Assert.assertEquals(ip.getElementSize(ip.authenticationmsg), 1);
			
	}

}
