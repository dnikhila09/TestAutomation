package com.valuemomentum.retail.testautomation.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleElements {
	
	//public static void main(String[] args) throws InterruptedException
	@Test
	public void multiele()
	{
   
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.amazon.in/");
	  driver.manage().window().maximize();
	//  Thread.sleep(3000); 
	  
	  //identify elements
	 List<WebElement> menu = driver.findElements(By.xpath("//*[@id='nav-xshop']/a"));
	 System.out.println("Size of the elements: "+menu.size());  
	
	 //Print all elements text value
	/* for(int i=0;i<(menu.size());i++)
	 {
		 String txtValue = menu.get(i).getText();
		 System.out.println("Menu item value="+txtValue);
	 }*/
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  try {
		     FileUtils.copyFile(scrFile, new File("C:\\Training\\Testing\\Screenshots\\image1.png"));
	     }catch(IOException e)
	     {
	    	 e.printStackTrace();
	     }
	 
	 for(WebElement value : menu)
	 {
		 String text = value.getText();
		 System.out.println("Menu item value  "+value.getText());
		 File elementFile = value.getScreenshotAs(OutputType.FILE);
		 try {
			     FileUtils.copyFile(elementFile, new File("C:\\Training\\Testing\\Screenshots\\image_"+text+".png"));
		     }catch(IOException e)
		     {
		    	 e.printStackTrace();
		     }
	 }
	  driver.close();
	  driver.quit();
	
	}	
	
	
}
