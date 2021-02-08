package TestJava;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import AT.Base.BaseClass;
import AT.objectRepository.HomePage;
import AT.objectRepository.MyAccountPage;
import AT.utility.Utilities;

public class RegistrationTest extends BaseClass {

	HomePage homepage;
	MyAccountPage accountPage;
	public ExtentTest ETest;
	public ExtentReports Ereport;
	
	@BeforeTest
	public void setup()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "AT-" + timeStamp + ".html";

		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\test-output\\Extent-report\\RegistrationR\\" + reportName);
		sparkreporter.config().setDocumentTitle("Automation Testing");
		sparkreporter.config().setReportName(" Shop Functionality Testing");
		sparkreporter.config().setTheme(Theme.DARK);

		Ereport = new ExtentReports();
		Ereport.attachReporter(sparkreporter);

		Ereport.setSystemInfo("Host Name", "Localhost");
		Ereport.setSystemInfo("Envionment", "QA");
		Ereport.setSystemInfo("OS", "Windows-10");
		Ereport.setSystemInfo("Tester name", "Siddhant");
	}
	
	@AfterTest
	public void closeReport()
	{
		Ereport.flush();
	}
	
	@BeforeMethod
	public void browsersetUp(Method name)
	{
		String methodname = name.getName();
		ETest = Ereport.createTest("Test : " + methodname);
		initialization();
	}
	
	@AfterMethod
	public void extentFailure(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			ETest.log(Status.PASS, MarkupHelper.createLabel("Test Name : " + result.getName(), ExtentColor.GREEN));
			ETest.info("Test execution has passed for " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ETest.log(Status.SKIP, MarkupHelper.createLabel("Test Name : " + result.getName(), ExtentColor.ORANGE));
			ETest.info("Test execution has skipped for " + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String methodname = result.getName();
			ETest.log(Status.FAIL, MarkupHelper.createLabel("Test Name : " + methodname, ExtentColor.RED));
			ETest.log(Status.FAIL, "Test execution has failed " + result.getThrowable());
			ETest.info("Test is failed,screenhot has been taken, check above screenshot");

			String screenshotpath = Utilities.takeScreenShot(methodname,Ndriver);
			try {
				ETest.addScreenCaptureFromPath(screenshotpath, methodname);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		Ndriver.close();

	}


	@Test(priority=1)
	public void registration_with_Valid_Invalid_Data() throws InterruptedException {
		homepage = new HomePage(Ndriver);
		accountPage = homepage.clickOnMyAccountLink();
		log.info("click on My account link");
		ETest.info("click on My account link");

		accountPage.enterEmailFieldforReg("siddhantvs56@gmail.com");
		log.info("Enterd email address in email field");
		ETest.info("Enterd email address in email field");
		Thread.sleep(2000);

		accountPage.enterPasswordFieldForReg("31Pushpavinod@123$");
		Thread.sleep(4000);
		log.info("Entered password in password field");
		ETest.info("Entered password in password field");

		accountPage.clickOnRegisterButton();
		log.info("click on Register button");
		ETest.info("click on Register button");
		
		boolean verifyLogin = accountPage.verifyUserLogin("hello");
		Assert.assertTrue(verifyLogin,"login unsuccessfull");
		log.info("is loginmessage displayed "+verifyLogin);

	}
	
	
	@Test(priority=2)
	public void registration_with_Invalid_email() throws InterruptedException {
		homepage = new HomePage(Ndriver);
		accountPage = homepage.clickOnMyAccountLink();
		log.info("click on My account link");
		ETest.info("click on My account link");

		accountPage.enterEmailFieldforReg("siddhantvs983@gmail");
		log.info("Enterd email address in email field");
		ETest.info("Enterd invalid email address in email field");
		Thread.sleep(2000);

		accountPage.enterPasswordFieldForReg("31Pushpavinod@123$");
		Thread.sleep(2000);
		log.info("Entered password in password field");
		ETest.info("Entered password in password field");

		accountPage.clickOnRegisterButton();
		Thread.sleep(2000);
		log.info("click on Register button");
		ETest.info("click on Register button");
		
		boolean verifymsg = accountPage.verfiyInvalidEmailErrorMsg("Error: Please provide a valid email address.");
		Assert.assertTrue( verifymsg,"message is not matching");
		log.info("is error msg displayed with enterd invlid email "+verifymsg);

	}

	@Test(priority=3)
	public void registration_with_Empty_email() throws InterruptedException {
		homepage = new HomePage(Ndriver);
		accountPage = homepage.clickOnMyAccountLink();
		log.info("click on My account link");
		ETest.info("click on My account link");

		accountPage.enterEmailFieldforReg("");
		log.info("Enterd email address in email field");
		ETest.info("Enterd Empty email address in email field");
		Thread.sleep(2000);

		accountPage.enterPasswordFieldForReg("31Pushpavinod@123$");
		Thread.sleep(3000);
		log.info("Entered password in password field");
		ETest.info("Entered password in password field");

		accountPage.clickOnRegisterButton();
		Thread.sleep(2000);
		log.info("click on Register button");
		ETest.info("click on Register button");
		
		boolean verifymsg = accountPage.verfiyInvalidEmailErrorMsg("Error: Please provide a valid email address.");
		Assert.assertTrue( verifymsg,"message is not matching");
		log.info("is error msg displayed with enterd invlid email "+verifymsg);
		

	}
	
	

}
