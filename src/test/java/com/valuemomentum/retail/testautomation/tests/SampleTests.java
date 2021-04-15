package com.valuemomentum.retail.testautomation.tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTests {
	
	//public static void main(String[] args) throws InterruptedException
	@Test
	public void verifylogin()
	{
		//set the browser context
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver",null);
		//calling web driver
		WebDriver driver =new ChromeDriver();
		//WebDriver driver =new EdgeDriver();
		driver.get("https://www.amazon.in");
		//driver.get("https://selenium.dev");
		//driver.navigate().to("https://selenium.dev");
		//Thread.sleep(10000);
		
		System.out.println("Current URL="+driver.getCurrentUrl());
		
		driver.navigate().refresh();//to refresh
		
		System.out.println("Title: "+driver.getTitle());// to get title of web site
		System.out.println("window details : "+driver.getWindowHandle());
	  
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    //Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	  //opens new tab and switches to new tab
     //driver.switchTo().newWindow(WindowType.TAB);
	  		
	  	//opens new tab
		//	driver.switchTo().newWindow(WindowType.WINDOW);
			
		//	driver.close();
			//driver.close();
			
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
	   // Thread.sleep(4000);
	      /*  driver.findElement(By.id("dropdownLangauge")).click();
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//*[@id=\"fr\"]")).click(); */
		    
	        driver.close();//close instance
	        driver.quit();
		
	}
	
}
