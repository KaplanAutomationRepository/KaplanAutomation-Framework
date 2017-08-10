package studentcenter_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import wrappers.KaplanSpecificWrappers;

public class KaplanFinancialCourses_Page extends KaplanSpecificWrappers{
	//Confirming that we are in ChangePassword Page
		public KaplanFinancialCourses_Page(RemoteWebDriver driver, ExtentTest test){
			this.driver = driver;
			this.test=test;
			if(!verifyTitleContains("Kaplan Financial Courses")){
				reportStep("This is not Kaplan Financial Courses Page", "FAIL");
			}
		}
		
		public KaplanFinancialCourses_Page verifysubTotal_Delivey_Total(String subTotal,String delivery,String total)
		{
			String subTot=driver.findElement(By.xpath("(//table[2]/tbody/tr/td[2])[1]")).getText();
			String del=driver.findElement(By.xpath("(//table[2]/tbody/tr/td[2])[2]")).getText();
			String tot=driver.findElement(By.xpath("(//table[2]/tbody/tr/td[2])[3]")).getText();
			if(subTot.contentEquals(subTotal) && del.contentEquals(delivery) && tot.contentEquals(total))
			{
				reportStep("SubTotal "+subTot+" , delivery charge "+del+"and total "+tot+" is matching with "+subTot+" and "+delivery+" and " +total, "PASS");	
			}
			else
			{
				reportStep("SubTotal "+subTot+" , delivery charge "+del+"and total "+tot+" is not matching with "+subTot+" and "+delivery+" and " +total, "PASS");	
			}
			return this;
		}
		
		public KaplanFinancialCourses_Page verifyDispatchDate_description_Status(String dispatchDate,String description,String status)
		{
			String dispDate=driver.findElement(By.xpath("(//table[1]/tbody/tr/td)[1]")).getText();
			String desc=driver.findElement(By.xpath("(//table[1]/tbody/tr/td)[2]")).getText();
			String stat=driver.findElement(By.xpath("(//table[1]/tbody/tr/td)[5]")).getText();
			System.out.println(dispDate+desc+stat);
			if(dispDate.contentEquals(dispatchDate) && desc.contentEquals(description) && stat.contentEquals(status))
			{
				reportStep("dispatchDate: "+dispDate+" , description: "+desc+" and status: "+stat+" is matching with "+dispatchDate+" and "+description+" and " +status, "PASS");	
			}
			else
			{
				reportStep("dispatchDate "+dispDate+" , description "+desc+"and status "+stat+" is not matching with "+dispatchDate+" and "+description+" and " +status, "FAIL");	
			}
			return this;
		}
		 
		public OrderHistory_Page clickBackToOrders() throws InterruptedException
		{
			if (driver.findElement(By.xpath("//*[@id='PublicWrapper']/div[3]/div/div[2]/div/p[2]/a")).isDisplayed() && driver.findElement(By.xpath("//*[@id='PublicWrapper']/div[3]/div/div[2]/div/p[2]/a")).isEnabled())
			{
				driver.findElement(By.xpath("//*[@id='PublicWrapper']/div[3]/div/div[2]/div/p[2]/a")).click();
			}
			return new OrderHistory_Page(driver, test);
		}
}
		
		
