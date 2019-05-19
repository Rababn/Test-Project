package com.ap.ui.ExtentReport.Listener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterN implements IReporter{
			/**This interface can be implemented by clients to generate a report.  Its method
			 * generateReport() will be invoked after all the suite have run and the parameters
			 * give all the test results that happened during that run.
			 */
private ExtentReports extent;
			/**so that the result is private
		 		*The type ExtentReporterN must implement the inherited abstract method IReporter.generateReport(List<XmlSuite>, List<ISuite>, String)
			 * generateReport is a built in method that 
			 * creating a method, use List to contain array, create a xml file which will have all the classes,
			 * that has methods, testcases, so it will
			 * generate a report on those methods, that is passing/failing/skipping
			 * It needs to be string
			*/
public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, String outPutDirectory){
		
			/**outPutDirectory will have all the status, pass/fail/skip
			 * creating an object for extent, creating a virtual obj to save the ouput
			 * .separator = Generate a report for the given suites into the specified output directory.
			 * it doesn't matter how I received the result,(linux/xml/language), the extent report file should be saved under "Extent.html" name, 
			 * so it can be opened from anywhere(mobile/web)
			 * true= sometime running the result, if there's no result, don't generate the report, 
			 * true makes sure to generate report only when there's a result
			 */
		
extent = new ExtentReports(outPutDirectory + File.separator + "Extent.html", true);
			/**ISuite contains all classes, it obtain a key value , it can't be duplicated, then it will map it to one
			 * location, the location is (in our case) ExtentReort, key value is the status (pass.fail/skip)that is interface
			 * go back to class, print fail to the class, if the method inside the class failed
			 * suite is for the object that I'm creating,
			 * ISuite suite : suites - saying if this script should be able to run multiple; if i run one class/two,it's going to give
			 * all the operators
			 */
for(ISuite suite : suites){ 
   Map<String, ISuiteResult>result = suite.getResults();
			/**the value needs to have context, the contest- the script, when it ran, we'll get a result
			 */
	for(ISuiteResult r : result.values()){
			/**This class represents the result of a suite run.
				*This class defines a test context which contains all the information
			 * for a given test run.  An instance of this context is passed to the
			 * test listeners so they can query information about their
			 * environment.*/
			ITestContext context = r.getTestContext();	
			buildTestNodes(context.getPassedTests(), LogStatus.PASS);
			buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
			buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
	}	
	extent.flush();//when the execution is done, adding the result and attach it to the HTML file 
	extent.close();
}
private void buildTestNodes(IResultMap tests, LogStatus status){
			//the constructor, and calling ExtentTest as test	
	ExtentTest test;
	if(tests.size()>0){
			/**if the result is there, 
			 * 
			 */			
		for(ITestResult result : tests.getAllResults()){
			test = extent.startTest(result.getMethod().getMethodName());
			
			test.setStartedTime(getTime(result.getStartMillis()));
			test.setEndedTime(getTime(result.getEndMillis()));
			 //to get the result and time
			for(String group : result.getMethod().getGroups())
				test.assignCategory(group);
			// going through all the results, organize them according to the status 		
			if(result.getThrowable() !=null){
				test.log(status, result.getThrowable());
				/** null is an empty string
				 * to log all the error
				 */				
		}else {
			//if the test doesn't fail, it will print the status
			test.log(status, "Test"+status.toString().toLowerCase()+"ed");
		}
			extent.endTest(test);
		}
	}
	}	
	private Date getTime(long millis){
		Calendar calender = Calendar.getInstance();
		calender.setTimeInMillis(millis);
		return calender.getTime();
	}	
	}
