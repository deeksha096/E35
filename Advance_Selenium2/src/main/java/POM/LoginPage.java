package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id= "username")
	private WebElement UN;
	
	public void setUN(WebElement uN) {
		UN = uN;
	}
	public void setPWD(WebElement pWD) {
		PWD = pWD;
	}
	public void setLOGINBUTTON(WebElement lOGINBUTTON) {
		LOGINBUTTON = lOGINBUTTON;
	}

	@FindBy(id = "inputPassword")
	private WebElement PWD;
	
	@FindBy(xpath = "//button[text() ='Sign in']")
	private WebElement LOGINBUTTON;
	
	public WebElement getUN()
	{
		return UN;
	}
	public WebElement getPWD()
	{
		return PWD;
	}
	public WebElement getLOGINBUTTON()
	{
		return LOGINBUTTON;
	}
	public void login(String url, String username, String password)
	{
		driver.get(url);
		UN.sendKeys(username);
		PWD.sendKeys(password);
		LOGINBUTTON.click();
		
	}
	

}


