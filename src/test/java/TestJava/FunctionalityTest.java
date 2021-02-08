package TestJava;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AT.Base.BaseTest;
import AT.objectRepository.HomePage;
import AT.objectRepository.ProductPage;

public class FunctionalityTest extends BaseTest {
	HomePage homepage;
	ProductPage productpage;
	
//	@BeforeTest
//	public void generateReport(Method method)
//	{
//		String methodName = method.getName();
//		sparkReport_Init( methodName);
//	}
//	
//	@AfterTest
//	public void endReport()
//	{
//		endTest();
//	}
	
//	@BeforeMethod
//	public void Setup(Method name) {
////		String methodname = name.getName();
////		startTest(methodname);
//		
//		initialization();
//		log.debug("************* "+ browser + " Browser has launched successfully *************");
//		log.info("Webpage has Opened and maximise");
//		homepage = new HomePage(Ndriver);
//	}
	

	@Test
	public void filter_By_Price_Functionality() {
		productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");

		productpage.changingSlider2();
		log.info("moved slider from right to left");

		productpage.clickOnFilterButton();
		log.info("clicked on Filter button");

		List allProductPrice = productpage.VerifyPriceShouldNotMoreThan450();
		log.info("all prouct are filtred accordin to price");
		Iterator newp = allProductPrice.iterator();
		while (newp.hasNext()) {
			Object printvalue = newp.next();
			System.out.println(printvalue);
			log.info(printvalue);
		}
	}

//	@AfterMethod
//	public void tearDown(ITestResult result) {
//		
//		if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			ETest.log(Status.PASS,MarkupHelper.createLabel("Test Name : "+result.getName(), ExtentColor.GREEN));
//			ETest.info("Test execution has passed for " + result.getName());
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			ETest.log(Status.SKIP,MarkupHelper.createLabel("Test Name : "+result.getName(), ExtentColor.ORANGE));
//			ETest.info("Test execution has skipped for " +result.getName());
//		}
//		else if(result.getStatus()==ITestResult.FAILURE)
//		{
//			String methodname = result.getName();
//			ETest.log(Status.FAIL, MarkupHelper.createLabel("Test Name : "+methodname, ExtentColor.RED));
//			ETest.log(Status.FAIL, "Test execution has failed "+result.getThrowable());
//			ETest.info("Test is failed,screenhot has been taken, check above screenshot");
//
//			String screenshotpath = Utilities.takeScreenShot(methodname,Ndriver);
//			try {
//				ETest.addScreenCaptureFromPath(screenshotpath, methodname);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
			
//		closure();
//		log.debug("************* " + browser+ " Browser closed successfully*************");
//	}

	@Test
	public void sort_Product_By_Popularity() {
		productpage = homepage.clickOnShopMenu();
		log.info("clicked on shop menu");
		
		productpage.filterProductBypopularity();
		log.info("sorted product by popularity");
		
		List<WebElement> productlist = productpage.popularProduct();
		log.info(" popular product list");
		Iterator<WebElement> list = productlist.iterator();
		while(list.hasNext())
		{
			 String names = list.next().getText();
			 System.out.println(" "+names);
			 log.info(names);
		}
		
	}
}
