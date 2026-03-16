package POM;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {

		public ProductPage(WebDriver driver) {
			PageFactory.initElements(driver , this);
		}
		
		@FindBy (xpath="//span[text()='Create Campaign")
		private  WebElement CN;

		@FindBy (xpath=("//span[text()='Add Product']"))
		private  WebElement ADDPRODUCT;

		@FindBy (name=("productName"))
		private  WebElement PRODUCTNAME;

		@FindBy (name=("productCategory"))
		private  WebElement PROCATEGORY;
		
		@FindBy (name=("quantity"))
		private  WebElement QUALITY;
		
		@FindBy (name=("price"))
		private  WebElement PRICE;
		
		@FindBy (name=("vendorId"))
		private  WebElement VENDORID;
		
		@FindBy (xpath=("//button[@type='submit']"))
		private  WebElement SUBMIT;
		
		@FindBy (xpath=("//div[@role='alert']"))
		private  WebElement TOASTMSG;
		
		@FindBy (xpath=("//div[@class='dropdown-item logout']"))
		private  WebElement LOGOUT;


		WebElement getADDPRODUCT() {
			return ADDPRODUCT;
		}

		WebElement getPRONAME() {
			return PRODUCTNAME;
		}

		WebElement getPROCAT() {
			return PROCATEGORY;
		}

		WebElement getQUALITY() {
			return QUALITY;
		}

		 WebElement getPRICE() {
			return PRICE;
		}

		WebElement getVENDORID() {
			return VENDORID;
		}

		WebElement getSUBMIT() {
			return SUBMIT;
		}

		
}

