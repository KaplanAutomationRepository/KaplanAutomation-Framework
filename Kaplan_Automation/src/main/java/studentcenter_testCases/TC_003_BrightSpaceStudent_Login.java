package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_003_BrightSpaceStudent_Login extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_003_BrightSpaceStudent_Login";
		testDescription="Login To BrightSpace and Logout";
		browserName="chrome,stgURL";
		dataSheetName="TC_003_BrightSpaceStudent_Login";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void loginAndLogoutOfBrightSpace(String userName, String password)
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickBSLogin()
.clicktakeMeHere()
.clickSignOut();
}
}




