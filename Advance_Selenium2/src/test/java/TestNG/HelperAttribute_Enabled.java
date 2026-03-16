package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Enabled 
{
	@Test(enabled = true)

	public void hello() 
	{
		Reporter.log("hello", true);
	}

	@Test(enabled = true)

	public void GoodMorning()
	{
		Reporter.log("GoodMorning", true);
	}

	@Test(enabled = false)

	public void GoodEvening()
	{
		Reporter.log("GoodEvening", false);
	}

	@Test(enabled = true)

	public void GoodNight()
	{
		Reporter.log("GoodNight", true);
	}

}
