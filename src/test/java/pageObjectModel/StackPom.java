package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.ExcelReader;
import utilities.LoggerLoad;

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


/*
 * public void getStartedStack() throws InterruptedException {
 * 
 * System.out.println("trying to get into Stack page");
 * 
 * driver.findElement(Stack_getStarted).click();
 * 
 * }
 */

public void getStartedStack() {
    LoggerLoad.info("Attempting to navigate to the Stack page");
    try {
        CommonUtils.clickElement(Stack_getStarted);
        LoggerLoad.info("Successfully navigated to the Stack page");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Get Started' link for Stack: " + e.getMessage());
    }
}

public void operationsinStack() {
    LoggerLoad.info("Attempting to click on 'Operations in Stack'");
    try {
        CommonUtils.clickElement(OperationsinStack);
        LoggerLoad.info("Successfully clicked on 'Operations in Stack'");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Operations in Stack' link: " + e.getMessage());
    }
}

/*
 * public void operationsinStack() throws InterruptedException {
 *  * driver.findElement(OperationsinStack).click();
 * * }
 */
/*
 * public void clickTryhere() throws InterruptedException {
 * 
 * driver.findElement(clickTryhere).click(); }
 */

public void clickTryhere() {
    LoggerLoad.info("Attempting to click on 'Try here>>>'");
    try {
        CommonUtils.clickElement(clickTryhere);
        LoggerLoad.info("Successfully clicked on 'Try here>>>'");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Try here>>>' link: " + e.getMessage());
    }
}

/*
 * public void StackRepresent() throws InterruptedException {
 * 
 * driver.findElement(StackRepresent).click();
 * 
 * }
 */
public void StackRepresent() {
    LoggerLoad.info("Attempting to click on 'Implementation' for Stack");
    try {
        CommonUtils.clickElement(StackRepresent);
        LoggerLoad.info("Successfully clicked on 'Implementation' for Stack");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Implementation' link for Stack: " + e.getMessage());
    }
}
/*
 * public void StackApplications() throws InterruptedException {
 * 
 * driver.findElement(StackApplications).click(); }
 */

public void StackApplications() {
    LoggerLoad.info("Attempting to click on 'Applications' for Stack");
    try {
        CommonUtils.clickElement(StackApplications);
        LoggerLoad.info("Successfully clicked on 'Applications' for Stack");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Applications' link for Stack: " + e.getMessage());
    }
}



/*
 * public void StackPractice() throws InterruptedException {
 * 
 * driver.findElement(StackPractice).click();
 * 
 * }
 */
public void StackPractice() {
    LoggerLoad.info("Attempting to click on 'Practice Questions' for Stack");
    try {
        CommonUtils.clickElement(StackPractice);
        LoggerLoad.info("Successfully clicked on 'Practice Questions' for Stack");
    } catch (Exception e) {
        LoggerLoad.error("Failed to click on 'Practice Questions' link for Stack: " + e.getMessage());
    }
}
/*
 * public Boolean validateElementDisplayed(By locator) { return
 * driver.findElement(locator).isDisplayed(); }
 */

public Boolean validateElementDisplayed(By locator) {
    LoggerLoad.info("Validating if element is displayed: " + locator.toString());
    try {
        Boolean isDisplayed = CommonUtils.isElementDisplayed(locator);
        LoggerLoad.info("Element displayed validation result for " + locator.toString() + ": " + isDisplayed);
        return isDisplayed;
    } catch (Exception e) {
        LoggerLoad.error("Error validating element visibility for " + locator.toString() + ": " + e.getMessage());
        return false;
    }
}

public String validatePageTitle() {
    LoggerLoad.info("Validating page title");
    try {
        String pageTitle = CommonUtils.getPageTitle();
        LoggerLoad.info("Page title validated: " + pageTitle);
        return pageTitle;
    } catch (Exception e) {
        LoggerLoad.error("Error validating page title: " + e.getMessage());
        return null;
    }
}


/*
 * public String validatePageTitle() { return driver.getTitle(); }
 */

/*
 * public String getTextForElement(By locator) { String elementText =
 * driver.findElement(locator).getText(); return elementText; }
 */

public String getTextForElement(By locator) {
    LoggerLoad.info("Getting text for element: " + locator.toString());
    try {
        String text = CommonUtils.getTextForElement(locator);
        LoggerLoad.info("Text for element " + locator.toString() + ": " + text);
        return text;
    } catch (Exception e) {
        LoggerLoad.error("Error getting text for element " + locator.toString() + ": " + e.getMessage());
        return null;
    }
}
/*
 * public Integer getElementSize(By locator) { Integer elementCount =
 * driver.findElements(locator).size(); return elementCount; }
 */

public Integer getElementSize(By locator) {
    LoggerLoad.info("Getting element count for locator: " + locator.toString());
    try {
        Integer count = CommonUtils.getElementCount(locator);
        LoggerLoad.info("Element count for locator " + locator.toString() + ": " + count);
        return count;
    } catch (Exception e) {
        LoggerLoad.error("Error getting element count for locator " + locator.toString() + ": " + e.getMessage());
        return 0;
    }
}
}

