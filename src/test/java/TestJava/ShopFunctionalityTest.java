package TestJava;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import AT.Base.BaseClass;
import AT.objectRepository.AndroidQuickGuidePage;
import AT.objectRepository.BasketPage;
import AT.objectRepository.CheckoutPage;
import AT.objectRepository.HomePage;
import AT.objectRepository.ProductPage;
import AT.utility.Utilities;

public class ShopFunctionalityTest extends BaseClass {
	HomePage homepage;
	ProductPage productpage;
	AndroidQuickGuidePage androidQuickPage;
	BasketPage basketpage;
	CheckoutPage checkoutpage;

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
	public void Setup() {
//		String methodname = name.getName();
//		sparkReport_Init(methodname);
//		startTest(methodname);

		initialization();
//		ETest.info("Test was performed on "+browser+" browser");
		log.debug("************* " + browser + " Browser has launched successfully *************");
		log.info("Webpage has Opened and maximise");
//		ETest.info("Webpage has Opened and maximise");
		homepage = new HomePage(Ndriver);
	}

	@AfterMethod
	public void tearDown() {

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
///		endTest();
		closure();
		log.debug("************* " + browser + " Browser closed successfully*************");
	}

	 @Test(description = "To read out of stock message is displayed or not")
	public void shop_ReadMore_Functionality() throws InterruptedException {
		productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");
//		ETest.info("clicked on shop menu");

		androidQuickPage = productpage.clickOnReadMoreButtonOfAndroidQuickGuide();
		log.info("clicked on read more button ofandroid quick guide");
//		ETest.info("clicked on read more button of android quick guide");

		boolean isMsgDisplay = androidQuickPage.verifyOutOfStockMsgForAndroid("Out of stock");
		log.info("is out of stock message is displayed on page " + isMsgDisplay);
//		ETest.info("is out of stock message is displayed on page " + isMsgDisplay);

		Assert.assertTrue(isMsgDisplay);
		log.info("message was clearly displaying on page");
//		ETest.info("message was clearly displaying on page");
	}

	//@Test(dataProvider = "dataProvider")
	public void add_To_Basket_View_Basket(String fname, String lname, String emails, String num, String cname,
			String adr, String city, String sname, String pcode) throws InterruptedException {

		productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		productpage.clickOnHtml5AddToCartButton();
		log.info("clicked on HTML5 add to cart button");

		boolean isItemLinkPresent = productpage.verifyItemMenuIsDisplaying();
		Assert.assertTrue(isItemLinkPresent);
		log.info("is item menu link is displaying :" + isItemLinkPresent);

		basketpage = productpage.clickOnItemMenu();
		log.info("clicked on Item menu");

		boolean isPriceNBookDisplay = basketpage.verifyBothPriceNBookDisplay();
		Assert.assertEquals(isPriceNBookDisplay, true, "product and price was not displaying on page");
		log.info("did product and price displayed on page :" + isPriceNBookDisplay);

		boolean subTotal_total = basketpage.verifySubTotal_TotalIsDisplay();
		log.info("is subtotal and total price displaying :" + subTotal_total);

		checkoutpage = basketpage.clickOnCheckOutButton();
		log.info("clicked on checlout button");

		boolean allDetails = checkoutpage.isBilling_n_Order_Payment_optionAvailable();
		Assert.assertTrue(allDetails);
		log.info("is billing , order and payment is displaying on checkout page : " + allDetails);

		checkoutpage.enterFirstName(fname);
		Thread.sleep(1000);
		log.info("enterd first name :" + fname);

		checkoutpage.enterLastName(lname);
		Thread.sleep(1000);
		log.info("enterd last name :" + lname);

		checkoutpage.enterEmail(emails);
		Thread.sleep(1000);
		log.info("enterd email");

		checkoutpage.enterPhoneNum(num);
		Thread.sleep(1000);
		log.info("enterd phone number");

		checkoutpage.selectcountry(cname);
		Thread.sleep(1000);
		log.info("selected country");

		checkoutpage.enteraddress(adr);
		Thread.sleep(1000);
		log.info("enterd address");

		checkoutpage.entercity(city);
		Thread.sleep(1000);
		log.info("enterd city");

		checkoutpage.selectState(sname);
		Thread.sleep(1000);
		log.info("enterd state");

		checkoutpage.enterPostalCode(pcode);
		Thread.sleep(1000);
		log.info("enterd postal code");

		checkoutpage.selectPaymentMethod();
		Thread.sleep(1000);
		log.info("selected payment method");

		checkoutpage.clickOnPlaceOrderButton();
		log.info("clicked on confirm order button");

		boolean confirmationMsg = checkoutpage
				.verifyOrderConfirmationMessage("Thank you. Your order has been received.");
		log.info("is order confirmation message on page");
		Assert.assertEquals(confirmationMsg, true, "confirmation message is not displayed");

	}

	//@DataProvider
	public Object[][] dataProvider() {
		Object[][] data = {
				{ "apex", "joseph", "svsn@gmail.com", "8976346598", "India", "at.hanuman", "pune", "Maharashtra",
						"441206" },
				{ "apesx", "joseh", "ssddvsn@gmail.com", "8976349598", "India", "at.keshav nagar", "pune",
						"Maharashtra", "441207" } };
		
		return data;
	}
}
