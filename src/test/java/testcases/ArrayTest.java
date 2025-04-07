package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import pageObjectModel.ArrayPom;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.TreePom;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class ArrayTest extends BaseClass {
	
	public DataStructureIntroPom dsIntro; 
	public ArrayPom ap;
	public IntroductionPagePom ip; 
	public TryEditorDsPom tp;
	public HomePom hp ;
	public  TreePom treePage ;
	public LoginPom login;
	
	@BeforeMethod
	public void loginToLinkedList() {
		
		
	        dsIntro=new DataStructureIntroPom();
	        ap = new ArrayPom();
		    hp = new HomePom();
		    ip = new IntroductionPagePom();
		    tp = new TryEditorDsPom();
		    treePage= new TreePom();
		    login = new LoginPom();
		   
		    
		    hp.ClickHomePageGetStartedButton();
		    ip.clickOnSignInlink();
		    login.dsAlgoLogin();
		    ip.clickOnArrayGetStartedBtn();		    
	}
	
//TC01
	@Test(priority=1)
	public void testArrayLaunchPage() {
		Assert.assertEquals("Array", dsIntro.validatePageTitle());
		LoggerLoad.info("title is" + "Array");
        }
	
//TC02	
	@Test(priority=2)
	public void testArraysInPythonPage() {
		ap.clickarraysInPythonLink();
		LoggerLoad.info("Arrays in Python link Clicked");
		Assert.assertEquals("Arrays in Python", dsIntro.validatePageTitle());
		LoggerLoad.info("title is" + "Arrays in Python");
       }
	
//TC03
	@Test(priority=3)
	public void testArraysInPythonTryHereLink() {
		ap.clickarraysInPythonLink();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
	
//TC04
	@Test(priority=4)
	public void testArraysInPythonTryHereNoCode() {
		ap.clickarraysInPythonLink();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
//TC05
@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
	public void testArraysInPythonTryHereInvalidCode(String code, String expectedResult) {
		ap.clickarraysInPythonLink();
		LoggerLoad.info("Arrays in python link clicked");
		tp.clickTryHereBtn();
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
	    }


//TC06 	
  @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
	public void testArraysInPythonTryHereValidCode(String code, String expectedResult) {
	  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
	  ap.clickarraysInPythonLink();
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
	public void testArraysUsingListPage() {
		ap.clickarraysUsingListLink();
		LoggerLoad.info("Arrays Using List Clicked");
		Assert.assertEquals("Arrays Using List", dsIntro.validatePageTitle());
		LoggerLoad.info("title is+" + "Arrays Using List");
	} 
	
//TC08
	@Test(priority=8)
	public void testArraysUsingListTryHereLink() {
		ap.clickarraysUsingListLink();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
   }
	
//TC09
	@Test(priority=9)
	public void testArraysUsingListTryHereNoCode() {
		ap.clickarraysUsingListLink();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
}
	
//TC10 
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 10)
	public void testArraysUsingListTryHereInvalidCode(String code, String expectedResult) {
		ap.clickarraysUsingListLink();
		LoggerLoad.info("Arrays Using List link clicked");
		tp.clickTryHereBtn();
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
	}  
	
//TC11 
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority=11)
	public void testArraysUsingListTryHereValidCode(String code, String expectedResult) {
		ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
		ap.clickarraysUsingListLink();
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
	
//TC12
	@Test(priority=12)
	public void testBasicOperationsInListsPage() {
		ap.clickbasicOperationsInListsLink();
		LoggerLoad.info("Basic Operations In Lists link Clicked");
		Assert.assertEquals("Basic Operations in Lists", dsIntro.validatePageTitle());
		LoggerLoad.info("title is" + "Basic Operations in Lists");
	}	
	
//TC13
	@Test(priority=13)
	public void testBasicOperationsInListsTryHereLink() {
		ap.clickbasicOperationsInListsLink();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
  
 }

//TC14
	@Test(priority=14)
	public void testBasicOperationsInListsTryHereNoCode() {
		ap.clickbasicOperationsInListsLink();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
}
	
//TC15
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority=15)
	public void testBasicOperationsInListsTryHereInvalidCode(String code, String expectedResult) {
		ap.clickbasicOperationsInListsLink();
		LoggerLoad.info("Basic Operations In Lists Link Clicked");
		tp.clickTryHereBtn();
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");		
	}  
	
	
//TC16
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority=16)
	public void testBasicOperationsInListsTryHereValidCode(String code,String expectedResult) {
		
		  ChainTestListener.log("Verifying code execution for Basic Operations In Lists Page");
		  ap.clickbasicOperationsInListsLink();
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
	
	//--------------------------- (Applications of Array)---------------------------

//TC17
	@Test(priority=17)
	public void testApplicationsOfArrayPage() {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Applications Of Array link Clicked");
		Assert.assertEquals("Applications of Array", dsIntro.validatePageTitle());
		LoggerLoad.info("title is+" + "Applications of Array");
	}
	
//TC18
	@Test(priority=18)
	public void testApplicationsOfArrayTryHereLink() {
		ap.clickapplicationsOfArrayLink();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
	
//TC19
	@Test(priority=19)
	public void testApplicationsOfArrayTryHereNoCode() {
		ap.clickapplicationsOfArrayLink();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	} 
	
//TC20 
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class,priority=20)
	public void testApplicationsOfArrayTryHereInvalidCode(String code, String expectedResult) {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Click Applications Of Array link clicked");
		tp.clickTryHereBtn();
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
	    }
	
//TC21
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class,priority=21)
	public void testApplicationsOfArrayTryHereValidCode(String code, String expectedResult) {
		
		  ChainTestListener.log("Verifying code execution for Applications Of Array Page");  
		  ap.clickapplicationsOfArrayLink();
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
	
	//--------------------------- (Practice Questions Validations)------------------------------------------------------

//TC22	
	@Test(priority=22)
	public void testPracticeQuestionsLinkOfArrayPage() throws InterruptedException {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Applications of Array link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals(hp.getTextForElement(ap.searchTheArrayLink), "Search the array");
		Assert.assertEquals(hp.getTextForElement(ap.maxConsecutiveOnes), "Max Consecutive Ones");
		Assert.assertEquals(hp.getTextForElement(ap.findNumWithEvenNumOfDigits),"Find Numbers with Even Number of Digits");
		Assert.assertEquals(hp.getTextForElement(ap.squaresOfAsortedArray), "Squares of a Sorted Array");
	}
	
//TC23	
	@Test(priority=23)
	public void testSearchTheArrayPageQuestionLink() throws InterruptedException {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Applications of Array link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickSearchTheArrayLink();
		LoggerLoad.info("Search the array Link Clicked");
		Assert.assertTrue(ip.validateElementDisplayed(ap.runButton));
		LoggerLoad.info("Run Button displayed");
		Assert.assertTrue(ip.validateElementDisplayed(ap.submitButton));
		LoggerLoad.info("Submit Button displayed");	
	} 

//TC24	
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class,priority=24)
	public void testSearchTheArrayPageQuestionInvalidCode(String code, String expectedResult) throws InterruptedException {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Applications of Array link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickSearchTheArrayLink();
		LoggerLoad.info("Search the array Link Clicked");
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();
	        Assert.assertEquals(true, tp.handleAlert());
			LoggerLoad.info("Alert displayed");
	    }

	
//TC25	
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority=25)
	public void testSearchTheArrayPageQuestionValidCode(String code, String expectedResult) throws InterruptedException {
		ap.clickapplicationsOfArrayLink();
		LoggerLoad.info("Applications of Array link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickSearchTheArrayLink();
		LoggerLoad.info("Search the array Link Clicked");
		 TryEditorPage tryEditor = new TryEditorPage();
	        ChainTestListener.log("Executing code: " + code);
	        tryEditor.enteringCode(code);	        
	        tp.clickRunButton();	      
	        String consoleOutput = tp.getOutputText();
			Assert.assertNotNull(consoleOutput, "Console output should not be null.");
			LoggerLoad.info("Console output: " + consoleOutput);
			Assert.assertNotNull(tp.getOutputText());	  
	  }

/*	
//TC26	
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class,priority=26)
	public void testMaxConsecutiveOnesInvalidCode() {
		ap.clickarraysInPythonLink();
		LoggerLoad.info("Arrays in Python link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickMaxConsecutiveOnes();
		LoggerLoad.info("Max Consecutive Ones Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 1);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	} 
/*
//TC27
	@Test(priority=27)
	public void testMaxConsecutiveOnesValidCode() {
		ap.clickarraysInPythonLink();
		LoggerLoad.info("Arrays in Python link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickMaxConsecutiveOnes();
		LoggerLoad.info("Max Consecutive Ones Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 0);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	} 
	
//TC28
	@Test(priority=28)
	public void testFindNumbersWithEvenNumberOfDigitsInvalidCode() {
		ap.clickarraysUsingListLink();
		LoggerLoad.info("Arrays Using List link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickFindNumWithEvenNumOfDigits();
		LoggerLoad.info("Find Numbers with Even Number of Digits Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 1);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}

//TC29
	@Test(priority=29)
	public void testFindNumbersWithEvenNumberOfDigitValidCode() {
		ap.clickarraysUsingListLink();
		LoggerLoad.info("Arrays Using List link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickFindNumWithEvenNumOfDigits();
		LoggerLoad.info("Find Numbers with Even Number of Digits Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 0);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}
	
//TC30
	@Test(priority=30)
	public void testSquaresOfASortedArrayPracticeInvalidCode() {
		ap.clickbasicOperationsInListsLink();
		LoggerLoad.info("Basic Operations In Lists link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickSquaresOfASortedArray();
		LoggerLoad.info("Squares of a Sorted Array Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 1);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}

	}
	
//TC31
	@Test(priority=31)
	public void testSquaresOfASortedArrayPracticeValidCode() throws InterruptedException {
		ap.clickbasicOperationsInListsLink();
		LoggerLoad.info("Basic Operations In Lists link clicked");
		ap.clickPracticeQuestionsLink();
		LoggerLoad.info("Practice Questions Link Clicked");
		ap.clickSquaresOfASortedArray();
		LoggerLoad.info("Squares of a Sorted Array Link Clicked");

		try {

			tp.enterTryHereCode("tryEditorCode", 0);
			tp.clickRunButton();
		} catch (Exception e) {
			System.err.println("Error while entering code or clicking Run: " + e.getMessage());
		}
	}
		
*/	
}