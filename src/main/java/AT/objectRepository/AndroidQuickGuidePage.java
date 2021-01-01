package AT.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AndroidQuickGuidePage {
	
	WebDriver driver;
	
	public AndroidQuickGuidePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *****************************page elements **************************

	@CacheLookup
	@FindBy(xpath = "//p[contains(text(),'Out of stock')]")
	WebElement outOfStockMsg;
	
	
	
	//****************************methods************************************
	
	public boolean verifyOutOfStockMsgForAndroid(String message)
	{
		boolean flag=false;
		if(outOfStockMsg.getText().equalsIgnoreCase(message))
		{
			try {
			flag=true;
			}catch(Exception e)
			{
				e.printStackTrace();
				flag=false;
			}
		}
		return flag;
	}

}
