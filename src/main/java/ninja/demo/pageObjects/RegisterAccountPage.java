package ninja.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class RegisterAccountPage {

	WebDriver driver;

	public RegisterAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// ********************************Page Objects********************************

	@CacheLookup
	@FindBy(id = "input-firstname")
	WebElement firstNameField;

	@CacheLookup
	@FindBy(id = "input-lastname")
	WebElement lastNameField;

	@CacheLookup
	@FindBy(id = "input-email")
	WebElement emailField;

	@CacheLookup
	@FindBy(id = "input-telephone")
	WebElement telephoneField;

	@CacheLookup
	@FindBy(id = "input-password")
	WebElement passwordField;

	@CacheLookup
	@FindBy(id = "input-confirm")
	WebElement confirmPasswordField;

	@CacheLookup
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@CacheLookup
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;

	// ************************methods*************************************

	public void enterFirstName(String name) {
		firstNameField.sendKeys(name);
	}

	public void enterLastName(String Lname) {
		lastNameField.sendKeys(Lname);
	}

	public void enterEmail(String Email) {
		emailField.sendKeys(Email);
	}

	public void enterPasswordField(String pass) {
		passwordField.sendKeys(pass);
	}

	public void enterConfirmPasswordField(String Cpass) {
		confirmPasswordField.sendKeys(Cpass);
	}

	public void enterTelephoneField(String phone) {
		telephoneField.sendKeys(phone);
	}

	public UserDashboardPage clickOnContinueButton() {
		Utilities.waitForElementUntilClickable(continueButton, 10, driver);
		continueButton.click();
		return new UserDashboardPage(driver);
	}

	public void clickOnPrivacyPolicyCheckbox() {

		privacyPolicyCheckBox.click();
	}

}
