package DataDrivenExcel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MiniProject {

	public static void main(String[] args) throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriver BrowserDriver=new ChromeDriver(options);
		System.out.println("Browser is launching");

		//BrowserDriver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html");
		BrowserDriver.get("https://www.sbisecurities.in/calculators/fd-calculator");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		String filePath = System.getProperty("user.dir")+"\\TestData\\MiniProject.xlsx";
		String SheetName="MiniProject";
		
		int rows = ExcelUtility.getRowNumber(filePath, SheetName);
		
		for(int r=1;r<=rows;r++) {//r=rows
			//reading data from excel file
			String FDInvestment = ExcelUtility.getCellData(filePath, SheetName, r, 0);
			String NoOfYear = ExcelUtility.getCellData(filePath, SheetName, r, 1);
			String InterestRate = ExcelUtility.getCellData(filePath, SheetName, r, 2);
			String CompoundingFrequency = ExcelUtility.getCellData(filePath, SheetName, r, 3);
			String MaturityValue = ExcelUtility.getCellData(filePath, SheetName, r, 4);
			
			//pass above date into application
			//try {
			WebElement FDInvestmentTextfield = BrowserDriver.findElement(By.xpath("//div[@class='input-group']//input[@id='input_fd_investment']"));
			FDInvestmentTextfield.sendKeys(FDInvestment);
			Thread.sleep(1000);
			
			WebElement NumberofYearsTextfield = BrowserDriver.findElement(By.xpath("//body/app-root/app-fd-calculator[@class='ng-star-inserted']/div[@class='container']/div[@class='col-md-12 pt-5 mt-5']/div[@class='row pdt-30']/div[@class='col-xl-9 col-lg-7 col-md-7']/div[@class='border']/form[@id='validForm']/div[@class='row mt-2 d-flex']/div[@class='form-group col-md-6 mb-3']/input[1]"));
			NumberofYearsTextfield.sendKeys(NoOfYear);
			Thread.sleep(1000);
			
			WebElement InterestRateTextfield = BrowserDriver.findElement(By.xpath("//input[@id='input_interest']"));
			InterestRateTextfield.sendKeys(InterestRate);
			Thread.sleep(1000);
			
			Select select = new Select(BrowserDriver.findElement(By.xpath("//select[@id=\"frequency\"]")));
			select.selectByVisibleText(CompoundingFrequency);
			Thread.sleep(1000);
			BrowserDriver.findElement(By.xpath("//div[@class='form-group col-md-6 mb-3 align']")).click();
		
			//validation
			String ActualMaturityValue = BrowserDriver.findElement(By.xpath("//p[@style=\"font-size:18px; font-weight:600; line-height:25px\"]//span")).getText();
			if(ActualMaturityValue==MaturityValue) {
				ExcelUtility.SetCellData(filePath, SheetName, r, 6, "Passesd");
				ExcelUtility.fillGreenColor(filePath, SheetName, r, 6);
				System.out.println("test case Passed");
			}
			else {
				ExcelUtility.SetCellData(filePath, SheetName, r, 6, "Failed");
				//ExcelUtility.fillRedColor(filePath, SheetName, r, 6);
				System.out.println("test case Failed");
			}
			
			FDInvestmentTextfield.clear();
			Thread.sleep(1000);
			NumberofYearsTextfield.clear();
			Thread.sleep(1000);
			InterestRateTextfield.clear();
			Thread.sleep(1000);
			//select.selectByVisibleText("Select Frequency");
//			}
//			catch (Exception e) {
//				// TODO: handle exception
//			}
			
		}
		System.out.println("Browser closed");
		BrowserDriver.quit();
	}
		
}

