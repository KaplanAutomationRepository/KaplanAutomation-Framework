package studentcenter_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.KaplanSpecificWrappers;

public class OrderHistory_Page extends KaplanSpecificWrappers{
	//Confirming that we are in ChangePassword Page
		public OrderHistory_Page(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test=test;
			if(!verifyTitleContains("Order History")){
				reportStep("This is not Order History Page", "FAIL");
			}
		}
		
		public OrderHistory_Page verifyOrderhistoryText(String text) throws InterruptedException
		{
			Thread.sleep(5000);
			getTextFromTable(objec.getProperty("OrderHistory.table.Xpath"), text);
			return this;
		}
		public OrderHistory_Page getTextFromOrderTable(String date,String refno)
		{
			WebElement table =driver.findElement(By.xpath(objec.getProperty("OrderHistory.table.Xpath")));
			String text1=table.findElement(By.xpath("//tr/td[1]")).getText();
			String text2=table.findElement(By.xpath("//tr/td[2]")).getText();
			if(text1.contentEquals(date) && text2.contentEquals(refno))
			{
				reportStep(text1+" and "+text2+" is matching with "+date+" and "+refno, "PASS");
			}
			else
			{
				reportStep(text1+" and "+text2+" is not matching with "+date+" and "+refno, "PASS");
			}
			return this;	    
		}
		
		public KaplanFinancialCourses_Page clickOrderDetails()
		{
			clickByXpath("//tr/td[3]/a");	
			return new KaplanFinancialCourses_Page(driver,test);
		}
		
		
		
		
		
		
		
		
		
		
		
		
}