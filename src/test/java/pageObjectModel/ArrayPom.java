package pageObjectModel;

import org.openqa.selenium.By;
import utilities.CommonUtils;
import utilities.ExcelReader;
import utilities.LoggerLoad;


public class ArrayPom {

	ExcelReader excelReader = new ExcelReader();
	
	public By arrayGetStartedButton = By.xpath("//div[h5[text()='Array']]//a[text()='Get Started']");
	public By arraysInPythonLink = By.xpath("//a[@href='arrays-in-python']");
	public By arraysUsingListLink = By.xpath("//a[@href='arrays-using-list']");
	public By basicOperationsInListsLink = By.xpath("//a[@href='basic-operations-in-lists']");
	public By applicationsOfArrayLink = By.xpath("//a[@href='applications-of-array']");
	public By practiceQuestionsLink = By.linkText(("Practice Questions"));
	public By searchTheArrayLink = By.xpath("//a[@href='/question/1']");
	public By maxConsecutiveOnes = By.xpath("//a[@href='/question/2']");
	public By findNumWithEvenNumOfDigits = By.xpath("//a[@href='/question/3']");
	public By squaresOfAsortedArray = By.xpath("//a[@href='/question/4']");
	public By runButton = By.xpath("//button[text()='Run']");
	public By submitButton = By.xpath("/html/body/div/div/form/input[@type='submit']");
	
		
		public void clickarrayGetStartedBtn() {
			
		    CommonUtils.clickElement(arrayGetStartedButton);
			LoggerLoad.info("Clicking the Array Get Started link");
			
		}
		
		public void clickarraysInPythonLink() {
			
			CommonUtils.clickElement(arraysInPythonLink);
			LoggerLoad.info("Clicking Arrays in Python link");
			
		}
		
		public void clickarraysUsingListLink() {
			
		    CommonUtils.clickElement(arraysUsingListLink);
			LoggerLoad.info("Clicking Arrays Using List link");
			
		}
		
		public void clickbasicOperationsInListsLink() {
			
			CommonUtils.clickElement(basicOperationsInListsLink);
			LoggerLoad.info("Clicking Basic Operations In Lists link");
		}
		public void clickapplicationsOfArrayLink() {
			
			CommonUtils.clickElement(applicationsOfArrayLink);
			LoggerLoad.info("Clicking Aplications Of Array link");
			
		}
		
		public void clickPracticeQuestionsLink() throws InterruptedException {
			
		    CommonUtils.clickElement(practiceQuestionsLink);
			LoggerLoad.info("Practice Questions link clicked");
		}
		
		public void clickSearchTheArrayLink() {
		  
			CommonUtils.clickElement(searchTheArrayLink);
		    LoggerLoad.info("Clicking Search the Array link");
        }
		    
	    public void clickMaxConsecutiveOnes() {
		   
	        CommonUtils.clickElement(maxConsecutiveOnes);
	        LoggerLoad.info("Clicking Max Consecutive Ones link");
		}
	    
		public void clickFindNumWithEvenNumOfDigits() {
		    
			CommonUtils.clickElement(findNumWithEvenNumOfDigits);
		    LoggerLoad.info("Clicking Find Numbers with Even Number of Digits link");
		}
		    
		public void clickSquaresOfASortedArray() {
		    
		    CommonUtils.clickElement(squaresOfAsortedArray);
		    LoggerLoad.info("Clicking Squares of a Sorted Array link");
		}
		
		public String getTextForElement(By locator) {
	        return CommonUtils.getTextForElement(locator);
	    }
		    		
		
}