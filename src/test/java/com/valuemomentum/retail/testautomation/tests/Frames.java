package com.valuemomentum.retail.testautomation.tests;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Frames {
	//public static void main(String[] args) throws InterruptedException
	@Test
	public void framecheck()
	{
   
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.w3schools.com/html/html_iframe.asp");
	  //driver.manage().window().maximize();
	  driver.manage().window().fullscreen();
	  
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     try {
	     FileUtils.copyFile(scrFile, new File("C:\\Training\\Testing\\Screenshots\\image.png"));
     }catch(IOException e)
     {
    	 e.printStackTrace();
     }
	//  Thread.sleep(3000); 
	
	  Dimension size =driver.manage().window().getSize();
	  int width = size.getWidth();
	  int height = size.getHeight();
	  
	  driver.manage().window().setSize(new Dimension(900,1000));
	  //Thread.sleep(2000);
	  System.out.println("width of the screen : "+width);
      System.out.println("height of the screen : "+height);
      
      Point position = driver.manage().window().getPosition();
      int x1 = position.getX();
      int y1 = position.getY();
      
      System.out.println("point on the screen : "+x1);
      System.out.println("point of the screen : "+y1);
	  //Thread.sleep(2000);

      driver.manage().window().setPosition(new Point(600,770));

	  
	//  driver.findElement(By.xpath("//a[@class='w3-bar-item w3-button'][1]")).click();
	// driver.findElement(By.id("topnavbtn_tutorials")).click();
	 //driver.findElement(By.id("topnavbtn_references")).click();
 
/*  int iframeSize = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Total iframes : "+iframeSize);
	
	 Thread.sleep(2000); 
    driver.switchTo().frame(0);
    Thread.sleep(2000); 
	driver.findElement(By.id("topnavbtn_tutorials")).click();
	driver.switchTo().parentFrame();
	 Thread.sleep(2000); 
	driver.findElement(By.id("topnavbtn_tutorials")).click();

	 driver.switchTo().frame(0);
	    Thread.sleep(2000); 
		driver.findElement(By.id("topnavbtn_references")).click();
		driver.switchTo().parentFrame();
		 Thread.sleep(2000); 
		driver.findElement(By.id("topnavbtn_references")).click();
		 Thread.sleep(10000); 
*/

      //Thread.sleep(2000); 
	driver.close();
	driver.quit();
	}
	

}
