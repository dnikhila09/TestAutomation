package com.valuemomentum.retail.testautomation.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

public class Waits {

//	public static void main(String[] args) throws InterruptedException
	@Test
	public void verifywait ()
	{
		//set the browser context
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver",null);
		//calling web driver
		WebDriver driver =new ChromeDriver();
		//WebDriver driver =new EdgeDriver();
		driver.get("https://www.amazon.in");
		
		System.out.println("Title: "+driver.getTitle());// to get title of web site
		System.out.println("Current URL="+driver.getCurrentUrl());

		//Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				              .until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
		firstResult.sendKeys("iphone");
		
		driver.navigate().refresh();//to refresh
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    //Thread.sleep(2000);

			
	    driver.navigate().back();
	    driver.navigate().forward();
	    
	  
	 //   driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).click();		
	    driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).click();
	    String currentWindow=driver.getWindowHandle();
	    Set<String> windows=driver.getWindowHandles();
	    Iterator<String> ite=windows.iterator();
	    while(ite.hasNext())
	    {
	    	String newWindow=ite.next();
	    	if(!currentWindow.equals(newWindow)) {
	    		driver.switchTo().window(newWindow);
	    	}
	    }
	    driver.findElement(By.id("add-to-cart-button")).click();
	  //  Thread.sleep(4000);
		    
	        driver.close();//close instance
	        driver.quit();
		
	}
	
}


