package DataDrivenExcel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MiniProject_01 {
	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver BrowserDriver=new ChromeDriver(options);
		System.out.println("Browser is launching");
		WebDriverWait wait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(10));

		//BrowserDriver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		//https://fd-calculator.in/
		//https://fdcalculator.net/sbi.html
		//https://fdcalculator.co.in/sbi-fd-calculator/
		BrowserDriver.get("https://fd-calculator.in/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\TestData\\MiniProject_01.xlsx";
		String SheetName="MiniProject_01";
		
		int RowNO = ExcelUtility.getRowNumber(filePath, SheetName);
		for(int r=1;r<=RowNO;r++) {
			//reading data from excel
			String FDAmount = ExcelUtility.getCellData(filePath, SheetName, r, 0);
			String FDPeriod01 = ExcelUtility.getCellData(filePath, SheetName, r, 1);
			String FDPeriod02 = ExcelUtility.getCellData(filePath, SheetName, r, 2);
			String Interest = ExcelUtility.getCellData(filePath, SheetName, r, 3);
			String CFrequency = ExcelUtility.getCellData(filePath, SheetName, r, 4);
			String ExcpClosingBalance = ExcelUtility.getCellData(filePath, SheetName, r, 5);
			
			//sent data into application
			WebElement FDAmountTextfield = BrowserDriver.findElement(By.xpath("//input[@id='amountInputField']"));
			FDAmountTextfield.sendKeys(FDAmount);
			Thread.sleep(1000);
			
			WebElement FDPeriod01Textfield = BrowserDriver.findElement(By.xpath("//input[@id='periodInputField']"));
			FDPeriod01Textfield.sendKeys(FDPeriod01);
			Thread.sleep(1000);
			
			Select FDPeriod = new Select(BrowserDriver.findElement(By.xpath("//select[@id='amountSelectField']")));
			FDPeriod.selectByVisibleText(FDPeriod02);
			Thread.sleep(1000);

			WebElement InterestTextfield = BrowserDriver.findElement(By.xpath("//input[@id='interestInputField']"));
			InterestTextfield.sendKeys(Interest);
			Thread.sleep(1000);
			
			Select Frequency = new Select(BrowserDriver.findElement(By.xpath("//select[@id='frequencySelectField']")));
			Frequency.selectByVisibleText(CFrequency);
			Thread.sleep(1000);
			
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(BrowserDriver.findElement(By.xpath("//button[@id='calculateButton']"))));
			button.click();
			Thread.sleep(2000);

			//validation
			String ActualClosingBal = BrowserDriver.findElement(By.xpath("(//i[@class='icon-inr'])[3]")).getText();
			System.out.println("balanca------------"+ActualClosingBal);
			if(Integer.parseInt(ActualClosingBal)==Integer.parseInt(ExcpClosingBalance)) {
				System.out.println("Test cases passed");
				ExcelUtility.SetCellData(ExcpClosingBalance, SheetName, r, 7, "Passed");
			}
			else {
				System.out.println("Test cases failed");
				ExcelUtility.SetCellData(ExcpClosingBalance, SheetName, r, 7, "Failed");
			}
			
			FDAmountTextfield.clear();
			Thread.sleep(1000);
			FDPeriod01Textfield.clear();
			Thread.sleep(1000);
			FDPeriod.deselectByVisibleText(FDPeriod02);
			Thread.sleep(1000);
			InterestTextfield.clear();
			Thread.sleep(1000);
			Frequency.deselectByVisibleText(CFrequency);

			
		}
		
		System.out.println("Browser closed");
		BrowserDriver.quit();
	}
}
