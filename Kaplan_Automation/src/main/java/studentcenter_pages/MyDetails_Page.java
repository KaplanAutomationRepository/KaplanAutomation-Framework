package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

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
			reportStep("This is not New MyKaplan Page", "FAIL");
		}
		}
	public Login_Page clickSignOut()
	{
		clickBylinkText(objec.getProperty("MyDetails.Signout.Link"));
		return new Login_Page(driver,test);
	}
	public MyDetails_Page clickMydetailsLink()
	{
		clickBylinkText(objec.getProperty("MyDetails.MyDetails.Link"));
		return this;
	}
	public MyDetails_Page clickPersonalDetailsEditLink() throws InterruptedException
	{
		//Thread.sleep(7000);
		clickByXpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"));
		//System.out.println(objec.getProperty("MyDetails.PersonalDetails_Edit_Xpath"));
		return this;
	}
	public MyDetails_Page editPersonalDetailsFN(String FN)
	{
		enterDataById(objec.getProperty("MyDetails.PersonalDetails_FirstName_Id"),FN);
		return this;
	}
	public MyDetails_Page editPersonalDetailsLN(String LN)
	{
		enterDataById(objec.getProperty("MyDetails.PersonalDetails_LastName_Id"),LN);
		return this;
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
}
