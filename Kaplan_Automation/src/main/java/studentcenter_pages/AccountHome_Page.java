package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class AccountHome_Page extends KaplanSpecificWrappers{
	//Confirming that we are in AccountHome Page
		public AccountHome_Page(RemoteWebDriver driver, ExtentTest test){
			
			this.driver = driver;
			this.test = test;
			
			if(!verifyTitle("Account home")){
				reportStep("This is not AccountHome Page", "FAIL");
			}
		}
		public MyDetails_Page goToMyDetailsPage()
		{
			return new MyDetails_Page(driver,test);
		}
}
