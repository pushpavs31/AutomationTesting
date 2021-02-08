package FacebookTest;

import org.testng.annotations.Test;

import AT.Base.BaseTest;
import FacebookObject.FbLoginPage;
import FacebookObject.HomePage;

public class FacebookLoginTest extends BaseTest {
	FbLoginPage loginpage;
	HomePage homePage;

	@Test(enabled = true, description = "this test all about login and logout of facebook")
	public void login_and_LogoutTest() throws InterruptedException {
		loginpage = new FbLoginPage(getDriver());

		loginpage.enterEmailField(prop.getProperty("uname"));
		log.info("Enterd email in field");
		ETest.info("Enterd email in field");

		loginpage.enterPassField(prop.getProperty("upass"));
		log.info("Enterd password in field");
		ETest.info("Enterd password in field");

		Thread.sleep(2000);
		homePage = loginpage.clickOnSubmitButton();
		log.info("Click on Login Button");
		ETest.info("Click on Login Button");
		
		Thread.sleep(4000);
		homePage.clickOnDropDown();
		log.info("Click drop Down ");
		ETest.info("Click drop Down ");
		
		Thread.sleep(4000);
		homePage.clickOnLogoutLink();
		log.info("Click on Logout Link");
		ETest.info("Click on Logout Link");
	}

}
