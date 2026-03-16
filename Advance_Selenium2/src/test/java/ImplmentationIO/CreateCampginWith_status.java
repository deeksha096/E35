package ImplmentationIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateCampginWith_status {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\commondata.properties");
		Properties prop = new Properties(); 
		prop.load(fis);
		String BROWSER = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("src\\test\\resources\\sample.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("sample");
		String CAMPAIGNNAME = sh.getRow(1).getCell(1).getStringCellValue();
		String TARGETSIZE = sh.getRow(1).getCell(2).getStringCellValue();
		String STATUS = sh.getRow(1).getCell(3).getStringCellValue();
	
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else if (BROWSER.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		driver.findElement(By.xpath("//span[text() ='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGNNAME);
		driver.findElement(By.name("campaignStatus")).sendKeys(STATUS);
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys(TARGETSIZE);
		driver.findElement(By.xpath("//button[text() ='Create Campaign']")).click();
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(12));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		
		if (msg.contains("DeeProject")) {
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



