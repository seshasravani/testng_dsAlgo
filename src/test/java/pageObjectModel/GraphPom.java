package pageObjectModel;

import org.openqa.selenium.By;
import utilities.CommonUtils;
import utilities.LoggerLoad;

public class GraphPom {

	public By graphTitle = By.xpath("//h4[text()='Graph']");
	private By graph_getStarted = By.xpath("//a[@href='graph']");
	public By graph_topicsCovered = By.linkText("Graph");
	public By graphRepresentations = By.linkText("Graph Representations");
	private By graphPractice = By.xpath("//a[@href='/graph/practice']");
	private By clickTryhere = By.linkText("Try here>>>");

	
	public void getStartedGraph() {
		CommonUtils.clickElement(graph_getStarted);
		LoggerLoad.info("Clicked Get Started for Graph");
	}
	
	public void topicsCoveredGraph() {
		CommonUtils.clickElement(graph_topicsCovered);
		LoggerLoad.info("Clicked Graph Topics Covered");
	}


	public void graphRepresentations() {
		CommonUtils.clickElement(graphRepresentations);
		LoggerLoad.info("Clicked Graph Representations");
	}
	
	
	
	public void graphPractice() {
		CommonUtils.clickElement(graphPractice);
		LoggerLoad.info("Clicked Graph Practice Questions");
	}

	
	public void clickTryhere() {
		CommonUtils.clickElement(clickTryhere);
		LoggerLoad.info("Clicked Try here");
	}


	
	public Boolean validateElementDisplayed(By locator) {
		return CommonUtils.isElementDisplayed(locator);
	}

	
	
	public String validatePageTitle() {
		return CommonUtils.getPageTitle();
	}

	public String getTextForElement(By locator) {
		return CommonUtils.getTextForElement(locator);
	}
	
	
	
	public Integer getElementSize(By locator) {
		return CommonUtils.getElementCount(locator);
	}
}