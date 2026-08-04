package swagLabs_framework;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import utilities.DriverUtility;
import utilities.ExcelUtility;
import utilities.JavaUtility;
import utilities.PropertyFileUtility;
import POMClasses.*;

public class SwagLab_POM_Implimentation {
	
	public static void main(String[] args) throws IOException, InterruptedException 
	
	{
		WebDriver driver=null;
		
		//Property Utility
		PropertyFileUtility p=new PropertyFileUtility();
		String browser=p.readDataFromPropertyFile("browser");
		String url=p.readDataFromPropertyFile("url");
		String username=p.readDataFromPropertyFile("username");
		String password=p.readDataFromPropertyFile("password");
		
		
		
		 try {
	          driver=DriverUtility.getDriver(browser);
		 } catch(IllegalArgumentException e) {
		        System.out.println("Browser not supported: " + e.getMessage());
		    }
		
		ExcelUtility e=new ExcelUtility();
		String firstname=e.readFromExcel("Sheet1",1, 0);
		String lastname=e.readFromExcel("Sheet1",1, 1);
		String postalCode = e.readFromExcel("Sheet1",1, 2);
		
		
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(postalCode);
		
		JavaUtility j=new JavaUtility();
		
		
			
		driver.get(url);
		
		DriverUtility.maximizeWindow(driver);
		DriverUtility.waitImplict(driver);
		
		
	

		//Add items to Cart and click on checkout and confirm logout
		
		        LoginPage lp=new LoginPage(driver);
	            WebElement userField = lp.getUserName();
				WebElement passField = lp.getPassword();
				WebElement loginBtn  = lp.getLoginBtn();
		
		//Login
				DriverUtility.explictWaitForVisiblity(driver, userField, username);
				DriverUtility.explictWaitForVisiblity(driver, passField, password);
				DriverUtility.explictWaitForElementClick(driver, loginBtn);
		
		//Sort
				HomePage hp=new HomePage(driver);
				WebElement sort=hp.getSort();
				DriverUtility.explictWaitForElementClick(driver,sort);
				
				DriverUtility.selectByValue(sort,"lohi");
					
		//item to cart
				WebElement i1=hp.getItem1();
				WebElement i2=hp.getItem2();
				WebElement i3=hp.getItem3();
				WebElement i4=hp.getItem4();
		
				DriverUtility.explictWaitForElementClick(driver, i1);
				DriverUtility.explictWaitForElementClick(driver, i2);
				DriverUtility.explictWaitForElementClick(driver, i3);
				DriverUtility.explictWaitForElementClick(driver, i4);
		//click cart icon
				WebElement cart=hp.getCart();
				DriverUtility.explictWaitForElementClick(driver, cart);
		
				
		//click checkout
				CartPOMPage c=new CartPOMPage(driver);
				WebElement checkout=c.getCheckOut();
				DriverUtility.explictWaitForElementClick(driver, checkout);
		
		//form
				CheckOutInfoPage ci=new CheckOutInfoPage(driver);
				
				WebElement fname=ci.getFirstName();
				DriverUtility.explictWaitForVisiblity(driver, fname, j.toGetRandomAlpha()+firstname);
		        WebElement lname=ci.getLastName();
		        DriverUtility.explictWaitForVisiblity(driver, lname, j.toGetRandomAlpha()+lastname);
		        WebElement pcode=ci.getPostalCode();
		        DriverUtility.explictWaitForVisiblity(driver, pcode, j.toGetRandomCount()+postalCode);
                WebElement conti=ci.getContinue();
		        DriverUtility.explictWaitForElementClick(driver, conti);
		        
		        
		        CheckoutOverviewPage co=new CheckoutOverviewPage(driver);
		        WebElement finish=co.getFinish();
		        DriverUtility.explictWaitForElementClick(driver, finish);
		
		//Logout
		CheckoutComplete cc=new CheckoutComplete(driver);
		cc.getMenu();
		cc.getLogoutSidebar();
		DriverUtility.explictWaitForElementClick(driver,cc.getMenu());
		DriverUtility.JSClick(driver, cc.getLogoutSidebar());

		
	
		
						
						
		//driver.quit();*/

	}

}



