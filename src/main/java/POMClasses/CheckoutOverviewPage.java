package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

	public CheckoutOverviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="finish")
	private WebElement finish;
	
	public WebElement getFinish()
	{
		return finish;
	}
	
}
