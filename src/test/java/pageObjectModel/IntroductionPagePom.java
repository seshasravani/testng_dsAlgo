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
            WebDriver driver = DriverManager.getDriver(); 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;  
        }
    }
}

















