package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCAmpaignPAge {
	
	public CreateCAmpaignPAge(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText  = "Create Campaign")
	private WebElement CREATECAMPAIGN;
	
	@FindBy(name = "campaignName")
	private WebElement CAMPAIGNNAME;
	
	@FindBy (name= "campaignStatus")
	private WebElement CAMPAIGNSTATUS;
	
	@FindBy (name = "targetSize")
	private WebElement TARGETSIZE;
	
	@FindBy (name ="expectedCloseDate")
	private WebElement ExpectedCloseDate;
	
	@FindBy(linkText = "CreateCampaignButton")
	private WebElement BUTTON;

	public WebElement getCREATECAMPAIGN() {
		return CREATECAMPAIGN;
	}

	public void setCREATECAMPAIGN(WebElement cREATECAMPAIGN) {
		CREATECAMPAIGN = cREATECAMPAIGN;
	}

	public WebElement getCAMPAIGNNAME() {
		return CAMPAIGNNAME;
	}

	public void setCAMPAIGNNAME(WebElement cAMPAIGNNAME) {
		CAMPAIGNNAME = cAMPAIGNNAME;
	}

	public WebElement getCAMPAIGNSTATUS() {
		return CAMPAIGNSTATUS;
	}

	public void setCAMPAIGNSTATUS(WebElement cAMPAIGNSTATUS) {
		CAMPAIGNSTATUS = cAMPAIGNSTATUS;
	}

	public WebElement getTARGETSIZE() {
		return TARGETSIZE;
	}

	public void setTARGETSIZE(WebElement tARGETSIZE) {
		TARGETSIZE = tARGETSIZE;
	}

	public WebElement getExpectedCloseDate() {
		return ExpectedCloseDate;
	}

	public void setExpectedCloseDate(WebElement expectedCloseDate) {
		ExpectedCloseDate = expectedCloseDate;
	}

	public WebElement getBUTTON() {
		return BUTTON;
	}

	public void setBUTTON(WebElement bUTTON) {
		BUTTON = bUTTON;
	}
	
	

}
