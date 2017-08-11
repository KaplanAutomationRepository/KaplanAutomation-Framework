package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_007_HomeAddressUpdate extends KaplanSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TC_007_HomeAddressUpdate";
		testDescription="HomeAdddress Update";
		browserName="chrome";
		dataSheetName="TC_007_HomeAddressUpdate";
		category="Smoke";
		authors="DivyaLakshmi";
	}
	
@Test(dataProvider="fetchData")
public void HomeAddressUpdate(String userName, String password,String address,String city,String pincode) throws InterruptedException
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickonAddresses()
.clickEditLinkofHome()
.enterAddressLine1Home(address)
.enterCityHome(city)
.enterPincodeHome(pincode)
.clickonUpdateDetailsHome();
}
}


