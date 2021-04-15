package com.valuemomentum.retail.testautomation.utils;



import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listeners implements ITestListener {

	
	protected static ExtentReports reports;
	protected static ExtentTest test;
    protected ExtentSparkReporter spark;
    
	@Override
	public void onTestStart(ITestResult result) {
		
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName() + "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//test screenshot code here
		 WebDriverHelper.captureScreenshot(result.getMethod().getMethodName());
	     test.log(Status.FAIL, "Test Failed");

		 test.addScreenCaptureFromPath("C:\\Training\\Java\\testautomation\\screenshot" + result.getMethod()
		                                                                .getMethodName()+".png");
		 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		reports = new ExtentReports();
		 spark = new ExtentSparkReporter("target/" +		
				new SimpleDateFormat("yyyy-MM-dd-hh-mm-ms").
						format(new Date()) + "reports.html");
	}
	@Override
	public void onFinish(ITestContext context) {
		reports.attachReporter(spark);
		reports.flush();
	}
	
	
	

}
