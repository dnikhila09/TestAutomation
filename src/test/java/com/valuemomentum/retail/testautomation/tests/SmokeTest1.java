package com.valuemomentum.retail.testautomation.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.valuemomentum.Project.PageObjectModel.pages.FilterPage;
import com.valuemomentum.Project.PageObjectModel.pages.HomePage;
import com.valuemomentum.Project.PageObjectModel.pages.ProductDetailsPage;
import com.valuemomentum.Project.PageObjectModel.pages.SearchResultsPage;
import com.valuemomentum.Project.PageObjectModel.utils.BaseTest;
import com.valuemomentum.Project.PageObjectModel.utils.DataUtility;

public class SmokeTest1 extends BaseTest {
	final Logger logger = LogManager.getLogger(SmokeTest1.class);
	WebDriver driver;
	HomePage homePage;
	FilterPage filterPage;
	ProductDetailsPage productDetailsPage;
	SearchResultsPage searchResultPage;

	@BeforeClass
	public void setup() {
		this.driver = getDriver();
		homePage = new HomePage(driver);
	}

	@DataProvider(name = "Input")
	public Object[][] dataInput() throws Exception {
		return DataUtility.getTestData();
	}

	@Test(dataProvider = "Input", priority = 2, enabled = true)
	public void DataUtilityMethod(String value) {
		homePage.homePagebtn();
		logger.info("Enter " + value + " in search bar");
		homePage.txtArea(value);
		logger.info("Clicked Search Button");
		homePage.searchBtn();
		logger.info("Navigated Back after search");
	}

	@Test(priority = 1, enabled = true)
	public void verifyMobilePurchase() {
		logger.info("Clicked on Mobile");
		filterPage = homePage.clickOnMobileButton();
		logger.info("Clicked on CloudTails India");
		searchResultPage = filterPage.clickOnMenu();

		logger.info("Selected USB");
		productDetailsPage = searchResultPage.clickOnItem();

		logger.info("Clicked Add To Cart");
		productDetailsPage.clickOnAddToCart();

	}
}