package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import AT.Base.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {
	static WebDriver driver;
	static String productPrice;

	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://practice.automationtesting.in/");
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		driver.
		

			
			

	}

	}
