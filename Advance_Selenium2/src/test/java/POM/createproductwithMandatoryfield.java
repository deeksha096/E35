package POM;



import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.Excelutility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;

public class createproductwithMandatoryfield 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		PropertyUtility plib = new PropertyUtility(); 
		Excelutility elib = new Excelutility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = plib.toReadDataFromPropertiesFile("browser");
		String URL = plib.toReadDataFromPropertiesFile("url");
		String USERNAME = plib.toReadDataFromPropertiesFile("username");
		String PASSWORD = plib.toReadDataFromPropertiesFile("password");
		
		String PRODUCTNAME = elib.toReadDataFromExcelFile("Sheet5", 1, 1);
		String PRODUCTCATEGORY = elib.toReadDataFromExcelFile("Sheet5", 1, 2);
		String QUANTITY = elib.toReadDataFromExcelFile("Sheet5", 1, 3);
		String PRICE = elib.toReadDataFromExcelFile("Sheet5", 1, 4);
		String VENDOR = elib.toReadDataFromExcelFile("Sheet5", 1, 5);


		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs= new HashMap<>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs);
		WebDriver driver = null;
		if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver = new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPWD().sendKeys(PASSWORD);
		lp.getLOGINBUTTON().click();
		
	    HomePage hp = new HomePage(driver);
	    hp.getPRODUCT().click();
	    
	    ProductPage pg = new ProductPage(driver);
	    pg.getADDPRODUCT().click();
	    pg.getPRONAME().sendKeys(PRODUCTNAME);
	    
	    WebElement category = pg.getPROCAT();
	    wlib.selectByvisibleText(category, PRODUCTCATEGORY);
	    WebElement qty = pg.getQUALITY();
	    qty.clear();
	    qty.sendKeys(QUANTITY);
	    
		WebElement pricefield = pg.getPRICE();
		pricefield.clear();
		pricefield.sendKeys(PRICE);
	    
		WebElement vendor = pg.getVENDORID();
		wlib.selectByvisibleText(vendor, VENDOR);
		pg.getSUBMIT().click();
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains(msg)) {
		System.out.println("product is created");
	}
	else {
		System.out.println("product is not created");
	}
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act = new Actions(driver);
		act.moveToElement(icon).click().perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.close();
		
		
	
	}
}