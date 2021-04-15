package com.valuemomentum.retail.testautomation.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest4 {
	
	//public static void main(String[] args) throws InterruptedException {
	    @Test
		public void verify()
		{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		// calling web driver
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
	//	Thread.sleep(5000);
		
		driver.findElement(By.linkText("Electronics")).click();
		//Thread.sleep(5000);
		driver.findElement(By.linkText("Noise")).click();
		  driver.findElement(By.xpath("//*[@id=\"low-price\"]")).sendKeys("5000");//min price
	        driver.findElement(By.xpath("//*[@id=\"high-price\"]")).sendKeys("20000");//max price
	    //    Thread.sleep(2000);
	        driver.findElement(By.id("a-autoid-1")).click();//Go button
	        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[1]/div/span/div/div/div[2]/h2/a/span")).click();
	    //    driver.findElement(By.xpath("driver.findElement(By.xpath")).click();
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
		 //   Thread.sleep(4000);
	     //   driver.findElement(By.id("add-to-cart-button")).click();
	  
		
	        //driver.findElement(By.xpath("")).click();
		/*driver.findElement(By.linkText("Fashion")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(@class,'a-link-normal') and contains(text(),'Shop now')])[3]")).click();*/
		
	//	driver.findElement(By.linkText("Electronics")).click();
		//driver.findElement(By.linkText("Noise")).click();
		//driver.findElement(By.partialLinkText("Noise Colorfit Pro 2 Full Touch Control Smart Watch Jet Black")).click();
		//driver.findElement(By.partialLinkText("iPhone 12 mini | Extra Rs. 6000 off")).click();
		
	//	Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
	
}
