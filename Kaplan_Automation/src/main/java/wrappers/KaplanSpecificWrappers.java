package wrappers;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentTest;

import utils.TestDataProvider;

public class KaplanSpecificWrappers extends GenericWrappers{
	
	public String browserName;
	public String dataSheetName;	
	
	

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest(){
		loadObjects();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testCaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authors);
		Properties pro= new Properties();
		String[] arrBrowser =browserName.split(",");
		try{
			ClassLoader classLoader = getClass().getClassLoader();
			pro.load(new FileInputStream(new File(classLoader.getResource("configuration.properties").getFile())));
			
			if(arrBrowser.length>1)
			{
				String UrlName = arrBrowser[1];	
				
				sUrl=pro.getProperty(UrlName);
				invokeApp(browserName, sUrl);
				//invokeApp(browserName);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			pro = null;
		}
		
	}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
		unloadObjects();
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		closeAllBrowsers();		
	}
	
	@DataProvider(name="fetchData")
	public Object[][] getData(){
		return TestDataProvider.getAllSheetData("./TestData/"+dataSheetName+".xlsx");		
	}	
}

