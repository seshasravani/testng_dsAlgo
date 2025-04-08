package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;

public class GraphPom {

	public WebDriver driver = DriverManager.getDriver();
	public By graphTitle = By.xpath("//h4[text()='Graph']");
	private By graph_getStarted = By.xpath("//a[@href='graph']");
	public By graph_topicsCovered = By.linkText("Graph");
	public By graphRepresentations = By.linkText("Graph Representations");
	private By graphPractice = By.xpath("//a[@href='/graph/practice']");
	private By clickTryhere = By.linkText("Try here>>>");

	public void getStartedGraph() throws InterruptedException {

		System.out.println("trying to get into Graph page");

		driver.findElement(graph_getStarted).click();

	}

	public void topicsCoveredGraph() throws InterruptedException {

		driver.findElement(graph_topicsCovered).click();

	}

	public void graphRepresentations() throws InterruptedException {

		driver.findElement(graphRepresentations).click();

	}

	public void graphPractice() throws InterruptedException {

		driver.findElement(graphPractice).click();

	}

	public void clickTryhere() throws InterruptedException {

		driver.findElement(clickTryhere).click();
	}

	public Boolean validateElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public String validatePageTitle() {
		return driver.getTitle();
	}

	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

	public Integer getElementSize(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}
}