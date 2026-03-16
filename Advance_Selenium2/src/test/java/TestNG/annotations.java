package TestNG;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class annotations 
{

	@Test
	
	public void testcase()
	{
		Reporter.log("hello",true);
		
	}
	
	@Test
	
	public void testcase1()
	{
		Reporter.log("hello hello",true);
		
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("DB Connection", true);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("Closing DB Connection", true);
	}
	
	@BeforeClass
	public void beforeclass()
	{
		Reporter.log("Launch the browser", true);
	}
	
	@AfterClass
	public void afterclass()
	{
		Reporter.log("Close the browser",true);
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		Reporter.log("Login to an application",true);
	}
	
	@AfterMethod
	public void aftermethod()
	{
		Reporter.log("Logout to an application", true);
	}
}
