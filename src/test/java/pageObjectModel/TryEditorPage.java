package pageObjectModel;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import driverManager.DriverManager;

import utilities.LoggerLoad;

import java.time.Duration;




public class TryEditorPage {

	private WebDriver driver = DriverManager.getDriver();


	private final By codeEditorPage = By.xpath("//*[@id='answer_form']/div/div/div[6]/div[1]/div/div/div/div[5]/div/pre");
	private final By runButton = By.xpath("//button[text()='Run']");
	private final By tryEditorOutput = By.xpath("//pre[@id='output']");

	private String actualResult;

	public void enterCode(String code) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement codeEditor = driver.findElement(codeEditorPage);

		action.moveToElement(codeEditor).click()
		      .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
		      .sendKeys(Keys.BACK_SPACE)
		      .perform();

		action.sendKeys(code).perform();
	}

	public void clickRunButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(runButton));
		button.click();
		isAlertPresent();
	}

	public String isAlertPresent() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert text: " + alertText);
			alert.accept();
			return alertText;
		} catch (NoAlertPresentException e) {
			LoggerLoad.info("No alert present.");
			return null;
		}
	}

	public String output() {
		try {
			Alert alert = driver.switchTo().alert();
			actualResult = alert.getText();
			System.out.println("Alert message of invalid code: " + actualResult);
			alert.accept();
		} catch (NoAlertPresentException e) {
			WebElement outputElement = driver.findElement(tryEditorOutput);
			actualResult = outputElement.getText();
			System.out.println("Actual result of valid code: " + actualResult);
		}
		return actualResult;
	}

	public void enteringCode(String code) {
		WebElement codeMirror = driver.findElement(
			By.xpath("//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(codeMirror).click().perform();

		WebElement textArea = codeMirror.findElement(By.xpath(".//textarea"));
		textArea.sendKeys(Keys.CONTROL + "a");
		textArea.sendKeys(Keys.DELETE);
		textArea.sendKeys(code);
	}


	}
