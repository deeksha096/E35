package TestNG.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testng.baseclass;

public class Listenerimplementation implements ITestListener, ISuiteListener 
{
	ExtentReports report;
	ExtentTest test;
	@Test
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("Execution started", true);
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,result.getMethod().getMethodName()+"execution started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("execution completed successfully",true);
		test.log(Status.PASS,result.getMethod().getMethodName()+"execution Completed");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testcasename = result.getMethod().getMethodName();
		test.log(Status.FAIL, result.getMethod().getMethodName() + "execution Failed");
		Date d=new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(d);
		TakesScreenshot ts=(TakesScreenshot)baseclass.sdriver;
		String file=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(file,testcasename+newdate);
		}
		

		public void onTestSkipped(ITestResult result)
		{
			Reporter.log("Execution skipped",true);
			test.log(Status.SKIP, result.getMethod() + "execution skipped");
		}
		
		@Override
		
		public void onStart(ISuite suite)
		{
			Date d=new Date();
			String newdate = d.toString().replace(" ", "_").replace(":", "_");
			ExtentSparkReporter spark=new ExtentSparkReporter("./Report/Ninza_"+newdate+"");
			spark.config().setDocumentTitle("Reports");
			spark.config().setReportName("CRMNinza");
			spark.config().setTheme(Theme.DARK);
			
			report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "window");
			report.setSystemInfo("browser", "chrome");
		}
		
		@Override
		
		public void onFinish(ISuite suite)
		{
			report.flush();
		}

}
