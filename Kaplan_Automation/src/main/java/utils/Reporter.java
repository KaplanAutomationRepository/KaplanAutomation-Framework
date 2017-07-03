package utils;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;

	public void reportStep(String desc, String status, boolean bSnap, boolean bLog) {

		if(bSnap && !status.equalsIgnoreCase("INFO")){
			long snapNumber = 100000l;
			
			try {
				snapNumber= takeSnap();
			} catch (Exception e) {
				e.printStackTrace();
			}
			desc = desc+test.
					addScreenCapture("./../reports/images/"+snapNumber+".jpg");
			//"./../reports/images/"+snapNumber+
		}
		
		// Write if it is successful or failure or information
		if(status.equalsIgnoreCase("PASS") && bLog){
			test.log(LogStatus.PASS, desc);
		}else if(status.equalsIgnoreCase("FAIL") && bLog){
			test.log(LogStatus.FAIL, desc);
			//throw new RuntimeException("FAILED");
		}else if(status.equalsIgnoreCase("WARN") && bLog){
			test.log(LogStatus.WARNING, desc);
		}else if(status.equalsIgnoreCase("INFO") && bLog){
			test.log(LogStatus.INFO, desc);
		}
	
	}
	
	public void reportStep(String desc, String status) {
		reportStep(desc, status, true, true);
	}

	public abstract long takeSnap();
	

	public ExtentReports startResult(){
		//change to false we can see all the previous reports
		extent = new ExtentReports("./reports/report.html", true);
		extent.loadConfig(new File("./src/main/resources/extent-configuration.xml"));
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

	
	
}