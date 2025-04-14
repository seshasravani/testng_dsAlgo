package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.LoggerLoad;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

public class IntroductionPagePom {

    // Locators
    public By numpyNinja = By.cssSelector("a[href='/home']");
    public By dataStructure = By.cssSelector("a.dropdown-toggle");
	public By dsDropdown = By.cssSelector("a.dropdown-item");

    public By dropDownLinkedListItem = By.cssSelector("a.dropdown-item[href='/linked-list']");
    public By dropDownArrayItem = By.cssSelector("a.dropdown-item[href='/array']");
    public By dropDownStackItem = By.cssSelector("a.dropdown-item[href='/stack']");
    public By dropDownQueueItem = By.cssSelector("a.dropdown-item[href='/queue']");
    public By dropDownTreeItem = By.cssSelector("a.dropdown-item[href='/tree']");
    public By dropDownGraphItem = By.cssSelector("a.dropdown-item[href='/graph']");

    public By dsCardTitle = By.xpath("//h5[text()='Data Structures-Introduction']");
    public By arrayCardTitle = By.xpath("//h5[text()='Array']");
    public By linkedListCardTitle = By.xpath("//h5[text()='Linked List']");
    public By stackCardTitle = By.xpath("//h5[text()='Stack']");
    public By queueCardTitle = By.xpath("//h5[text()='Queue']");
    public By treeCardTitle = By.xpath("//h5[text()='Tree']");

    public By getStartedButtonOnCard = By.cssSelector("a.btn-primary");

    public By dsIntroductionGetStartedBtn = By.cssSelector("a[href='data-structures-introduction']");
    public By arrayGetStartedBtn = By.cssSelector("a[href='array']");
    public By linkedListGetStartedBtn = By.cssSelector("a[href='linked-list']");
    public By stackGetStartedBtn = By.cssSelector("a[href='stack']");
    public By queueGetStartedBtn = By.cssSelector("a[href='queue']");
    public By treeGetStartedBtn = By.cssSelector("a[href='tree']");
    public By graphGetStartedBtn = By.cssSelector("a[href='graph']");

    public By signInLink = By.cssSelector("a[href='/login']");
    public By registerLink = By.cssSelector("a[href='/register']");
    public By authenticationmsg = By.cssSelector("div.alert.alert-primary");

    // Dropdown Methods
    public void clickDropdownToggle() {
        LoggerLoad.info("Clicking dropdown toggle...");
        CommonUtils.scrollIntoView(dataStructure);
        CommonUtils.clickElement(dataStructure);
    }

    public void clickDropdownItemArray() {
        CommonUtils.clickElement(dropDownArrayItem);
        LoggerLoad.info("Array Dropdown selected");
    }

    public void clickDropdownItemLinkedList() {
        CommonUtils.clickElement(dropDownLinkedListItem);
        LoggerLoad.info("LinkedList Dropdown selected");
    }

    public void clickDropdownItemStack() {
        CommonUtils.clickElement(dropDownStackItem);
        LoggerLoad.info("Stack Dropdown selected");
    }

    public void clickDropdownItemQueue() {
        CommonUtils.clickElement(dropDownQueueItem);
        LoggerLoad.info("Queue Dropdown selected");
    }

    public void clickDropdownItemTree() {
        CommonUtils.clickElement(dropDownTreeItem);
        LoggerLoad.info("Tree Dropdown selected");
    }

    public void clickDropdownItemGraph() {
        CommonUtils.clickElement(dropDownGraphItem);
        LoggerLoad.info("Graph Dropdown selected");
    }

    // Get Started Buttons
    public void clickOnDataStructuresGetStartedBtn() {
        CommonUtils.clickElement(dsIntroductionGetStartedBtn);
        LoggerLoad.info("Clicked DS-Introduction Get Started button");
    }

    public void clickOnArrayGetStartedBtn() {
        CommonUtils.clickElement(arrayGetStartedBtn);
        LoggerLoad.info("Clicked Array Get Started button");
    }

