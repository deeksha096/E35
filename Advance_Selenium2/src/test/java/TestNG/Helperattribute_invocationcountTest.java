package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Helperattribute_invocationcountTest
{
	@Test(invocationCount=5)
	
	public void sampletest()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		String Title= driver.getTitle();
		Reporter.log(Title,true);
		
	}

}
