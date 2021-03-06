package studentcenter_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	public Login_Page clickLoginInvalidUser()
	{
		 clickByXpath(objec.getProperty("Login.Loginbutton.Xpath"));
		 return this;
	}

	public Login_Page invalidUserLogin(String errortext)
	{
		//WebDriverWait wait = new WebDriverWait(driver, 10); 
		//WebElement element = wait.until(ExpectedConditions.elementT(objec.getProperty("Login.ErrorMessage.Class"))));
		//element.click();
		//String eText=driver.findElement(By.className("text-danger")).getText();
		//System.out.println(eText);
		verifyTextByXPath(objec.getProperty("Login.ErrorMessage.Xpath"), errortext);
		
		return this;
	}
}
