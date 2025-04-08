package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import driverManager.DriverManager;
import utilities.ExcelReader;

public class StackPom {
	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();
	
	public By stackTitle = By.xpath("//h4[text()='Stack']");
private	By Stack_getStarted = By.xpath("//a[@href='stack']");
	
public By OperationsinStack = By.linkText("Operations in Stack");
private	 By clickTryhere = By.linkText("Try here>>>");

public		By StackRepresent = By.linkText("Implementation");
public		By StackApplications = By.linkText("Applications");
public		By StackPractice =  By.linkText("Practice Questions");



public void getStartedStack() throws InterruptedException {
	
	System.out.println("trying to get into Stack page");
	
	driver.findElement(Stack_getStarted).click();

}

public void operationsinStack() throws InterruptedException {
	
	
	
	driver.findElement(OperationsinStack).click();

}
public void clickTryhere() throws InterruptedException {
	
	
	
	driver.findElement(clickTryhere).click();
}

public void StackRepresent() throws InterruptedException {
	
	
	
	driver.findElement(StackRepresent).click();

}
public void StackApplications() throws InterruptedException {
	
	
	
	driver.findElement(StackApplications).click();

}



public void StackPractice() throws InterruptedException {
	
	
	
	driver.findElement(StackPractice).click();

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
