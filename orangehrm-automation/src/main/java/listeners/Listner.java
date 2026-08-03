package listeners;



	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.io.FileHandler;
	import org.testng.ISuite;
	import org.testng.ISuiteListener;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import org.testng.Reporter;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	import java.io.File;
	import java.io.IOException;
	import java.util.Date;
	import config_BaseClass.BaseClass;;



		public class Listner implements ITestListener,ISuiteListener {
	 
			
			
			public void onStart(ISuite suite) { 
			
					Reporter.log("Report configuration",true); 
			 
					
			
			}
			
			
			public void onFinish(ISuite suite) { 
			Reporter.log("Report backup",true); 
			}
			
			
			public void onTestStart(ITestResult result) { 
			Reporter.log("====="+result.getMethod().getMethodName()+" Execution STARTED=====",true); 
			}
			
		 
			 public void onTestSuccess(ITestResult result) { 	
			 Reporter.log("====="+result.getMethod().getMethodName()+"SUCCESS=====",true)	; 
			 
			 } 
			
		
			 public void onTestFailure(ITestResult result) {
				    String testName = result.getMethod().getMethodName();
				    Reporter.log("======" + testName + " ============FAILURE====", true);

				    Date d = new Date();
				    String newdate = d.toString().replace(" ", "_").replace(":", "_");

				    TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
				    File temp = ts.getScreenshotAs(OutputType.FILE);

				    File screenshotDir = new File("./Screenshots");
				    if (!screenshotDir.exists()) {
				        screenshotDir.mkdirs();
				    }

				    File perm = new File(screenshotDir, "listnerReport"+testName + "_" + newdate + ".png");
				    try {
				        FileHandler.copy(temp, perm);
				    } catch (IOException e) {
				        e.printStackTrace();
				    }
				}
			  
			
			 
		

			 
			 
			 }
		




