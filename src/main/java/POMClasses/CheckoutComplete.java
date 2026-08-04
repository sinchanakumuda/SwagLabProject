package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {
	
	public CheckoutComplete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menu;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutSidebar;
	
	public WebElement getMenu()
	{
		return menu;
	}
	
	public WebElement getLogoutSidebar()
	{
		return logoutSidebar;
	}
	

}
