package swagLabs_framework;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POMClasses.CartPOMPage;
import POMClasses.CheckOutInfoPage;
import POMClasses.CheckoutOverviewPage;
import POMClasses.HomePage;
import utilities.DriverUtility;
import utilities.ExcelUtility;
import utilities.JavaUtility;
import config_BaseClass.BaseClass;


@Listeners(listeners.ListenerExtentImplementationClass.class)
public class SwagLabAssertionBaseClassInhertingforTest extends BaseClass{
	
	ExcelUtility e=new ExcelUtility();
	JavaUtility j=new JavaUtility();
	
	@Test
	public void swagLabTest() throws EncryptedDocumentException, IOException
	{
		String firstname=e.readFromExcel("Sheet1",1, 0);
		String lastname=e.readFromExcel("Sheet1",1, 1);
		String postalCode = e.readFromExcel("Sheet1",1, 2);
		
		HomePage hp=new HomePage(driver);
		
		List<WebElement> headers = hp.getproductHeaders();
		if (headers.isEmpty()) {
			//Force a failure with a custom message if the element list is empty.
		    Assert.fail("Login failed - Products header not visible");
		} else {
			//isDisplayed()-it returns true if the element is present in the DOM and is visible on the page (not hidden by CSS, not display:none, not visibility:hidden, not zero‑sized).
		    Assert.assertTrue(headers.get(0).isDisplayed(), "Login failed - Products header not visible");
		}

		
		WebElement sort=hp.getSort();
		DriverUtility.explictWaitForElementClick(driver,sort);
		
		DriverUtility.selectByValue(sort,"lohi");
			
//item to cart
		WebElement i1=hp.getItem1();
		WebElement i2=hp.getItem2();
		WebElement i3=hp.getItem3();
		WebElement i4=hp.getItem4();

		DriverUtility.explictWaitForElementClick(driver, i1);
		DriverUtility.explictWaitForElementClick(driver, i2);
		DriverUtility.explictWaitForElementClick(driver, i3);
		DriverUtility.explictWaitForElementClick(driver, i4);
		
        //click cart icon
		WebElement cart=hp.getCart();
		DriverUtility.explictWaitForElementClick(driver, cart);
		
		//click checkout
		CartPOMPage c=new CartPOMPage(driver);
	
		String msg = c.getMsgText().getText();
	    Assert.assertEquals(msg, "Your Cart", "Cart page header mismatch!");
		
		WebElement checkout=c.getCheckOut();
		DriverUtility.explictWaitForElementClick(driver, checkout);

//form
		CheckOutInfoPage ci=new CheckOutInfoPage(driver);
		
		WebElement fname=ci.getFirstName();
		DriverUtility.explictWaitForVisiblity(driver, fname, j.toGetRandomAlpha()+firstname);
        WebElement lname=ci.getLastName();
        DriverUtility.explictWaitForVisiblity(driver, lname, j.toGetRandomAlpha()+lastname);
        WebElement pcode=ci.getPostalCode();
        DriverUtility.explictWaitForVisiblity(driver, pcode, j.toGetRandomCount()+postalCode);
        WebElement conti=ci.getContinue();
        DriverUtility.explictWaitForElementClick(driver, conti);
        

        
        CheckoutOverviewPage co=new CheckoutOverviewPage(driver);
        WebElement finish=co.getFinish();
        DriverUtility.explictWaitForElementClick(driver, finish);
        
        // ✅ Assertion: Order confirmation message
       List<WebElement> confirmationMsg = co.getConfirmMsg();
       
      
       if(confirmationMsg.isEmpty())
       {
    	   Assert.fail("Test Fail Order confirmation not visible!");
       }
        Assert.assertTrue(confirmationMsg.get(0).isDisplayed(), "Order confirmation not visible!");

		
	}
	

}