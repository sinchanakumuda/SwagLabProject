package POMClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	@FindBy(className="product_sort_container")
	private WebElement sort;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	private WebElement item1;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	private WebElement item2;
	
	@FindBy(id="add-to-cart-sauce-labs-bike-light")
	private WebElement item3;
	
	@FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
	private WebElement item4;
	
	@FindBy(css="a[class='shopping_cart_link']")
	private WebElement cart;
	
	@FindBy(xpath = "//span[text()='Products']")
	private List<WebElement> productsHeader;  // ✅ List of elements

 
    public List<WebElement> getproductHeaders() {
		return productsHeader;
	}
    
	public WebElement getSort() {
		return sort;
	}



	public WebElement getItem1() {
		return item1;
	}


	public WebElement getItem2() {
		return item2;
	}


	public WebElement getItem3() {
		return item3;
	}


	public WebElement getItem4() {
		return item4;
	}
	
	public WebElement getCart()
	{
		return cart;
	}
	
	
	
	

}
