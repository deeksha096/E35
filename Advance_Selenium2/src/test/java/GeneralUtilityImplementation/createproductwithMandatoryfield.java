	package GeneralUtilityImplementation;


import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.Excelutility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;


public class createproductwithMandatoryfield
{
	public static void main(String[] args) throws IOException
	{
		PropertyUtility plib = new PropertyUtility(); 
		  Excelutility elib = new Excelutility(); 
		  JavaUtility jlib = new JavaUtility(); 
		  WebDriverUtility wlib = new WebDriverUtility(); 
		 
		  // Reading data from properties file 
		  String BROWSER = 
		plib.toReadDataFromPropertiesFile("browser"); 
		  String URL = plib.toReadDataFromPropertiesFile("url"); 
		  String USERNAME = 
		plib.toReadDataFromPropertiesFile("username"); 
		  String PASSWORD = 
		plib.toReadDataFromPropertiesFile("password"); 
		 
		  // Reading data from Excel file 
		  String PRODUCT_NAME = 
		elib.toReadDataFromExcelFile("CreateProduct", 1, 0); 
		  String DROPDOWN1 = 
		elib.toReadDataFromExcelFile("CreateProduct", 1, 1); 
		  String QUANTITY = 
		elib.toReadDataFromExcelFile("CreateProduct", 1, 2); 
		  String PRICE = 
		elib.toReadDataFromExcelFile("CreateProduct", 1, 3); 
		  String DROPDOWN2 = 
		elib.toReadDataFromExcelFile("CreateProduct", 1, 4); 
		 
		  WebDriver driver = null; 
		  if (BROWSER.equals("edge")) { 
		   driver = new EdgeDriver(); 
		  } else if (BROWSER.equals("chrome")) { 
		   driver = new ChromeDriver(); 
		  } else if (BROWSER.equals("firefox")) { 
		   driver = new FirefoxDriver(); 
		  } 
		 
		  driver.manage().window().maximize(); 
		  wlib.implicitwait(driver); 
		  driver.get(URL); 
		  driver.findElement(By.id("username")).sendKeys(USERNAME); 
		 
		 driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD); 
		  driver.findElement(By.xpath("//button[text()='SignIn']")).click(); 
		  driver.findElement(By.linkText("Products")).click(); 
		  driver.findElement(By.xpath("//span[text()='Add Product']")).click(); 
		 
		 driver.findElement(By.name("productName")).sendKeys(PRODUCT_NAME + jlib.randomNumber()); 
		 
		  WebElement dropdown1 = 
		driver.findElement(By.name("productCategory")); 
		  wlib.Select(dropdown1, DROPDOWN1); 
		 
		  WebElement quantity = 
		driver.findElement(By.name("quantity")); 
		  quantity.clear(); 
		  quantity.sendKeys(QUANTITY); 
		 
		  WebElement price = driver.findElement(By.name("price")); 
		  price.clear(); 
		  price.sendKeys(PRICE); 
		 
		WebElement dropdown2 = driver.findElement(By.name("vendorId")); 
		wlib.Select(dropdown2, DROPDOWN2); 
		driver.findElement(By.xpath("//button[text()='Add']")).click(); 
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']")); 
		wlib.selectByvisibleText(driver, toastmsg); 
		String msg = toastmsg.getText(); 
		if (msg.contains(PRODUCT_NAME)) { 
		System.out.println("product are created"); 
		} else { 
		System.out.println("product not created"); 
		} 
		WebElement icon = 
		driver.findElement(By.xpath("//div[@class='user-icon']")); 
		wlib.ClickOnWebelement(driver, icon); 
		WebElement logout = driver.findElement(By.xpath("//div[text()='Logout ']")); 
		driver.findElement(By.xpath("//div[text()='Logout ']")).click(); 
		driver.quit(); 
		} 
		}