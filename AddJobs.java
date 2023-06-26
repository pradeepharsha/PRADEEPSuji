package seleniumgluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddJobs {
	
	static WebDriver driver;
	
	@Given("User launch crome browser")
	public void user_launch_crome_browser() 
	{
	    
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		
	}
	@When("User Oper URL {string}")
	public void user_oper_url(String TestURL) 
	{
		driver.get(TestURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	}
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String UserName, String Password) throws Exception 
	{
	 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(UserName);
		findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
		findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		
		
	}
	@Then("Go to Jobs Page")
	public void go_to_jobs_page() throws Exception 
	{
	
         findElement(By.xpath("//span[text()='Admin']")).click();
	  

		
		findElement(By.xpath("//span[text()='Job ']")).click();
		findElement(By.xpath("//a[text()='Job Titles']")).click();
		findElement(By.xpath("//button[text()=' Add ']")).click();
		
	}
	
	@When("Add Jobs with jobtitle as {string} and jobdescription as {string} and note as {string}")
	public void add_jobs_with_jobtitle_as_and_jobdescription_as_and_note_as(String jobtitle, String jobdescrption, String note) throws Exception 
	
	{
	    
		
		findElement(By.xpath(" (//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(jobtitle);
		findElement(By.xpath("//textarea[ @placeholder='Type description here']")).sendKeys(jobdescrption);
		findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys(note);
				  
		Thread.sleep(5000);
		findElement(By.xpath("//button[text()=' Save ']")).click();
		
	}
	
	
	
	@When("Click on logout button")
	public void click_on_logout_button() throws Exception 
	{
		
        findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		
		Thread.sleep(2000);
		
		findElement(By.xpath("(//a[@class='oxd-userdropdown-link'])[4]")).click();
		
	}
	    
	@Then("Close Browser")
	public void close_browser()
	{
	
		driver.quit();
		  
		
	}
	
	
	
public  WebElement findElement(By by) throws Exception {
		
	    WebElement elem = driver.findElement(by);
	    	    
	    // draw a border around the found element
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);

	        
	    }
	    return elem;
	}
	
	
}
