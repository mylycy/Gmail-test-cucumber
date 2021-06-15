package StepDefinitions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class LoginStep {
	
	WebDriver driver = null;
	
	
	
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		

		driver.get("https://gmail-login-system.herokuapp.com");
	
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
	    
		
	}

	@Given("user is login page")
	public void user_is_login_page() throws InterruptedException {
		
		Thread.sleep(5000);
		 
		
		WebElement clickOnsingButton=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button/span"));
		clickOnsingButton.click();
		
		
	}
	
	
	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException{
		Thread.sleep(5000);
		
		String Mainwindow = driver.getWindowHandle();
	     Set<String> s1 = driver.getWindowHandles();
	     Iterator<String> i1 = s1.iterator();

	     while (i1.hasNext()) {
	          String ChildWindow = i1.next();
	          if (!Mainwindow.equalsIgnoreCase(ChildWindow)) {
	              driver.switchTo().window(ChildWindow);
	             
	           }
	       }
	    
	    driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("testcyan1@gmail.com");
	    
		WebElement clickOnsingButton=driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		clickOnsingButton.click();
	    
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Test@123456");
        
        WebElement clickOnsinglogarButton=driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));
		clickOnsinglogarButton.click();
	
		Thread.sleep(5000);
		
		driver.switchTo().window(Mainwindow);
	}
	
	
	@Then("user exit")
	public void user_exit() {
		
		

		WebElement clickOnsingButton=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button/span"));
		clickOnsingButton.click();
		
		driver.close();
		
		
	}

}




