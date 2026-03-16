package Batchexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class demo4 {

	@Test
	
	public void ajio()
	{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();

	}

}
