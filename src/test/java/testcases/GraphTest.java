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