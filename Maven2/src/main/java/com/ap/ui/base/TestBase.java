package com.ap.ui.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ap.ui.util.TestUtil;
import com.ap.ui.util.WebEventListener;

public class TestBase {//setting the property value 
	public static WebDriver driver;
	public static Properties propt;
	public static EventFiringWebDriver en_driver;//initiates the webdriver
	public static WebEventListener eventListener;//sends the event thats takes place in the extent reporter
	
	public TestBase(){//constructor-blueprint,same name as the class
		try{//using try catch instead of the throw IOexception
			propt = new Properties();//creating an object for the properties
			FileInputStream ipa = new FileInputStream(System.getProperty("user.dir")+ "/Automation2/src/main/java/com/ap/ui/config/config.properties"); 
			//fileinputstream is reading the file, user dir is , path of the file
			propt.load(ipa);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void intialization(){//method
		String browserName = propt.getProperty("browser");//created string value
		if (browserName.equalsIgnoreCase("chrome")){//naming the browser
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/src/main/resources/drivers/chromedriver.exe");	//setting the chrome path
			driver = new ChromeDriver();//calling the chrome driver
		}
		//else if(browserName.equalsIgnoreCase("FF")){
		//	System.setProperty("webdriver.gecko.driver","");
		//	driver = new FirefoxDriver();
			
		//}
		//else if (browserName.equalsIgnoreCase("IE")){
		//	System.setProperty("webdriver.ie.driver", "")// internet driver and path 
		//	driver = new InternetExplorerDriver();
		//}
		////creating object for action that occurring and sharing with driver 
		en_driver = new EventFiringWebDriver(driver);//creating an object because, instead of calling the driver u can call the object quickly, assert, verify, passed fail 
		//en_driver creating object of webevent listener to register it with eventfiring webdriver 
		eventListener = new WebEventListener();// object holding information, events(the passed, or failed).
		//event can be captured based on the method we create webeventlistener class
		en_driver.register(eventListener);
		//since we driver object is for browser en_driver is for event. we declaringthat they are equal to each when they are exchanging the information.
		driver = en_driver;
		
		driver.manage().window().maximize();//maximizing the window
		driver.manage().deleteAllCookies();// deleting all cookies
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_Load, TimeUnit.SECONDS);
		
		driver.get(propt.getProperty("url"));
	
	
	}
}
