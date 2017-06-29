package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class Login_Page extends KaplanSpecificWrappers
{
	//Confirming that we are in Login Page
	public Login_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Log in")){
			reportStep("This is not Login Page", "FAIL");
		}
	}
	//Enter Username in the field
	public Login_Page enterUserName(String userName)
	{
		enterDataById(objec.getProperty("Login.EmailAddress.Id"),userName);
		return this;
	}
	//Enter Password in the field
	public Login_Page enterPassword(String password)
	{
		enterDataById(objec.getProperty("Login.Password.Id"),password);
		return this;
	}
	//Click on Login button
	public MyDetails_Page clickLogin()
	{
	   clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
	   //clickByXpath("//button[@type='submit']");
		 //clickByXPath("//button[@value='Login']");
		return new MyDetails_Page(driver,test);	
	}
	public Homepage_CIMABooks_BS_Page clickBSLogin()
	{
		 clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
		 return new Homepage_CIMABooks_BS_Page(driver,test);
	}
}
