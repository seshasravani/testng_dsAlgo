package pageObjectModel;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.LoggerLoad;
import driverManager.DriverManager;

public class IntroductionPagePom {
	
	public WebDriver driver = DriverManager.getDriver();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(50000)); // Timeout in second

	public By numpyNinja = By.cssSelector("a[href='/home']");
	public By dataStructure = By.cssSelector("a.dropdown-toggle");
	public By dsDropdown = By.cssSelector("a.dropdown-item");

	public By dropDownLinkedListItem = By.cssSelector("a.dropdown-item[href='/linked-list']");
	public By dropDownArrayItem = By.cssSelector("a.dropdown-item[href='/array']");
	public By dropDownStackItem = By.cssSelector("a.dropdown-item[href='/stack']");
	public By dropDownQueueItem = By.cssSelector("a.dropdown-item[href='/queue']");
	public By dropDownTreeItem = By.cssSelector("a.dropdown-item[href='/tree']");
	public By dropDownGraphItem = By.cssSelector("a.dropdown-item[href='/graph']");

	public By cardBody = By.cssSelector("div.card-body");
	public By cardTitle = By.cssSelector("h5.card-title");
	public By cardText = By.cssSelector("p.card-text");
	
	public By dsCardTitle = By.xpath("//h5[text()='Data Structures-Introduction']");
	public By arrayCardTitle = By.xpath("//h5[text()='Array']");
	public By linkedListCardTitle = By.xpath("//h5[text()='Linked List']");
	public By stackCardTitle = By.xpath("//h5[text()='Stack']");
	public By queueCardTitle = By.xpath("//h5[text()='Queue']");
	public By treeCardTitle = By.xpath("//h5[text()='Tree']");


	public By getStartedButtonOnCard = By.cssSelector("a.btn-primary");
	public By signInLink = By.cssSelector("a[href='/login']");
	
	public By registerLink = By.cssSelector("a[href='/register']");

	public By dsIntroductionGetStartedBtn = By.cssSelector("a[href='data-structures-introduction']");
	public By arrayGetStartedBtn = By.cssSelector("a[href='array']");
	public By linkedListGetStartedBtn = By.cssSelector("a[href='linked-list']");
	public By stackGetStartedBtn = By.cssSelector("a[href='stack']");
	public By queueGetStartedBtn = By.cssSelector("a[href='queue']");
	public By treeGetStartedBtn = By.cssSelector("a[href='tree']");
	public By graphGetStartedBtn = By.cssSelector("a[href='graph']");

	public By authenticationmsg = By.cssSelector("div.alert.alert-primary");
	
	public void clickDropdownToggle() {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    try {
	       
	        WebElement toggle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.dropdown-toggle")));

	          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toggle);

	         wait.until(ExpectedConditions.elementToBeClickable(toggle));

	        toggle.click();
	        System.out.println("Dropdown toggle clicked successfully.");
	        
	    } catch (TimeoutException e) {
	        System.out.println("Timeout: The dropdown toggle was not found or not clickable in the given time.");
	    } catch (Exception e) {
	        System.out.println("An error occurred while clicking the dropdown toggle: " + e.getMessage());
	    }
	}
	
	public void clickDropdownItemArray() {
		driver.findElement(dropDownArrayItem).click();
		LoggerLoad.info("Array Dropdown selected");
		
	}
	
	public void clickDropdownItemLinkedList() {
			wait.until(ExpectedConditions.elementToBeClickable(dropDownLinkedListItem));
			driver.findElement(dropDownLinkedListItem).click();
			LoggerLoad.info("LinkedList Dropdown selected");
		}

	public void clickDropdownItemStack() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownStackItem));
		driver.findElement(dropDownStackItem).click();
		LoggerLoad.info("Stack Dropdown selected");
	}
	
	public void clickDropdownItemQueue() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownQueueItem));
		driver.findElement(dropDownQueueItem).click();
		LoggerLoad.info("Queue Dropdown selected");
	}

	public void clickDropdownItemTree() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownTreeItem));
		driver.findElement(dropDownTreeItem).click();
		LoggerLoad.info("Tree Dropdown selected");
	}

	public void clickDropdownItemGraph() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownGraphItem));
		driver.findElement(dropDownGraphItem).click();
		LoggerLoad.info("Graph Dropdown selected");
	}

	public Integer getElementCnt(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}

	public String getTextForArrayElements(By locator, Integer posInteger) {
		String elementText = driver.findElements(locator).get(posInteger).getText();
		return elementText;
	}

	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

	public Integer getElementSize(By locator) {
		Integer elementCount = driver.findElements(locator).size();
		return elementCount;
	}
	
	public Boolean validateElementDisplayed(By locator) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public void clickOnDataStructuresGetStartedBtn() {
		driver.findElement(dsIntroductionGetStartedBtn).click();
		LoggerLoad.info("Clicking the DS-Introduction Get Started link");
	}

	public void clickOnArrayGetStartedBtn() {
		driver.findElement(arrayGetStartedBtn).click();
		LoggerLoad.info("Clicking the Array Get Started link");
	}


	public void clickOnLinkedListGetStartedBtn() {
		driver.findElement(linkedListGetStartedBtn).click();
		LoggerLoad.info("Clicking the Linked List Get Started link");
	}

	public void clickOnStackGetStartedBtn() {
		driver.findElement(stackGetStartedBtn).click();
		LoggerLoad.info("Clicking the Stack Get Started link");
	}

	public void clickOnQueueGetStartedBtn() {
		driver.findElement(queueGetStartedBtn).click();
		LoggerLoad.info("Clicking the Queue Get Started link");
	}

	public void clickOnTreeGetStartedBtn() {
		driver.findElement(treeGetStartedBtn).click();
		LoggerLoad.info("Clicking the Tree Get Started link");
	}

	public void clickOnGraphGetStartedBtn() {
		driver.findElement(graphGetStartedBtn).click();
		LoggerLoad.info("Clicking the Graph Get Started link");
	}

	public void clickOnRegisterlink() {
		driver.findElement(registerLink).click();
	}

	public void clickOnSignInlink() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/login']")));
		signInLink.click();
	}


	public String getPageTitle() {
		String elementText = driver.getTitle();
		return elementText;
	}


}