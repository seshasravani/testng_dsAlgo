package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class QueuePom {
	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
private By Queue_getStarted = By.xpath("//a[@href='queue']");
public	By OperationsinQueue = By.linkText("Implementation of Queue in Python");
public	By QueueRepresent = By.linkText("Implementation using collections.deque");
public	By QueueArray = By.linkText("Implementation using array");
public	By QueueOperations=  By.linkText("Queue Operations");
public	By QueuePractice =  By.linkText("Practice Questions");
private By clickTryhere = By.linkText("Try here>>>");
public By queueTitle = By.xpath("//h4[text()='Queue']");

public void getStartedQueue() throws InterruptedException {
	LoggerLoad.info("trying to get into Queue page");
	
	driver.findElement(Queue_getStarted).click();

}

public void operationsinQueue() throws InterruptedException {
	
	
	
	driver.findElement(OperationsinQueue).click();

}

public void queueRepresent() throws InterruptedException {
	
	
	
	driver.findElement(QueueRepresent).click();

}

public void queueArray() throws InterruptedException {
	
	
	
	driver.findElement(QueueArray).click();

}

public void queueOperations() throws InterruptedException {
	
	
	
	driver.findElement(QueueOperations).click();

}

public void QueuePractice() throws InterruptedException {
	
	
	
	driver.findElement(QueuePractice).click();

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