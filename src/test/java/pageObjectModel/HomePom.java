package pageObjectModel;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;
import utilities.ConfigReader;

public class HomePom {
	

	public WebDriver driver = DriverManager.getDriver();
    
	// Create a WebDriverWait instance with Duration

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in second

	public By getStartedButton = By.cssSelector("button.btn");
	public By contentHeader = By.cssSelector(".content h1");
	
	public By contentText = By.cssSelector("div.content p");
	public By signOutLink = By.xpath("//a[@href='/logout']");

	public void openURL() {
		System.out.println("Inside openURL-->" + driver);
		driver.get(ConfigReader.getUrl());
		System.out.println("2Inside openURL-->" + driver);

	}

	// Open Time Complexity url


	public void ClickHomePageGetStartedButton() {
		System.out.println("Before ClickHomePageGetStartedButton");
		driver.findElement(getStartedButton).click();
	}

	public WebElement linkClickable(By locator) {
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));

	}


//    public void openHomeURL() {
//    	System.out.println("Inside openURL");
//    	driver.get(ConfigReader.getUrlHome());
//    		
//    }
    
      
 	public String getTextForElement(By locator) {
		String elementText = driver.findElement(locator).getText();
		return elementText;
	}

    
	
	public void clickSignOutLink() {
		driver.findElement(signOutLink).click();
	}

}

	




