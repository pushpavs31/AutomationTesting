package FlipkartTest;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import AT.Base.BaseTest;
import Flipkart.PageObject.HomePage;

public class LogInTest extends BaseTest {
	
	
	@Test(enabled=false)
	public void loginWithValidCredentials()
	{
		HomePage homepage=new HomePage(getDriver());
		
		homepage.entreLoginEmail(prop.getProperty("mobilenum"));
		log.info("Entered mobile number");
		ETest.info("Entered mobile number");
		
		homepage.entrePasswordField(prop.getProperty("password"));
		log.info("Entered password");
		ETest.info("Entered password");
		
		homepage.clickOnLoginButton();
		log.info("clicked on login button");
		ETest.info("clicked on login button");
		
		boolean loginstatus = homepage.verifyLoginSuccessfull();
		
		Assert.assertTrue(loginstatus);
		log.info("login successfull");
		ETest.info("login successfull");
			
	}
	
	@Test
	public void chechException()
	{
		HomePage homepage=new HomePage(getDriver());
		homepage.entreLoginEmail(prop.getProperty("mobilenum"));
		log.info("Entered mobile number");
		ETest.info("Entered mobile number");
		
		homepage.entrePasswordField(prop.getProperty("password"));
		log.info("Entered password");
		ETest.info("Entered password");
		
		homepage.clickOnLoginButton();
		log.info("clicked on login button");
		ETest.info("clicked on login button");
		List<WebElement> item = getDriver().findElements(By.xpath("//div[contains(text(),'Car & Bike Accessories')]/parent::a/parent::div/parent::div/parent::"));
	}

}
