package wrappers;

public interface Wrappers {

	/**
	 * This method will launch the given browser and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Divya Suravarjula - Kaplan
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception 
	 * 
	 */
	
	public void invokeApp(String browser)  ;
	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url 
	 * @author Divya Suravarjula - Kaplan
	 * @param browser - The browser of the application to be launched
	 * @param url - The url with http or https
	 * @throws Exception
	 */
	public void invokeApp(String browser, boolean bRemote);
	/**
	 This method will close all the browsers
	 * @author Divya Suravarjula - Kaplan
	 */
	public void closeAllBrowsers();
	
	/**
	 This method will close the current browsers
	 * @author Divya Suravarjula - Kaplan
	 */
	public void closeBrowser();
	/**
	 * This method will enter the data in the text field using ID as locator
	 * @author Divya Suravarjula - Kaplan
	 * @param IdValue - The locator ID value of the web element
	 * @param text - The text to be entered
	 */
	public void enterDataById(String idValue,String text);
	/**
	 * This method will click the web element by using linktext as an locator
	 * @author Divya Suravarjula - Kaplan
	 * @param linkValue - The linktext value of the web element
	 */
	public void clickBylinkText(String linkValue);
	/**
	 * This method will click the web element by using Class as an locator
	 * @author Divya Suravarjula - Kaplan
	 * @param classValue - The class attribute value of the web element
	 */
	public void clickByClassName(String classValue);
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Divya Suravarjula - Kaplan
	 */
	public boolean verifyTitle(String title);
	
	
	
	/**
	 * This method will accept the alert opened
	 * @author Divya - Kaplan
	 */
	public void acceptAlert();
	/**
	 * This method will return the text of the alert
	 * @author Divya Suravarjula - Kaplan
	 */
	public String getAlertText();
	
	
}
