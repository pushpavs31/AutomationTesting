package AT.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class BasketPage {
	
public WebDriver driver;
	
	public BasketPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************************page elements **************************
	
	
	@CacheLookup
	@FindBy(xpath= "//a[normalize-space()='Selenium Ruby']")
	WebElement rubyInBasket;
	
	@CacheLookup
	@FindBy(xpath= "//a[contains(text(),'Selenium Ruby')]/ancestor::tr/descendant::td")
	List<WebElement> rubyWithPrice;
	
	@FindBy(xpath= "//tbody/tr[1]/td[4]/span[1]")
	WebElement priceOnBasketPage1;
	
	@FindBy(xpath= "//tbody/tr[1]/td[3]/a[1]")
	WebElement bookitemInBasketPage1;
	
	@CacheLookup
	@FindBy(xpath= "//a[contains(text(),'Proceed to Checkout')]")
	WebElement checkoutButton;
	
	@CacheLookup
	@FindBy(xpath= "//tbody/tr[1]/td[1]/span[1]")
	WebElement subTotalValues;
	
	@CacheLookup
	@FindBy(xpath= "//tbody/tr[3]/td[1]/strong[1]/span[1]")
	WebElement TotalValues;
	
	
	//****************************methods*********************************
	
	public boolean verifyRubyIsAddedInBasket()
	{
		Utilities.waitForElementUntilClickable(rubyInBasket, 10, driver);
		return rubyInBasket.isDisplayed();
	}


	public boolean verifyRubyBookIsAvailableWithPrice(String bookName, String price)
	{
		
		String productName = rubyWithPrice.get(2).getText();
		String Actualprice = rubyWithPrice.get(3).getText();
		boolean flag=false;
		if(productName.equals(bookName) && Actualprice.equals(price) )
		{
			flag=true;
			
		}
		
		return flag;
		
		
	}
	
	
	public boolean verifyBothPriceNBookDisplay()
	{
		boolean flag=false;
		try {
		if(priceOnBasketPage1.isDisplayed()==true)
		{
			if(bookitemInBasketPage1.isDisplayed()==true)
			{
				flag=true;
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
	public boolean verifySubTotal_TotalIsDisplay()
	{
		boolean flag=false;
		try {
		if(subTotalValues.isDisplayed()==true)
		{
			if(TotalValues.isDisplayed()==true)
			{
				flag=true;
			}
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			flag=false;
		}
		return flag;
	}
	
	public CheckoutPage clickOnCheckOutButton()
	{
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
}
