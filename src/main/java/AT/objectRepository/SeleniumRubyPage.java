package AT.objectRepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AT.utility.Utilities;

public class SeleniumRubyPage {

	WebDriver driver;

	public SeleniumRubyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *****************************page elements **************************

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Add to basket')]")
	WebElement rubyAddToBasketButton;

	@CacheLookup
	@FindBy(xpath = "//span[@class='cartcontents']")
	WebElement cartItem;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Description')]")
	WebElement rubyDescriptionTab;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='product-160']/div[3]/div[1]/p[1]")
	private WebElement rubyDescription;

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Reviews (0)')]")
	WebElement rubyReviewTab;

	@CacheLookup
	@FindBy(xpath = "//h2[contains(text(),'Reviews')]")
	WebElement rubyReview;

	@CacheLookup
	@FindBy(xpath = "//input[@title='Qty']")
	private WebElement productTypeField;

	// ****************************methods*********************************

	public void clickOnRubyAddToBasketButton() {
		rubyAddToBasketButton.click();

	}

	public String verifyPageTitle() {
		return driver.getTitle();
	}

	public BasketPage clickOnCartItem() {
		Utilities.waitForElementUntilClickable(cartItem, 10, driver);
		cartItem.click();
		return new BasketPage(driver);
	}

	public void clickOnRubyDescriptionTab() {
		rubyDescriptionTab.click();
	}

	public boolean verifyRubyDescriptionIsAvailable() {
		String description = rubyDescription.getText();
		System.out.println(description);
		return rubyDescription.isDisplayed();
	}

	public void clickOnRubyReviewTab() {
		rubyReview.click();
	}

	public boolean verifyReviewIsPresent() {
		return rubyReview.isDisplayed();
	}

	public void enterQuantityOfRuby(int num) {
		productTypeField.clear();
		Utilities.waitForElementUntilClickable(productTypeField, 5, driver);
		productTypeField.sendKeys(String.valueOf(num));
	}

	public String checkErrorMsgForOutOfQuantity() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
 
}
