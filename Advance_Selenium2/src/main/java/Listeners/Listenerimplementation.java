package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Testng.baseclass;

public class Listenerimplementation implements ITestListener
{

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	public void onTestStart(ITestResult result)
	{
		Reporter.log("Execution started", true);
	}
	
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("execution completed successfully",true);
	}
	
	@Override
	
	public void onTestFailure(ITestResult result)
	{
		Date d=new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(d);
		TakesScreenshot ts=(TakesScreenshot)baseclass.sdriver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		File perm= new File("./Screenshot/facebook_"+newdate+".jpg");
		try
		{
			FileHandler.copy(file, perm);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log("Execution skipped",true);
	}

}
