package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.LoggerLoad;

public class TryEditorPage {

	private WebDriver driver = DriverManager.getDriver();


	private final By codeEditorPage = By.xpath("//*[@id='answer_form']/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre");
	private final By runButton = By.xpath("//button[text()='Run']");
	private final By tryEditorOutput = By.xpath("//pre[@id='output']");

	private String actualResult;
	
	 public void enterCode(String code) throws InterruptedException {
	        LoggerLoad.info("Entering code into the editor.");
	        try {
	            WebElement codeEditor = driver.findElement(codeEditorPage);
	            Actions action = new Actions(driver);

	            
	            action.moveToElement(codeEditor).click()
	                  .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
	                  .sendKeys(Keys.BACK_SPACE).perform();
	            
	          
	            action.sendKeys(code).perform();
	            LoggerLoad.info("Code entered successfully.");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to enter code: " + e.getMessage());
	        }
	    }
	 
	 public void clickRunButton() {
	        LoggerLoad.info("Attempting to click the 'Run' button.");
	        try {
	            CommonUtils.clickElement(runButton);  
	            LoggerLoad.info("Clicked the 'Run' button.");
	            isAlertPresent(); 
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click the 'Run' button: " + e.getMessage());
	        }
	    }

	 public String isAlertPresent() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            LoggerLoad.info("Alert text: " + alertText);
	            alert.accept();
	            return alertText;
	        } catch (NoAlertPresentException e) {
	            LoggerLoad.info("No alert present.");
	            return null;
	        }
	    }

	    public String output() {
	        LoggerLoad.info("Attempting to retrieve output.");
	        try {
	          
	            Alert alert = driver.switchTo().alert();
	            actualResult = alert.getText();
	            LoggerLoad.info("Alert message of invalid code: " + actualResult);
	            alert.accept();
	        } catch (NoAlertPresentException e) {
	            
	            WebElement outputElement = driver.findElement(tryEditorOutput);
	            actualResult = outputElement.getText();
	            LoggerLoad.info("Actual result of valid code: " + actualResult);
	        }
	        return actualResult;
	    }

	    public void enteringCode(String code) {
	        LoggerLoad.info("Entering code using 'enteringCode' method.");
	        try {
	            WebElement codeMirror = driver.findElement(By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));
	            Actions actions = new Actions(driver);
	            actions.moveToElement(codeMirror).click().perform();

	            WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
	            textArea.sendKeys(Keys.CONTROL + "a");
	            textArea.sendKeys(Keys.DELETE);
	            textArea.sendKeys(code);
	            LoggerLoad.info("Code entered successfully.");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to enter code in the editor: " + e.getMessage());
	        }
	    }
	}