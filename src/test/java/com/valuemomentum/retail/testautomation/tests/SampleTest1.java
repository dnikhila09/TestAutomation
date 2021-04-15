package com.valuemomentum.retail.testautomation.tests;

	
	import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	
	import org.testng.annotations.Test;

	public class SampleTest1 {

		//public static void main(String[] args) throws InterruptedException
		@Test
		public void verifylogin()
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.navigate().to("https://amazon.in");
	        //Thread.sleep(5000);
	        
	        System.out.println("Current URL = "+driver.getCurrentUrl());
			System.out.println("Window Details "+driver.getWindowHandle());
		//	Thread.sleep(5000);
			driver.manage().window().maximize();
			 driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[7]")).click();
			 driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[5]/ul/li[3]/span/a/span")).click();
			 driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/h2/a/span")).click();
			 driver.findElement(By.id("a-autoid-0-announce")).click();
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
			    
			    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			     try {
				     FileUtils.copyFile(scrFile, new File("C:\\Training\\Testing\\Screenshots\\image.png"));
			     }catch(IOException e)
			     {
			    	 e.printStackTrace();
			     }
			 
			// Thread.sleep(5000);
		
			System.out.println(driver.getTitle());
			
			driver.close();
			driver.quit();

		}

	}
	
