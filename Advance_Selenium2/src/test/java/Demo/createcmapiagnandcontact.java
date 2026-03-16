package Demo;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class createcmapiagnandcontact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		driver = new ChromeDriver(settings); 
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Earth");
		driver.findElement(By.name("campaignStatus")).sendKeys("Active");
		WebElement  size=driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys("8");
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, 15);
		String expecteddate= sim.format(cal.getTime());
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[text()=\'Contacts\']")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		driver.findElement(By.name("organizationName")).sendKeys("Qspid");
		driver.findElement(By.name("title")).sendKeys("Training");
		driver.findElement(By.name("contactName")).sendKeys("Rosy");
		driver.findElement(By.name("mobile")).sendKeys("9876543212");
		driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.id("search-criteria")).click();
		 
	}

}
