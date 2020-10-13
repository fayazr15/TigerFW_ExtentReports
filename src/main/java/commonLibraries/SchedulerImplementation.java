package commonLibraries;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


/**
 * @code This Class is used to capture the failed testCases Screenshot
 * @author Fayaz
 *
 */
public class SchedulerImplementation implements ITestListener
{

	ExtentReports extent = ConfigFiles.extentReportGenerator();
	ExtentTest test;
	
//	  Thread Safe to avoid overriding of TestCases when executed parallel
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result)
	{
		 test = extent.createTest(result.getMethod().getMethodName());
//		 To  store test object in extentTest
		 extentTest.set(test);
		 extentTest.get().log(Status.INFO, result.getName()+" is Started");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, result.getName()+" is Pass");
		
	}

	public void onTestFailure(ITestResult result) {
		
		
//		To get test from extentTest  " extentTest.get()=test"
		
		 extentTest.get().fail(result.getThrowable());
		 
//		 Screenshot and attach to report
				try {
					extentTest.get().addScreenCaptureFromPath(Screenshot.getSceenshotPath(result.getMethod().getMethodName(),ConfigFiles.driver), result.getMethod().getMethodName());
				} catch (IOException e) {
					e.printStackTrace();
				} 
			
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, result.getName()+" is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