    public void clickOnLinkedListGetStartedBtn() {
        CommonUtils.clickElement(linkedListGetStartedBtn);
        LoggerLoad.info("Clicked Linked List Get Started button");
    }

    public void clickOnStackGetStartedBtn() {
        CommonUtils.clickElement(stackGetStartedBtn);
        LoggerLoad.info("Clicked Stack Get Started button");
    }

    public void clickOnQueueGetStartedBtn() {
        CommonUtils.clickElement(queueGetStartedBtn);
        LoggerLoad.info("Clicked Queue Get Started button");
    }

    public void clickOnTreeGetStartedBtn() {
        CommonUtils.clickElement(treeGetStartedBtn);
        LoggerLoad.info("Clicked Tree Get Started button");
    }

    public void clickOnGraphGetStartedBtn() {
        CommonUtils.clickElement(graphGetStartedBtn);
        LoggerLoad.info("Clicked Graph Get Started button");
    }

    public void clickOnRegisterLink() {
        CommonUtils.clickElement(registerLink);
        LoggerLoad.info("Clicked Register link");
    }

    public void clickOnSignInlink() {
        CommonUtils.clickElement(signInLink);
        LoggerLoad.info("Clicked Sign In link");
    }

    // Utility Methods
    public String getTextFromCardTitle(By locator) {
        return CommonUtils.getElementText(locator);
    }

    public String getTextForElement(By locator) {
        return CommonUtils.getElementText(locator);
    }

    public boolean isElementDisplayed(By locator) {
        return CommonUtils.isElementDisplayed(locator);
    }

    public boolean isElementVisible(By locator, int timeoutInSeconds) {
        return CommonUtils.isElementVisible(locator, timeoutInSeconds);
    }

    public int getElementCount(By locator) {
        return CommonUtils.getElementCount(locator);
    }

    public String getTextForElementAtIndex(By locator, int index) {
        return CommonUtils.getTextFromElementAtIndex(locator, index);
    }

    public String getPageTitle() {
        return CommonUtils.getPageTitle();
    }
    
    public int getElementSize(By locator) {
        return CommonUtils.getElementSize(locator);
    }
  
    public Boolean validateElementDisplayed(By locator) {
        try {
            WebDriver driver = DriverManager.getDriver(); // Get the WebDriver instance from DriverManager
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for 10 seconds
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;  // Handle the exception and return false if element is not found or not visible
        }
    }
}

















