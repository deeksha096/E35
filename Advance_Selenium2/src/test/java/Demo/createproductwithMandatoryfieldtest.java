package Demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class createproductwithMandatoryfieldtest
{
	public static void main(String[] args)
	{
		Random rand=new Random();
		int number=rand.nextInt(1000);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); 
		driver = new ChromeDriver(settings); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		driver.findElement(By.name("productName")).sendKeys("Johnn");
		WebElement productCategory=driver.findElement(By.name("productCategory"));
		Select sel = new Select(productCategory); 
		sel.selectByVisibleText("Furniture");
		WebElement quantity=driver.findElement(By.name("quantity"));
		quantity.clear();
		quantity.sendKeys("2");
		WebElement price=driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("8000");
		WebElement vendor = driver.findElement(By.name("vendorId"));
		Select sell=new Select(vendor);
		sell.selectByVisibleText("Vendor_21041 - (Electronics)");
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		WebElement toastmsg= driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg=toastmsg.getText();
		System.out.println(msg);
		if(msg.contains("Mobile")) {
			System.out.println("product is created");
		}
		else
		{
			System.out.println("product not created");
		}
		WebElement usericon=driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act=new Actions(driver);
		act.moveToElement(usericon).click().perform();
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		logout.click();
		driver.close();
		
	}
		
}
