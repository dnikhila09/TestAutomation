package com.valuemomentum.retail.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import com.valuemomentum.retail.testautomation.pages.ProductDetailsPage;
import com.valuemomentum.retail.testautomation.utils.WebDriverHelper;

public class SearchResultsPage extends BasePage {
	
	public SearchResultsPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//element
	@FindBy(xpath = "(//*[text()='New Apple iPhone 11 (128GB) - Purple'])[1]" )
	private WebElement _lblItem;
	
	
	//action
	
	public ProductDetailsPage clickOnItem()
	{
		_lblItem.click();
		WebDriverHelper.switchToWindow();
		return new ProductDetailsPage(getDriver());
	}
	 @FindBy(xpath="//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")
     private WebElement _lblPlayStation;
	 
	 public ProductDetailsPage clickOnPlayStation()
		{
		 _lblPlayStation.click();
			WebDriverHelper.switchToWindow();
			return new ProductDetailsPage(getDriver());
		}
 
 public String getItemText() {
        
     return _lblPlayStation.getText() ;
    
 }

	
	
}
