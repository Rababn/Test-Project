package com.ap.ui.testcases;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.ui.base.TestBase;
import com.ap.ui.pages.HomePage;
import com.ap.ui.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;//creating object for this page instead of calling the page directly. 
	HomePage homePage;
	
	public LoginPageTest(){//constructor
		super();//super helps connect this with the for parent class which is the TestBase
		
	}

	@BeforeMethod
	public void setUpdriver(){
		intialization();
		loginPage = new LoginPage();
		
	}
	@Test
	public void loginPageTitleTest(){
		String title = loginPage.verifyPageTitle();
		Assert.assertEquals(title, "later will check on the web site");
		//assert its in testng allows u to capture a value and verify if its true or not
	}
	@Test (priority=2)
	public void apLogoTest(){
		boolean value = loginPage.validateAPImage();
				Assert.assertTrue(value);
	}
	
	@Test(priority=3)
	public void loginTest(){
		//getting the properties and using propt object from the testbase class and go the properties from the config properties file
		homePage = loginPage.login(propt.getProperty("username"),propt.getProperty("password"));			
	}
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
	
}


















