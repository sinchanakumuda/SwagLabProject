package swagLabs_framework;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;



public class SwagLab_HardCoding {
	
	public static void main(String args[]) throws InterruptedException
	{
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); //key:prefs 
		WebDriver driver=new ChromeDriver(settings);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Add items to Cart and click on checkout and confirm
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2000);
		
		WebElement sort =driver.findElement(By.className("product_sort_container"));
		Select s=new Select(sort);
		s.selectByValue("lohi");
		
		
		driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
		
		driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		driver.findElement(By.id("first-name")).sendKeys("abcd");
		driver.findElement(By.id("last-name")).sendKeys("defgh");
		driver.findElement(By.id("postal-code")).sendKeys("895678");
		
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		
		//Logout
		WebElement icon=driver.findElement(By.id("react-burger-menu-btn"));
		Actions act=new Actions(driver);
		act.moveToElement(icon).click();
		
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", logout);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", logout);


		
		
	
		Thread.sleep(2000);
		
						
						
		//driver.quit();*/
	}

}
