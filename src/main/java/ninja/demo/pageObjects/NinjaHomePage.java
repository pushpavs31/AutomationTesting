package ninja.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class NinjaHomePage {
	
	WebDriver driver;
	
	
	public NinjaHomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//**********************page Objects*************************************
	
	@CacheLookup
	@FindBy (xpath="//span[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	@CacheLookup
	@FindBy (xpath="//span[contains(text(),'My Account')]")
	WebElement registerlink;
	
	
	
	//*********************methods******************************
	
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	
	public RegisterAccountPage clickOnRegisterLink()
	{
		registerlink.click();
		return new RegisterAccountPage(driver);
	}
	
	

}
