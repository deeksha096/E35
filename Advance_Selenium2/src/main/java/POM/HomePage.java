package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Campaigns")
	private WebElement CAMPAIGN;
	
	@FindBy(linkText = "Products")
	private WebElement PRODUCT;
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement CREATECAMPAIGN;
	
	@FindBy(className = "user-icon")
	private WebElement USERICON;
	
	@FindBy(xpath = "//div[text()='Logout']")
	private WebElement LOGOUT;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement TOASTMSG;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement CLOSEMSG;

	public WebElement getCAMPAIGN() {
		return CAMPAIGN;
	}

	public void setCAMPAIGN(WebElement cAMPAIGN) {
		CAMPAIGN = cAMPAIGN;
	}

	public WebElement getPRODUCT() {
		return PRODUCT;
	}

	public void setPRODUCT(WebElement pRODUCT) {
		PRODUCT = pRODUCT;
	}

	public WebElement getCREATECAMPAIGN() {
		return CREATECAMPAIGN;
	}

	public void setCREATECAMPAIGN(WebElement cREATECAMPAIGN) {
		CREATECAMPAIGN = cREATECAMPAIGN;
	}

	public WebElement getUSERICON() {
		return USERICON;
	}

	public void setUSERICON(WebElement uSERICON) {
		USERICON = uSERICON;
	}

	public WebElement getLOGOUT() {
		return LOGOUT;
	}

	public void setLOGOUT(WebElement lOGOUT) {
		LOGOUT = lOGOUT;
	}

	public WebElement getTOASTMSG() {
		return TOASTMSG;
	}

	public void setTOASTMSG(WebElement tOASTMSG) {
		TOASTMSG = tOASTMSG;
	}

	public WebElement getCLOSEMSG() {
		return CLOSEMSG;
	}

	public void setCLOSEMSG(WebElement cLOSEMSG) {
		CLOSEMSG = cLOSEMSG;
	}

}
