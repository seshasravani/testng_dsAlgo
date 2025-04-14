package pageObjectModel;

import org.openqa.selenium.By;
import utilities.CommonUtils;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class QueuePom {
	
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
	/*
	 * LoggerLoad.info("trying to get into Queue page");
	 * driver.findElement(Queue_getStarted).click();
	 */
	
	LoggerLoad.info("Trying to get into Queue page");
	CommonUtils.clickElement(Queue_getStarted);

}

/*
 * public void operationsinQueue() throws InterruptedException {
 * driver.findElement(OperationsinQueue).click();
 * 
 * }
 */

public void operationsinQueue() {
	CommonUtils.clickElement(OperationsinQueue);
}

/*
 * public void queueRepresent() throws InterruptedException {
 * driver.findElement(QueueRepresent).click(); }
 */

public void queueRepresent() {
	CommonUtils.clickElement(QueueRepresent);
}

public void queueArray() {
	CommonUtils.clickElement(QueueArray);
}

/*
 * public void queueArray() throws InterruptedException {
 * driver.findElement(QueueArray).click(); }
 */
/*
 * public void queueOperations() throws InterruptedException {
 * driver.findElement(QueueOperations).click(); }
 */

public void queueOperations() {
	CommonUtils.clickElement(QueueOperations);
}

/*
 * public void QueuePractice() throws InterruptedException {
 * driver.findElement(QueuePractice).click(); }
 */

public void QueuePractice() {
	CommonUtils.clickElement(QueuePractice);
}

public void clickTryhere() {
	CommonUtils.clickElement(clickTryhere);
}
/*
 * public void clickTryhere() throws InterruptedException {
 * 
 * driver.findElement(clickTryhere).click(); }
 */


public Boolean validateElementDisplayed(By locator) {
	return CommonUtils.isElementDisplayed(locator);
}
/*
 * public Boolean validateElementDisplayed(By locator) { return
 * driver.findElement(locator).isDisplayed(); }
 */

/*
 * public String validatePageTitle() { return driver.getTitle(); }
 */

public String validatePageTitle() {
	return CommonUtils.getPageTitle();
}

public String getTextForElement(By locator) {
	return CommonUtils.getTextForElement(locator);
}

/*
 * public String getTextForElement(By locator) { String elementText =
 * driver.findElement(locator).getText(); return elementText; }
 */
/*
 * public Integer getElementSize(By locator) { Integer elementCount =
 * driver.findElements(locator).size(); return elementCount; }
 */
 
 public Integer getElementSize(By locator) {
		return CommonUtils.getElementCount(locator);
	}
 
}