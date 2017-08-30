package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_008_DeliveryAddressUpdate extends KaplanSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TC_008_DeliveryAddressUpdate";
		testDescription="DeliveryAdddress Update";
		browserName="chrome,stgURL";
		dataSheetName="TC_008_DeliveryAddressUpdate";
		category="Smoke";
		authors="DivyaLakshmi";
	}
	
@Test(dataProvider="fetchData")
public void deliveryAddressUpdate(String userName, String password,String address,String city,String pincode) throws InterruptedException
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickonAddresses()
.clickEditLinkofDelivery()
.enterAddressLine1Delivery(address)
.enterCityDelivery(city)
.enterPincodeDelivery(pincode)
.clickonUpdateDetailsDelivery();
}
}


