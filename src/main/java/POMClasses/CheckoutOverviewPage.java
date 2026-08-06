package POMClasses;

import java.util.List;

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
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private List<WebElement> confirmMsg;
	
	
	
	
	public WebElement getFinish()
	{
		return finish;
	}
	
	public List<WebElement> getConfirmMsg()
	{
		return confirmMsg;
	}
	
}
