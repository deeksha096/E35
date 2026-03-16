package TestNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TakeScreenShot 
{
	@Test
	public void sample() throws IOException 
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.facebook.com/");
	Date d=new Date();
	String newdate = d.toString().replace(" ", "_").replace(":", "_");
	System.out.println(d);
	TakesScreenshot ts=(TakesScreenshot)driver;
	File file=ts.getScreenshotAs(OutputType.FILE);
	File perm= new File("./Screenshot/facebook_"+newdate+".jpg");
	FileHandler.copy(file, perm);
	
	}
	
	
}
