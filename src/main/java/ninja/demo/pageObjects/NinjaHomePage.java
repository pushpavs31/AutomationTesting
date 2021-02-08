package ninja.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinjaHomePage {
	
	WebDriver driver;
	
	
	public NinjaHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//**********************page Objects*************************************
	
	@CacheLookup
	@FindBy (xpath="//span[contains(text(),'My Account')]")
	WebElement myAccountLink;
	
	@CacheLookup
	@FindBy (xpath="//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
	WebElement registerlink;
	
	
	
	//*********************methods******************************
	
	public void clickOnMyAccountLink() throws InterruptedException
	{
		myAccountLink.click();
		Thread.sleep(2000);
	}
	
	public RegisterAccountPage clickOnRegisterLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(registerlink).click().build().perform();
		return new RegisterAccountPage(driver);
	}
	
	

}
