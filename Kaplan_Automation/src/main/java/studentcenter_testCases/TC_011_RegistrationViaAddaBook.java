package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;


public class TC_011_RegistrationViaAddaBook extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_011_RegistrationViaAddaBook";
		testDescription="Registration via addabook";
		browserName="chrome,sysAABURL";
		dataSheetName="TC_011_RegistrationViaAddaBook";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void registrationviaAddaBook(String email, String FN,String LN,String mobnum,String password) throws InterruptedException
{
new Login_Page(driver,test)
.clickAddBook()
.clickRegister()
.enterEmail(email)
.enterConfirmEmail(email)
.clickRegisterButton()
.enterFirstName(FN)
.enterLastName(LN)
.enterMobileNumber(mobnum)
.enterPassword(password)
.enterConfirmPassword(password)
.clickRegisterButton();
//hi
}
}
