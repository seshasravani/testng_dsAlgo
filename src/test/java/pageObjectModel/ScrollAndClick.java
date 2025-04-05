package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollAndClick {
	
	WebDriver driver;

    public ScrollAndClick(WebDriver driver) {
        this.driver = driver;
    }
    
    //Data Structures-Introduction Page - Time Complexity Topic
    public void clickTimeComplexityLink() {
       
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timeComplexityLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Time Complexity")));
        
        js.executeScript("arguments[0].scrollIntoView(true);", timeComplexityLink);
        
        timeComplexityLink.click();
          

    }
    
    
    
}