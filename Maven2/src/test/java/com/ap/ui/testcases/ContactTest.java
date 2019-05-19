package com.ap.ui.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.ContactsPage;
import com.ap.ui.pages.HomePage;

public class ContactTest extends TestBase{
// creating virtual objects for contacts page and home page 
	ContactsPage contactspage;
	HomePage homepage;
	
	public  ContactTest(){//
		super();
	}
	@BeforeMethod
	public void setUpdriver(){
		intialization();//initializing the driver 
		contactspage = new ContactsPage();//creating new object
		homepage = new HomePage();//creating new object
	}
	@Test
	public void testContact(){
		homepage.clickOnContactLink();
		
		contactspage = contactspage.fillContactForm("Customer service", "Random@test.com","Testing","This is test purpose");
		contactspage.submitMessage();
		String successMsg = contactspage.getMessage();
		Assert.assertEquals(successMsg, "Your meessage has been sent to the site");
		
	}
	@AfterMethod
	public void teaarDown(){
		driver.quit();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	