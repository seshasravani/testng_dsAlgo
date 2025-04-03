package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;

public class HomePageTest extends BaseClass {
	
	public HomePom hp = new HomePom();
	public IntroductionPagePom ip = new IntroductionPagePom();
	
	//Verify that user is able to view options for Data Structures drop down on home page without Sign in
	
	@BeforeMethod
	public void logintoHomePage() {
	    hp.openURL();
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
	


	
	

}
