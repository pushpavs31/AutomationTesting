package AT.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	// ****************switch to frame method********************************

	public void switchToFrameByName(String frameName, WebDriver driver) {
		driver.switchTo().frame(frameName);
	}
	
	public void switchToFrameByidElement(WebElement element, WebDriver driver) {
		driver.switchTo().frame(element);
	}

	// ***********method for taking screenshot for failing methods***************8

	public static String takeScreenShot(String Mname, WebDriver driver) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String filepath = System.getProperty("user.dir") + "\\screenshot\\flipkart\\" + Mname + "-" + timeStamp + ".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepath;
	}

	// **********************method for data driven approach*****************************

	public static Object[][] getDataFromSheet(String sheetname) {
		FileInputStream fis;

		try {
			fis = new FileInputStream(".\\Configuration\\User Credentilas.xlsx");
			workbook = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowcount][cellcount];

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;
	}

	// ******************Javascript click method************************

	public static void javaScriptClicK(WebElement element, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	// *************************Explicitly wait for element******************************

	public static void waitForVisibleElement(WebElement element, long waitTime, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public static void waitForElementUntilClickable(WebElement element, long waitTime, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

}
