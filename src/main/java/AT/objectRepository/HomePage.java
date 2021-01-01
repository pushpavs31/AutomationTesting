package AT.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//*****************************page elements **************************
	
	
	@CacheLookup
	@FindBy(xpath= "//a[contains(text(),'Shop')]")
	WebElement shopLink;

	@CacheLookup
	@FindBy(xpath= "//a[contains(text(),'Home')]")
	WebElement homeMenuLink;
	
	@CacheLookup
	@FindBy(xpath= "//h3[contains(text(),'Selenium Ruby')]/ancestor::li/parent::ul/parent::div/parent::div/parent::div/parent::div/descendant::h3")
	List<WebElement> homeArrival;
	
	@CacheLookup
	@FindBy(xpath= "//img[@title='Selenium Ruby']")
	WebElement seleniumRubyImg;

	@CacheLookup
	@FindBy(xpath= "//a[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	
	
	//****************************methods*********************************
	
	public ProductPage clickOnShopMenu()
	{
		shopLink.click();
		return new ProductPage(driver);
	}
	
	public boolean verifyThreeArrivals()
	{
		boolean flag=false;
		if(homeArrival.size()==3)
		{
			flag=true;
			}
		return flag;
		}
	
	public SeleniumRubyPage clickOnSeleniumRubyImage()
	{
		Utilities.waitForElement(seleniumRubyImg, 15, driver);
		seleniumRubyImg.click();
		return new SeleniumRubyPage(driver);
	}
	
	public MyAccountPage clickOnMyAccountLink()
	{
		myAccountLink.click();
		return new MyAccountPage(driver);
	}
	
}
