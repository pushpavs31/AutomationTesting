package TestJava;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import AT.Base.BaseClass;
import AT.objectRepository.BasketPage;
import AT.objectRepository.HomePage;
import AT.objectRepository.ProductPage;
import AT.objectRepository.SeleniumRubyPage;
import AT.utility.Utilities;

public class HomePageTest extends BaseClass {
	HomePage homepage;
	ProductPage productpage;
	HomePage homepage1;
	SeleniumRubyPage seleniumruby;
	BasketPage basketpage;

//	@BeforeTest
//	public void generateReport(Method method) {
//		String methodName = method.getName();
//		sparkReport_Init(methodName);
//	}
//
//	@AfterTest
//	public void endReport() {
//		endTest();
//	}
	
	@BeforeMethod
	public void setUp(Method name) throws InterruptedException {
//		String method = name.getName();
//		startTest(method);
		initialization();
		
		log.debug("************* " + browser + " Browser has launched successfully *************");
		log.info("Webpage has Opened and maximise");
		homepage = new HomePage(Ndriver);

	}

	 @Test
	public void homePageHasThreeArrival() throws InterruptedException {

		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
//
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			ETest.log(Status.PASS, MarkupHelper.createLabel("Test Name : " + result.getName(), ExtentColor.GREEN));
//			ETest.info("Test execution has passed for " + result.getName());
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			ETest.log(Status.SKIP, MarkupHelper.createLabel("Test Name : " + result.getName(), ExtentColor.ORANGE));
//			ETest.info("Test execution has skipped for " + result.getName());
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			String methodname = result.getName();
//			ETest.log(Status.FAIL, MarkupHelper.createLabel("Test Name : " + methodname, ExtentColor.RED));
//			ETest.log(Status.FAIL, "Test execution has failed " + result.getThrowable());
//			ETest.info("Test is failed,screenhot has been taken, check above screenshot");
//
//			String screenshotpath = Utilities.takeScreenShot(methodname, Ndriver);
//			try {
//				ETest.addScreenCaptureFromPath(screenshotpath, methodname);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		endTest();
		closure();
		log.debug("************* " + browser + " Browser closed successfully*************");
	}

	@Test
	public void imagesInArrivalShoulsNavigate() throws InterruptedException {

		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		seleniumruby = homepage.clickOnSeleniumRubyImage();
		log.info("clicked on ruby Image");

		String pageTitle = seleniumruby.verifyPageTitle();
		log.debug("Next page title is : " + pageTitle);

		Assert.assertEquals(pageTitle, "Selenium Ruby – Automation Practice Site");
		log.info("page title is matching with expected title");

		seleniumruby.clickOnRubyAddToBasketButton();
		log.info("clicked on ruby basket button");

		basketpage = seleniumruby.clickOnCartItem();
		log.info("clicked on cart item");

		boolean rubyInBasket = basketpage.verifyRubyIsAddedInBasket();

		Assert.assertTrue(rubyInBasket, "Ruby is suucessfully added in basket");
		log.info("ruby is successfully added in basket");

	}

	@Test
	public void imageArrivalDescription() throws InterruptedException {
		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		seleniumruby = homepage.clickOnSeleniumRubyImage();
		log.info("clicked on ruby Image");

		String pageTitle = seleniumruby.verifyPageTitle();
		log.debug("Next page title is : " + pageTitle);

		Assert.assertEquals(pageTitle, "Selenium Ruby – Automation Practice Site");
		log.info("page title is matching with expected title");

		seleniumruby.clickOnRubyDescriptionTab();
		log.info("clicked on description tab");

		boolean description = seleniumruby.verifyRubyDescriptionIsAvailable();

		Assert.assertEquals(description, true);
		log.info("selenium ruby description is available");

	}

	@Test
	public void arrivalImageReview() throws InterruptedException {
		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		seleniumruby = homepage.clickOnSeleniumRubyImage();
		log.info("clicked on ruby Image");

		String pageTitle = seleniumruby.verifyPageTitle();
		log.debug("Next page title is : " + pageTitle);

		Assert.assertEquals(pageTitle, "Selenium Ruby – Automation Practice Site");
		log.info("page title is matching with expected title");

		seleniumruby.clickOnRubyReviewTab();
		log.info("clicked on ruby review tab");

		boolean review = seleniumruby.verifyReviewIsPresent();

		Assert.assertTrue(review, "review is not present");
	}

	 @Test
	public void arrival_Image_AddTo_Basket() throws InterruptedException {
		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		seleniumruby = homepage.clickOnSeleniumRubyImage();
		log.info("clicked on ruby Image");

		String pageTitle = seleniumruby.verifyPageTitle();
		log.debug("Next page title is : " + pageTitle);

		Assert.assertEquals(pageTitle, "Selenium Ruby – Automation Practice Site");
		log.info("page title is matching with expected title");

		seleniumruby.clickOnRubyAddToBasketButton();
		log.info("clicked on ruby basket button");

		basketpage = seleniumruby.clickOnCartItem();
		log.info("clicked on cart item");

		boolean verifyProductAndItsPrice = basketpage.verifyRubyBookIsAvailableWithPrice("Selenium Ruby", "?500.00");
		Assert.assertTrue(verifyProductAndItsPrice);
		log.info("Selenium Ruby book is present on Basket with price");

	}

	 @Test
	public void arrival_Add_To_Basket_With__MoreBooks() throws InterruptedException {
		ProductPage productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		homepage1 = productpage.clickOnHomeMenu();
		log.info("clicked on home menu");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		Assert.assertEquals(true, homepage1.verifyThreeArrivals());
		log.info("home page has only three arrival");

		seleniumruby = homepage.clickOnSeleniumRubyImage();
		log.info("clicked on ruby Image");

		String pageTitle = seleniumruby.verifyPageTitle();
		log.debug("Next page title is : " + pageTitle);

		seleniumruby.enterQuantityOfRuby("414");
		log.info("Entered the vale in text box ");

		seleniumruby.clickOnRubyAddToBasketButton();
		log.info("clicked on ruby add to basket button");

		String msg = seleniumruby.checkErrorMsgForOutOfQuantity();

		System.out.println(msg);
		log.info("Displayed error messge ** " + msg);

	}
}
