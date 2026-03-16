package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HelperAttribute_Dataprovider 
{
	@DataProvider
	
	public Object[][] logindetail()
	{
	
	Object[][] objarr = new Object[3][2];
	
	objarr[0][0]= "Dee";
	objarr[0][1]= "dee@123";
	
	objarr[1][0]= "vik";
	objarr[1][1] = "vik@123";
	
	objarr[2][0] = "Sonu";
	objarr[2][1]= "sonu@123";
	return objarr;
	}
	
	@Test(dataProvider = "logindetail")
		
		public void login(String un, String pwd) throws InterruptedException
		{
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://49.249.28.218:8098/");
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2000);
			driver.close();
		}
}
	
	
