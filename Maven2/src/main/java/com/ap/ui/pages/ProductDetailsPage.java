package com.ap.ui.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;



public class ProductDetailsPage extends TestBase{
	@FindBy(id = "quantity_wanted")
	WebElement quantityInput;
	
	@FindBy(id = "group_1")
	WebElement sizeDropDown;
	
	@FindBy(css= "[name = 'Submit']")
	WebElement addCartButton;
	
	@FindBy (css = "[title = 'Proceed to checkout']")
    WebElement proceedCheckOut;
	
	@FindBy(id = "wishlist_button")
	WebElement addToWishListButton;
	
	@FindBy (css="[class='fancybox-error']")
	WebElement addWishListMsg;
	

	@FindBy (css="[ class='fancybox-item fancybox-close']")
	WebElement addWishListMsgCloseButton;
	
	public ProductDetailsPage(){//constructor and initalizing the page 
		PageFactory.initElements(driver, this);
	}
	public void verifyAddWishListMsg(){//method if this is true this msg will show
		Assert.assertEquals(addWishListMsg.getText(), "Added to your wishlist");
		addWishListMsgCloseButton.click();
	}
	//u use return this when u are interacting with an object that has alot of options.
	public ProductDetailsPage selectProductColor(String color){//color is coming from excel file
		String locator = "[name='"+color+"']";//locator is the object
		driver.findElement(By.cssSelector(locator)).click();//always find it by cssselector
		return this;
	}
	public ProductDetailsPage inputQuantity(String quantity){//constructor overloading
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
		return this;
	}
	public ProductDetailsPage selectSize(String size){
		Select select = new Select(sizeDropDown);
		select.selectByVisibleText(size);
		return this;
	}
	public ProductDetailsPage ClickAddCart(){
	addCartButton.click();
	return this;
	}

	public ProductDetailsPage ClickAddWishListButton(){
	addToWishListButton.click();
	return this;
	}
	public ProductDetailsPage proceedCheckOut(){
		proceedCheckOut.click();
		return new OrderSummaryPage();//after adding a new item it will always go to the ordersummarypage
		}
		
}
	
