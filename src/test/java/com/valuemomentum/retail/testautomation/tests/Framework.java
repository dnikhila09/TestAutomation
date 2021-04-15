package com.valuemomentum.retail.testautomation.tests;

import java.time.Duration;
import java.util.function.Function;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valuemomentum.retail.testautomation.utils.WebDriverHelper;


public class Framework extends WebDriverHelper {
	
	private static final Logger Logger = LogManager.getLogger(Framework.class);
	WebDriver driver;
	
    @BeforeClass
    public void setUp() {
    	Logger.info("setup method called");
    	this.driver = getDriver();
    	
    }
    
	@DataProvider(name = "Login")
	public static Object[][] Credentials() {
		return new Object[][] { { "12312312", "13123123" }, { "4543534534", "23423423" }, { "25234234234", "123312" },
				{ "123121134", "1231312" }, { "454534534", "312312312" } };
	}

	@Test(dataProvider = "Login", priority = 1, enabled = true)
	public void verifyLogin(String crnnumber, String password) {
		Logger.info("Test Method Started");
		driver.get("https://netbanking.kotak.com/knb2/");
		Logger.info("Opened Url");
		WebElement userName = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		userName.sendKeys(crnnumber);
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
        		.pollingEvery(Duration.ofMillis(1)).ignoring(NoSuchElementException.class);
        
        
        WebElement next = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath("//*[@type='submit']"));
            }
        });
        next.click();
		System.out.println(" Password - " + password);
		Logger.info("Test complted");
	}

	@Test(priority = 2, enabled = true)
	public void verifyLocators() {
		driver.get("http://www.amazon.in");
		WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
		System.out.println(" Text from image " + logo.getText());
		Rectangle rect = driver.findElement(By.xpath("(//*[contains(text(),'Cart')])[1]")).getRect();
		System.out.println(" height value of " + rect.getHeight());
		System.out.println(" Width value of " + rect.getWidth());
		System.out.println(" X value of " + rect.getX());
		System.out.println(" Y value of " + rect.getY());
		System.out.println(" Dimensions value of " + rect.getDimension());
		System.out.println(" Point value of " + rect.getPoint());
		WebElement cart = driver.findElement(By.xpath("(//*[contains(text(),'Cart')])[1]"));
		System.out.println(" Tag name for cart id = " + cart.getTagName());
		WebElement menuCustomerService = driver.findElement(By.xpath("//div/a[text()='Customer Service']"));
		System.out.println(" Text of the element " + menuCustomerService.getText());
		System.out.println(" Accessible Name of the element " + menuCustomerService.getAccessibleName());
		System.out.println(" Aria Role of the element " + menuCustomerService.getAriaRole());
		System.out.println(" Attributes of the element " + menuCustomerService.getAttribute("data-csa-c-id"));
		System.out.println(" Value of the element " + menuCustomerService.getAttribute("value"));
		System.out.println(" CSS - color Value of the element " + menuCustomerService.getCssValue("color"));
		System.out.println(" CSS - Font family Value of the element " + menuCustomerService.getCssValue("font-family"));
		System.out.println(" CSS - Font size Value of the element " + menuCustomerService.getCssValue("font-size"));
		System.out.println(" DOM Attribute Value of the element " + menuCustomerService.getDomAttribute("class"));
		System.out.println(" DOM Property Value of the element " + menuCustomerService.getDomProperty("data-csa-c-id"));
		System.out.println(" Tag of the element " + menuCustomerService.getTagName());
	}
}