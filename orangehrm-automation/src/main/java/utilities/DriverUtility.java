package utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DriverUtility {
	
	
	    public static WebDriver getDriver(String browser) {
	        if(browser.equalsIgnoreCase("chrome")) {
	    		// Avoid Change Password Popup 
	    		ChromeOptions settings = new ChromeOptions(); 
	    		Map<String, Object> prefs = new HashMap<String, Object>(); 
	    		prefs.put("profile.password_manager_leak_detection", false); 
	    		settings.setExperimentalOption("prefs", prefs); 
	            return new ChromeDriver(settings);
	        } else if(browser.equalsIgnoreCase("edge")) {
	            return new EdgeDriver();
	        } else if(browser.equalsIgnoreCase("firefox")) {
	            return new FirefoxDriver();
	        }
	        throw new IllegalArgumentException("Invalid browser: " + browser);
	    }
	    
	    public static void maximizeWindow(WebDriver driver)
		   {
		    driver.manage().window().maximize();
		   }
	   
	    
	   public static void waitImplict(WebDriver driver) 
	   {
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   }
	   
	   public static void explictWaitForVisiblity(WebDriver driver,WebElement loc,String key)
	   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.visibilityOf(loc)).sendKeys(key);;
	   }
	  
	
	   public static void explictWaitForElementClick(WebDriver driver,WebElement loc)
	   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	   wait.until(ExpectedConditions.elementToBeClickable(loc)).click();
	   }
	  
	   
	  
	   
	   public static void selectByValue(WebElement ele,String val)
	   {
		   Select se=new Select(ele);
		   se.selectByValue(val);
		   
	   }
	 
	   
	   public static void closeWindow(WebDriver driver)
	   {
	    driver.quit();
	   }
	   
	   public static void explictWaitForElementClick(WebDriver driver, By locator) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		    element.click();
		}

		public static void JSClick(WebDriver driver, WebElement webElement) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		}
		public static void JSClick(WebDriver driver, By webElement) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		    ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		}

	   
	}


