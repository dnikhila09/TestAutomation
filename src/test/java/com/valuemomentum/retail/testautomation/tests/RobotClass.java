package com.valuemomentum.retail.testautomation.tests;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RobotClass {

	public static void main(String args[]) throws Exception {

		Robot robot = new Robot();
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		StringSelection ss = new StringSelection("C:\\Training\\Java\\screenshot\\Task01.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		  WebElement file = new WebDriverWait(driver, Duration.ofSeconds(5000))
		  .until(ExpectedConditions.elementToBeClickable(By.id("imagesrc")));
		  //login.click();
		 		
		 Actions action=new Actions(driver);
	        action.moveToElement(file).click();
	//	driver.findElement(By.xpath("//*[@id='imagesrc']")).click();
	        
	        System.out.println("clicked");

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);


		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
        System.out.println("end");


		driver.close();
		driver.quit();

	}
}