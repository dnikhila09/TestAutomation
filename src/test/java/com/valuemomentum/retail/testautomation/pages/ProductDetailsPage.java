package com.valuemomentum.retail.testautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage
{
	public ProductDetailsPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//element
    @FindBy(id="add-to-cart-button")
    private static  WebElement _btnAddToCart;
    
    
    //action
    public  void clickOnAddToCart() {
        _btnAddToCart.click();;
        
        }

}
