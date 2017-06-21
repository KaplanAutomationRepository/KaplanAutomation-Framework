package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {

	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;
	
	public void reportstep(String description,String status,boolean bSnap)
	{
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;
			
			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			description = description+test.
					addScreenCapture("./../reports/images/"+snapNumber+".jpg");
		}
		//write if it is successful or failure or information	
		if(status.equalsIgnoreCase("PASS"))
		{
			test.log(LogStatus.PASS, description);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			test.log(LogStatus.FAIL, description);
			throw new RuntimeException("Failed");
		}
		else if(status.equalsIgnoreCase("WARN"))
		{
			test.log(LogStatus.WARNING,description);
		}
		else if(status.equalsIgnoreCase("INFO"))
				{
					test.log(LogStatus.INFO, description);
				}
	}
	public abstract long takeSnap();
	
	public void reportStep(String desc, String status) {
		reportstep(desc, status, true);
	}

		public ExtentReports startResult()
		{
			extent = new ExtentReports("./reports/report.html", false);
//			extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
			return extent;
		}
		public ExtentTest startTestCase(String testCaseName,String testDescription)
		{
			test = extent.startTest(testCaseName, testDescription);
			return test;
			
		}
		public void endResult()
		{
			extent.flush();
		}
		public void endTestCase()
		{
			extent.endTest(test);
		}

	
}
