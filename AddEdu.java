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

public class AddEdu {
	
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
	@Then("Go to Qualifications Page")
	public void go_to_jobs_page() throws Exception 
	{
	
		findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'])[1]")).click();
		findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[4]")).click();
		findElement(By.xpath("//a[text()='Education']")).click();
		findElement(By.xpath("(//button)[2]")).click();
		
	}
	
	@When("Add Education with educationname as {string}")
	public void add_education_with_educationname_as(String educationname) throws Exception
	{
	
		findElement(By.xpath("(//input)[2]")).sendKeys(educationname);
		Thread.sleep(10000);
		findElement(By.xpath("//button[@type='submit']")).click();
		
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
