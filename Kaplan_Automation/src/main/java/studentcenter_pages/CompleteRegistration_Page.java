package studentcenter_pages;


import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class CompleteRegistration_Page extends KaplanSpecificWrappers
{
	//Confirming that we are in Complete Registration Page
	public CompleteRegistration_Page(RemoteWebDriver driver, ExtentTest test){
		
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Complete registration")){
			reportStep("This is not Complete Registration Page", "FAIL");
		}
	}
	//Enter FirstName in the field
	public CompleteRegistration_Page enterFirstName(String FN)
	{
		enterDataById(objec.getProperty("CompleteRegistration.FirstName.Id"),FN);
		return this;
	}
	//Enter LastName in the field
	public CompleteRegistration_Page enterLastName(String LN)
	{
		enterDataById(objec.getProperty("CompleteRegistration.LastName.Id"),LN);
		return this;
	}
	//Enter MobileNumber in the field
		public CompleteRegistration_Page enterMobileNumber(String mobnum)
		{
			enterDataById(objec.getProperty("CompleteRegistration.MobileNumber.Id"),mobnum);
			return this;
		}
	//Enter Password in the field
			public CompleteRegistration_Page enterPassword(String password)
			{
				enterDataById(objec.getProperty("CompleteRegistration.Password.Id"),password);
				return this;
			}
			//Enter Password in the field
			public CompleteRegistration_Page enterConfirmPassword(String password)
			{
				enterDataById(objec.getProperty("CompleteRegistration.ConfirmPassword.Id"),password);
				return this;
			}
					
	//Click on Register button
	public CompleteRegistration_Page clickRegisterButton()
	{
	clickByXpath(objec.getProperty("CompleteRegistration.Register.xpath"));
	return new CompleteRegistration_Page(driver, test);
	}
	
}
