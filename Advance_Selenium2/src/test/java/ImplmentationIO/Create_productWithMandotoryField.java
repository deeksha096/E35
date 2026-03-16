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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_productWithMandotoryField {

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
			String PRODUCTNAME = sh.getRow(1).getCell(4).getStringCellValue();
			String QUANTITY = sh.getRow(1).getCell(5).getStringCellValue();
			String PRICE = sh.getRow(1).getCell(6).getStringCellValue();
			String VENDOR = sh.getRow(1).getCell(7).getStringCellValue();
			String PRODUCTCAT = sh.getRow(1).getCell(8).getStringCellValue();
			
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
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.xpath("//span[text() ='Add Product']")).click();
			driver.findElement(By.name("productName")).sendKeys(PRODUCTNAME);
			WebElement productCategory = driver.findElement(By.name("productCategory"));
			Select sel = new Select(productCategory);
			sel.selectByVisibleText(PRODUCTCAT);
			WebElement quantity = driver.findElement(By.name("quantity"));
			quantity.clear();
			quantity.sendKeys(QUANTITY);
			WebElement price = driver.findElement(By.name("price"));
			price.clear();
			price.sendKeys(PRICE);
			WebElement vendor = driver.findElement(By.name("vendorId"));
			Select ven1 = new Select(vendor);
			ven1.selectByVisibleText(VENDOR);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(toastmsg));
			String msg = toastmsg.getText();
			System.out.println(msg);
			if(msg.contains(PRODUCTNAME)) {//yes mam
				System.out.println("Product is created");
			}
			else {
				System.out.println("Product is not created");
				
			}
			WebElement usericon = driver.findElement(By.xpath("//div[@class='user-icon']"));
			
			Actions act=new Actions(driver);
			act.moveToElement(usericon).click().perform();
			driver.findElement(By.xpath("//div[@class='dropdown-item logout'] ")).click();
			driver.close();
			
		}

	}