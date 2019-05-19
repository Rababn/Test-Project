package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ap.ui.base.TestBase;
//PageFactory
public class ContactsPage extends TestBase {
	@FindBy(id ="id_contact")
	WebElement headingDropdown;
	
	@FindBy(id ="email")
	WebElement emailInput;
	
	@FindBy(id ="id_order")
	WebElement OrderReference;
	
	@FindBy(id ="message")
	WebElement messageTextBox;
	
	@FindBy(id ="submitMessage")
	WebElement submitMessageButton;
	
	@FindBy(id = "[class= 'alert alert-success']")
	WebElement successMsg;
	
	public ContactsPage(){//constructor
		PageFactory.initElements(driver, this);//
	}
	//creating a method
	public ContactsPage fillContactForm(String heading, String email, String reference,String message){
	Select select = new Select(headingDropdown);// multiple dropdown 
	select.selectByVisibleText(heading);
	emailInput.sendKeys(email);
	OrderReference.sendKeys(reference);
	messageTextBox.sendKeys(message);
	return this;
}
	public void submitMessage(){// clicking and submitting the message
		submitMessageButton.click();	
}
	public String getMessage(){//success message after submitting 
		return successMsg.getText();
	}
	}















