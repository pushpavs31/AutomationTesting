package AT.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import AT.utility.Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	int max_page_load_time = 100;
	int max_implicit_time = 80;
	public static Logger log;
	public static String browser;
	public static WebDriver Ndriver;
	String file = ".\\Configuration\\globalprop.properties";
	public ExtentSparkReporter sparkreporter;
	public ExtentReports Ereport;
	public ExtentTest ETest;

	public static ThreadLocal<WebDriver> TDriver = new ThreadLocal<>();

	public void initialization() {

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
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		TDriver.set(driver);
		Ndriver = TDriver.get();

		Ndriver.manage().window().maximize();
		Ndriver.manage().deleteAllCookies();
		Ndriver.manage().timeouts().pageLoadTimeout(max_page_load_time, TimeUnit.SECONDS);
		Ndriver.manage().timeouts().implicitlyWait(max_implicit_time, TimeUnit.SECONDS);

		log = LogManager.getLogger(BaseClass.class.getName());
		log.debug(browser + " Browser has started Successfully");

		String url = prop.getProperty("url");
		Ndriver.get(url);

	}

	// ************************Closing Driver***********************************

	public void closure() {
		Ndriver.close();
	}

	public void quit() {
		Ndriver.quit();
	}

	// ************************Extent Report method******************************

	public void sparkReport_Init(String methodName) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "AT-" + timeStamp + ".html";

		sparkreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\test-output\\Extent-report\\Shop-function\\" + reportName);
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

	public void startTest(String methodname) {
		ETest = Ereport.createTest("Test : " + methodname);
	}

	public void endTest() {
		Ereport.flush();
	}

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

			String screenshotpath = Utilities.takeScreenShot(methodname, Ndriver);
			try {
				ETest.addScreenCaptureFromPath(screenshotpath, methodname);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
