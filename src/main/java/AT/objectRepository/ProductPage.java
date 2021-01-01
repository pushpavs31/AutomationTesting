package AT.objectRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AT.utility.Utilities;

public class ProductPage {

	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *****************************page elements **************************

	@CacheLookup
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement homeMenuLink;

	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/aside[@id='sidebar']/div[@id='woocommerce_price_filter-2']/form[1]/div[1]/div[1]/span[2]")
	WebElement filterSliderDot2;

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	WebElement filterButton;
	
	@CacheLookup
	@FindBy(xpath = "//select[@name='orderby']")
	WebElement dropDownField;
	
	@CacheLookup
	@FindBy(xpath = "//h3[normalize-space()='Selenium Ruby']/ancestor::li/parent::ul/descendant::h3")
	List<WebElement> popularProduct;
	
	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li[1]/a[2]")
	WebElement readMoreButtonOfAndroidQuickGuide;
	
	@CacheLookup
	@FindBy(xpath = "//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/ul[1]/li[3]/a[2]")
	WebElement HTML5BasketButton;
	
	@CacheLookup
	@FindBy(xpath = "//a[@title='View your shopping cart']")
	WebElement itemMenu;

	// ****************************methods*********************************

	public HomePage clickOnHomeMenu() throws InterruptedException {
		Thread.sleep(2000);
		homeMenuLink.click();
		return new HomePage(driver);
	}

	public void changingSlider2() {

		Actions action = new Actions(driver);
		action.dragAndDropBy(filterSliderDot2, -28, 00).build().perform();

	}

	public void clickOnFilterButton() {
		filterButton.click();
	}

	public List<Object> VerifyPriceShouldNotMoreThan450() {
		
		
		String first="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[";
		String second="]/a[1]/span[1]/span[1]";
		String third="]/a[1]/span[2]/ins[1]/span[1]";
		
		List<Object> price=new ArrayList<>();
				
		for(int i=1;i<=7;i++)
		{
			String productPrice;
			try {
			 productPrice = driver.findElement(By.xpath(first+i+second)).getText();
			 price.add(productPrice);
			
			}catch(Exception e)
			{
				 productPrice = driver.findElement(By.xpath(first+i+third)).getText();
				 price.add(productPrice);
			}
		}
		return price;
	}
	
	public void filterProductBypopularity()
	{
		Select select=new Select(dropDownField);
		try {
		select.selectByVisibleText("Sort by popularity");
		}catch(Exception e)
		{
			select.selectByIndex(1);
		}
	}
	
	public List<WebElement> popularProduct()
	{
		return popularProduct;
	}
	
	public AndroidQuickGuidePage clickOnReadMoreButtonOfAndroidQuickGuide() throws InterruptedException
	{
		Thread.sleep(2000);
		Utilities.javaScriptClicK(readMoreButtonOfAndroidQuickGuide, driver);
		return new AndroidQuickGuidePage(driver);
	}
	
	public void clickOnHtml5AddToCartButton()
	{
		Utilities.javaScriptClicK(HTML5BasketButton, driver);
		
	}
	
	public BasketPage clickOnItemMenu()
	{
		
		Utilities.javaScriptClicK(itemMenu, driver);
		return new BasketPage(driver);
	}
	
	public boolean verifyItemMenuIsDisplaying()
	{
		return itemMenu.isDisplayed();
	}
}
