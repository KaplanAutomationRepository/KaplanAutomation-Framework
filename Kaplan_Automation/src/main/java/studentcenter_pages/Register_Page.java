package studentcenter_pages;


import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class Register_Page extends KaplanSpecificWrappers
{
	//Confirming that we are in Register Page
	public Register_Page(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Register")){
			reportStep("This is not Register Page", "FAIL");
		}
	}
	//Enter Email address in the field
	public Register_Page enterEmail(String email)
	{
		enterDataById(objec.getProperty("Register.YourEmail.Id"),email);
		return this;
	}
	//Enter Confirm email in the field
	public Register_Page enterConfirmEmail(String email)
	{
		enterDataById(objec.getProperty("Login.Password.Id"),email);
		return this;
	}
	//Click on Register button
	public CompleteRegistration_Page clickRegisterButton()
	{
	   clickByXpath(objec.getProperty("Register.Registerbutton.Xpath"));
	   return new CompleteRegistration_Page(driver, test);
	}
	
}
