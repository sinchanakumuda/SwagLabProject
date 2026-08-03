package POMClasses;


import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login-button")
	private WebElement loginButton;
	
	public WebElement getUserName()
	{
		return userName;
	}
	public WebElement getPassword()
	{
		return password;
	}
	
	 public WebElement getLoginBtn() { 
		  return loginButton; 
		 }
	
	}
	
	


