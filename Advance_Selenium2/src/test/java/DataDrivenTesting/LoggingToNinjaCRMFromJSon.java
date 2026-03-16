package DataDrivenTesting;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggingToNinjaCRMFromJSon {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		JSONParser jsonparse=new JSONParser();
		FileReader reader=new FileReader("./src\\test\\resources\\NinjaCRMlogindata.json");
		Object javaobj=jsonparse.parse(reader);
		JSONObject obj=(JSONObject)javaobj;
		String value=obj.get("browser").toString();
		System.out.println(value);
		String Url = obj.get("url").toString();
		System.out.println(Url);
		String name = obj.get("username").toString();
		System.out.println(name);
		String pwd=obj.get("password").toString();
		System.out.println(pwd);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(Url);
		driver.findElement(By.id("username")).sendKeys(name);
		driver.findElement(By.id("inputPassword")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		
	}

}
