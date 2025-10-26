package DataDrivenExcel;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MiniProject_02 {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver BrowserDriver=new ChromeDriver(options);
		System.out.println("Browser is launching");
		BrowserDriver.get("https://fdcalculator.net/sbi.html");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
//		WebElement close = BrowserDriver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
//		if(close.isDisplayed()) {
//			close.click();
//		}
		Robot robot = new Robot();
		WebElement close = BrowserDriver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
		if(close.isDisplayed()) {
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		String filePath=System.getProperty("user.dir")+"\\TestData\\MiniProject_02.xlsx";
		String SheetName="MiniProject_02";
		
		int RowNO = ExcelUtility.getRowNumber(filePath, SheetName);
		for(int r=1;r<=RowNO;r++) {
			//reading data from excel
			String TotalInvestment = ExcelUtility.getCellData(filePath, SheetName, r, 0);
			String InterestRate = ExcelUtility.getCellData(filePath, SheetName, r, 1);
			String InvestmentDuration01 = ExcelUtility.getCellData(filePath, SheetName, r, 2);
			String InvestmentDuration02 = ExcelUtility.getCellData(filePath, SheetName, r, 3);
			String CompoundingFrequency = ExcelUtility.getCellData(filePath, SheetName, r, 4);
			String EXPMaturityValue = ExcelUtility.getCellData(filePath, SheetName, r, 5);
			
			//sent data into application
			try {
			BrowserDriver.findElement(By.xpath("//input[@id=\"inv\"]")).sendKeys(TotalInvestment);
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//input[@id='i_rate']")).sendKeys(InterestRate);
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//input[@id='i_duration']")).sendKeys(InvestmentDuration01);
			Thread.sleep(1000);
			Select Durationselect = new Select(BrowserDriver.findElement(By.xpath("//select[@id='idur_in']")));
			Durationselect.selectByVisibleText(InvestmentDuration02);
			Select Frequencyselect = new Select(BrowserDriver.findElement(By.xpath("//select[@id='c_period']")));
			Frequencyselect.selectByVisibleText(CompoundingFrequency);
			
			BrowserDriver.findElement(By.xpath("//button[normalize-space()='Calculate']")).click();
			String ACTMaturityValue = BrowserDriver.findElement(By.xpath("id=\"m_amount\"")).getText();
			
			if(ACTMaturityValue==EXPMaturityValue) {
					System.out.println("test case passed");
					ExcelUtility.SetCellData(filePath, SheetName, r, 7, "passed");
			}
			else {
				System.out.println("test case failed");
			ExcelUtility.SetCellData(filePath, SheetName, r, 7, "failed");
			}
			
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//button[@type='reset']")).click();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
	
}
