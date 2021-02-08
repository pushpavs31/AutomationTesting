package FlipkartTest;

import org.junit.Assert;
import org.testng.annotations.Test;

import AT.Base.BaseTest;
import Flipkart.PageObject.AccountPage;
import Flipkart.PageObject.HomePage;

public class PersonalInformationChangesTest extends BaseTest {

	HomePage homepage;
	AccountPage accountpage;
	String name="sid";
	String Lname="sinha";

	@Test(enabled = true)
	public void User_Can_Change_His_Name_N_Surname() throws InterruptedException {

		homepage = new HomePage(getDriver());

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

		homepage.MouseHoverOnProfile();

		accountpage = homepage.clickOnMyProfile();
		log.info("clicked on my profile link");
		ETest.info("clicked on my profile link");
		
		Assert.assertTrue(accountpage.verifyDashboardIsDisplayed()); 
		
		accountpage.clickOnpersonalInfoEditLink();
		log.info("clicked on edit link");
		ETest.info("clicked on edit link");
		
		accountpage.enterName(name);
		log.info("entre the name in Field");
		ETest.info("entre the name in Field");
		
		accountpage.enterLastName(Lname);
		log.info("entre the last name in Field");
		ETest.info("entre the last name in Field");
		
		accountpage.selectFemaleCheckBox();
		log.info("selected the female checkbox field");
		ETest.info("selected the female checkbox field");
		
		accountpage.clickOnSaveButton();
		log.info("clicked on save button");
		ETest.info("clicked on save button");

	}

}
