package pageObjectModel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import driverManager.DriverManager;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class TryEditorDsPom {
	
	WebDriver driver = DriverManager.getDriver(); 
	ExcelReader excelReader = new ExcelReader();

	public By tryHereButton = By.xpath("//a[@href='/tryEditor']");
	public By textAreaForCode = By.xpath("//textarea[@tabindex='0']");
	public By runButton = By.xpath("//button[text()='Run']");
	public By consoleOutputMsg = By.xpath("//pre[@id='output']");
	public void clickTryHereBtn() {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(tryHereButton)).click().perform();
		LoggerLoad.info("Clicked the Try Here button.");
	}
	
//	public void enterTryHereCode(String pCode) {
//	    LoggerLoad.info("Entering Code: " + pCode);
//
//	   // textAreaForCode.clear(); // Clears any previous code
//	   // textAreaForCode.sendKeys(pCode);
//	}
	
	public void enterTryHereCode(String sheetName, int row)
			throws InvalidFormatException, IOException, OpenXML4JException {
		LoggerLoad.info("Reading code from Excel sheet: " + sheetName + ", Row: " + row);
		List<Map<String, String>> testData = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx",
				sheetName);

		System.out.println("testData--->" + testData.size()+"-->"+testData);
		String pCode = "";
		if (row <= testData.size()) {
			System.out.println("Inside if loop---->");
			System.out.println("row--->" + row);
			pCode = testData.get(row).get("pCode");
			System.out.println("pCode-->" + pCode);
		} else {
			LoggerLoad.error("Specified row " + row + " is out of bounds for the Excel sheet.");
			throw new IllegalArgumentException("Row index out of bounds.");
		}
		if (pCode != null && !pCode.isEmpty()) {
			LoggerLoad.info("Fetched code from Excel: " + pCode);
			enterTryHereCode(pCode);
		} else {
			LoggerLoad.error("No code found for the specified row in the Excel sheet.");
		}
	}

	public void clickRunButton() {
		driver.findElement(runButton).click();
		LoggerLoad.info("Clicked the Run button.");
	}

	public boolean isAlertPresent() {
		try {
			System.out.println("Inside isAlertPresent driver--->" + driver);
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			LoggerLoad.info("Alert message----> " + alertMessage);
			LoggerLoad.info("Alert is present.");
			alert.accept();
			if (alertMessage != null && !alertMessage.isEmpty())  {
				return true;
			}else {
				return false;
			}
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert is present.");
			return false;
		}
	}

	public boolean handleAlert() {
		
		LoggerLoad.info("driver.switchTo().alert()--->"+driver);
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		LoggerLoad.info("Alert message: " + alertMessage);
		alert.accept();
		if (alertMessage != null && !alertMessage.isEmpty())  {
		System.out.println("Inside if --->");
		return true;
	}else {
		LoggerLoad.info("Inside else --->");
		return false;
	}

	}
  
        public String getOutputText() {
        try {
            
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement consoleOutputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(consoleOutputMsg));
            
             String consoleOutput = consoleOutputElement.getText();
            
            LoggerLoad.info("Console output text retrieved: " + consoleOutput);
            return consoleOutput;
        } catch (Exception e) {
            LoggerLoad.error("Error retrieving console output: " + e.getMessage());
            return ""; 
        }
    }
}
