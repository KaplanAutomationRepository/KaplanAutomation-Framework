package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class Addresses_Page extends KaplanSpecificWrappers{
	//Confirming that we are in AccountHome Page
		public Addresses_Page(RemoteWebDriver driver, ExtentTest test){
			
			this.driver = driver;
			this.test = test;
			if(!verifyTitleContains("Addresses")){
				reportStep("This is not Addresses Page", "FAIL");
			}
		}
		public  Addresses_Page clickEditLinkofHome()
		{
			clickByXpath(objec.getProperty("Address.Homeadr.Edit.Xpath"));
			return this;
		}
		public  Addresses_Page clickEditLinkofDelivery()
		{
			clickByXpath(objec.getProperty("Address.Deliveryadr.Edit.Xpath"));
			return this;
		}
		public  Addresses_Page enterAddressLine1Home(String address)
		{
			enterDataById (objec.getProperty("Address.Homeadr.AddressLine1.Id"),address);
			return this;
		}
		public  Addresses_Page enterCityHome(String city)
		{
			enterDataById (objec.getProperty("Address.Homeadr.City.Id"),city);
			return this;
		}
		public  Addresses_Page enterPincodeHome(String pincode)
		{
			enterDataById (objec.getProperty("Address.Homeadr.PCode.Id"),pincode);
			return this;
		}
		public  Addresses_Page clickonUpdateDetailsHome() throws InterruptedException
		{
			clickByXpathNoSnap (objec.getProperty("Address.Homeadr.UpdateDetails.Xpath"));
			Thread.sleep(5000);
			clickByXpathNoSnap (objec.getProperty("MyDetails.ContactInfo_Backbutton.Xpath"));
			/*WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.alertIsPresent());
			acceptAlert();*/
			return this;
		}
		public  Addresses_Page enterAddressLine1Delivery(String address)
		{
			enterDataById (objec.getProperty("Address.Deladr.AddressLine1.Id"),address);
			return this;
		}
		public  Addresses_Page enterCityDelivery(String city)
		{
			enterDataById (objec.getProperty("Address.Deladr.City.Id"),city);
			return this;
		}
		public  Addresses_Page enterPincodeDelivery(String pincode)
		{
			enterDataById (objec.getProperty("Address.Deladr.PCode.Id"),pincode);
			return this;
		}
		public  Addresses_Page clickonUpdateDetailsDelivery() throws InterruptedException
		{
			clickByXpathNoSnap (objec.getProperty("Address.Deladr.UpdateDetails.Xpath"));
			Thread.sleep(5000);
			clickByXpathNoSnap (objec.getProperty("MyDetails.ContactInfo_Backbutton.Xpath"));
			
			/*WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println(getAlertText());
			acceptAlert();*/
			return this;
		}
		
}