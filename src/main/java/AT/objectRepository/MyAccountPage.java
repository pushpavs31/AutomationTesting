package AT.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class MyAccountPage {

	public WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *****************************page elements **************************

	@CacheLookup
	@FindBy(id = "username")
	WebElement LoginusernameField;

	@CacheLookup
	@FindBy(id = "password")
	WebElement LoginpasswordField;

	@CacheLookup
	@FindBy(xpath = "//input[@value='Login']")
	WebElement LoginButton;

	@CacheLookup
	@FindBy(id = "reg_email")
	WebElement RegEmailField;

	@CacheLookup
	@FindBy(id = "reg_password")
	WebElement RegPasswordField;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/div[1]/div[2]/form[1]/p[3]/input[3]")
	WebElement registrationButton;

	@CacheLookup
	@FindBy(xpath = "//div[@id='body']//li[1]")
	WebElement msgForInvalidEmail;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/ul[1]/li[1]")
	WebElement msgForInvalidPass;

	// ***********************methods********************************

	public void enterEmailFieldforReg(String email) {
		RegEmailField.sendKeys(email);
	}

	public void enterPasswordFieldForReg(String pass) {
		RegPasswordField.sendKeys(pass);
	}

	public void clickOnRegisterButton() {
		
		Utilities.waitForElementUntilClickable(registrationButton, 60, driver);
		registrationButton.click();
	}

	public boolean verifyUserLogin(String msg) {
		return driver.getPageSource().contains(msg);
	}

	public boolean verfiyInvalidEmailErrorMsg(String msg1) {
		
		Utilities.waitForElementUntilClickable(msgForInvalidEmail, 5, driver);
		boolean flag = false;

		if (msgForInvalidEmail.getText().equals(msg1)) {
			flag = true;
		}
		return flag;
		
	}

	public boolean verfiyInvalidPassErrorMsg(String msg3) {

		boolean flag = false;

		if (msgForInvalidPass.getText().equalsIgnoreCase(msg3)) {
			flag = true;
		}
		return flag;
	}
}
