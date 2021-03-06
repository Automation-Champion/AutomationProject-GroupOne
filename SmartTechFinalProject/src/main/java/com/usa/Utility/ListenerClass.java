package com.usa.Utility;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.usa.Parent.Parent;

public class ListenerClass extends Utility implements ITestListener {

	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Utility.Screenshot(result.getMethod().getMethodName());
		
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
	
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
		

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		
		

		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/ExtentReport/Myreport.html" + " "+ timestamp);

	
		extent = new ExtentReports();

		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA Student");
		extent.setSystemInfo("Group Name", "Group One");
		extent.setSystemInfo("Project Name", "Zoopla Project");
		htmlreporter.config().setDocumentTitle("Group One Zoopla Test Report");
		htmlreporter.config().setReportName("Login & Homepage Test Report");
		htmlreporter.config().setTheme(Theme.DARK);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();

	}
}
