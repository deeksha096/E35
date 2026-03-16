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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createcampaignwithexpecteddate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		driver = new ChromeDriver(settings); 
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("Ninza");
		driver.findElement(By.name("campaignStatus")).sendKeys("Active");
		Actions act=new Actions(driver);
		act.scrollByAmount(0, 600);
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
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg=toastmsg.getText();
		if(msg.contains("Ninza"))
		{
			System.out.println("Campaign created");
		}
		else
		{
			System.out.print("Campaign is created");
		}
		WebElement usericon=driver.findElement(By.xpath("//div[class='user-icon']"));
		act.moveToElement(usericon).click().perform();
		driver.findElement(By.xpath("//div[text()='Logout']")).click();
		driver.close();
		

	}


}

