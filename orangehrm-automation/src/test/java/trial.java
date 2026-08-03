import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//button[@class=\"oxd-icon-button oxd-icon-button--solid-main employee-image-action\"]")).click();
		
		//click on PIM link
				/*driver.findElement(By.xpath("//span[text()='PIM']")).click();
				Thread.sleep(2000);
		//click on +Add button
				driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
				Thread.sleep(2000);
				//send EmpName
				driver.findElement(By.name("firstName")).sendKeys("Harish");
				Thread.sleep(2000);
				//Emp id
				driver.findElement(By.xpath("//label[normalize-space()='Employee Id']/../following-sibling::div/input")).sendKeys("86");
				
				driver.findElement(By.xpath("//button[@class=\"oxd-icon-button oxd-icon-button--solid-main employee-image-action\"]")).click();
				//
				//Emp Name
				//driver.findElement(By.xpath("//label[normalize-space()='Employee Name']/../following-sibling::div//input")).sendKeys("Harish");
				////label[normalize-space()='LABEL_TEXT']/parent::div/following-sibling::div//input
		        ////label[normalize-space()='Employee Name']/ancestor::div[contains(@class,'oxd-input-group')]//input*/

	}

}
