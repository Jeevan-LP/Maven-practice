package DataDrivenExcel;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MiniProject_03 {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");
		BrowserDriver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement allow = BrowserDriver.findElement(By.xpath("//button[@id=\"wzrk-confirm\"]"));
		if(allow.isDisplayed()) {
			allow.click();
		}
		
		String filePath=System.getProperty("user.dir")+"\\TestData\\MiniProject_03.xlsx";
		String SheetName="MiniProject_03";
		
		int RowNO = ExcelUtility.getRowNumber(filePath, SheetName);
		for(int r=1;r<=RowNO;r++) {
			String PrincipalAmount = ExcelUtility.getCellData(filePath, SheetName, r, 0);
			String RateofInterest = ExcelUtility.getCellData(filePath, SheetName, r, 1);
			String Period1 = ExcelUtility.getCellData(filePath, SheetName, r, 2);
			String Period12 = ExcelUtility.getCellData(filePath, SheetName, r, 3);
			String Frequency = ExcelUtility.getCellData(filePath, SheetName, r, 4);
			String ExpMaturityValue = ExcelUtility.getCellData(filePath, SheetName, r, 5);
			
			BrowserDriver.findElement(By.xpath("//input[@id='principal']")).sendKeys(PrincipalAmount);
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RateofInterest);
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Period1);
			Thread.sleep(1000);
			Select Period=new Select(BrowserDriver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			Period.selectByVisibleText(Period12);
			Thread.sleep(1000);
			////for alert handling
			try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			Select FrequencySelect=new Select(BrowserDriver.findElement(By.xpath("//select[@id='frequency']")));
			FrequencySelect.selectByVisibleText(Frequency);
			Thread.sleep(1000);
			
			BrowserDriver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
		
			String ActMaturityValue = BrowserDriver.findElement(By.xpath("//span[@id=\"resp_matval\"]//strong")).getText();
			System.out.println(ActMaturityValue);
			if(Double.parseDouble(ActMaturityValue)==Double.parseDouble(ExpMaturityValue)) {
				ExcelUtility.SetCellData(filePath, SheetName, r, 7, "Passesd");
				System.out.println("Test cases Passesd");
				//ExcelUtility.fillGreenColor(filePath, SheetName, r, 7);
			}
			else {
				System.out.println("Test cases Failed");
				ExcelUtility.SetCellData(filePath, SheetName, r, 7, "Failed");
				//ExcelUtility.fillRedColor(filePath, filePath, r, 7);
			}
			BrowserDriver.findElement(By.xpath("//img[@class='PL5']")).click();

		}	
				
				
			
		BrowserDriver.quit();
		System.out.println("browser closed");
	}
			
}
