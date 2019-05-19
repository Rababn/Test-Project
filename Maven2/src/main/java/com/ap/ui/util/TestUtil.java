package com.ap.ui.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ap.ui.base.TestBase;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JavaScriptConfiguration;

public class TestUtil extends TestBase {
	public static long Page_Load = 10;
	public static long Implicit_Wait = 10;

	public static String XL_SHEET_PATH = "path of the xl sheet";
	static Workbook book;// created object for the workbook
	static Sheet sheet;
	static JavascriptExecutor js;
	
	//created 2 arrays for pw and username
	public static Object[][] getTestData(String sheetName){
		FileInputStream file = null;// if the sheet is null/doesnt have any value then don't perform the action/method.
		try{//when ever u work with a file it throws an error and u have to give an exception or can use the try catch block, for file level 
			file = new FileInputStream(XL_SHEET_PATH);
			
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		try{//created try catch block for the workbook level
			book = WorkbookFactory.create(file);
			
		}catch (InvalidFormatException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		//wrote a method for the info in the sheet. 
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		//getting information based on how many row and col numbers are filled
		for(int i = 0; i< sheet.getLastRowNum(); i++){
			for(int j =0; j<sheet.getRow(0).getLastCellNum(); j++){
				data[i][j]=sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}
 //taking a screenshot, creating an object called srcfile for that file and u're naming the file.
	public  static void takeScreenshotAt() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//creating string currentDirect is an object for the user.directory(whenever talking about user directory its ur machine and project).
		String currentDirect = System.getProperty("user.dir");
		//creating a folder called screenshot and putting the time stamp on the screenshot taken and saving it in png file
		FileUtils.copyFile(srcFile, new File(currentDirect + "/screenshot/" + System.currentTimeMillis() + ".png"));			
	}
	//using jquery
	
	//method for capturing everything that's happening during the execution process.
	//when it runs it creates a applog file in ur project and shows everything what's happening and this is useful for the dev's.
	
	public static void runTimeInfo(String messageType, String message) throws Exception{
		js = (JavascriptExecutor) driver;
		js.executeScript("if (!window.JQuery){" 
		+ "varjquery = document.createElement('script'); jquery.type = 'text/javascript';"
		+"jquery,src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';" 
		+ "document.getElementsByTagName('head')[0].appendchild(jquery); " + "}");
		Thread.sleep(2000);
		
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

	
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(3000);
		//getting the message/information from the website
		js.executeScript("$ growl({ title: 'GET', message: '/'});");
		//created a logic for the msgs.
		if (messageType.equals("error")){
			js.executeScript("$growl.error({ title: 'ERROR' meesage: '"+message+"'});");
		}else if(messageType.equals("info")){
			js.executeScript("$growl.notice({ title: 'Notice', message: 'your notice message will appear here'});");	
				
		}else if(messageType.equals("warning")){
			js.executeScript("$growl.warning({ title: 'Warning!!', message: 'your warning message will appear here'});");			
	}else 
		System.out.println("Show NO Error Message");
		Thread.sleep(6000);//implicit waits don't work with javascript.
	}
}












































