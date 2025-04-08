package pageObjectModel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverManager.DriverManager;


public class TreePom {
	
	
	public WebDriver driver = DriverManager.getDriver();
	
	By tree_getStarted = By.xpath("//a[@href='tree']");

	
	private By overviewofTrees = By.xpath("//a[@href='overview-of-trees']");
	private By terminologies = By.linkText("Terminologies");
	private By typesofTrees = By.xpath("//a[@href='types-of-trees']");
	private By treeTraversals = By.xpath("//a[@href='tree-traversals']");
	private By traversalsIllustration = By.xpath("//a[@href='traversals-illustration']");
	private By binaryTrees=By.xpath("//a[@href='binary-trees']");
	private By typesofBinaryTrees=By.xpath("//a[@href='types-of-binary-trees']");
	private By implementationInPython=By.xpath("//a[@href='implementation-in-python']");
	private By binaryTreeTraversals=By.xpath("//a[@href='binary-tree-traversals']");
	private By implementationofBinaryTrees=By.xpath("//a[@href='implementation-of-binary-trees']");
	private By applicationsofBinaryTrees=By.xpath("//a[@href='applications-of-binary-trees']");
	private By binarySearchTrees=By.xpath("//a[@href='binary-search-trees']");
	private By implementationOfbst=By.xpath("//a[@href='implementation-of-bst']");
	private By practiceQuestions = By.linkText("Practice Questions");
	private By clickTryhere = By.linkText("Try here>>>");

	
	public void getStartedTree() throws InterruptedException {
		
		System.out.println("trying to get into tree page");
		
		driver.findElement(tree_getStarted).click();
	
	}
	
	public void overviewofTreesLink() throws InterruptedException {
		System.out.println("trying overview of trees");
		

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    
	 
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(overviewofTrees));
	    
	   
	    element.click();
	    

	    System.out.println("clicked");


	}
	
	public void terminologiesLink() {
		driver.findElement(terminologies).click();
	}
	public void typesofTrees() {
		driver.findElement(typesofTrees).click();
	}
	
	public void treeTraversals() {
		driver.findElement(treeTraversals).click();
	}
	public void traversalsIllustration() {
		driver.findElement(traversalsIllustration).click();
	}
	
	public void binaryTrees() {
		driver.findElement(binaryTrees).click();
	}
	public void typesofBinaryTrees() {
		driver.findElement(typesofBinaryTrees).click();
	}
	public void implementationInPython() {
		driver.findElement(implementationInPython).click();
	}
	public void binaryTreeTraversals() {
		driver.findElement(binaryTreeTraversals).click();
	}
	public void implementationofBinaryTrees() {
		driver.findElement(implementationofBinaryTrees).click();
	}
	public void applicationsofBinaryTrees() {
		driver.findElement(applicationsofBinaryTrees).click();
	}
	public void binarySearchTrees() {
		driver.findElement(binarySearchTrees).click();
	}
	public void implementationOfbst() {
		driver.findElement(implementationOfbst).click();
	}
	public void practiceQuestions() {
		driver.findElement(practiceQuestions).click();
	}
	public void clickTryhere()  {
		driver.findElement(clickTryhere).click();
	}
}
