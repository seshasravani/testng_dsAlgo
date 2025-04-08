package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import baseClass.BaseClass;
import pageObjectModel.DataStructureIntroPom;
import pageObjectModel.HomePom;
import pageObjectModel.IntroductionPagePom;
import pageObjectModel.LoginPom;
import pageObjectModel.RegisterPom;
import pageObjectModel.TreePom;
import pageObjectModel.TryEditorDsPom;
import pageObjectModel.TryEditorPage;
import utilities.LoggerLoad;
import utilities.TestDataProvider;

public class TreeTest extends BaseClass {

	public TryEditorPage tryEditor;
	public HomePom hp;
	public LoginPom login;
	public IntroductionPagePom ip;
	public RegisterPom regPage;
	public DataStructureIntroPom dsintropage;
	public TreePom treePage;
	public TryEditorDsPom tp;

	@BeforeMethod
	public void loginToTreePage() {

		tryEditor = new TryEditorPage();
		hp = new HomePom();
		login = new LoginPom();
		ip = new IntroductionPagePom();
		regPage = new RegisterPom();
		dsintropage = new DataStructureIntroPom();
		treePage = new TreePom();
		tp = new TryEditorDsPom();

		hp.ClickHomePageGetStartedButton();
		ip.clickOnSignInlink();
		login.dsAlgoLogin();
		ip.clickOnTreeGetStartedBtn();
	}

	// TC01
	@Test(priority = 1)
	public void testArrayLaunchPage() {
		Assert.assertEquals("Tree", dsintropage.validatePageTitle());
		LoggerLoad.info("title is" + "Tree");
	}

	// --------------------------- (1. Overview of
	// Trees)------------------------------------------------------
	
	@Test(priority=2)
	public void testOverviewOfTrees() throws InterruptedException {
		treePage.overviewofTreesLink();
		LoggerLoad.info("Overview of Trees link Clicked");
		Assert.assertEquals("Overview of Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is" + "Overview of Trees");
		
		
	}

