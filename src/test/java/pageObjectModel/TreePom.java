package pageObjectModel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driverManager.DriverManager;
import utilities.CommonUtils;
import utilities.LoggerLoad;


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

	/*
	 * public void getStartedTree() throws InterruptedException {
	 * 
	 * System.out.println("trying to get into tree page");
	 * 
	 * driver.findElement(tree_getStarted).click();
	 * 
	 * }
	 */
	
	   public void getStartedTree() {
	        LoggerLoad.info("Attempting to navigate to the Tree page");
	        try {
	            CommonUtils.clickElement(tree_getStarted);
	            LoggerLoad.info("Successfully navigated to the Tree page");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Get Started' link for Tree: " + e.getMessage());
	        }
	    }
	   
	    public void overviewofTreesLink() {
	        LoggerLoad.info("Attempting to click on 'Overview of Trees' link");
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(overviewofTrees));
	            element.click();
	            LoggerLoad.info("Successfully clicked on 'Overview of Trees'");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Overview of Trees' link: " + e.getMessage());
	        }
	    }
	
		/*
		 * public void overviewofTreesLink() throws InterruptedException {
		 * System.out.println("trying overview of trees");
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 * 
		 * 
		 * WebElement element =
		 * wait.until(ExpectedConditions.elementToBeClickable(overviewofTrees));
		 * 
		 * 
		 * element.click();
		 * 
		 * 
		 * System.out.println("clicked");
		 * 
		 * 
		 * }
		 */
	
		/*
		 * public void terminologiesLink() { driver.findElement(terminologies).click();
		 * }
		 */
	    
	    public void terminologiesLink() {
	        LoggerLoad.info("Attempting to click on 'Terminologies' link");
	        try {
	            CommonUtils.clickElement(terminologies);
	            LoggerLoad.info("Successfully clicked on 'Terminologies' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Terminologies' link: " + e.getMessage());
	        }
	    }
	    
	    
		/*
		 * public void typesofTrees() { driver.findElement(typesofTrees).click(); }
		 */
	    
	    public void typesofTrees() {
	        LoggerLoad.info("Attempting to click on 'Types of Trees' link");
	        try {
	            CommonUtils.clickElement(typesofTrees);
	            LoggerLoad.info("Successfully clicked on 'Types of Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Types of Trees' link: " + e.getMessage());
	        }
	    }
	
		/*
		 * public void treeTraversals() { driver.findElement(treeTraversals).click(); }
		 */
	    
	    public void treeTraversals() {
	        LoggerLoad.info("Attempting to click on 'Tree Traversals' link");
	        try {
	            CommonUtils.clickElement(treeTraversals);
	            LoggerLoad.info("Successfully clicked on 'Tree Traversals' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Tree Traversals' link: " + e.getMessage());
	        }
	    }
	    
	    
		/*
		 * public void traversalsIllustration() {
		 * driver.findElement(traversalsIllustration).click(); }
		 */
	    

	    public void traversalsIllustration() {
	        LoggerLoad.info("Attempting to click on 'Traversals Illustration' link");
	        try {
	            CommonUtils.clickElement(traversalsIllustration);
	            LoggerLoad.info("Successfully clicked on 'Traversals Illustration' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Traversals Illustration' link: " + e.getMessage());
	        }
	    }
	
		/*
		 * public void binaryTrees() { driver.findElement(binaryTrees).click(); }
		 */
	    
	    public void binaryTrees() {
	        LoggerLoad.info("Attempting to click on 'Binary Trees' link");
	        try {
	            CommonUtils.clickElement(binaryTrees);
	            LoggerLoad.info("Successfully clicked on 'Binary Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Binary Trees' link: " + e.getMessage());
	        }
	    }

		/*
		 * public void typesofBinaryTrees() {
		 * driver.findElement(typesofBinaryTrees).click(); }
		 */
	    
	    public void typesofBinaryTrees() {
	        LoggerLoad.info("Attempting to click on 'Types of Binary Trees' link");
	        try {
	            CommonUtils.clickElement(typesofBinaryTrees);
	            LoggerLoad.info("Successfully clicked on 'Types of Binary Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Types of Binary Trees' link: " + e.getMessage());
	        }
	    }
	    
	    
		/*
		 * public void implementationInPython() {
		 * driver.findElement(implementationInPython).click(); }
		 */
	    public void implementationInPython() {
	        LoggerLoad.info("Attempting to click on 'Implementation in Python' link");
	        try {
	            CommonUtils.clickElement(implementationInPython);
	            LoggerLoad.info("Successfully clicked on 'Implementation in Python' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Implementation in Python' link: " + e.getMessage());
	        }
	    }

		/*
		 * public void binaryTreeTraversals() {
		 * driver.findElement(binaryTreeTraversals).click(); }
		 */
	    
	    public void binaryTreeTraversals() {
	        LoggerLoad.info("Attempting to click on 'Binary Tree Traversals' link");
	        try {
	            CommonUtils.clickElement(binaryTreeTraversals);
	            LoggerLoad.info("Successfully clicked on 'Binary Tree Traversals' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Binary Tree Traversals' link: " + e.getMessage());
	        }
	    }
	    
		/*
		 * public void implementationofBinaryTrees() {
		 * driver.findElement(implementationofBinaryTrees).click(); }
		 */
	    
	    public void implementationofBinaryTrees() {
	        LoggerLoad.info("Attempting to click on 'Implementation of Binary Trees' link");
	        try {
	            CommonUtils.clickElement(implementationofBinaryTrees);
	            LoggerLoad.info("Successfully clicked on 'Implementation of Binary Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Implementation of Binary Trees' link: " + e.getMessage());
	        }
	    }
	    
		/*
		 * public void applicationsofBinaryTrees() {
		 * driver.findElement(applicationsofBinaryTrees).click(); }
		 */
	    
	    public void applicationsofBinaryTrees() {
	        LoggerLoad.info("Attempting to click on 'Applications of Binary Trees' link");
	        try {
	            CommonUtils.clickElement(applicationsofBinaryTrees);
	            LoggerLoad.info("Successfully clicked on 'Applications of Binary Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Applications of Binary Trees' link: " + e.getMessage());
	        }
	    }
	    
	    
		/*
		 * public void binarySearchTrees() {
		 * driver.findElement(binarySearchTrees).click(); }
		 */
	    
	    public void binarySearchTrees() {
	        LoggerLoad.info("Attempting to click on 'Binary Search Trees' link");
	        try {
	            CommonUtils.clickElement(binarySearchTrees);
	            LoggerLoad.info("Successfully clicked on 'Binary Search Trees' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Binary Search Trees' link: " + e.getMessage());
	        }
	    }
	    
	    public void implementationOfbst() {
	        LoggerLoad.info("Attempting to click on 'Implementation of BST' link");
	        try {
	            CommonUtils.clickElement(implementationOfbst);
	            LoggerLoad.info("Successfully clicked on 'Implementation of BST' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Implementation of BST' link: " + e.getMessage());
	        }
	    }

		/*
		 * public void implementationOfbst() {
		 * driver.findElement(implementationOfbst).click(); }
		 */
		/*
		 * public void practiceQuestions() {
		 * driver.findElement(practiceQuestions).click(); }
		 */
	    
	    public void practiceQuestions() {
	        LoggerLoad.info("Attempting to click on 'Practice Questions' link");
	        try {
	            CommonUtils.clickElement(practiceQuestions);
	            LoggerLoad.info("Successfully clicked on 'Practice Questions' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Practice Questions' link: " + e.getMessage());
	        }
	    }
		/*
		 * public void clickTryhere() { driver.findElement(clickTryhere).click(); }
		 */
	    
	    public void clickTryhere() {
	        LoggerLoad.info("Attempting to click on 'Try here>>>' link");
	        try {
	            CommonUtils.clickElement(clickTryhere);
	            LoggerLoad.info("Successfully clicked on 'Try here>>>' link");
	        } catch (Exception e) {
	            LoggerLoad.error("Failed to click on 'Try here>>>' link: " + e.getMessage());
	        }
	    }
}
