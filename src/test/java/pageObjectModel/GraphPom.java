package pageObjectModel;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import utilities.ConfigReader;

public class GraphPom {
	
	   
 public WebDriver driver = DriverManager.getDriver();
	
	private By graph_getStarted = By.xpath("//a[@href='graph']");
	private By graph_topicsCovered = By.linkText("Graph");
	private By graphRepresentations = By.xpath("//a[@href='graph-representations']");
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

}