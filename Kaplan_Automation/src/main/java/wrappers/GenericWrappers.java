package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	
	public GenericWrappers()
	{
		 Properties pro = new Properties();
	
			try {
				pro.load(new FileInputStream(new File(".src/mail/resources/configuration.properties")));
				sHubUrl = pro.getProperty("HUB");
				sHubPort = pro.getProperty("PORT");
				pro.getProperty("URL");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public GenericWrappers(RemoteWebDriver driver,ExtentTest test)
	{
		this.test=test;
		this.driver=driver;
	}
	

	public void invokeApp(String browser) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public long takeSnap() {
		
		return 0;
	}	
}
