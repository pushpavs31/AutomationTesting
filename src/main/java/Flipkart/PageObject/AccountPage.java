package Flipkart.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class AccountPage {

	public WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *************************page Objects*****************************

	@CacheLookup
	@FindBy(xpath = "//span[@class='oKZoMV']")
	WebElement peronalInformationEditLink;

	@CacheLookup
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstnameField;

	@CacheLookup
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastNameField;

	@CacheLookup
	@FindBy(xpath = "//label[@for='Female']//div[@class='_1XFPmK']")
	WebElement femaleCheckbox;

	@CacheLookup
	@FindBy(xpath = "//label[@for='Male']//div[@class='_1XFPmK']")
	WebElement maleCheckbox;

	@CacheLookup
	@FindBy(xpath = "//label[@for='Male']//div[@class='_1XFPmK']")
	WebElement saveButtonOfpersonalInfo;

	@CacheLookup
	@FindBy(xpath = "//a[normalize-space()='MY ORDERS']")
	WebElement myOrderIcon;

	// ***************************Methods*****************************************

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyDashboardIsDisplayed() {
		return myOrderIcon.isDisplayed();
	}

	public void clickOnpersonalInfoEditLink() {
		Utilities.waitForElementUntilClickable(peronalInformationEditLink, 5, driver);
		peronalInformationEditLink.click();
	}

	public void enterName(String name) throws InterruptedException {
		Utilities.waitForVisibleElement(firstnameField, 3, driver);
		firstnameField.clear();
		Thread.sleep(3000);
		firstnameField.sendKeys(name);
	}

	public void enterLastName(String Lname) throws InterruptedException {
		Utilities.waitForVisibleElement(firstnameField, 3, driver);
		lastNameField.clear();
		Thread.sleep(3000);
		lastNameField.sendKeys(Lname);
	}

	public void selectFemaleCheckBox() {
		femaleCheckbox.click();
	}
	
	public void clickOnSaveButton()
	{
		Utilities.waitForElementUntilClickable(saveButtonOfpersonalInfo, 3, driver);
		saveButtonOfpersonalInfo.click();
	}
}
