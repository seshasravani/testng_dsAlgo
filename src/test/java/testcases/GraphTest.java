package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectModel.LoginPom;
import utilities.RetryAnalyzer;
import utilities.TestDataProvider;
import baseClass.BaseClass;
import pageObjectModel.GraphPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import io.github.bonigarcia.wdm.WebDriverManager;
public class GraphTest extends BaseClass{

	public GraphPom gp;
	public HomePom hp;
	public IntroductionPagePom ip;
	public LoginPom lp ;

	@BeforeMethod
	public void loginIntoApp() {
		hp = new HomePom();
		gp = new GraphPom();
		ip =  new IntroductionPagePom();
		lp = new LoginPom();
//		hp.openHomeURL();
	hp.ClickHomePageGetStartedButton();

//		ip.clickOnGetStartedButtonOfGraph();
	
		System.out.println("before method");
	//	hp.openURL();
		
		
		
//		hp.ClickHomePageGetStartedButton();
        ip.clickOnSignInlink();
        
        driver.findElement(By.id("id_username")).sendKeys("teamachievers");
        driver.findElement(By.id("id_password")).sendKeys("Welcome@1");

        driver.findElement(By.xpath("//input[@value='Login']")).click();


        
        //        lp.enterLoginFormFields("login", 6);
//	     lp.clickloginBtn();
	//	gp.getStartedGraph();
	}
	
	
	@Test
    public void testMethod1() {
        System.out.println("Running testMethod1");
        // Your assertions or logic for testMethod1
    }
	
	@Test
	
	public void navigatetoGraphPage() throws InterruptedException
	{
		
		gp.getStartedGraph();
		
		
	}
	
	
	
	
	
	
	
	
	
}




