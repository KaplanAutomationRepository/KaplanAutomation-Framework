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
	
}
