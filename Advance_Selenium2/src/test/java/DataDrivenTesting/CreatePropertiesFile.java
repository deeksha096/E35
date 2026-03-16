package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CreatePropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("./src\\test\\resources\\Facebook.properties");
		Properties prop=new Properties();
		prop.load(file);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String Pass = prop.getProperty("password");
		//System.out.println(Browser);
		//System.out.println(URL);
		//System.out.println(USERNAME);
		//System.out.println(Pass);
		
		WebDriver driver = null;
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
			
		} else if (BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(Pass);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		

	}

}
