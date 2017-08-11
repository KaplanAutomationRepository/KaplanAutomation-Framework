package studentcenter_testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import studentcenter_pages.Login_Page;
import wrappers.KaplanSpecificWrappers;

public class TC_010_OrderHistory extends KaplanSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TC_010_OrderHistory";
		testDescription="Validate Order HIstory";
		browserName="chrome";
		dataSheetName="TC_010_OrderHistory";
		category="Smoke";
		authors="DivyaLakshmi";
	}
@Test(dataProvider="fetchData")
public void orderHistory(String userName, String password,String date,String refno,String subTotal,String delivery,String total,String dispatchDate,String description,String status) throws InterruptedException
{
new Login_Page(driver,test)
.enterUserName(userName)
.enterPassword(password)
.clickLogin()
.clickOrderHistory()
.getTextFromOrderTable( date, refno)
.clickOrderDetails()
.verifysubTotal_Delivey_Total(subTotal, delivery, total)
.verifyDispatchDate_description_Status(dispatchDate,description,status);
//hai
}
}


