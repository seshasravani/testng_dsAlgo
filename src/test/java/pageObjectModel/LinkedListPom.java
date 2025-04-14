package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class LinkedListPom {
	
	ExcelReader excelReader = new ExcelReader();
		
	public By lsGetStartedBtn = By.cssSelector("a[href='linked-list']");
	public By lsIntroductionLink = By.xpath("//a[@href='introduction']");
	public By lsCreatingLinkedLIst = By.xpath("//a[@href='creating-linked-list']");
	public By lsTypesOfLinkedList = By.xpath("//a[@href='types-of-linked-list']");
	public By lsImplementLinkedListInPython = By.xpath("//a[@href='implement-linked-list-in-python']");
	public By lsTraversal = By.xpath("//a[@href='traversal']");
	public By lsInsertion = By.xpath("//a[@href='insertion-in-linked-list']");
	public By lsDeletion = By.xpath("//a[@href='deletion-in-linked-list']");
	public By lsPracticeQns = By.linkText("Practice Questions");

	public void clicklsGetStartedBtn() {
		//driver.findElement(lsGetStartedBtn).click();
		CommonUtils.clickElement(lsGetStartedBtn);
		LoggerLoad.info("Clicking the Linked List Get Started link");
		
	}

	public void clicklsIntroductionLink() {
		//driver.findElement(lsIntroductionLink).click();
		CommonUtils.clickElement(lsIntroductionLink);
		LoggerLoad.info("Clicking the LinkedList-Introduction page link");
	}

	 public void clicklsCreatingLinkedLIstLink() {
	    //driver.findElement(lsCreatingLinkedLIst).click();
	    CommonUtils.clickElement(lsCreatingLinkedLIst); 
	    LoggerLoad.info("Clicking the LinkedList-Creating Linked LIst page link");
			
		}
	 
	 public void clicklsTypesOfLinkedListLink() {
	   	//driver.findElement(lsTypesOfLinkedList).click();
	    CommonUtils.clickElement(lsTypesOfLinkedList);
	    LoggerLoad.info("Clicking the LinkedList-Types Of Linked List page link");
			
		}
	 
	 public void clicklsImplementLinkedListInPythonLink() {
		//driver.findElement(lsImplementLinkedListInPython).click();
		CommonUtils.clickElement(lsImplementLinkedListInPython);
	    LoggerLoad.info("Clicking the LinkedList-Implement Linked List in Python page link");
	 }
	 
	 public void clicklsTraversalLink() {
			/* driver.findElement(lsTraversal).click(); */
        CommonUtils.clickElement(lsTraversal);
	    LoggerLoad.info("Clicking the LinkedList-Traversal page link");
	 }
	 
	 public void clicklsInsertionLink() {
			/* driver.findElement(lsInsertion).click(); */
		CommonUtils.clickElement(lsInsertion); 
	    LoggerLoad.info("Clicking the LinkedList-Insertion page link");
	 }
	 
	 public void clicklsDeletionLink() {
			/* driver.findElement(lsDeletion).click(); */
	    CommonUtils.clickElement(lsDeletion);		 
	    LoggerLoad.info("Clicking the LinkedList-Deletion page link");
	 }
	 
		/*
		 * public void clickpracticequestions() { WebDriverWait wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(10)); WebElement practiceQns =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.
		 * linkText("Practice Questions"))); practiceQns.click(); }
		 */
	 
	 public void clickpracticequestions() {
	        WebElement practiceQns = CommonUtils.waitForElementToBeClickable(lsPracticeQns);
	        practiceQns.click();
	        LoggerLoad.info("Clicking the Practice Questions link");
	    }
}
