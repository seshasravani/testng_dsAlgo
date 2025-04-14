package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class DataStructureIntroPom {

	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();

	public By dsGetStartedBtn = By.xpath("//a[contains(text(), 'Get Started') and contains(@href, 'data-structures-introduction')]");
	public By timeComplexityLink = By.xpath("//a[contains(@href, 'time-complexity')]");
	public By practiceQuestionsLink = By.xpath("//a[contains(text(),'Practice Questions')]");
	public By dsPageTitle = By.xpath("//h4[text()='Data Structures-Introduction']");

	public void clickGetStartedBtn() {
		
		CommonUtils.clickElement(dsGetStartedBtn);
		LoggerLoad.info("DS Get Started Button Clicked");

	}

	public void clickTimeComplexityLink() {
		
		CommonUtils.clickElement(timeComplexityLink);
		LoggerLoad.info("Time Complexity link clicked");

	}

	public void clickPracticeQuestionsLink() {
		
		CommonUtils.clickElement(practiceQuestionsLink);
		LoggerLoad.info("Practice Questions link clicked");
	}

	public Boolean validateElementDisplayed(By locator) {
		
		return CommonUtils.isElementDisplayed(locator);
	}

	public String validatePageTitle() {
		
		return CommonUtils.getPageTitle();
	}

	public String getTextForElement(By locator) {
		
		return CommonUtils.getTextForElement(locator);
	}
	
	public Integer getElementSize(By locator) {
	    return CommonUtils.getElementCount(locator);
	}	



}
