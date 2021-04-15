package com.valuemomentum.retail.testautomation.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PartnerPortal 
{

	public static void main(String[] args) throws InterruptedException
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
		
		// driver.findElement(By.id("username")).sendKeys("IMD1001507");

		WebElement password = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("current-password")));
		password.sendKeys("Passw0rd");
		// driver.findElement(By.id("current-password")).sendKeys("Passw0rd");

		WebElement login = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("btn-login")));
		login.click();
		// driver.findElement(By.id("btn-login")).click();
		// Thread.sleep(20000);
		WebElement quote = new WebDriverWait(driver, Duration.ofSeconds(30))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class=\"lnk-pd\"][3]")));
		quote.click();
		// driver.findElement(By.xpath("//*[@class=\"lnk-pd\"][3]")).click();
		System.out.println("Quote clicked");

		// List<WebElement> menu = driver.findElements(By.xpath(""));
		Thread.sleep(2000);
	WebElement lob =  driver.findElement(By.id("lob"));
	lob.click();
		// Select lob = new Select(driver.findElement(By.id("lob")));
		Thread.sleep(2000);
		Actions action=new Actions(driver);
        action.moveToElement(lob).perform();
		//lob.findElement(By.name("lob")).click();
        
		
		System.out.println("check box done");

		Thread.sleep(2000);
		/*
		 * // Select product = new Select(driver.findElement(By.xpath("product")));
		 * 
		 * product.selectByVisibleText(""); product.selectByIndex(0);
		 * System.out.println("product done");
		 */
		
		driver.close();
		driver.quit();

	}

}
