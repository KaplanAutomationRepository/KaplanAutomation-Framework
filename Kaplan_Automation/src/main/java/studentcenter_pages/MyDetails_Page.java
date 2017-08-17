package studentcenter_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class MyDetails_Page extends KaplanSpecificWrappers{
	
	public MyDetails_Page(RemoteWebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		Boolean bLog = false, bSnap=false;
		if(!(verifyTitleContains("New MyKaplan", bSnap, bLog) || verifyTitleContains("Account home", bSnap, bLog)))
		{
			reportStep("This is not New MyKaplan Page or Account Home Page", "FAIL");
		}
		}
	public Login_Page clickSignOut()
	{
		clickBylinkText(objec.getProperty("MyDetails.Signout.Link"));
		return new Login_Page(driver,test);
	}
	public Addresses_Page clickonAddresses()
	{
		clickBylinkText(objec.getProperty("MyDetails.Address.Link"));
		return new Addresses_Page(driver,test);
	}
	public ChangePassword_Page clickonChangePassword()
	{
		clickBylinkText(objec.getProperty("MyDetails.ChangePassword.Link"));
		return new ChangePassword_Page(driver,test);
	}
	public MyDetails_Page clickMydetailsLink()
	{
		clickBylinkText(objec.getProperty("MyDetails.MyDetails.Link"));
		return this;
	}
	public MyDetails_Page clickPersonalDetailsEditLink() throws InterruptedException
	{
		Thread.sleep(10000);
	   // new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(By.xpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"))));
		/*if (driver.findElement(By.xpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"))).isDisplayed() && driver.findElement(By.xpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"))).isEnabled())
		{
			clickByXpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"));
		}*/
		clickByXpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"));
		return this;
	}
	//To edit FirstName 
	public MyDetails_Page editPersonalDetailsFN(String FN)
	{
		enterDataById(objec.getProperty("MyDetails.PersonalDetails_FirstName.Id"),FN);
		return this;
	}
	//To edit LastName
	public MyDetails_Page editPersonalDetailsLN(String LN)
	{
		enterDataById(objec.getProperty("MyDetails.PersonalDetails_LastName.Id"),LN);
		return this;
	}
	//To Click on Update Details
		public MyDetails_Page clickOnUpdateDetails() throws InterruptedException
		{
			Thread.sleep(8000);
			if (driver.findElement(By.xpath(objec.getProperty("MyDetails.PersonalDetails_UpdateMyDetailsbutton.Xpath"))).isDisplayed() && driver.findElement(By.xpath(objec.getProperty("MyDetails.PersonalDetails_UpdateMyDetailsbutton.Xpath"))).isEnabled())
			{
				clickByXpathNoSnap(objec.getProperty("MyDetails.PersonalDetails_UpdateMyDetailsbutton.Xpath"));	
			}		
			//WebDriverWait wait = new WebDriverWait(driver, 15);
		    //wait.until(ExpectedConditions.alertIsPresent());
			//getAlertText();
			//acceptAlert();
			return this;
		}
	
	//To click on edit link under contact info
	public MyDetails_Page clickContactInfoEditLink() throws InterruptedException
	{
		Thread.sleep(15000);
		//new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.xpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"))));
		clickByXpath(objec.getProperty("MyDetails.ContactInfo_Edit.Xpath"));
		//System.out.println(objec.getProperty("MyDetails.PersonalDetails_Edit_Xpath"));
		return this;
	}
	//To Edit the mobilenumber
	public MyDetails_Page editMobileNum(String mobnum)
	{
		enterDataById(objec.getProperty("MyDetails.ContactInfo_MobileNumber.Id"),mobnum);
		return this;
	}
	public MyDetails_Page editWorkEmail(String email)
	{
		enterDataById(objec.getProperty("MyDetails.ContactInfo_WorkEmail.Id"),email);
		return this;
	}
	public MyDetails_Page editWorkNumber(String workNumber)
	{
		enterDataById(objec.getProperty("MyDetails.ContactInfo_WorkNumber.Id"),workNumber);
		return this;
	}
	public MyDetails_Page editHomeNumber(String homeNumber)
	{
		enterDataById(objec.getProperty("MyDetails.ContactInfo_HomeNumber.Id"),homeNumber);
		return this;
	}
	public MyDetails_Page selectPreferredQualification(String qualification)
	{
		selectVisibileTextByXPath(objec.getProperty("MyDetails.ContactInfo_PreferredQualification.Xpath"),qualification);
		return this;
	}
	public MyDetails_Page clickUpdateDetailsContactinfo() throws InterruptedException
	{
		Thread.sleep(5000);
		clickByXpath(objec.getProperty("MyDetails.ContactInfo_PreferredQualification.Xpath"));
		return this;
	}
	public OrderHistory_Page clickOrderHistory()
	{
		clickBylinkText(objec.getProperty("MyDetails.OderHistory.Link"));
		return new OrderHistory_Page(driver,test);
	}
	
}
