package config_BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import POMClasses.CheckoutComplete;
import POMClasses.LoginPage;
import utilities.DriverUtility;
import utilities.PropertyFileUtility;

@Listeners(listeners.ListenerExtentImplementationClass.class)
public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;//Listener purpose
	PropertyFileUtility p=new PropertyFileUtility();
	
	//Launching the browser for cross browser testing
	/*@Parameters("browser")
	@BeforeClass()
	public void beforClassLaunchB(String browser) throws IOException
	{
		Reporter.log("Launch Browser -> beforemethod",true);
		//String browser=p.readDataFromPropertyFile("browser");
		 try {
	          driver=DriverUtility.getDriver(browser);
		 } 
		 catch(IllegalArgumentException e) {
		        System.out.println("Browser not supported: " + e.getMessage());
		    }
		 sdriver=driver;
		 System.out.println("launching browser");
		 
	}*/
	
	@BeforeClass()
	public void beforClassLaunchB() throws IOException
	{
		Reporter.log("Launch Browser -> beforemethod",true);
		String browser=p.readDataFromPropertyFile("browser");
		 try {
	          driver=DriverUtility.getDriver(browser);
		 } 
		 catch(IllegalArgumentException e) {
		        System.out.println("Browser not supported: " + e.getMessage());
		    }
		 sdriver=driver;
		 System.out.println("launching browser");
		 
	}
	
	
	//Method using Command line parameter
	/*@BeforeMethod()
	public void beforeMethodLoginApp() throws IOException
	{
		Reporter.log("login to app using command line parameter-> beforemethod",true);
		
		String url=System.getProperty("url");
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		
		DriverUtility.maximizeWindow(driver);
		 DriverUtility.waitImplict(driver);
		driver.get(url);
		 LoginPage lp=new LoginPage(driver);
         WebElement userField = lp.getUserName();
			WebElement passField = lp.getPassword();
			WebElement loginBtn  = lp.getLoginBtn();
	
	//Login
			DriverUtility.explictWaitForVisiblity(driver, userField, username);
			DriverUtility.explictWaitForVisiblity(driver, passField, password);
			DriverUtility.explictWaitForElementClick(driver, loginBtn);	
			System.out.println("login Done");
	}*/
	
	@BeforeMethod()
	public void beforeMethodLoginApp() throws IOException
	{
		Reporter.log("login to app -> beforemethod",true);
		String url=p.readDataFromPropertyFile("url");
		String username=p.readDataFromPropertyFile("username");
		String password=p.readDataFromPropertyFile("password");
		DriverUtility.maximizeWindow(driver);
		 DriverUtility.waitImplict(driver);
		driver.get(url);
		 LoginPage lp=new LoginPage(driver);
         WebElement userField = lp.getUserName();
			WebElement passField = lp.getPassword();
			WebElement loginBtn  = lp.getLoginBtn();
	
	//Login
			DriverUtility.explictWaitForVisiblity(driver, userField, username);
			DriverUtility.explictWaitForVisiblity(driver, passField, password);
			DriverUtility.explictWaitForElementClick(driver, loginBtn);	
			System.out.println("login Done");
	}
	
	@AfterMethod()
	public void afterMethodLogoutApp()
	{
		CheckoutComplete cc=new CheckoutComplete(driver);
		cc.getMenu();
		cc.getLogoutSidebar();
		DriverUtility.explictWaitForElementClick(driver,cc.getMenu());
		DriverUtility.JSClick(driver, cc.getLogoutSidebar());
	
	}
	
	@AfterClass()
	public void afterClassCloseB()
	{
		Reporter.log("Close Browser -> beforemethod",true);
		DriverUtility.closeWindow(driver);
	}
	
	
	

}
