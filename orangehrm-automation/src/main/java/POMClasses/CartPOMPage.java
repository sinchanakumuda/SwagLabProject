package POMClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPOMPage {
	
	public CartPOMPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="checkout")
	private WebElement checkout;
	
	@FindBy(xpath="//span[text()='Your Cart']")
	private WebElement msgtext;
	
	public WebElement getCheckOut()
	{
		return checkout;
	}
	public WebElement getMsgText()
	{
		return msgtext;
	}


}

