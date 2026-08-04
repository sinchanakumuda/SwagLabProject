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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import config_BaseClass.BaseClass;;



	public class ListenerExtentImplementationClass implements ITestListener,ISuiteListener {
 
		public ExtentSparkReporter spark;
		public static ExtentReports report;
		public ExtentTest test; 
		
		public void onStart(ISuite suite) { 
		
		Reporter.log("Report configuration",true); 
		  Date d=new Date(); 
		  String newDate = d.toString().replace(" ","_").replace(":","_");  
		spark=new ExtentSparkReporter("./AdvanceReports/Extentreport_"+newDate+".html"); 
		   spark.config().setDocumentTitle("SwagLab Test Suite Results"); 
		   spark.config().setReportName("ECommerceApp Report"); 
		   spark.config().setTheme(Theme.DARK); 
		    
		   report=new ExtentReports(); 
		   report.attachReporter(spark); 
		   report.setSystemInfo("OS","Windows 11"); 
		   report.setSystemInfo("Browser", "Edge");
				
				
		
		}
		
		
		public void onFinish(ISuite suite) { 
		report.flush();	
		Reporter.log("Report backup",true); 
		}
		
		
	
		
		public void onTestStart(ITestResult result) {
		    String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
		    if (browser == null || browser.trim().isEmpty()) {
		        browser = "DefaultBrowser"; // or "chrome"
		    }
		    String testName = result.getMethod().getMethodName() + " [" + browser + "]";
		    test = report.createTest(testName);
		    test.log(Status.INFO, "=====" + testName + " Execution STARTED=====");
		}

		
	 
		 public void onTestSuccess(ITestResult result) { 	
		
		 test.log(Status.PASS,"====="+result.getMethod().getMethodName()+" Execution SUCCESS====="); 
		 } 
		
	
		 public void onTestFailure(ITestResult result) {
			    String testName = result.getMethod().getMethodName();
			    Reporter.log("======" + testName + " ============FAILURE====", true);

			    Date d = new Date();
			    String newDate = d.toString().replace(" ", "_").replace(":", "_");

			    TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
			    String src = ts.getScreenshotAs(OutputType.BASE64);
                test.addScreenCaptureFromBase64String(src,testName+"Failure"+newDate);
			  
			    
			    test.log(Status.FAIL,"======"+testName+" FAILURE======");
			    
			}
		 
		 public void onTestSkipped(ITestResult result)
		 {
			 test.log(Status.SKIP,"========="+result.getMethod().getMethodName()+"====SKIPPED=====");
		 }
		  
		
		 
	

		 
		 
		 }
	


