package AT.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import AT.utility.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	

	public static WebDriver driver;
	public static Properties prop;
	int max_page_load_time = 100;
	int max_implicit_time = 80;
	public static Logger log;
	public static String browser;
	String file = ".\\Configuration\\globalprop.properties";
	


	public static ThreadLocal<WebDriver> TDriver = new ThreadLocal<>();

//	@BeforeMethod
	public void initialization() {
		
//		String methodname = name.getName();

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(file);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		browser = prop.getProperty("browser1");

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			TDriver.set(driver);
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			TDriver.set(driver);
		}

		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			TDriver.set(driver);
		}


		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(max_page_load_time, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(max_implicit_time, TimeUnit.SECONDS);

		log = LogManager.getLogger(BaseClass.class.getName());
		log.debug(browser + " Browser has started Successfully");
//		ETest = Ereport.createTest("Test : " + methodname);
		String url = prop.getProperty("url");
		getDriver().get(url);

	}
	
	public WebDriver getDriver()
	{
		return this.TDriver.get();
	}

//	@AfterMethod
//	public void extentFailure(ITestResult result) {
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
//			String screenshotpath = Utilities.takeScreenShot(methodname,getDriver());
//			try {
//				ETest.addScreenCaptureFromPath(screenshotpath, methodname);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		getDriver().close();
//
//	}
}
