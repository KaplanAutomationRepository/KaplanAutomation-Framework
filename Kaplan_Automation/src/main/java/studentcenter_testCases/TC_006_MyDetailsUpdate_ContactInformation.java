package studentcenter_testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_006_MyDetailsUpdate_ContactInformation extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_006_MyDetailsUpdate_ContactInformation";
		testDescription="Verifying whether the user is able to update contact details";
		browserName="chrome";
		dataSheetName="TC_006_ContactDetailsUpdate";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void myDetailsUpdate(String userName, String password,String email,String mobnum,String workNumber,String homeNumber,String qualification) throws InterruptedException 
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickMydetailsLink()
.clickContactInfoEditLink()
.editWorkEmail(email)
.editMobileNum(mobnum)
.editWorkNumber(workNumber)
.editHomeNumber(homeNumber)
.selectPreferredQualification(qualification)
.clickUpdateDetailsContactinfo();
}
}




