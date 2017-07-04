package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;

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
		
}