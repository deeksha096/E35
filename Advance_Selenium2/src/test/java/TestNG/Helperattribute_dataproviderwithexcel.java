package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Helperattribute_dataproviderwithexcel
{

		@DataProvider
		
		public Object[][] logindetail() throws EncryptedDocumentException, IOException
		{
			
		FileInputStream fis = new FileInputStream("./src\\test\\resources\\sample.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet3");
		int rowcount = sh.getLastRowNum();
		Object[][] objarr = new Object[2][2];
		
		for (int i=0; i< rowcount; i++)
		{
		
		objarr[i][0]= sh.getRow(i+1).getCell(0).getStringCellValue();
		objarr[i][1]= sh.getRow(i+1).getCell(0).getStringCellValue();
		}
		return objarr;
		}
		
		@Test(dataProvider = "logindetail")
			
			public void login(String un, String pwd) throws InterruptedException
			{
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("http://49.249.28.218:8098/");
				driver.findElement(By.id("username")).sendKeys(un);
				driver.findElement(By.name("password")).sendKeys(pwd);
				Thread.sleep(2000);
				driver.close();
			}
	}
		
		

