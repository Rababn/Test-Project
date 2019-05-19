package com.ap.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.ui.base.TestBase;

/* proceedcheckoutbutton  title="Proceed to checkout"
 * processaddressbutton
 * processcarrierbutton
 * termsandcondition
 * paybybankwire
 * confirmOrder
 * orderConfirm
 */

public class OrderSummaryPage extends TestBase {

	@FindBy(css="[title='Proceed to checkout']")
	WebElement ProceedCheckOutButton;
	

	@FindBy(css="[name='processAddress']")
	WebElement ProcessAddressButton;
	

	@FindBy(css="[ name='processCarrier']")
	WebElement processCarrierButton;
	

	@FindBy(css="[id='cgv']")
	WebElement TermsandCondition;
	

	@FindBy(css="[class='payment_module'][ title='Pay by bank wire']")
	WebElement PayByBankWire;
	

	@FindBy(css="[id='cart_navigation']button")
	WebElement ConfirmOrder;

	@FindBy(css="[class='cheque-indent'][class='dark']")
	WebElement OrderConfirm;
	
		public OrderSummaryPage() {
			PageFactory.initElements(driver, this);
			
		}
		public OrderSummaryPage proceedCheckOut(){
			ProceedCheckOutButton.click();
			return this;
		}
		public OrderSummaryPage processAddressCheckOut(){
			ProcessAddressButton.click();
			return this;
		}
		
		public OrderSummaryPage proceedShipping(){
			TermsandCondition.click();
			processCarrierButton.click();
			return this;
		}
		public OrderSummaryPage ConfirmOrder(){
			PayByBankWire.click();
			ConfirmOrder.click();
			return this;
		}
		public String getConfirmationMessage(){
			return OrderConfirm.getText();
		}
}
