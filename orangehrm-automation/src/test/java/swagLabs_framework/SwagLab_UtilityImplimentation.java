package swagLabs_framework;

import utilities.*;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.io.IOException;


public class SwagLab_UtilityImplimentation {
	

		public static void main(String[] args) throws IOException, InterruptedException 
		
		{
			WebDriver driver=null;
			
			//Property Utility
			PropertyFileUtility p=new PropertyFileUtility();
			String url=p.readDataFromPropertyFile("url");
			String username=p.readDataFromPropertyFile("username");
			String password=p.readDataFromPropertyFile("password");
			String browser=p.readDataFromPropertyFile("browser");
			
			
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
		
					
					WebElement userField = driver.findElement(By.id("user-name"));
					WebElement passField = driver.findElement(By.id("password"));
					WebElement loginBtn  = driver.findElement(By.id("login-button"));
			
			//Login
					DriverUtility.explictWaitForVisiblity(driver, userField, username);
					DriverUtility.explictWaitForVisiblity(driver, passField, password);
					DriverUtility.explictWaitForElementClick(driver, loginBtn);
			
			//Sort
					WebElement sort=driver.findElement(By.className("product_sort_container"));
					DriverUtility.explictWaitForElementClick(driver,sort);
					
					DriverUtility.selectByValue(sort,"lohi");
						
			
			//item to cart
					WebElement i1=driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
					WebElement i2=driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
					WebElement i3=driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
					WebElement i4=driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
			
					DriverUtility.explictWaitForElementClick(driver, i1);
					DriverUtility.explictWaitForElementClick(driver, i2);
					DriverUtility.explictWaitForElementClick(driver, i3);
					DriverUtility.explictWaitForElementClick(driver, i4);
			//click cart icon
					WebElement cart=driver.findElement(By.cssSelector("a[class='shopping_cart_link']"));
					DriverUtility.explictWaitForElementClick(driver, cart);
			
			//click checkout
					WebElement checkout=driver.findElement(By.id("checkout"));
					DriverUtility.explictWaitForElementClick(driver, checkout);
			
			//form
					WebElement fname=driver.findElement(By.id("first-name"));
					DriverUtility.explictWaitForVisiblity(driver, fname, j.toGetRandomAlpha()+firstname);
			
			WebElement lname=driver.findElement(By.id("last-name"));
			DriverUtility.explictWaitForVisiblity(driver, lname, j.toGetRandomAlpha()+lastname);
			
			WebElement pcode=driver.findElement(By.id("postal-code"));
			DriverUtility.explictWaitForVisiblity(driver, pcode, j.toGetRandomCount()+postalCode);
			
			WebElement conti=driver.findElement(By.id("continue"));
			DriverUtility.explictWaitForElementClick(driver, conti);
			
			WebElement finish=driver.findElement(By.id("finish"));
			DriverUtility.explictWaitForElementClick(driver, finish);
			
			//Logout
			
			
			
			
			
			DriverUtility.explictWaitForElementClick(driver, By.id("react-burger-menu-btn"));
			DriverUtility.JSClick(driver, By.id("logout_sidebar_link"));

			
		
			
							
							
			//DriverUtility.closeWindow();*/

		}

	}



