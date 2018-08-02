package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class MercuryRegistration {
	 WebDriver driver; 
	 String url = "http://newtours.demoaut.com/";
	
	 String ActualValue;
	 
	
	 @Given("^Navigate to the application$")
	 public void navigatetotheapplication() throws InterruptedException, Throwable
		{
			System.out.println("navigatetoregisterpage method");
	    	System.setProperty("webdriver.chrome.driver", "C:\\SeleniumInstallation\\chromedriver.exe");
	 	   
	    	driver = new ChromeDriver();
	    //	driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	    	driver.get(url);
		System.out.println( "navigatetoregisterpage");
			driver.findElement(By.linkText("REGISTER")).click();
			Thread.sleep(2000);
		}
	 
	 @When("^Click on register link$")
	 public void clickonregisterlink() throws InterruptedException
	 {
			
		System.out.println( "clickregisterlink");
	   	driver.findElement(By.linkText("REGISTER")).click();
			Thread.sleep(2000);	
	 }
	 
	 
	 @Then("^Registration page display$")
	 public void registerpagedisplay() throws InterruptedException, Throwable
	 {
		
		String ExpectedValue = "Register: Mercury Tours";
		ActualValue= driver.getTitle();
		System.out.println( "expected"+ExpectedValue);
		System.out.println( "actual"+ActualValue);
		Assert.assertEquals(ExpectedValue, ActualValue);
		}
	 
	 
	 @And("^Close application$")
	 public void Closeapp1() throws InterruptedException, Throwable
	 {
		 
		driver.close();
		driver.quit();
	 }
}