	// TC03
	@Test(priority = 3)
	public void testOverviewOfTreesPageTryHere() throws InterruptedException {
		treePage.overviewofTreesLink();
		LoggerLoad.info("Overview of Trees link Clicked");
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

	// TC04
	@Test(priority = 4)
	public void testOverviewOfTreesPageTryHereNoCode() throws InterruptedException {
		treePage.overviewofTreesLink();
		LoggerLoad.info("Overview of Trees link Clicked");
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

	// TC05
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 5)
	public void testOverviewOfTreesPageTryHereInvalidCode(String code, String expectedResult)
			throws InterruptedException {
		treePage.overviewofTreesLink();
		LoggerLoad.info("Overview of Trees link Clicked");
		tp.clickTryHereBtn();
		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

	// TC06
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 6)
	public void testOverviewOfTreesPageTryHereValidCode(String code, String expectedResult)
			throws InterruptedException {
		treePage.overviewofTreesLink();
		LoggerLoad.info("Overview of Trees link Clicked");
		tp.clickTryHereBtn();
		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

	// ------------------------------2.
	// Terminologies-----------------------------------

	// TC07
	@Test(priority = 7)
	public void TestTerminologiesLink() {
		treePage.terminologiesLink();
		LoggerLoad.info("Terminologies Link Clicked");
		Assert.assertEquals("Terminologies", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Terminologies");
	}

	// TC08
	@Test(priority = 8)
	public void TestTerminologiesLinkTryHere() {
		treePage.terminologiesLink();
		LoggerLoad.info("Terminologies Link Clicked");
		tp.clickTryHereBtn();

		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

	// TC09
	@Test(priority = 9)
	public void TestTerminologiesLinkTryHereNoCode() {
		treePage.terminologiesLink();
		LoggerLoad.info("Terminologies Link Clicked");
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

	// TC10
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 10)
	public void TestTerminologiesLinkTryHereInvalidCode(String code, String expectedResult) {
		treePage.terminologiesLink();
		LoggerLoad.info("Terminologies Link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

	// TC11
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 11)
	public void TestTerminologiesLinkTryHereValidCode(String code, String expectedResult) {
		treePage.terminologiesLink();
		LoggerLoad.info("Terminologies Link Clicked");
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

	// ------------------------------3. Types of
	// Trees-----------------------------------

	// TC12
	@Test(priority = 12)
	public void testTypesOfTreesLink() {
		treePage.typesofTrees();
		LoggerLoad.info("Types of Trees link Clicked");
		Assert.assertEquals("Types of Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is" + "Types of Trees");
	}

	// TC13
	@Test(priority = 13)
	public void testTypesOfTreesLinkTryHere() {
		treePage.typesofTrees();
		LoggerLoad.info("Types of Trees link Clicked");
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));

	}

	// TC14
	@Test(priority = 14)
	public void testTypesOfTreesLinkTryHereNoCode() {
		treePage.typesofTrees();
		LoggerLoad.info("Types of Trees link Clicked");
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

	// TC15
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 15)
	public void testTypesOfTreesLinkTryHereInvalidCode(String code, String expectedResult) {
		treePage.typesofTrees();
		LoggerLoad.info("Types of Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

	// TC16
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 16)
	public void testTypesOfTreesLinkTryHereValidCode(String code, String expectedResult) {

		treePage.typesofTrees();
		LoggerLoad.info("Types of Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();

		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());

	}

//----------------------------4. Tree Traversals--------------------------------------------------

	// TC17
	@Test(priority = 17)
	public void testTreeTraversalsPage() {
		treePage.treeTraversals();
		LoggerLoad.info("Tree Traversals link Clicked");
		Assert.assertEquals("Tree Traversals", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Tree Traversals");
	}

	// TC18
	@Test(priority = 18)
	public void testTreeTraversalsPageTryHere() {
		treePage.treeTraversals();
		LoggerLoad.info("Tree Traversals link Clicked");
		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

	// TC19
	@Test(priority = 19)
	public void testTreeTraversalsPageTryHereNoCode() {
		treePage.treeTraversals();
		LoggerLoad.info("Tree Traversals link Clicked");
		tp.clickTryHereBtn();
		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

	// TC20
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 20)
	public void testTreeTraversalsPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.treeTraversals();
		LoggerLoad.info("Tree Traversals link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

	// TC21
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 21)
	public void testTreeTraversalsPageTryHereValidCode(String code, String expectedResult) {
		treePage.treeTraversals();
		LoggerLoad.info("Tree Traversals link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------5. Traversals-Illustration--------------------------------------------------

//TC22
	@Test(priority = 22)
	public void testTraversalsIllustrationPage() {
		treePage.traversalsIllustration();
		LoggerLoad.info("Traversals-Illustration link Clicked");
		Assert.assertEquals("Traversals-Illustration", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Traversals-Illustration");
	}

//TC23
	@Test(priority = 23)
	public void testTraversalsIllustrationPageTryHere() {
		treePage.traversalsIllustration();
		LoggerLoad.info("Traversals-Illustration link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC24
	@Test(priority = 24)
	public void testTraversalsIllustrationPageTryHereNoCode() {
		treePage.traversalsIllustration();
		LoggerLoad.info("Traversals-Illustration link Clicked");
		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC25
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 25)
	public void testTraversalsIllustrationPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.traversalsIllustration();
		LoggerLoad.info("Traversals-Illustration link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC26
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 26)
	public void testTraversalsIllustrationPageTryHereValidCode(String code, String expectedResult) {
		treePage.traversalsIllustration();
		LoggerLoad.info("Traversals-Illustration link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------6. Binary Trees--------------------------------------------------

//TC27
	@Test(priority = 27)
	public void testBinaryTreesPage() {
		treePage.binaryTrees();
		LoggerLoad.info("Binary Trees link Clicked");
		Assert.assertEquals("Binary Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Binary Trees");
	}

//TC28
	@Test(priority = 28)
	public void testBinaryTreesPageTryHere() {
		treePage.binaryTrees();
		LoggerLoad.info("Binary Trees link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC29
	@Test(priority = 24)
	public void testBinaryTreesPageTryHereNoCode() {
		treePage.binaryTrees();
		LoggerLoad.info("Binary Trees link Clicked");
		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC30
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 30)
	public void testBinaryTreesPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.binaryTrees();
		LoggerLoad.info("Binary Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC31
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 31)
	public void testBinaryTreesPageTryHereValidCode(String code, String expectedResult) {
		treePage.binaryTrees();
		LoggerLoad.info("Binary Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------7. Types of Binary Trees--------------------------------------------------

//TC32
	@Test(priority = 32)
	public void testTypesOfBinaryTreesPage() {
		treePage.typesofBinaryTrees();
		LoggerLoad.info("Types of Binary Trees link Clicked");
		Assert.assertEquals("Types of Binary Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Types of Binary Trees");
	}

//TC33
	@Test(priority = 33)
	public void typesofBinaryTreesTryHere() {
		treePage.typesofBinaryTrees();
		LoggerLoad.info("Types of Binary Trees link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC34
	@Test(priority = 34)
	public void typesofBinaryTreesTryHereNoCode() {
		treePage.typesofBinaryTrees();
		LoggerLoad.info("Types of Binary Trees link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC35
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 35)
	public void typesofBinaryTreesTryHereInvalidCode(String code, String expectedResult) {
		treePage.typesofBinaryTrees();
		LoggerLoad.info("Types of Binary Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC36
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 36)
	public void typesofBinaryTreesTryHereValidCode(String code, String expectedResult) {
		treePage.typesofBinaryTrees();
		LoggerLoad.info("Types of Binary Trees link Clicked");
		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------8. Implementation in Python--------------------------------------------------

//TC37
	@Test(priority = 37)
	public void testImplementationInPythonPage() {
		treePage.implementationInPython();
		LoggerLoad.info("Implementation in Python link Clicked");
		Assert.assertEquals("Implementation in Python", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Implementation in Python");
	}

//TC38
	@Test(priority = 38)
	public void testImplementationInPythonPageTryHere() {
		treePage.implementationInPython();
		LoggerLoad.info("Implementation in Python link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC39
	@Test(priority = 39)
	public void testImplementationInPythonPageTryHereNoCode() {
		treePage.implementationInPython();
		LoggerLoad.info("Implementation in Python link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC40
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 40)
	public void testImplementationInPythonPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.implementationInPython();
		LoggerLoad.info("Implementation in Python link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC41
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 41)
	public void testImplementationInPythonPageTryHereValidCode(String code, String expectedResult) {
		treePage.implementationInPython();
		LoggerLoad.info("Implementation in Python link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------9. Binary Tree Traversals-------------------------------------------------

//TC42
	@Test(priority = 42)
	public void testBinaryTreeTraversalsPage() {
		treePage.binaryTreeTraversals();
		LoggerLoad.info("Binary Tree Traversals link Clicked");
		Assert.assertEquals("Binary Tree Traversals", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Binary Tree Traversals");
	}

//TC43
	@Test(priority = 43)
	public void testBinaryTreeTraversalsPageTryHere() {
		treePage.binaryTreeTraversals();
		LoggerLoad.info("Binary Tree Traversals link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC44
	@Test(priority = 44)
	public void testBinaryTreeTraversalsPageTryHereNoCode() {
		treePage.binaryTreeTraversals();
		LoggerLoad.info("Binary Tree Traversals link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC45
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 40)
	public void testBinaryTreeTraversalsPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.binaryTreeTraversals();
		LoggerLoad.info("Binary Tree Traversals link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC46
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 41)
	public void testBinaryTreeTraversalsPageTryHereValidCode(String code, String expectedResult) {
		treePage.binaryTreeTraversals();
		LoggerLoad.info("Binary Tree Traversals link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------10. Implementation of Binary Trees-------------------------------------------------

//TC47
	@Test(priority = 47)
	public void testImplementationOfBinaryTreesPage() {
		treePage.implementationofBinaryTrees();
		LoggerLoad.info("Implementation of Binary Trees link Clicked");
		Assert.assertEquals("Implementation of Binary Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Implementation of Binary Trees");
	}

//TC48
	@Test(priority = 48)
	public void testImplementationOfBinaryTreesPageTryHere() {
		treePage.implementationofBinaryTrees();
		LoggerLoad.info("Implementation of Binary Trees link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC49
	@Test(priority = 49)
	public void testImplementationOfBinaryTreesPageTryHereNoCode() {
		treePage.implementationofBinaryTrees();
		LoggerLoad.info("Implementation of Binary Trees link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC50
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 50)
	public void testImplementationOfBinaryTreesPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.implementationofBinaryTrees();
		LoggerLoad.info("Implementation of Binary Trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC51
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 51)
	public void testImplementationOfBinaryTreesPageTryHereValidCode(String code, String expectedResult) {
		treePage.implementationofBinaryTrees();
		LoggerLoad.info("Implementation of Binary Trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------11. Applications of Binary trees-------------------------------------------------

//TC52
	@Test(priority = 52)
	public void testApplicationsOfBinaryTreesPage() {
		treePage.applicationsofBinaryTrees();
		LoggerLoad.info("Applications of Binary trees link Clicked");
		Assert.assertEquals("Applications of Binary trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Applications of Binary trees");
	}

//TC53
	@Test(priority = 53)
	public void testApplicationsOfBinaryTreesPageTryHere() {
		treePage.applicationsofBinaryTrees();
		LoggerLoad.info("Applications of Binary trees link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC54
	@Test(priority = 54)
	public void testApplicationsOfBinaryTreesPageTryHereNoCode() {
		treePage.applicationsofBinaryTrees();
		LoggerLoad.info("Applications of Binary trees link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC55
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 55)
	public void testApplicationsOfBinaryTreesPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.applicationsofBinaryTrees();
		LoggerLoad.info("Applications of Binary trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC56
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 56)
	public void testApplicationsOfBinaryTreesPageTryHereValidCode(String code, String expectedResult) {
		treePage.applicationsofBinaryTrees();
		LoggerLoad.info("Applications of Binary trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------12. Binary Search Trees-------------------------------------------------

//TC57
	@Test(priority = 57)
	public void testBinarySearchTreesPage() {
		treePage.binarySearchTrees();
		LoggerLoad.info("Binary Search Trees link Clicked");
		Assert.assertEquals("Binary Search Trees", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Binary Search Trees");
	}

//TC58
	@Test(priority = 58)
	public void testBinarySearchTreesPageTryHere() {
		treePage.binarySearchTrees();
		LoggerLoad.info("Binary Search Trees link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC59
	@Test(priority = 59)
	public void testBinarySearchTreesPageTryHereNoCode() {
		treePage.binarySearchTrees();
		LoggerLoad.info("Binary Search Trees link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC60
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 60)
	public void testBinarySearchTreesPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.binarySearchTrees();
		LoggerLoad.info("Binary Search Trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC61
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 61)
	public void testBinarySearchTreesPageValidCode(String code, String expectedResult) {
		treePage.binarySearchTrees();
		LoggerLoad.info("Binary Search Trees link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//----------------------------13. Implementation Of BST-------------------------------------------------

//TC62
	@Test(priority = 62)
	public void testImplementationOfBSTPage() {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");
		Assert.assertEquals("Implementation Of BST", dsintropage.validatePageTitle());
		LoggerLoad.info("title is+" + "Implementation Of BST");
	}

//TC63
	@Test(priority = 63)
	public void testImplementationOfBSTPageTryHere() {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");

		tp.clickTryHereBtn();
		Assert.assertEquals(ip.getPageTitle(), "Assessment");
		Assert.assertTrue(ip.validateElementDisplayed(tp.runButton));
	}

//TC64
	@Test(priority = 64)
	public void testImplementationOfBSTPageTryHereNoCode() {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");

		tp.clickTryHereBtn();

		tp.clickRunButton();
		LoggerLoad.info("Run Button clicked");
		Assert.assertEquals(false, tp.isAlertPresent());
		LoggerLoad.info("No Error message displayed");
	}

//TC65
	@Test(dataProvider = "codeExecutionDataInvalid", dataProviderClass = TestDataProvider.class, priority = 65)
	public void testImplementationOfBSTPageTryHereInvalidCode(String code, String expectedResult) {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();
		Assert.assertEquals(true, tp.handleAlert());
		LoggerLoad.info("Alert displayed");
	}

//TC66
	@Test(dataProvider = "codeExecutionDataValid", dataProviderClass = TestDataProvider.class, priority = 66)
	public void testImplementationOfBSTPageValidCode(String code, String expectedResult) {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");

		tp.clickTryHereBtn();

		TryEditorPage tryEditor = new TryEditorPage();
		tryEditor.enteringCode(code);
		tp.clickRunButton();

		String consoleOutput = tp.getOutputText();
		Assert.assertNotNull(consoleOutput, "Console output should not be null.");
		LoggerLoad.info("Console output: " + consoleOutput);
		Assert.assertNotNull(tp.getOutputText());
	}

//--------------------------14. Practice Questions----------------------------------

//TC67
	@Test(priority = 67)
	public void testPracticeQuestionsLinkOfArrayPage() throws InterruptedException {
		treePage.implementationOfbst();
		LoggerLoad.info("Implementation Of BST link Clicked");

		treePage.practiceQuestions();
		LoggerLoad.info("Practice Questions Link Clicked");
		Assert.assertEquals("Assessment", dsintropage.validatePageTitle());
		LoggerLoad.info("dsIntro.validatePageTitle()->" + dsintropage.validatePageTitle());
	}

}