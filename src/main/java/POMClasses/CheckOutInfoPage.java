package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutInfoPage {


	
	public CheckOutInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first-name")
	private WebElement firstName;
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(id="postal-code")
	private WebElement postalCode;
	
	@FindBy(id="continue")
	private WebElement conti;
	
	public WebElement getContinue()
	{
		return conti;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	
	public WebElement getLastName() {
		return lastName;
	}

	

	public WebElement getPostalCode() {
		return postalCode;
	}


}

