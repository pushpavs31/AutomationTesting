package FacebookObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class HomePage {
	
	public WebDriver driver;
	
	
	public HomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@CacheLookup
	@FindBy(xpath="//i[@class='hu5pjgll op6gxeva sp_Q_hfOj-xGcZ sx_090b5d']")
	private WebElement DropDownFieldForLogout;
	
	@CacheLookup
	@FindBy(xpath="//button[@id='u_0_i']")
	private WebElement LogoutButton;
	
	
	//********************methods*********************
	
	public void clickOnDropDown()
	{
		Utilities.waitForElementUntilClickable(DropDownFieldForLogout, 15, driver);
		Actions action=new Actions(driver);
		action.moveToElement(DropDownFieldForLogout).click().build().perform();
	}
	
	public void clickOnLogoutLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(LogoutButton).click().build().perform();
	}
	

}
