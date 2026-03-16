package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementreferencewithoutPOM {
 
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8098/");
		WebElement UN=driver.findElement(By.id("username"));
		UN.sendKeys("rmgyantra");
		WebElement PWD=driver.findElement(By.id("inputPassword"));
		PWD.sendKeys("rmgy@9999");
		WebElement button=driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		driver.navigate().refresh();
		UN.sendKeys("rmgyantra");
		PWD.sendKeys("rmgy@9999");
		button.click();
	}
}
