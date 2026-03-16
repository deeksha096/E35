package TestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assignment1
{	
		// TODO Auto-generated method stub
		
		@DataProvider
		
		public Object[][] Search() throws EncryptedDocumentException, IOException 
		{
			FileInputStream fis = new FileInputStream("/src\\test\\resources\\sample.xlsx");
			Workbook wb= WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet("Sheet1");
			int rowcount = sh.getLastRowNum();
			Object[][] objarr = new Object[2][2];
			
			for (int i=0; i< rowcount; i++)
			{
			
			objarr[i][0]= sh.getRow(i+1).getCell(0).getStringCellValue();
			objarr[i][1]= sh.getRow(i+1).getCell(0).getStringCellValue();
			}
			return objarr;
		}
		
		@Test(dataProvider = "Search")
		
		public void login(String Mobilebrand, String iphoneversion) throws InterruptedException {

			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
			driver.get("https://www.flipkart.com/");
			
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys(Mobilebrand);
			search.click();
			WebElement iphone16 = driver.findElement(By.xpath("//div[contains(@class, 'KzDlHZ')][1]/parent::div/following-sibling::div//div[contains(@class,'Nx9bqj _4b5DiR')]"));
					//("//div[@class='Nx9bqj _4b5DiR']/../../../..//div[text()='Apple iPhone 16 (Teal, 128 GB)']"));
			
			Thread.sleep(1000);
			System.out.println(" Output: " + iphone16.getText());
			
			driver.close();

			WebElement search2 = driver.findElement(By.name("q"));
			search2.sendKeys("Mobilebrand");
			search2.click();
			
			WebElement iphone14 = driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone 14 (Starlight, 128 GB)')][1]/parent::div/following-sibling::div//div[contains(@class,'Nx9bqj _4b5DiR')]"));
					//"//div[text()='₹54,900']/../../../..//div[text()='Apple iPhone 14 (Starlight, 128 GB)']\""));
			
			System.out.println(" output: " + iphone14.getText());


			Thread.sleep(2000);
			driver.close();
		}

}


