package com.valuemomentum.retail.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	
	//constructor
	public HomePage(WebDriver driver)
	{
		
		super(driver);
		
	}
	
	//element
	@FindBy(id="twotabsearchtextbox")
	private WebElement _txtSearchBox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement _btnSearch;
	
	//action
	public void enterSearchText(String text)
	{
		_txtSearchBox.clear();
		_txtSearchBox.sendKeys(text);
	}
	
	public SearchResultsPage clickOnSearchButton()
	{
		_btnSearch.click();
		return new  SearchResultsPage(getDriver());
	}
	
}