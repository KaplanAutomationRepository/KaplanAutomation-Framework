package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class GenericWrappers extends Reporter implements Wrappers {

	public RemoteWebDriver driver;
	protected static Properties pro;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;
	protected String objecFile = "object.properties";
	private String propertyLocation = "resources/";
	protected static Properties objec = null;
	
	
	public GenericWrappers()
	{
		 Properties pro = new Properties();
	
			try {
				ClassLoader classLoader = getClass().getClassLoader();
				pro.load(new FileInputStream(new File(classLoader.getResource("configuration.properties").getFile())));
				sHubUrl = pro.getProperty("HUB");
				sHubPort = pro.getProperty("PORT");
				sUrl=pro.getProperty("URL");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}
	public GenericWrappers(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test=test;
	}
	/*public void loadObjects()
	{
		Properties pro = new Properties();
		try {
			//ClassLoader classLoader = getClass().getClassLoader();
			//pro.load(new FileInputStream(new File(classLoader.getResource("object.properties").getFile())));
			pro.load(App.class.getClassLoader().getResourceAsStream("object.properties")); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			}
		objec = new Properties();
		try {
			FileInputStream ip = new FileInputStream(propertyLocation + objectFile);
			try {
				objec.load(ip);
				System.out.println(objec);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	   public void loadObjects()
	   {
	    objec = new Properties();
        try {
			//objec.load(ip);
        	ClassLoader classLoader = getClass().getClassLoader();
			objec.load(new FileInputStream(new File(classLoader.getResource("object.properties").getFile())));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }

	public void unloadObjects()
	{
		pro=null;
		//added
		objec=null;
	}
	
	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Divya Suravarjula - Kaplan
	 * @param url - The url with http or https
	 * 
	 */

	public void invokeApp(String browser) {
		
		invokeApp(browser,false);
	}
	/**
	 * This method will take snapshot of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url 
	 * @author Divya Suravarjula - Kaplan
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception
	 */
	
	public void invokeApp(String browser, boolean bRemote) {
		
		try {
             DesiredCapabilities dc= new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);
			
			//this is for grid run
			
			if(bRemote)
{
			driver=new RemoteWebDriver(new URL("https://"+sHubUrl+":"+sHubPort+"/wd/hub"),dc);
}
			//This is for local run
			else
{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else
			{
				System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.get(sUrl);
			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser "+browser+" is launched successfully", "PASS");
		} catch (Exception e) {
			e.printStackTrace();
		reportStep("The browser "+browser+" is not launched","FAIL");
		}
	}
/**
 * This method will close all browsers
 * @author Divya Suravarjula - Kaplan 
 */
	public void closeAllBrowsers() 
	{
	 try {
		driver.quit();
	} catch (Exception e)
	 {
		reportStep("The browser could not be closed", "WARN");
	}		
	}
	/**
	 * This method will close all browsers
	 * @author Divya Suravarjula - Kaplan 
	 */
public void closeBrowser() {
	try {
		driver.close();
	} catch (Exception e) {

		reportStep("The browser could not be closed", "WARN");
	}
}
	/**
	 * This method will enter the data in the text field using ID as locator
	 * @author Divya Suravarjula - Kaplan
	 * @param IdValue - The locator ID value of the web element
	 */
	public void enterDataById(String idValue,String text)
	{	
			try {
				driver.findElement(By.id(idValue)).clear();
				driver.findElement(By.id(idValue)).sendKeys(text);
				reportStep("The data "+text+" is entered in "+idValue, "PASS");
			} 
			catch(NoSuchElementException e)
			{
				reportStep("The data "+text+" could not be entered in "+idValue, "FAIL");
			}
			catch (Exception e)
			{
				reportStep("Unknown exception occured while entering "+text+"in "+idValue, "FAIL");
			}	
	}
	/**
	 * This method will click the web element by using linktext as an locator
	 * @author Divya Suravarjula - Kaplan
	 * @param linkValue - The linktext value of the web element
	 */
	public void clickBylinkText(String linkValue)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkValue)));
			element.click();
			//driver.findElement(By.linkText(linkValue)).click();
			reportStep("The web element "+linkValue+" is clicked", "PASS");
		} 
		catch (NoSuchElementException e) 
		{
			reportStep("The web element "+linkValue+" is not clickable", "FAIL");
		}
		catch (Exception e) 
		{
			reportStep("Unknown exception occured while clicking "+linkValue, "FAIL");
		}
	}
	/**
	 * This method will click the web element by using Class as an locator
	 * @author Divya Suravarjula - Kaplan
	 * @param classValue - The class attribute value of the web element
	 */
	public void clickByClassName(String classValue)
	{
		try {
			
			driver.findElement(By.className(classValue)).click();
			reportStep("The web element "+classValue+" is clicked", "PASS");
		} 
		catch (NoSuchElementException e) 
		{
			reportStep("The web element "+classValue+" is not clickable", "FAIL");
		}
		catch (Exception e) 
		{
			reportStep("Unknown exception occured while clicking "+classValue, "FAIL");
		}	
	}
	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Divya Suravarjula- Kaplan
	 */
	public void clickByXpath(String xpathVal) {
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10); 
			//driver.findElement(By.xpath(xpathVal)).click();
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			element.click();
			//Thread.sleep(3000);
			
			reportStep("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: "+xpathVal+" could not be clicked.", "FAIL");
		}
	}
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public boolean verifyTitle(String title)
	{
		boolean titlestatus=false;
		try {
			if(driver.getTitle().equalsIgnoreCase(title))
				{reportStep("The title of the page is matching with the value "+title, "PASS");
			titlestatus=true;
				}
			else{
			reportStep("The title of the page is not matching", "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
				return titlestatus;
		
	}
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public boolean verifyTitleContains(String title)
	{
		return verifyTitleContains(title, true, true);
	}
	public boolean verifyTitleContains(String title, Boolean bSnap, Boolean bLog)
	{
		boolean titlestatus=false;
		try {
			if(driver.getTitle().contains(title))
				{reportStep("The title of the page is matching with the value "+title, "PASS", bSnap, bLog);
			titlestatus=true;
				}
			else{
			reportStep("The title of the page is not matching", "FAIL", bSnap, bLog);
			titlestatus=false;
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
				return titlestatus;	
	}
	/**
	 * This method will verify the text of web element using locator class 
	 * @param title - The expected text of the element
	 * @author Divya Suravarjula - Kaplan
	 */
	@SuppressWarnings("deprecation")
	public void verifyTextByClass(String classValue,String text)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			String eText=driver.findElement(By.className(classValue)).getText();
			WebElement wb=driver.findElement(By.className(classValue));
			System.out.println(wb);
			System.out.println("test value"+eText);
			wait.until(ExpectedConditions.textToBe(By.className(classValue), text));
			//WebDriverWait wait = new WebDriverWait(driver, 10); 
			//WebElement element = wait.until(ExpectedConditions.textToBePresentInElement(By.className(classValue), text)));
			//String eText=element.getText();
			//System.out.println(eText);
			
			if(eText.contains(text))
			{
				reportStep("The text "+eText+" matches with given text value "+text,"PASS");
			}
			else
			{
				reportStep("The text "+eText+" is not matching with given value "+text, "FAIL");
			}
		} catch (Exception e) {
			
			System.out.println("this is excep"+e.getMessage());
			reportStep("Unknown exception occured while verifying the text", "FAIL");
		}
	}
	public void verifyTextByXPath(String xPathValue,String text)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			String eText=driver.findElement(By.xpath(xPathValue)).getText();
			//WebElement wb=driver.findElement(By.className(xPathValue));
			//System.out.println(wb);
			System.out.println("test value"+eText);
		//	wait.until(ExpectedConditions.textToBe(By.className(xPathValue), text));
			//WebDriverWait wait = new WebDriverWait(driver, 10); 
			//WebElement element = wait.until(ExpectedConditions.textToBePresentInElement(By.className(classValue), text)));
			//String eText=element.getText();
			//System.out.println(eText);
			
			if(eText.contains(text))
			{
				reportStep("The text "+eText+"matches with given text value "+text,"PASS");
			}
			else
			{
				reportStep("The text "+eText+"is not matching with given value "+text, "FAIL");
			}
		} catch (Exception e) {
			
			System.out.println("this is excep"+e.getMessage());
			reportStep("Unknown exception occured while verifying the text", "FAIL");
		}
	}
}	

