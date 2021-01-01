package ninja.demo.Test;

import org.junit.Assert;

import AT.Base.BaseTest;
import ninja.demo.pageObjects.NinjaHomePage;
import ninja.demo.pageObjects.RegisterAccountPage;
import ninja.demo.pageObjects.UserDashboardPage;

public class WebsiteRegistrationTest extends BaseTest {
	NinjaHomePage homePage;
	RegisterAccountPage accountPage;
	UserDashboardPage userDashboard;

	public void filled_Registration() {

		homePage = new NinjaHomePage(getDriver());

		homePage.clickOnMyAccountLink();
		Thread.sleep(2000);

		accountPage = homePage.clickOnRegisterLink();
		Thread.sleep(2000);

		accountPage.enterFirstName(name);
		Thread.sleep(2000);

		accountPage.enterLastName(Lname);
		Thread.sleep(2000);

		accountPage.enterEmail(Email);
		Thread.sleep(2000);

		accountPage.enterTelephoneField(phone);
		Thread.sleep(2000);

		accountPage.enterPasswordField(pass);
		Thread.sleep(2000);

		accountPage.enterConfirmPasswordField(Cpass);
		Thread.sleep(2000);

		accountPage.clickOnPrivacyPolicyCheckbox();
		Thread.sleep(2000);

		userDashboard = accountPage.clickOnContinueButton();

		boolean msg = userDashboard.verfifyLoginSuccess("Your Account Has Been Created!");
		Assert.assertTrue(msg);

//		Your Account Has Been Created!

	}

}
