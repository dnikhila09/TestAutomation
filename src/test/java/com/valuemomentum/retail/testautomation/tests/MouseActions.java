package com.valuemomentum.retail.testautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MouseActions {

//public static void main(String[] args) throws InterruptedException
	@Test
	public void verifylogin()
	{
   
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.amazon.in/");
	  driver.manage().window().maximize();
	//  Thread.sleep(3000); 
	  
	  //keyboard actions
	/* driver.findElement(By.id("twotabsearchtextbox"));
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	 Thread.sleep(3000); 
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.TAB);
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);*/
	 
	  WebElement wb = driver.findElement(By.id("twotabsearchtextbox"));
	 // WebElement wb = driver.findElement(By.xpath(""));
	  
      wb.sendKeys("iphone"+Keys.UP);
      wb.sendKeys(Keys.BACK_SPACE);
      wb.clear();
   //   Thread.sleep(3000); 
      wb.sendKeys(Keys.DOWN);
      wb.sendKeys(Keys.DOWN);
      wb.sendKeys(Keys.UP);

   //   Thread.sleep(3000); 
      wb.sendKeys(Keys.UP);


	  
	 // Thread.sleep(3000); 
	  driver.close();
      driver.quit();
	    

}
}