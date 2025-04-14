package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.CommonUtils;

public class ScrollAndClick {
	
	WebDriver driver;

    public ScrollAndClick(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public void clickTimeComplexityLink() {
    	 CommonUtils.scrollIntoView(By.linkText("Time Complexity"));
    	 CommonUtils.clickElementWithWait(By.linkText("Time Complexity"), Duration.ofSeconds(10));
          

    }

    
}