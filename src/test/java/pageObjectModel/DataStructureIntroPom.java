package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class DataStructureIntroPom {

	WebDriver driver = DriverManager.getDriver();
	ExcelReader excelReader = new ExcelReader();

	public By dsGetStartedBtn = By
			.xpath("//a[contains(text(), 'Get Started') and contains(@href, 'data-structures-introduction')]");
	public By timeComplexityLink = By.xpath("//a[contains(@href, 'time-complexity')]");
	public By practiceQuestionsLink = By.xpath("//a[contains(text(),'Practice Questions')]");
	public By dsPageTitle = By.xpath("//h4[text()='Data Structures-Introduction']");

	public void clickGetStartedBtn() {
		driver.findElement(dsGetStartedBtn).click();
		LoggerLoad.info("DS Get Started Button Clicked");

	}

	public void clickTimeComplexityLink() {
		driver.findElement(timeComplexityLink).click();

	}

	public void clickPracticeQuestionsLink() {
		driver.findElement(practiceQuestionsLink).click();
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
