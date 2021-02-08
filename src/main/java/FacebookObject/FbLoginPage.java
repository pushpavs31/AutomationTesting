package FacebookObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class FbLoginPage {
	
	 WebDriver driver;
	
	
	public FbLoginPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(id="email")
	private WebElement emailField;
	
	@CacheLookup
	@FindBy(id="pass")
	private WebElement passField;
	
	@CacheLookup
	@FindBy(xpath="//button[normalize-space()='Log In']")
	public WebElement loginButton;
	
	
	//*************************Methods*****************************************
	
	public void enterEmailField(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void enterPassField(String pass)
	{
		passField.sendKeys(pass);
	}

	public HomePage clickOnSubmitButton()
	{
		Utilities.javaScriptClicK(loginButton, driver);
		return new HomePage(driver);
	}
	
	
}
