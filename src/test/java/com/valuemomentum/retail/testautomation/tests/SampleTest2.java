package com.valuemomentum.retail.testautomation.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SampleTest2 {
	
	static WebDriver driver;
	String baseURL, nodeURL;
	
//	public static void main(String[] args) throws InterruptedException {
	@Test
	public void verifylogin() throws IOException
	{
		
	nodeURL="http://192.168.1.102:5555";
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
      //  capability.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		// calling web driver
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
	//	Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Home and kitchen");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//*[@id=\"n/976442031\"]/span/a/span")).click();// home and kitchen
		driver.findElement(By.xpath("//*[@id=\"nav-subnav\"]/a[7]/span[1]")).click();// home decor
		driver.findElement(By.xpath(" //*[@id=\"a-page\"]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[3]/li[1]/a")).click(); // wall clock
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[1]/div/div[2]/ul/span[1]/li/span/div/a/div[1]/div")).click();//1st clock
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/ul/li[1]/span/div/a/div[1]/div")).click();// clock
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
		
	//	Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}


