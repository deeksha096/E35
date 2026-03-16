package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.Excelutility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;

public class CreateCampaignWithStatus 
{
	public static void main(String[] args) throws IOException, 
	InterruptedException { 
	  PropertyUtility plib = new PropertyUtility(); 
	  Excelutility elib = new Excelutility(); 
	  WebDriverUtility wlib = new WebDriverUtility(); 
	 
	  // Reading data from properties file 
	  String BROWSER = 
	plib.toReadDataFromPropertiesFile("browser"); 
	  String URL = plib.toReadDataFromPropertiesFile("url"); 
	  String USERNAME = 
	plib.toReadDataFromPropertiesFile("username"); 
	  String PASSWORD = 
	plib.toReadDataFromPropertiesFile("password"); 
	 
	  // reading data from excel 
	  String CAMPAIGN_NAME = 
	elib.toReadDataFromExcelFile("CreateCampaign", 1, 2); 
	  String TARGET_SIZE = 
	elib.toReadDataFromExcelFile("CreateCampaign", 1, 3); 
	  String STATUS = 
	elib.toReadDataFromExcelFile("CreateCampaign", 1, 4); 
	 
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
	 
	  // login 
	  LoginPage lp = new LoginPage(driver); 
	  lp.getUN().sendKeys(USERNAME); 
	  lp.getPWD().sendKeys(PASSWORD); 
	  lp.getLOGINBUTTON().click(); 
	 
	  // create campaign 
	  HomePage hp = new HomePage(driver); 
	  hp.getCREATECAMPAIGN().click(); 
	 
	  // enter mandatory details 
	  CreateCAmpaignPAge cmp = new CreateCAmpaignPAge(driver); 
	  cmp.getCAMPAIGNNAME().sendKeys(CAMPAIGN_NAME); 
	  cmp.getTARGETSIZE().clear(); 
	  cmp.getTARGETSIZE().sendKeys(TARGET_SIZE); 
	  Thread.sleep(2000); 
	  cmp.getCAMPAIGNSTATUS().sendKeys(STATUS); 
	  cmp.getCREATECAMPAIGN().click(); 
	 
	  // validation 
	  WebElement toastmsg = hp.getTOASTMSG(); 
	  wlib.selectByvisibleText(driver, toastmsg); 
	  String msg = toastmsg.getText(); 
	  if (msg.contains(CAMPAIGN_NAME)) { 
	   System.out.println("campaign created"); 
	  } else { 
	   System.out.println("campaign not created"); 
	  } 
	 
	  // logout 
	  WebElement icon = hp.getUSERICON(); 
	  wlib.ClickOnWebelement(driver, icon); 
	  hp.getLOGOUT().click(); 
	  driver.quit(); 
	 } 
	 
}
