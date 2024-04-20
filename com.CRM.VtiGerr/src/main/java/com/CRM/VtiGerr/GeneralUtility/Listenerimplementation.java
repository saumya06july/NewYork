package com.CRM.VtiGerr.GeneralUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplementation implements ITestListener{
	ExtentReports reports;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Execution Started");
		test=reports.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Execution Pass");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Execution Fail");
		WebdriverUtility wutil=new WebdriverUtility();
		JavaUtility jutil=new JavaUtility();
		String ScreenshotName = jutil.getModifiedgetSysdate();
		test.log(Status.INFO, result.getThrowable());
		try {
			String path = wutil.screenshot(Baseclass.sdriver,ScreenshotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Execution Skipped");
		test.log(Status.INFO, result.getThrowable());
				
	}

	public void onStart(ITestContext context) {
		
		System.out.println("Suite level Execution started");
		//System Cofiguration
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./Extentreport\\Report-"+new JavaUtility().getModifiedgetSysdate()+".html");
		
		htmlreport.config().setDocumentTitle("ExtentReports");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Vtiger Execution Report");
		//Report Configuration
		reports=new ExtentReports();
		reports.attachReporter(htmlreport);
		reports.setSystemInfo("baseurl", "http\\://localhost\\:8888");
		reports.setSystemInfo("platform", "windows");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("reporterName", "Soumya Ranjan Behera");
		
		
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Suite level Execution finished");
		//To generate report
		reports.flush();
		
	}
	
	

}
