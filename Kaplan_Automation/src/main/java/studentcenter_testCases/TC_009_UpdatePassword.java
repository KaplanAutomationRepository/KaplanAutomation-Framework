package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_009_UpdatePassword extends KaplanSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TC_009_UpdatePassword";
		testDescription="Password Update";
		browserName="chrome";
		dataSheetName="TC_009_UpdatePassword";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void updatePassword(String userName, String password,String newPassword,String confirmPassword) throws InterruptedException
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickonChangePassword()
.enterCurrentPassword(password)
.enterNewPassword(newPassword)
.enterConfirmPassword(confirmPassword)
.clickUpdatePassword();
}
}


