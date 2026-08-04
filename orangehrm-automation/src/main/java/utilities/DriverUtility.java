package utilities;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtility {
	
	

	    
	    public static WebDriver getDriver(String browser) {
	        WebDriver driver;

	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();

	            // Avoid Change Password Popup
	            ChromeOptions settings = new ChromeOptions();
	            Map<String, Object> prefs = new HashMap<>();
	            prefs.put("profile.password_manager_leak_detection", false);
	            settings.setExperimentalOption("prefs", prefs);

	            driver = new ChromeDriver(settings);

	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();

	            EdgeOptions options = new EdgeOptions();
	            driver = new EdgeDriver(options);

	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();

	            FirefoxOptions options = new FirefoxOptions();
	            driver = new FirefoxDriver(options);

	        } else {
	            throw new IllegalArgumentException("Invalid browser: " + browser);
	        }

	        driver.manage().window().maximize();
	        return driver;
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


