package studentcenter_testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_004_MyDetailsUpdate extends KaplanSpecificWrappers {
	@BeforeClass
	public void setData() {
		testCaseName="TC_004_MyDetailsUpdate";
		testDescription="Verifying whether the user is able to update personal details";
		browserName="chrome";
		dataSheetName="TC004_MyDetailsUpdate";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void myDetailsUpdate(String userName, String password,String FN,String LN) throws InterruptedException
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickMydetailsLink()
.clickPersonalDetailsEditLink()
.editPersonalDetailsFN(FN)
.editPersonalDetailsLN(LN)
.clickSignOut();
}
}




