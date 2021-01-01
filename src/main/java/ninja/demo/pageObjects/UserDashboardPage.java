package ninja.demo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class UserDashboardPage {
	
	WebDriver driver;

	public UserDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// ********************************Page Objects********************************

	@CacheLookup
	@FindBy(id = "input-firstname")
	WebElement firstNameField;
	
	
	//******************************methods*************************************
	
	public boolean verfifyLoginSuccess(String msg)
	{
		boolean flag=false;
		if(driver.getPageSource().contains(msg))
		{
			flag=true;
		}
		return flag;
	}

}
