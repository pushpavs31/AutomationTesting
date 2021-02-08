package Flipkart.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************page Objects*****************************

	@CacheLookup
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement loginEmailField;

	@CacheLookup
	@FindBy(xpath = "//input[@type='password']")
	WebElement loginPasswordField;

	@CacheLookup
	@FindBy(xpath = "//span[normalize-space()='Forgot?']")
	WebElement loginForgetPassword;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'New to Flipkart? Create an account')]")
	WebElement createAnAccountLink;

	@CacheLookup
	@FindBy(xpath = "//input[@class='_2IX_2- VJZDxU']")
	WebElement entreMobileNumberField;

	@CacheLookup
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement continueButton;

	@CacheLookup
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement logInButton;
	
	@CacheLookup
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")
	WebElement profile;
	
	@CacheLookup
	@FindBy(xpath = "//div[normalize-space()='My Profile']")
	WebElement myProfile;

	// ***************************methods***********************************************

	public void clickOnRegisterLink() {
		Utilities.waitForVisibleElement(createAnAccountLink, 10, driver);
		createAnAccountLink.click();
	}

	public void entreMobileNumber(String number) {
		Utilities.waitForVisibleElement(entreMobileNumberField, 3, driver);
		entreMobileNumberField.sendKeys(number);
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}

	public void entreLoginEmail(String num) {
		Utilities.waitForVisibleElement(loginEmailField, 10, driver);
		loginEmailField.sendKeys(num);
	}

	public void entrePasswordField(String pass) {
		loginPasswordField.sendKeys(pass);
	}

	public void clickOnLoginButton() {
		logInButton.click();
	}

	public boolean verifyLoginSuccessfull() {
return driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]")).isDisplayed();
	}
	
	public void MouseHoverOnProfile()
	{
		Actions action =new Actions(driver);
		action.moveToElement(profile).perform();
	}
	
	public AccountPage clickOnMyProfile()
	{
		Utilities.waitForVisibleElement(myProfile, 3, driver);
		Actions action =new Actions(driver);
		action.moveToElement(myProfile).click().build().perform();
		return new AccountPage(driver);
	}
}
