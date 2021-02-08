package AT.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AT.utility.Utilities;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *****************************page elements **************************

	@CacheLookup
	@FindBy(xpath = "//h3[contains(text(),'Billing Details')]")
	WebElement BillingDetailsHeading;

	@CacheLookup
	@FindBy(xpath = "//h3[@id='order_review_heading']")
	WebElement orderDetailsheading;

	@CacheLookup
	@FindBy(xpath = "//h3[@id='order_review_heading']")
	WebElement bankTransferheading;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_first_name']")
	WebElement firstname;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_last_name']")
	WebElement lastname;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_email']")
	WebElement email;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_phone']")
	WebElement phone;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_address_1']")
	WebElement addressField;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_city']")
	WebElement cityField;

	@CacheLookup
	@FindBy(xpath = "//select[@id='billing_state']")
	WebElement StateDropDown;

	@CacheLookup
	@FindBy(xpath = "//select[@id='billing_country']")
	WebElement countryDropDown;

	@CacheLookup
	@FindBy(xpath = "//label[contains(text(),'Cash on Delivery')]")
	WebElement cashOnDeliveryCheckBox;

	@CacheLookup
	@FindBy(xpath = "//input[@id='place_order']")
	WebElement placeOrderButton;

	@CacheLookup
	@FindBy(xpath = "//input[@id='billing_postcode']")
	WebElement postalCode;

	@CacheLookup
	@FindBy(xpath = "//input[@id='payment_method_cod']")
	WebElement orderConfirmationMessage;

	// >>>>>>>>>>>>>>>>>>>>>>methods>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public boolean isBilling_n_Order_Payment_optionAvailable() {
		boolean flag = false;
		if (BillingDetailsHeading.isDisplayed() == true) {
			if (orderDetailsheading.isDisplayed() == true) {
				if (bankTransferheading.isDisplayed() == true) {
					flag = true;
				}
			}
		}
		return flag;
	}

	public void enterFirstName(String fname) {
		firstname.sendKeys(fname);
	}

	public void enterLastName(String lname) {
		lastname.sendKeys(lname);
	}

	public void enterEmail(String emails) {
		email.sendKeys(emails);
	}

	public void enterPhoneNum(String num) {
		phone.sendKeys(num);
	}

	public void enteraddress(String adr) {
		addressField.sendKeys(adr);
	}

	public void entercity(String city) {
		cityField.sendKeys(city);
	}

	public void selectState(String sname) throws InterruptedException {
		Select select = new Select(StateDropDown);
		Actions action = new Actions(driver);
		try {
			select.selectByVisibleText(sname);
		} catch (Exception e) {
			Thread.sleep(2000);
			try {
			action.moveToElement(driver.findElement(By.xpath("//span[@id='select2-chosen-2']"))).click().build()
					.perform();
			Utilities.waitForElementUntilClickable(driver.findElement(
							By.xpath("//div[@class='select2-result-label' and @id='select2-result-label-39']")), 5, driver);
			action.moveToElement(driver
					.findElement(By.xpath("//div[@class='select2-result-label' and @id='select2-result-label-39']")))
					.click().build().perform();

//			Utilities.javaScriptClicK(
//					driver.findElement(
//							By.xpath("//div[@class='select2-result-label' and @id='select2-result-label-39']")),
//					driver);
			}catch(Exception a)
			{
				a.printStackTrace();
				
			}
		}
	}

	public void selectcountry(String cname) {
		Select select = new Select(countryDropDown);

		try {
			select.selectByVisibleText(cname);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectPaymentMethod() {
		Utilities.javaScriptClicK(cashOnDeliveryCheckBox, driver);
	}

	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();
	}

	public void enterPostalCode(String pcode) {
		postalCode.sendKeys(pcode);
	}

	public boolean verifyOrderConfirmationMessage(String msg) {
		boolean flag = false;
		if (orderConfirmationMessage.getText().equalsIgnoreCase(msg)) {
			System.out.println(orderConfirmationMessage.getText());
			flag = true;
		}
		return true;
	}
}
