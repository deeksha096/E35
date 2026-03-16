package Demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createcampaignwithmandatoryfield 
{
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(settings);
		
		//WebDriver driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text() ='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("NinzaCRMPProject");
		WebElement size = driver.findElement(By.name("targetSize"));
		
		size.clear();
		size.sendKeys("8");
		driver.findElement(By.xpath("//button[text() ='Create Campaign']")).click();
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		
		if(msg.contains("NinzaCRMPProject")) {
			System.out.println("campaign is created");
		}
		else {
			System.out.println("campaign is not created");
		}
		WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(usericon).click().perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout'] ")).click();
		driver.close();
	}

}

