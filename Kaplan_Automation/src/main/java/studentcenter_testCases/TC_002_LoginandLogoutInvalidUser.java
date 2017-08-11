package studentcenter_testCases;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_002_LoginandLogoutInvalidUser extends KaplanSpecificWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="TC_002_LoginandLogoutInvalidUser";
		testDescription="Login To MyKaplan and Logout with an invalid user";
		browserName="chrome";
		dataSheetName="TC_002_LoginandLogoutInvlaidUser";
		category="Smoke";
		authors="DivyaLakshmi";
	}
	@Test(dataProvider="fetchData")
	public void loginAndLogoutInvalidUser(String userName, String password,String errortext)
	{
	new Login_Page(driver,test)
	.enterUserName(userName)
	.enterPassword(password)
	.clickLoginInvalidUser()
	.invalidUserLogin(errortext);
	} 
	
}
