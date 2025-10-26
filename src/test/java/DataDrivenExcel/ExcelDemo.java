package DataDrivenExcel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ExcelDemo{

	public static void main(String[] args) throws Throwable {

//		String filePath=System.getProperty("user.dir")+"\\TestData\\Practice.xlsx";
//		String sheetName="Data";
//		
//		//demoUtility.getCellNumber(filePath, sheetName, 1);
//		//ExcelUtility.getCellData(filePath, sheetName, 1, 2);
//	//	ExcelUtility.getCellSingleData(filePath, sheetName, 1, 10);
//		ExcelUtility.getCellAllData(filePath, sheetName, 1);

		String filePath=System.getProperty("user.dir")+"\\TestData\\Practice.xlsx";
		String sheetName="Data";
		//ExcelUtility.fillRedColor(filePath, sheetName, 1, 1);
		//ExcelUtility.getCellAllData(filePath, sheetName, 1);
		int cellno = ExcelUtility.getCellNumber(filePath, sheetName, 0);

		//ExcelUtility.getCellData(filePath, sheetName, 0, 0);
		
		for(int i=0;i<=cellno;i++) {
			ExcelUtility.getCellData(filePath, sheetName, 1, i);
		}
		
	}

}
