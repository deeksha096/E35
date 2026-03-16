package Assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
	@Test
	
	public void sample()
	{		
			
			// TODO Auto-generated method stub
			String ExpectedTitle= "Insta";
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.instagram.com/");
			String actualtitle = driver.getTitle();
			System.out.println(actualtitle);
			Assert.assertEquals(actualtitle, ExpectedTitle);
			System.out.println("step1");
	}

}
