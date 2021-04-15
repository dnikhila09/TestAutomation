package com.valuemomentum.retail.testautomation.tests;


import org.testng.Assert;
//import static org.testng.AssertJUnit.assertEquals;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.util.Assert;
import com.valuemomentum.retail.testautomation.pages.HomePage;
import com.valuemomentum.retail.testautomation.pages.ProductDetailsPage;
import com.valuemomentum.retail.testautomation.pages.SearchResultsPage;
import com.valuemomentum.retail.testautomation.utils.BaseTest;                          
import com.valuemomentum.retail.testautomation.utils.DataUtility;
//import com.valuemomentum.retail.testautomation.utils.WebDriverHelper;

public class SmokeTest extends BaseTest
{ 
	private static final Logger Logger = LogManager.getLogger(SmokeTest.class);
	WebDriver driver;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ProductDetailsPage productDetailsPage;
	
	@BeforeClass
	public void setup()
	{
		
		Logger.info("Setup method called");
		homePage = new HomePage(getDriver());
	}
	 
		@DataProvider(name = "Search")
		public static Object[][] Credentials() throws Exception {
			
			return DataUtility.getTestData();
		
			
			
		}
		 @Test(priority = 0, enabled = false)
		    public void verifyMobilePurchaseAssertions() {
		       
		        System.out.println("Thread id: "+Thread.currentThread().getId());
		        homePage.enterSearchText("Play Station");
		        searchResultsPage=homePage.clickOnSearchButton();
		        String extractedText=searchResultsPage.getItemText();
		        Assert.assertEquals(extractedText, "PS4 1TB Slim Bundled with Spider-Man, GTaSport, Ratchet & Clank And PSN 3Month");
		        productDetailsPage=searchResultsPage.clickOnPlayStation();
		        productDetailsPage.clickOnAddToCart();
		       
		 }
		/* @Test
		 public void UnderstandingAsserrtion()
		 {
			 System.out.println("line 01");
			 Assert.assertEquals("hello","hello");
			 System.out.println("line 02");
			 Assert.assertFalse(true);
			 System.out.println("Line 03");
			 
		 }*/
	@Test(priority = 1,enabled = true, dataProvider = "Search")
	public void verifyMobilePurchase(String text)
	{
		System.out.println(" Thread id "+Thread.currentThread().getId());
		homePage.enterSearchText(text);
		//homePage.enterSearchText(searchtext);
		searchResultsPage = homePage.clickOnSearchButton();
		productDetailsPage = searchResultsPage.clickOnItem();	
		productDetailsPage.clickOnAddToCart();
		
				
	}
/*	@Test(priority = 2,enabled = true, dataProvider = "Search")
	public void verifyMobilePurchase01(String text)
	{
		System.out.println(" Thread id "+Thread.currentThread().getId());
		homePage.enterSearchText(text);
		searchResultsPage = homePage.clickOnSearchButton();
		//productDetailsPage = searchResultsPage.clickOnItem();	
		//productDetailsPage.clickOnAddToCart();
		
				
	}
	@Test(priority = 3,enabled = true, dataProvider = "Search")
	public void verifyMobilePurchase02(String text)
	{
		System.out.println(" Thread id "+Thread.currentThread().getId());
		homePage.enterSearchText(text);
		//homePage.enterSearchText(searchtext);
		searchResultsPage = homePage.clickOnSearchButton();
		//productDetailsPage = searchResultsPage.clickOnItem();	
		//productDetailsPage.clickOnAddToCart();
		
				
	}*/
}