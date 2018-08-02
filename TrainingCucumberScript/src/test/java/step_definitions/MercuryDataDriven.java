package step_definitions;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class MercuryDataDriven {
	
	 WebDriver driver; 
	 String url = "http://newtours.demoaut.com/";
	
	 String ActualValue;
	 
	 
	 @Given("^Navigate to the application datadriven$")
	 public void navigatetotheapplication() throws InterruptedException, Throwable
	 {
		System.out.println("navigatetoregisterpage method");
	    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumInstallation\\chromedriver.exe");
	 	   
	   	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	   	driver.get(url);
		System.out.println( "navigatetoregisterpage");
		driver.findElement(By.linkText("REGISTER")).click();
			Thread.sleep(2000);
	 }
	 
	 @When("^Click on register link datadriven$")
	 public void clickonregisterlink() throws InterruptedException
	 {
			
		System.out.println( "clickregisterlink");
		driver.findElement(By.linkText("REGISTER")).click();
			Thread.sleep(2000);
			
	 }
 
	@And("^Enter \"(.*?)\" \"(.*?)\" \"(.*?)\" values, click on register button$")
	public void userregistrationwithmultipledata(String username, String password, String confimpassword) throws InterruptedException
	{
		
		driver.findElement(By.name("email")).sendKeys(username);
 	    driver.findElement(By.name("password")).sendKeys(password);
 	    driver.findElement(By.name("confirmPassword")).sendKeys(confimpassword);
 	    driver.findElement(By.name("register")).click();
 	    	Thread.sleep(2000);
	}
	
	@Then("^user \"(.*?)\" created sucesful$")
	public void uservaerification(String username)
	{
		String  sActualValue=driver.findElement(By.tagName("Body")).getText();
	 	System.out.println( "check the actual value:"+sActualValue);
	 	String expected = "Your user name is "+username; 
	 	Assert.assertTrue(sActualValue.contains(expected)); 	
	}
	
	@And("^Close application datadriven$")
	public void Closeapp1() throws InterruptedException, Throwable
	{
		 
		driver.close();
		driver.quit();
	}
	
}