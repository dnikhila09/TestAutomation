package com.valuemomentum.retail.testautomation.tests;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class Kotak {
	
	//public static void main(String[] args) throws InterruptedException
	@Test
	public void verifylogin()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://netbanking.kotak.com/knb2/");
		  driver.manage().window().maximize();
		  	
	WebElement Name = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));

	Name.sendKeys("123");
	
	
	/*WebElement Next = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
    Next.click();
	
  /*  WebElement mobilenum = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileNo")));

	mobilenum.sendKeys("1234567811");*/
	
	//fluent wait 
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)               
              .withTimeout(Duration.ofSeconds(5))
              .pollingEvery(Duration.ofMillis(1)).ignoring(NoSuchElementException.class);
      WebElement next = wait.until(new Function<WebDriver, WebElement>() {
          public WebElement apply(WebDriver driver) {
              return driver.findElement(By.xpath("//*[@type='submit']"));
          }
      });
      next.click();
	
    
    WebElement password = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(By.id("credentialInputField")));

	password.sendKeys("1234567811");
	
	password.findElement(By.xpath("//*[text()='Secure login']")).click();
	
//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 
  
// System.out.println("Displays the Next button: "+Name.isDisplayed());
   //System.out.println("Is Next button enabled: "+Name.isEnabled());
  // System.out.println("Is Next button selected: "+Name.isSelected());
  // driver.findElement(By.id("userName")).sendKeys("12345");   
	

	
driver.close();
driver.quit();
}
}