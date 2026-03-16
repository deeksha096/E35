package product;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.CreateCAmpaignPAge;
import POM.HomePage;
import Testng.baseclass;


public class CampaignTest extends baseclass
{
	@Test (groups = "Smoke")
	public void createCampaignWithMandatoryDetailsTest() throws 
	EncryptedDocumentException, IOException 
	{
		  // reading data from excel 
		  String CAMPAIGN_NAME = 
		 elib.toReadDataFromExcelFile("CreateCampaign", 1, 2); 
		  String TARGET_SIZE = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 3); 
		  
		//homepage
		HomePage hp = new HomePage(sdriver); 
		hp.getCREATECAMPAIGN().click(); 
		
		//create Campaign
		CreateCAmpaignPAge cmp = new CreateCAmpaignPAge(sdriver); 
		  cmp.getCAMPAIGNNAME().sendKeys(CAMPAIGN_NAME); 
		  cmp.getTARGETSIZE().clear(); 
		  cmp.getTARGETSIZE().sendKeys(TARGET_SIZE); 
		  cmp.getCREATECAMPAIGN().click();
		  
		  WebElement toastmsg = hp.getTOASTMSG(); 
		  wlib.explicitwait(sdriver, toastmsg); 
		  String msg = toastmsg.getText(); 
		  if (msg.contains(CAMPAIGN_NAME)) { 
		   System.out.println("campaign created"); 
		  } else { 
		   System.out.println("campaign not created");
		  }
		
		
}
	
	@Test (groups = "Smoke")
		public void createcampaignwithstatus() throws 
		EncryptedDocumentException, IOException, InterruptedException { 
		  // reading data from excel 
		  String CAMPAIGN_NAME = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 2); 
		  String TARGET_SIZE = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 3); 
		  String STATUS = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 4);
		  
		HomePage hp = new HomePage(sdriver); 
		hp.getCREATECAMPAIGN().click(); 		
		 
		// enter Mandatory details
		
		CreateCAmpaignPAge cmp = new CreateCAmpaignPAge(sdriver); 
		  cmp.getCAMPAIGNNAME().sendKeys(CAMPAIGN_NAME); 
		  cmp.getTARGETSIZE().clear(); 
		  cmp.getTARGETSIZE().sendKeys(TARGET_SIZE); 
		  Thread.sleep(2000); 
		  cmp.getCAMPAIGNSTATUS().sendKeys(STATUS); 
		  cmp.getCREATECAMPAIGN().click(); 
		  
		  WebElement toastmsg = hp.getTOASTMSG(); 
		  wlib.selectByvisibleText(sdriver, toastmsg); 
		  String msg = toastmsg.getText(); 
		  if (msg.contains(CAMPAIGN_NAME)) { 
		   System.out.println("campaign created"); 
		  } else { 
		   System.out.println("campaign not created"); 
		  } 
	}
	
	@Test	
	public void createCampaignWithExpectedDateTest() throws EncryptedDocumentException, IOException
	{
		// reading data from excel 
		  String CAMPAIGN_NAME = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 2); 
		  String TARGET_SIZE = 
		elib.toReadDataFromExcelFile("CreateCampaign", 1, 3); 
		 
		  // create campaign 
		  HomePage hp = new HomePage(sdriver); 
		  hp.getCREATECAMPAIGN().click(); 
		 
		  // enter mandatory details 
		  CreateCAmpaignPAge cmp = new CreateCAmpaignPAge(sdriver); 
		  cmp.getCAMPAIGNNAME().sendKeys(CAMPAIGN_NAME); 
		  cmp.getTARGETSIZE().clear(); 
		  cmp.getTARGETSIZE().sendKeys(TARGET_SIZE); 
		 
		 cmp.getExpectedCloseDate().sendKeys(jlib.togetRequiredDate(30)
		); 
		  cmp.getCREATECAMPAIGN().click(); 
		   
		  //validation 
		  WebElement toastmsg = hp.getTOASTMSG(); 
		  wlib.selectByvisibleText(sdriver, toastmsg); 
		  String msg = toastmsg.getText(); 
		  if (msg.contains(CAMPAIGN_NAME)) { 
		   System.out.println("campaign created"); 
		  } else { 
		   System.out.println("campaign not created"); 
		
	}

	}
}
