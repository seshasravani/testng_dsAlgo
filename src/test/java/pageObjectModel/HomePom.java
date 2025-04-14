package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.LoggerLoad;

public class HomePom {

	// Locators
	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	public By contentText = By.cssSelector("div.content p");
	public By signOutLink = By.xpath("//a[@href='/logout']");

	// Click Actions
	public void ClickHomePageGetStartedButton() {
		LoggerLoad.info("Clicking Home Page Get Started button");
		CommonUtils.clickElement(getStartedButton);
	}

	public void clickSignOutLink() {
		LoggerLoad.info("Clicking Sign Out link");
		CommonUtils.clickElement(signOutLink);
	}

	// Get Text
	public String getTextForElement(By locator) {
		return CommonUtils.getTextForElement(locator);
	}

	// Wait for Clickable
	public WebElement linkClickable(By locator) {
		return CommonUtils.waitForElementToBeClickable(locator);
	}
}






/*
 * package pageObjectModel;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import driverManager.DriverManager; import
 * utilities.CommonUtils; import utilities.LoggerLoad;
 * 
 * public class HomePom {
 * 
 * public WebDriver driver = DriverManager.getDriver();
 * 
 * //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 * 
 * public By getStartedButton = By.cssSelector("button.btn"); public By
 * contentHeader = By.cssSelector(".content h1"); public By contentText =
 * By.cssSelector("div.content p"); public By signOutLink =
 * By.xpath("//a[@href='/logout']");
 * 
 * public void ClickHomePageGetStartedButton() {
 * 
 * System.out.println("Before ClickHomePageGetStartedButton");
 * driver.findElement(getStartedButton).click();
 * 
 * 
 * LoggerLoad.info("Clicking Home Page Get Started button");
 * CommonUtils.clickElement(getStartedButton); }
 * 
 * 
 * public WebElement linkClickable(By locator) { return
 * wait.until(ExpectedConditions.elementToBeClickable(locator));
 * 
 * }
 * 
 * 
 * public WebElement linkClickable(By locator) { return
 * CommonUtils.waitForElementToBeClickable(locator); }
 * 
 * 
 * public String getTextForElement(By locator) { String elementText =
 * driver.findElement(locator).getText(); return elementText; }
 * 
 * 
 * public String getTextForElement(By locator) { return
 * CommonUtils.getTextForElement(locator); }
 * 
 * 
 * public void clickSignOutLink() { driver.findElement(signOutLink).click(); }
 * 
 * 
 * public void clickSignOutLink() { LoggerLoad.info("Clicking Sign Out link");
 * CommonUtils.clickElement(signOutLink); }
 * 
 * }
 */