package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.LoggerLoad;

public class GraphPom {

	public WebDriver driver = DriverManager.getDriver();
	
	public By graphTitle = By.xpath("//h4[text()='Graph']");
	private By graph_getStarted = By.xpath("//a[@href='graph']");
	public By graph_topicsCovered = By.linkText("Graph");
	public By graphRepresentations = By.linkText("Graph Representations");
	private By graphPractice = By.xpath("//a[@href='/graph/practice']");
	private By clickTryhere = By.linkText("Try here>>>");

	/*
	 * public void getStartedGraph() throws InterruptedException {
	 * 
	 * System.out.println("trying to get into Graph page");
	 * 
	 * driver.findElement(graph_getStarted).click();
	 * 
	 * }
	 */
	
	public void getStartedGraph() {
		CommonUtils.clickElement(graph_getStarted);
		LoggerLoad.info("Clicked Get Started for Graph");
	}
	
	public void topicsCoveredGraph() {
		CommonUtils.clickElement(graph_topicsCovered);
		LoggerLoad.info("Clicked Graph Topics Covered");
	}


	/*
	 * public void topicsCoveredGraph() throws InterruptedException {
	 * 
	 * driver.findElement(graph_topicsCovered).click();
	 * 
	 * }
	 */

	/*
	 * public void graphRepresentations() throws InterruptedException {
	 * 
	 * driver.findElement(graphRepresentations).click();
	 * 
	 * }
	 */

	public void graphRepresentations() {
		CommonUtils.clickElement(graphRepresentations);
		LoggerLoad.info("Clicked Graph Representations");
	}
	
	
	/*
	 * public void graphPractice() throws InterruptedException {
	 * 
	 * driver.findElement(graphPractice).click();
	 * 
	 * }
	 */
	
	public void graphPractice() {
		CommonUtils.clickElement(graphPractice);
		LoggerLoad.info("Clicked Graph Practice Questions");
	}

	/*
	 * public void clickTryhere() throws InterruptedException {
	 * 
	 * driver.findElement(clickTryhere).click(); }
	 */
	
	public void clickTryhere() {
		CommonUtils.clickElement(clickTryhere);
		LoggerLoad.info("Clicked Try here");
	}

	/*
	 * public Boolean validateElementDisplayed(By locator) { return
	 * driver.findElement(locator).isDisplayed(); }
	 */
	
	public Boolean validateElementDisplayed(By locator) {
		return CommonUtils.isElementDisplayed(locator);
	}

	/*
	 * public String validatePageTitle() { return driver.getTitle(); }
	 */
	
	public String validatePageTitle() {
		return CommonUtils.getPageTitle();
	}

	/*
	 * public String getTextForElement(By locator) { String elementText =
	 * driver.findElement(locator).getText(); return elementText; }
	 */

	public String getTextForElement(By locator) {
		return CommonUtils.getTextForElement(locator);
	}
	
	/*
	 * public Integer getElementSize(By locator) { Integer elementCount =
	 * driver.findElements(locator).size(); return elementCount; }
	 */
	
	public Integer getElementSize(By locator) {
		return CommonUtils.getElementCount(locator);
	}
}