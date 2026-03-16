package Testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import GenericUtility.Excelutility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import POM.HomePage;

public class baseclass {
	
	WebDriver driver=new ChromeDriver();
	public static WebDriver sdriver;
	PropertyUtility plib = new PropertyUtility();
	protected Excelutility elib = new Excelutility();
	protected JavaUtility jlib = new JavaUtility();
	protected WebDriverUtility wlib = new WebDriverUtility();

	@BeforeSuite (groups= {"smoke"})
	public void beforeSuite() {
		Reporter.log("DB Connection", true);
	}

	@AfterSuite (groups= {"smoke"})
	public void afterSuite() {
		Reporter.log("Closing DB Connection", true);
	}
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke"})
	public void beforeclass(String browser) throws IOException {
		String BROWSER = 
				plib.toReadDataFromPropertiesFile("browser"); 
		  if (BROWSER.equals("edge")) { 
		   driver = new EdgeDriver(); 
		  } else if (BROWSER.equals("chrome")) { 
		   driver = new ChromeDriver(); 
		  } else if (BROWSER.equals("firefox")) { 
		   driver = new FirefoxDriver(); 
		  } 
		  sdriver=driver;
		  driver.manage().window().maximize(); 
		  wlib.implicitwait(driver); 
		
	}

	@AfterClass
	public void afterclass() {
		driver.close();
		Reporter.log("Close the browser", true);
	}

	@BeforeMethod
	public void beforemethod() throws IOException {
		
		 String URL = plib.toReadDataFromPropertiesFile("url"); 
		  String USERNAME = 
		plib.toReadDataFromPropertiesFile("username"); 
		  String PASSWORD = 
		plib.toReadDataFromPropertiesFile("password"); 
		 driver.get(URL);
	}

	@AfterMethod
	public void aftermethod() {
		HomePage hp = new HomePage(driver); 
		WebElement usericon = hp.getUSERICON();
		wlib=clickonElement(driver,usericon);
		hp.getLOGOUT();
	}

	private WebDriverUtility clickonElement(WebDriver driver2, WebElement usericon) {
		// TODO Auto-generated method stub
		return null;
	}

}
