package studentcenter_testCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


public class Test1 {
	public RemoteWebDriver driver;
	@Test
	public void test22()
	{

	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://stg.mykaplan.co.uk/my-account/my-details/MyDetails/");
	
	
	}
}
