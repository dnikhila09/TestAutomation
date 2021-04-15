package com.valuemomentum.retail.testautomation.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartnerPortal1 {
	
	public void createPartone() throws Exception
	{

		
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(4000);
		driver.navigate().to("https://partnerportal-nprod.libertyinsurance.in/");
		driver.manage().window().maximize();
		Thread.sleep(10000);

		WebElement user = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		user.sendKeys("IMD1001507");  

		WebElement password = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));
		password.sendKeys("Passw0rd");

		WebElement login = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("btn-login")));
		login.click();

		WebElement quote = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"lnk-pd\"][3]")));        
		Thread.sleep(3000);
		quote.click();
		System.out.println("Quote clicked");                                                           
		
		//Thread.sleep(5000);
		
		
		WebElement productwait = new WebDriverWait(driver, Duration.ofSeconds(5000))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='lob']")));   
		
		Select lobdropdown = new Select(driver.findElement(By.xpath("//select[@id='lob']")));
		lobdropdown.selectByVisibleText(" Fire");
			
			 
		/*
		 * //WebElement lob = driver.findElement(By.xpath(""));
		 * driver.close(); driver.quit();
		 */
	
	}
	
	
	
	
	

	public static void main(String[] args) throws InterruptedException {
		
		PartnerPortal1 p1 = new  PartnerPortal1();
		
		
		
	}
}