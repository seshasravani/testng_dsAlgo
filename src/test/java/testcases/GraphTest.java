package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.GraphPom;
import pageObjectModel.ScrollAndClick;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class GraphTest extends BaseClass {

    public DataStructureIntroPom dsIntro; 
    public HomePom hp; 
    public TryEditorDsPom tp; 
    public IntroductionPagePom ip; 
    public LoginPom login; 
    public ScrollAndClick sc; 
    public GraphPom graph;

    @BeforeMethod
    public void loginToGraph() throws InterruptedException {
        dsIntro = new DataStructureIntroPom();
        graph = new GraphPom();
        hp = new HomePom();
        tp = new TryEditorDsPom();
        ip = new IntroductionPagePom();
        login = new LoginPom();
        sc = new ScrollAndClick(driver);
        
        hp.ClickHomePageGetStartedButton();
	    ip.clickOnSignInlink();
	    login.dsAlgoLogin();
	    graph.getStartedGraph();
	    
    }

    @Test(priority = 1)
    public void testGraphLaunchPage() {
    	Assert.assertTrue(graph.validateElementDisplayed(graph.graphTitle));
		Assert.assertEquals(graph.getTextForElement(graph.graphTitle), "Graph");
		LoggerLoad.info("title is+" + "Graph");
	
    }
  
  //TC02	
  	@Test(priority=2)
  	public void topicsCoveredGraph() throws InterruptedException {
  		graph.topicsCoveredGraph();
  		LoggerLoad.info("Graph");
  		Assert.assertEquals(graph.getTextForElement(graph.graph_topicsCovered), "Graph");
		LoggerLoad.info("title is+" + "Graph");
  		
         }
  	
  	
  	@Test(priority=3)
	public void topicsCoveredGraphTryHereLink() throws InterruptedException {
  		graph.topicsCoveredGraph();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=4)
	public void topicsCoveredGraphTryHereNoCode() throws InterruptedException {
  		graph.topicsCoveredGraph();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
  		public void topicsCoveredGraphTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		graph.topicsCoveredGraph();
  			tp.clickTryHereBtn();
  			 TryEditorPage tryEditor = new TryEditorPage();


  		        tryEditor.enteringCode(code);	        
  		        tp.clickRunButton();
  		        Assert.assertEquals(true, tp.handleAlert());
  				LoggerLoad.info("Alert displayed");
  		    }
  //TC06 	
    @Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
  	public void topicsCoveredGraphTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
  	graph.topicsCoveredGraph();
        tp.clickTryHereBtn();
        TryEditorPage tryEditor = new TryEditorPage();
    
        tryEditor.enteringCode(code); 
        tp.clickRunButton();
          String consoleOutput = tp.getOutputText();
  		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
  		LoggerLoad.info("Console output: " + consoleOutput);
  		Assert.assertNotNull(tp.getOutputText());
    }

    
    //TC07
  	@Test(priority=7)
  	public void graphRepresentations() throws InterruptedException {
  		graph.graphRepresentations();
  		LoggerLoad.info("Graph Representations");
  		Assert.assertEquals(graph.getTextForElement(graph.graphRepresentations), "Graph Representations");
		LoggerLoad.info("title is+" + "Graph Representations");
  		
         }
  	
  	
  	@Test(priority=8)
	public void graphRepresentationsTryHereLink() throws InterruptedException {
  		graph.graphRepresentations();
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
 }
  	
  	@Test(priority=9)
	public void graphRepresentationsTryHereNoCode() throws InterruptedException {
  		graph.graphRepresentations();
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
 }
	
  //TC05
  	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 10)
  		public void graphRepresentationsTryHereInvalidCode(String code, String expectedResult) throws InterruptedException {
  		graph.graphRepresentations();
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
  	public void graphRepresentTryHereValidCode(String code, String expectedResult) throws InterruptedException {
  	//  ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
    	graph.graphRepresentations();
        tp.clickTryHereBtn();
        TryEditorPage tryEditor = new TryEditorPage();
      
        tryEditor.enteringCode(code); 
        tp.clickRunButton();
          String consoleOutput = tp.getOutputText();
  		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
  		LoggerLoad.info("Console output: " + consoleOutput);
  		Assert.assertNotNull(tp.getOutputText());
    }
    
   
    
    //TC07
  	@Test(priority=17)
  	public void graphPractice() throws InterruptedException {
    	graph.graphRepresentations();
  		graph.graphPractice();
  		LoggerLoad.info("Practice Questions");
  		Assert.assertEquals("Assessment", graph.validatePageTitle());		
		LoggerLoad.info("graph.validatePageTitle()->" + graph.validatePageTitle());
	
         }
    
}






//package driverManager;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class DriverManager {
//
//	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//
//	// Flag to toggle between local and grid
//	private static final boolean RUN_ON_GRID = true;
//
//	// Replace this with your actual Grid Hub URL
//	private static final String GRID_URL = "http://selenium-hub.selenium-grid.svc.cluster.local:4444/wd/hub";
//
//	public WebDriver initializeBrowser(String browser) {
//		if (browser == null || browser.isEmpty()) {
//			throw new IllegalArgumentException("Browser name must not be null or empty.");
//		}
//
//		try {
//			switch (browser.toLowerCase()) {
//				case "chrome":
//					if (RUN_ON_GRID) {
//						ChromeOptions chromeOptions = new ChromeOptions();
//						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), chromeOptions));
//					} else {
//						tlDriver.set(new org.openqa.selenium.chrome.ChromeDriver());
//					}
//					break;
//
//				case "firefox":
//					if (RUN_ON_GRID) {
//						FirefoxOptions firefoxOptions = new FirefoxOptions();
//						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), firefoxOptions));
//					} else {
//						tlDriver.set(new org.openqa.selenium.firefox.FirefoxDriver());
//					}
//					break;
//
//				case "edge":
//					if (RUN_ON_GRID) {
//						EdgeOptions edgeOptions = new EdgeOptions();
//						tlDriver.set(new RemoteWebDriver(new URL(GRID_URL), edgeOptions));
//					} else {
//						tlDriver.set(new org.openqa.selenium.edge.EdgeDriver());
//					}
//					break;
//
//				default:
//					throw new IllegalArgumentException("Unsupported browser: " + browser);
//			}
//		} catch (MalformedURLException e) {
//			throw new RuntimeException("Malformed Grid URL: " + GRID_URL, e);
//		} catch (Exception e) {
//			System.err.println("Error initializing browser: " + e.getMessage());
//			throw e;
//		}
//
//		WebDriver driver = getDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		return driver;
//	}
//
//	public static WebDriver getDriver() {
//		WebDriver driver = tlDriver.get();
//		if (driver == null) {
//			throw new IllegalStateException("WebDriver is not initialized. Did you call initializeBrowser?");
//		}
//		return driver;
//	}
//
//	public static void removeDriver() {
//		WebDriver driver = tlDriver.get();
//		if (driver != null) {
//			driver.quit();
//			tlDriver.remove();
//		}
//	}
//}
