package Batchexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo5 {

@Test
	public void myntra()
	{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

	}

}
