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
import utilities.CommonUtils;
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
		LoggerLoad.info("Attempting to click the 'Try Here' button.");
		try {
			CommonUtils.clickElement(tryHereButton); // Using CommonUtils click method
			LoggerLoad.info("Clicked the 'Try Here' button.");
		} catch (Exception e) {
			LoggerLoad.error("Failed to click the 'Try Here' button: " + e.getMessage());
		}
	}

	public void enterTryHereCode(String pCode) {
		LoggerLoad.info("Entering code: " + pCode);
		try {
			WebElement codeMirror = driver.findElement(textAreaForCode);
			Actions actions = new Actions(driver);
			actions.moveToElement(codeMirror).click().perform();
			WebElement textArea = codeMirror.findElement(By.xpath("//textarea[@tabindex='0']"));
			textArea.sendKeys(pCode);
			LoggerLoad.info("Code entered successfully.");
		} catch (Exception e) {
			LoggerLoad.error("Failed to enter code: " + e.getMessage());
		}
	}

	public void enterTryHereCode(String sheetName, int row)
			throws InvalidFormatException, IOException, OpenXML4JException {
		LoggerLoad.info("Reading code from Excel sheet: " + sheetName + ", Row: " + row);
		try {
			List<Map<String, String>> testData = excelReader.readFromExcel("src/test/resources/Excel/TestData.xlsx",
					sheetName);

			if (row <= testData.size()) {
				String pCode = testData.get(row).get("pCode");
				if (pCode != null && !pCode.isEmpty()) {
					LoggerLoad.info("Fetched code from Excel: " + pCode);
					enterTryHereCode(pCode);
				} else {
					LoggerLoad.error("No code found for the specified row in the Excel sheet.");
				}
			} else {
				LoggerLoad.error("Specified row " + row + " is out of bounds for the Excel sheet.");
				throw new IllegalArgumentException("Row index out of bounds.");
			}
		} catch (Exception e) {
			LoggerLoad.error("Error while reading or entering code from Excel: " + e.getMessage());
		}
	}

	public void clickRunButton() {
		LoggerLoad.info("Attempting to click the 'Run' button.");
		try {
			CommonUtils.clickElement(runButton); // Using CommonUtils click method
			LoggerLoad.info("Clicked the 'Run' button.");
		} catch (Exception e) {
			LoggerLoad.error("Failed to click the 'Run' button: " + e.getMessage());
		}
	}

	public boolean isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			LoggerLoad.info("Alert message: " + alertMessage);
			alert.accept();
			return alertMessage != null && !alertMessage.isEmpty();
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert is present.");
			return false;
		}
	}

	public boolean handleAlert() {
		LoggerLoad.info("Attempting to handle alert.");
		try {
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			LoggerLoad.info("Alert message: " + alertMessage);
			alert.accept();
			return alertMessage != null && !alertMessage.isEmpty();
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert is present.");
			return false;
		}
	}

	public String getOutputText() {
		LoggerLoad.info("Attempting to retrieve console output.");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement consoleOutputElement = wait
					.until(ExpectedConditions.visibilityOfElementLocated(consoleOutputMsg));
			String consoleOutput = consoleOutputElement.getText();
			LoggerLoad.info("Console output retrieved: " + consoleOutput);
			return consoleOutput;
		} catch (Exception e) {
			LoggerLoad.error("Error retrieving console output: " + e.getMessage());
			return "";
		}
	}
}