package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.QueuePom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;

import utilities.LoggerLoad;

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
    
   /* @Test(priority = 2)
    public void testDSIntroTimeComplexityLink() {
    	sc.clickTimeComplexityLink();
		LoggerLoad.info("Time Complexity Link is clicked");
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Time Complexity"),
				"Page title does not contain 'Time Complexity'. Found: " + pageTitle);
		LoggerLoad.info("Title is: " + pageTitle);
	
    }*/
}