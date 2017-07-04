package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_006_HomeAddressUpdate extends KaplanSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TC_006_HomeAddressUpdate";
		testDescription="HomeAdddress Update";
		browserName="chrome";
		dataSheetName="TC_006_HomeAddressUpdate";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void loginAndLogout(String userName, String password,String newPassword,String confirmPassword)
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
//.clickonAddresses();
//.clickSignOut();
}
}


