package ninja.demo.Test;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import AT.Base.BaseTest;
import AT.utility.Utilities;
import ninja.demo.pageObjects.NinjaHomePage;
import ninja.demo.pageObjects.RegisterAccountPage;
import ninja.demo.pageObjects.UserDashboardPage;

public class WebsiteRegistrationTest extends BaseTest {
	NinjaHomePage homePage;
	RegisterAccountPage accountPage;
	UserDashboardPage userDashboard;

	@Test(enabled=true,dataProvider="getdata",description="user can register his account")
	public void filled_Registration(String name,String Lname,String Email,String phone,String pass, String Cpass) throws InterruptedException {

		homePage = new NinjaHomePage(getDriver());

		homePage.clickOnMyAccountLink();
		log.info("click on My account link");
		ETest.info("click on My account link");;
		
		Thread.sleep(2000);

		accountPage = homePage.clickOnRegisterLink();
		Thread.sleep(2000);
		log.info("click on Register link");
		ETest.info("click on Register link");

		accountPage.enterFirstName(name);
		Thread.sleep(2000);
		log.info("Entered first name");
		ETest.info("Entered first name");

		accountPage.enterLastName(Lname);
		Thread.sleep(2000);
		log.info("Entered last name");
		ETest.info("Entered last name");

		accountPage.enterEmail(Email);
		Thread.sleep(2000);
		log.info("Entered email");
		ETest.info("Entered email");

		accountPage.enterTelephoneField(phone);
		Thread.sleep(2000);
		log.info("Entered phone number");
		ETest.info("Entered phone number");

		accountPage.enterPasswordField(pass);
		Thread.sleep(2000);
		log.info("Entered password");
		ETest.info("Entered password");

		accountPage.enterConfirmPasswordField(Cpass);
		Thread.sleep(2000);
		log.info("Confirmed password ");
		ETest.info("Confirmed password ");

		accountPage.clickOnPrivacyPolicyCheckbox();
		Thread.sleep(2000);
		log.info("ticked privacy policy checkbox");
		ETest.info("ticked privacy policy checkbox");
		

		userDashboard = accountPage.clickOnContinueButton();
		log.info("clicked on continue button");
		ETest.info("clicked on continue button");

		boolean msg = userDashboard.verfifyLoginSuccess("Your Account Has Been Created!");
		Assert.assertTrue(msg);

//		Your Account Has Been Created!

	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object [][]data=Utilities.getDataFromSheet("user");
		return data;
	}

}
