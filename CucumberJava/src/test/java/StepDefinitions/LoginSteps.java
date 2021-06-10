package StepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	

	WebDriver driver = null;
	
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}

	@Given("user is login page")
	public void user_is_login_page() {
		
		driver.get("https://gmail-login-system.herokuapp.com");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();	
		
	}
	
	
	@When("user enters username and password")
	public void user_enters_username_and_password() {
		
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("testcyan1@gmail.com");
		driver.findElement(By.id("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@123456");
        driver.findElement(By.id("//*[@id=\"passwordNext\"]/div/button/span")).click();
		
		
				
	    
	}

	@Then("user exit")
	public void user_exit() {
	    // Write code here that turns the phrase above into concrete actions  

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();
		
	}

}
