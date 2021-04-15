package com.valuemomentum.retail.testautomation.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementsOfElements {

	//public static void main(String[] args) throws InterruptedException
    @Test
	public void eleofele()
	{
   
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www.amazon.in/");
	  driver.manage().window().maximize();
	 // Thread.sleep(3000); 
	  //find element of element
	  WebElement menu = driver.findElement(By.id("nav-xshop"));
	
    WebElement value = menu.findElement(By.tagName("a"));
      System.out.println("get value of element : " +value.getText());
      
	  //finds elements of elements
	 List<WebElement> value1 = menu.findElements(By.tagName("a"));
	  for(WebElement item : value1)
		 {
			 System.out.println("Menu item value  "+item.getText());
		 }
	  
      driver.close();
      driver.quit();
}
}