package studentcenter_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class ChangePassword_Page extends KaplanSpecificWrappers{
	//Confirming that we are in ChangePassword Page
		public ChangePassword_Page(RemoteWebDriver driver, ExtentTest test){
			
			this.driver = driver;
			this.test = test;
			if(!verifyTitleContains("Change password")){
				reportStep("This is not Change Password Page", "FAIL");
			}
		}
		public ChangePassword_Page enterCurrentPassword(String currentPassword)
		{
			enterDataById(objec.getProperty("ChangePassword.CurrentPassword.Id"),currentPassword);
			return this;
		}
		public ChangePassword_Page enterNewPassword(String newPassword)
		{
			enterDataById(objec.getProperty("MyDetails.NewPassword.Id"),newPassword);
			return this;
		}
		public ChangePassword_Page enterConfirmPassword(String confirmPassword)
		{
			enterDataById(objec.getProperty("MyDetails.ConfirmNewPassword.Id"),confirmPassword);
			return this;
		}
		public ChangePassword_Page clickUpdatePassword() throws InterruptedException
		
		{
			if (driver.findElement(By.xpath(objec.getProperty("MyDetails.UpdatePassword.Xpath"))).isDisplayed() && driver.findElement(By.xpath(objec.getProperty("MyDetails.UpdatePassword.Xpath"))).isEnabled())
			{
				clickByXpath((objec.getProperty("MyDetails.UpdatePassword.Xpath"))); 
			}
			//Thread.sleep(5000);		
			//new WebDriverWait(driver, 700).until(ExpectedConditions.elementToBeClickable(By.xpath(objec.getProperty("MyDetails.UpdatePassword.Xpath"))));		
			//clickByXpathNoSnap((objec.getProperty("MyDetails.UpdatePassword.Xpath")));	
			return this;
			
			//getAlertText();
			//acceptAlert();
			//new WebDriverWait(driver, 200).until(ExpectedConditions.elementToBeClickable(By.xpath(objec.getProperty("MyDetails.PersonalDetails_Edit.Xpath"))));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}