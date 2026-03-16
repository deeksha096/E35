package GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void toMaximise(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void scroll(Actions action)
	{
		action.scrollByAmount(0, -500);
	}
	public void move(Actions action)
	{
		action.moveByOffset(454, 200);
	}
	public void explicitwait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).click();
	}
	public void doubleClickonElement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void contextClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void selectByvisibleText(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	public void ClickOnWebelement(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.click();
	}
	
	
	public void selectByIndex(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String value)
	{
		driver.switchTo().frame(value);
	}
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertandSendKeys(WebDriver driver,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	public void Select(WebElement dropdown2, String dropdown) {
		// TODO Auto-generated method stub
		Select sel=new Select(dropdown2);
		sel.selectByValue(dropdown);
		
	}
	public void selectByvisibleText(WebDriver driver, WebElement toastmsg) {
		// TODO Auto-generated method stub
		Select sel=new Select(toastmsg);
	}
	

	
	
}

