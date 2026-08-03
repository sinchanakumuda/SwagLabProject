package swagLabs_framework;

import java.time.Duration;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SwagLab_PropertyExcelFileImplementation {

public static void main(String[] args) throws IOException, InterruptedException 
	
	{
		//Property Utility
		FileInputStream fs=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fs);
		String browser = p.getProperty("browser");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		//Excel Utility
		FileInputStream fs1=new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fs1);
		Sheet sh=wb.getSheet("Sheet1");
		String firstname=sh.getRow(1).getCell(0).getStringCellValue();
		String lastname=sh.getRow(1).getCell(1).getStringCellValue();
		DataFormatter f = new DataFormatter();
		String postalCode = f.formatCellValue(sh.getRow(1).getCell(2));
	
		System.out.println(firstname);
		System.out.println(lastname);
		System.out.println(postalCode);
		System.out.println(browser);
		
		
		

		System.out.println(browser);
		WebDriver driver=null;
		
		
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		
		ChromeOptions settings = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>(); 
		prefs.put("profile.password_manager_leak_detection", false); 
		settings.setExperimentalOption("prefs", prefs); //key:prefs 
		
	      driver=new ChromeDriver(settings);
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			 driver=new FirefoxDriver();
		}
		
			
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Add items to Cart and click on checkout and confirm
		
		//Login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
		
		//Sort
		WebElement sort = wait.until(ExpectedConditions.elementToBeClickable(By.className("product_sort_container")));
		Select sel=new Select(sort);
		sel.selectByValue("lohi");
		
		//Add items
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-onesie"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bolt-t-shirt"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-bike-light"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-fleece-jacket"))).click();
		
	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[class='shopping_cart_link']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();
		
		Random r=new Random();
		int n=r.nextInt(1000);
		
		char letter=(char)('A'+r.nextInt(26));
		String s=""+letter;
		
	//form
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys(s+firstname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name"))).sendKeys(s+lastname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code"))).sendKeys(postalCode+n);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("continue"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("finish"))).click();
		
		
	
		
	
		//Logout
		
		WebElement icon=wait.until(ExpectedConditions.elementToBeClickable(By.id("react-burger-menu-btn")));
		Actions act=new Actions(driver);
		act.moveToElement(icon).click().perform();
		
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", logout);

		
		
		
	
		Thread.sleep(2000);
		
						
						
		//driver.quit();*/
	}

}
