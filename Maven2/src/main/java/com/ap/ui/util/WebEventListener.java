/*we have created this class WebDriverEventListener in order to implement interface 
is to override all the methods and define certain helpful log actions which would
be displayed/logged as the application under test is being executed. These methods will be invoked by itself automatically when certain action are performed.
Ex: click, submit, screenshot, findby, etc.
*/

package com.ap.ui.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;//built in, when u have all the jar files

import com.ap.ui.base.TestBase;
//extends for inheritance and implements for interface.using both because inheritance can't extend from package to package but interface can.
public class WebEventListener extends TestBase implements WebDriverEventListener{
	
	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigating to: '" + url + "'");
		}

		public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to:'" + url + "'");
		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the:" + element.toString() + " before any changes made");
		}

		public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to: " + element.toString());
		}

		public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on: " + element.toString());
		}

		public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on: " + element.toString());
		}

		public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigating back to previous page");
		}

		public void afterNavigateBack(WebDriver driver) {
		System.out.println("Navigated back to previous page");
		}

		public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Navigating forward to next page");
		}

		public void afterNavigateForward(WebDriver driver) {
		System.out.println("Navigated forward to next page");
		}

		public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured: " + error);
		try {
		TestUtil.takeScreenshotAt();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}

		public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
		}

		public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
		}

		/*
		* non overridden methods of WebListener class
		*/
		public void beforeScript(String script, WebDriver driver) {
		}

		public void afterScript(String script, WebDriver driver) {
		}

		public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

		}

		public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

		}

		public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

		}

		public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub

		}

		public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		// TODO Auto-generated method stub

		}

		public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

		}

		public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub

		}

		public void beforeGetText(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

		}

		public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

		}

		}


/*	public void beforeNavigate (String url, WebDriver driver){
		System.out.println("Before navi to: '" + url + "'");
		
	}
	public void afterNavigate (String url, WebDriver driver){
		System.out.println("Navigate to: '" + url + "'");
		
}
	public void beforeChangeValueof (WebElement element, WebDriver driver){
		System.out.println("Value of: " + element.toString() + "Before making any change");
		
}
	public void afterChangeValueof (WebElement element, WebDriver driver){
		System.out.println("Element Value changed to: " + element.toString());
		
}
	//clicking with be done through out the application,thats why we have a return type here.
	public void beforeClickingOn (WebElement element, WebDriver driver){
		System.out.println("Attempting to click on: " + element.toString());//.toString
		
}
	public void afterClickingOn (WebElement element, WebDriver driver){
		System.out.println("Successfully clicked on: " + element.toString());		
}
	public void beforeNavigatingback (WebDriver driver){
		System.out.println("Attempting Navigating back to the previous page");
		
}
	public void afterNavigatingback (WebDriver driver){
		System.out.println("Successfully Navigating to current page");
	}
	public void beforeNavigatingforward(WebDriver driver){
		System.out.println("Attempting Navigating forward to the next page");
		
}
	public void afterNavigatingforward(WebDriver driver){
		System.out.println("Successfully Navigating forward to the next page");
	}
	// screenshot and will also shows/captures where the error is coming up	
	public void dueToException(Throwable error, WebDriver driver){
			System.out.println("Exception occured: "+ error);
			try{
				TestUtil.takeScreenshotAt();
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		public void beforeFindBy (By by, WebElement element, WebDriver driver){
			System.out.println("Attempting to Find the Element: " + by.toString());
}
		public void afterFindBy (By by, WebElement element, WebDriver driver){
			System.out.println("Successfully Found the Element: " + by.toString());
}
		//these are non-overridden methods of the WebListener class, all the ones without the sysout println ones
		//action will be performed once.
		//what happens before running the script, we're gonna invoke the url
		public void beforeScript(String script, WebDriver driver){
	
		}
		public void afterScript(String script, WebDriver driver){
		
		}
		public void beforeAcceptingAlert(WebDriver driver){
			
		}
		public void afterAcceptingAlert(WebDriver driver){
		
		}
		public void beforeDissimissingAlert(WebDriver driver){
			
		}
		public void afterDissmissingAlert(WebDriver driver){
		
		}
		public void beforeNavigateRefresh(WebDriver driver){
			
		}
		public void afterNavigateRefresh(WebDriver driver){
		
		}
		//these methods are never overridden, only done once 
		public void beforeChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){//keysToSend is an object
			
		}
		public void afterChangeValueof(WebElement element, WebDriver driver, CharSequence [] keysToSend){
		
		}
		//screenshot is done once thats why we never override the methods 
		//u have to capture the image and then save it in an object. here we are going to output in the extent report
		//<x> here is like an object it could be called anything and its dynamic
		// only 1 arg because u're just taking the image here
		public <X> void beforeGetScreenshotAs(OutputType<X> arg0){
			
		}
		// u have 2 args here because u take the image and then u have save it
		// the image will save with its time and date taken
		
		public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1){
				
		}
		public void beforeGetText(WebElement arg0, WebDriver arg1){
			
		}
		public void afterGetText(WebElement arg0, WebDriver arg1, String arg2){
			
		}
		public void beforeSwitchToWindow(String arg0,WebDriver arg1){
			
		}
		public void afterSwitchToWindow(String arg0,WebDriver arg1){
			
		}
		
}*/
		
