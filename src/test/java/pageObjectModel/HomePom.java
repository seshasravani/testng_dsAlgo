package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonUtils;
import utilities.LoggerLoad;

public class HomePom {

	
	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	public By contentText = By.cssSelector("div.content p");
	public By signOutLink = By.xpath("//a[@href='/logout']");

	
	public void ClickHomePageGetStartedButton() {
		LoggerLoad.info("Clicking Home Page Get Started button");
		CommonUtils.clickElement(getStartedButton);
	}

	public void clickSignOutLink() {
		LoggerLoad.info("Clicking Sign Out link");
		CommonUtils.clickElement(signOutLink);
	}

	public String getTextForElement(By locator) {
		return CommonUtils.getTextForElement(locator);
	}

	
	public WebElement linkClickable(By locator) {
		return CommonUtils.waitForElementToBeClickable(locator);
	}
}





