package step_definitions;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MercuryDataDrivenExcel {

	 public WebDriver driver; 
	 public String url ="http://newtours.demoaut.com/";		 
	 public String sExpected = "Welcome: Mercury Tours";
	 public String sActualValue;
	 public Sheet sht;
	 
	 public String path ="C:\\SeleniumScript\\TrainingCucumberScript\\src\\test\\resources\\TestData\\Registration.xlsx";
	 public String sheetName="Sheet1";
	 
	
	 @Given("^Open Mercury Flights website$")
	 public void navigatetowebsite () throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\SeleniumInstallation\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 Thread.sleep(2000);
	 }

	 @When("^Click on Registration link$")
	 public void clickregistratinlink () throws InterruptedException
	 {
		 driver.findElement(By.linkText("REGISTER")).click();
	 	  	Thread.sleep(2000);
	 }

	 @When("^Populate data from \"(.*?)\" \"(.*?)\"$")
	 public void userregistration (String Registration) throws InterruptedException, Throwable
	 {
		 
		 File file = new File(path);
		 FileInputStream inputStream = new FileInputStream(file);
	   	 Workbook  wb = new XSSFWorkbook(inputStream);
	   	 sht = wb.getSheet(sheetName);
	   	 int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();    	 
	 		System.out.println("Row cont:" + rowCount);	  
 	  	 
	 	 for (int i = 1; i <= rowCount; i++) {	
  		 Row row = sht.getRow(i);   	  

         driver.findElement(By.name("firstName")).sendKeys(row.getCell(0).getStringCellValue());
 	 	 driver.findElement(By.name("lastName")).sendKeys(row.getCell(1).getStringCellValue());
 	 	 driver.findElement(By.name("phone")).sendKeys(row.getCell(2).getStringCellValue());
 	 	 driver.findElement(By.name("userName")).sendKeys(row.getCell(3).getStringCellValue());
 	 	 driver.findElement(By.name("address1")).sendKeys(row.getCell(4).toString());
 	 	 driver.findElement(By.name("address2")).sendKeys(row.getCell(5).getStringCellValue());
 	 	 driver.findElement(By.name("city")).sendKeys(row.getCell(6).getStringCellValue());
 	 	 driver.findElement(By.name("state")).sendKeys(row.getCell(7).getStringCellValue());
 	 	 driver.findElement(By.name("postalCode")).sendKeys(row.getCell(8).toString());
 	 	 Select drpcountry = new Select(driver.findElement(By.name("country")));
 	 	    drpcountry.selectByVisibleText(row.getCell(9).getStringCellValue());
 	 	 driver.findElement(By.name("email")).sendKeys(row.getCell(10).getStringCellValue());
 	 	 driver.findElement(By.name("password")).sendKeys(row.getCell(11).getStringCellValue());
 	 	 driver.findElement(By.name("confirmPassword")).sendKeys(row.getCell(12).getStringCellValue());
 	 	 driver.findElement(By.name("register")).click();
 	 	   Thread.sleep(2000);
	 	 }
	 }	 

	 @Then("^Validate the user \"(.*?)\"$")
	 public void validateuser() throws Throwable 
	 {
		 int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();    	 
	 		System.out.println("Row cont:" + rowCount);	  
	  	 
	 	 for (int i = 1; i <= rowCount; i++) {
		 
		 Row row= sht.getRow(i);
		 System.out.println("username in validatetheuser method :" + row.getCell(10).getStringCellValue());	
		 String	Username=row.getCell(10).getStringCellValue();
		 
		 String expected = "Your user name is "+Username; 
		 	   
		 String  sActualValue=driver.findElement(By.tagName("Body")).getText();
		 Assert.assertTrue(sActualValue.contains(expected)); 
		 driver.quit();
	 	 }	 
	 }	 
}