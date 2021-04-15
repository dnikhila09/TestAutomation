package com.valuemomentum.retail.testautomation.tests;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {

	//public static void main(String[] args) throws InterruptedException {
	
	    @Test
	    public void dateset() {
	    	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://paytm.com/flights");
		driver.manage().window().maximize();
	//	Thread.sleep(2000);
		
	//	WebElement departureDate = driver.findElement(By.xpath("(//*[@class='_3jkx'])[1]"));
		//departureDate.click();
		//Thread.sleep(2000);	
	//driver.findElement(By.name("Departure-Date")).sendKeys("12 Apr 2021");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement departureDate = driver.findElement(By.xpath("(//*[@class='_3jkx'])[1]"));
		//execute javascript to click on element
		js.executeScript("arguments[0].click();",departureDate);
		//get return value from script
		String text = (String) js.executeScript("return arguments[0]",departureDate );
		//executing javascript directly
		//js.executeScript("console.log", args);
	//	Thread.sleep(10000);
		driver.close();
		driver.quit();

}
}