package studentcenter_pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;
//Confirming that we are in Homepage_CIMABooks_BS Page
public class Homepage_CIMABooks_BS_Page extends KaplanSpecificWrappers {
	
	public Homepage_CIMABooks_BS_Page(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Homepage - CIMA Books")){
			reportStep("This is not Login Page", "FAIL");
		}
	}	
//Click on Take Me Here Link
 public MyDetails_Page clicktakeMeHere()
 {
	clickBylinkText(objec.getProperty("HomePage.TakeMeThere.Link"));
	return new MyDetails_Page(driver,test);
 }
}