package Assertion;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class ifelseProgram {
	
	@Test
	public void sample() {
		// TODO Auto-generated method stub
		String ExpectedTitle= "Insta";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		if(ExpectedTitle.equals(actualtitle))
		{
			System.out.println("pass");
		}
		else {
		System.out.println("fail");
		}

	}

}
