package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

		CommonUtils.clickElement(lsGetStartedBtn);
		LoggerLoad.info("Clicking the Linked List Get Started link");

	}

	public void clicklsIntroductionLink() {

		CommonUtils.clickElement(lsIntroductionLink);
		LoggerLoad.info("Clicking the LinkedList-Introduction page link");
	}

	public void clicklsCreatingLinkedLIstLink() {

		CommonUtils.clickElement(lsCreatingLinkedLIst);
		LoggerLoad.info("Clicking the LinkedList-Creating Linked LIst page link");

	}

	public void clicklsTypesOfLinkedListLink() {

		CommonUtils.clickElement(lsTypesOfLinkedList);
		LoggerLoad.info("Clicking the LinkedList-Types Of Linked List page link");

	}

	public void clicklsImplementLinkedListInPythonLink() {

		CommonUtils.clickElement(lsImplementLinkedListInPython);
		LoggerLoad.info("Clicking the LinkedList-Implement Linked List in Python page link");
	}

	public void clicklsTraversalLink() {

		CommonUtils.clickElement(lsTraversal);
		LoggerLoad.info("Clicking the LinkedList-Traversal page link");
	}

	public void clicklsInsertionLink() {

		CommonUtils.clickElement(lsInsertion);
		LoggerLoad.info("Clicking the LinkedList-Insertion page link");
	}

	public void clicklsDeletionLink() {

		CommonUtils.clickElement(lsDeletion);
		LoggerLoad.info("Clicking the LinkedList-Deletion page link");
	}

	public void clickpracticequestions() {
		WebElement practiceQns = CommonUtils.waitForElementToBeClickable(lsPracticeQns);
		practiceQns.click();
		LoggerLoad.info("Clicking the Practice Questions link");
	}
}