/*
 * package pageObjectModel;
 * 
 * import java.time.Duration; import org.openqa.selenium.By; import
 * org.openqa.selenium.JavascriptExecutor; import
 * org.openqa.selenium.TimeoutException; import org.openqa.selenium.WebDriver;
 * import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * import utilities.CommonUtils; import utilities.LoggerLoad; import
 * driverManager.DriverManager;
 * 
 * public class IntroductionPagePom {
 * 
 * public WebDriver driver = DriverManager.getDriver();
 * 
 * // WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000));
 * // // Timeout in second
 * 
 * public By numpyNinja = By.cssSelector("a[href='/home']"); public By
 * dataStructure = By.cssSelector("a.dropdown-toggle"); public By dsDropdown =
 * By.cssSelector("a.dropdown-item");
 * 
 * public By dropDownLinkedListItem =
 * By.cssSelector("a.dropdown-item[href='/linked-list']"); public By
 * dropDownArrayItem = By.cssSelector("a.dropdown-item[href='/array']"); public
 * By dropDownStackItem = By.cssSelector("a.dropdown-item[href='/stack']");
 * public By dropDownQueueItem =
 * By.cssSelector("a.dropdown-item[href='/queue']"); public By dropDownTreeItem
 * = By.cssSelector("a.dropdown-item[href='/tree']"); public By
 * dropDownGraphItem = By.cssSelector("a.dropdown-item[href='/graph']");
 * 
 * public By cardBody = By.cssSelector("div.card-body"); public By cardTitle =
 * By.cssSelector("h5.card-title"); public By cardText =
 * By.cssSelector("p.card-text");
 * 
 * public By dsCardTitle =
 * By.xpath("//h5[text()='Data Structures-Introduction']"); public By
 * arrayCardTitle = By.xpath("//h5[text()='Array']"); public By
 * linkedListCardTitle = By.xpath("//h5[text()='Linked List']"); public By
 * stackCardTitle = By.xpath("//h5[text()='Stack']"); public By queueCardTitle =
 * By.xpath("//h5[text()='Queue']"); public By treeCardTitle =
 * By.xpath("//h5[text()='Tree']");
 * 
 * public By getStartedButtonOnCard = By.cssSelector("a.btn-primary"); public By
 * signInLink = By.cssSelector("a[href='/login']");
 * 
 * public By registerLink = By.cssSelector("a[href='/register']");
 * 
 * public By dsIntroductionGetStartedBtn =
 * By.cssSelector("a[href='data-structures-introduction']"); public By
 * arrayGetStartedBtn = By.cssSelector("a[href='array']"); public By
 * linkedListGetStartedBtn = By.cssSelector("a[href='linked-list']"); public By
 * stackGetStartedBtn = By.cssSelector("a[href='stack']"); public By
 * queueGetStartedBtn = By.cssSelector("a[href='queue']"); public By
 * treeGetStartedBtn = By.cssSelector("a[href='tree']"); public By
 * graphGetStartedBtn = By.cssSelector("a[href='graph']");
 * 
 * public By authenticationmsg = By.cssSelector("div.alert.alert-primary");
 * 
 * 
 * public void clickDropdownToggle() { WebDriverWait wait = new
 * WebDriverWait(driver, Duration.ofSeconds(20));
 * 
 * try {
 * 
 * WebElement toggle =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
 * "a.dropdown-toggle")));
 * 
 * ((JavascriptExecutor)
 * driver).executeScript("arguments[0].scrollIntoView(true);", toggle);
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(toggle));
 * 
 * toggle.click(); System.out.println("Dropdown toggle clicked successfully.");
 * 
 * } catch (TimeoutException e) { System.out.
 * println("Timeout: The dropdown toggle was not found or not clickable in the given time."
 * ); } catch (Exception e) {
 * System.out.println("An error occurred while clicking the dropdown toggle: " +
 * e.getMessage()); } }
 * 
 * 
 * public void clickDropdownToggle() { try {
 * CommonUtils.scrollIntoView(dataStructure);
 * CommonUtils.clickWhenClickable(dataStructure);
 * LoggerLoad.info("Dropdown toggle clicked successfully."); } catch (Exception
 * e) { LoggerLoad.error("Error clicking dropdown toggle: " + e.getMessage()); }
 * }
 * 
 * public void clickDropdownItemArray() {
 * driver.findElement(dropDownArrayItem).click();
 * CommonUtils.clickWhenClickable(dropDownArrayItem);
 * LoggerLoad.info("Array Dropdown selected");
 * 
 * }
 * 
 * public void clickDropdownItemLinkedList() {
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(dropDownLinkedListItem));
 * driver.findElement(dropDownLinkedListItem).click();
 * 
 * CommonUtils.clickWhenClickable(dropDownLinkedListItem);
 * LoggerLoad.info("LinkedList Dropdown selected"); }
 * 
 * public void clickDropdownItemStack() {
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(dropDownStackItem));
 * driver.findElement(dropDownStackItem).click();
 * 
 * CommonUtils.clickWhenClickable(dropDownStackItem);
 * LoggerLoad.info("Stack Dropdown selected"); }
 * 
 * public void clickDropdownItemQueue() {
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(dropDownQueueItem));
 * driver.findElement(dropDownQueueItem).click();
 * 
 * CommonUtils.clickWhenClickable(dropDownQueueItem);
 * LoggerLoad.info("Queue Dropdown selected"); }
 * 
 * public void clickDropdownItemTree() {
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(dropDownTreeItem));
 * driver.findElement(dropDownTreeItem).click();
 * 
 * CommonUtils.clickWhenClickable(dropDownTreeItem);
 * LoggerLoad.info("Tree Dropdown selected"); }
 * 
 * public void clickDropdownItemGraph() {
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(dropDownGraphItem));
 * driver.findElement(dropDownGraphItem).click();
 * 
 * CommonUtils.clickWhenClickable(dropDownGraphItem);
 * LoggerLoad.info("Graph Dropdown selected"); }
 * 
 * 
 * public Integer getElementCnt(By locator) { Integer elementCount =
 * driver.findElements(locator).size(); return elementCount; }
 * 
 * 
 * public int getElementCount(By locator) { return
 * CommonUtils.getElementCount(locator); }
 * 
 * 
 * public String getTextForArrayElements(By locator, Integer posInteger) {
 * String elementText = driver.findElements(locator).get(posInteger).getText();
 * return elementText; }
 * 
 * 
 * public String getTextForArrayElements(By locator, int index) { return
 * CommonUtils.getTextFromElementAtIndex(locator, index); }
 * 
 * 
 * public String getTextForElement(By locator) { String elementText =
 * driver.findElement(locator).getText(); return elementText; }
 * 
 * 
 * public String getTextForElement(By locator) { return
 * CommonUtils.getElementText(locator); }
 * 
 * // update this later
 * 
 * public Integer getElementSize(By locator) { Integer elementCount =
 * driver.findElements(locator).size(); return elementCount; }
 * 
 * 
 * 
 * 
 * 
 * public Boolean validateElementDisplayed(By locator) { try { WebDriverWait
 * wait = new WebDriverWait(driver, Duration.ofSeconds(10)); WebElement element
 * = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)); return
 * element.isDisplayed(); } catch (Exception e) { return false; } }
 * 
 * 
 * public boolean validateElementDisplayed(By locator) { return
 * CommonUtils.isElementVisible(locator, 10); }
 * 
 * public void clickOnDataStructuresGetStartedBtn() {
 * driver.findElement(dsIntroductionGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(dsIntroductionGetStartedBtn);
 * LoggerLoad.info("Clicking the DS-Introduction Get Started link"); }
 * 
 * public void clickOnArrayGetStartedBtn() {
 * driver.findElement(arrayGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(arrayGetStartedBtn);
 * LoggerLoad.info("Clicking the Array Get Started link"); }
 * 
 * public void clickOnLinkedListGetStartedBtn() {
 * driver.findElement(linkedListGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(linkedListGetStartedBtn);
 * LoggerLoad.info("Clicking the Linked List Get Started link"); }
 * 
 * public void clickOnStackGetStartedBtn() {
 * driver.findElement(stackGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(stackGetStartedBtn);
 * LoggerLoad.info("Clicking the Stack Get Started link"); }
 * 
 * public void clickOnQueueGetStartedBtn() {
 * driver.findElement(queueGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(queueGetStartedBtn);
 * LoggerLoad.info("Clicking the Queue Get Started link"); }
 * 
 * public void clickOnTreeGetStartedBtn() {
 * driver.findElement(treeGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(treeGetStartedBtn);
 * LoggerLoad.info("Clicking the Tree Get Started link"); }
 * 
 * public void clickOnGraphGetStartedBtn() {
 * driver.findElement(graphGetStartedBtn).click();
 * CommonUtils.clickWhenClickable(graphGetStartedBtn);
 * LoggerLoad.info("Clicking the Graph Get Started link"); }
 * 
 * public void clickOnRegisterlink() { driver.findElement(registerLink).click();
 * CommonUtils.clickWhenClickable(registerLink);
 * LoggerLoad.info("Clicking the Register link"); }
 * 
 * 
 * public void clickOnSignInlink() {
 * 
 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
 * WebElement signInLink =
 * wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
 * "a[href='/login']"))); signInLink.click(); }
 * 
 * 
 * public void clickOnSignInLink() { CommonUtils.clickWhenClickable(signInLink);
 * LoggerLoad.info("Clicking the Sign In link"); }
 * 
 * 
 * public String getPageTitle() { String elementText = driver.getTitle(); return
 * elementText; }
 * 
 * 
 * public String getPageTitle() { return driver.getTitle(); }
 * 
 * }
 */