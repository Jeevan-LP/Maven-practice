package DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jQueeryDatePickerr {
	
	public static void DatePickerFuture(WebDriver BrowserDriver, String Date, String Month, String Year) throws Throwable {
		
		while(true) {
			String month=BrowserDriver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year=BrowserDriver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(month.equals(Month) && year.equals(Year)) {
				//System.out.println("Happy birthday jeevan");
				break;
			}
		
			Thread.sleep(1500);
			BrowserDriver.findElement(By.xpath("//span[text()='Next']")).click();
			
		}
		
		List<WebElement> alldates = BrowserDriver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement d:alldates) {
			String date = d.getText();
			if(date.equals(Date)) {
				d.click();
				break;
			}
			
		}
		System.out.println(Date+"/"+Month+"/"+Year);
		
	}
	
	public static void DatePickerPast(WebDriver BrowserDriver, String Date, String Month, String Year) throws Throwable {
		
		while(true) {
			String month=BrowserDriver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String year=BrowserDriver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(month.equals(Month) && year.equals(Year)) {
				//System.out.println("Happy birthday jeevan");
				break;
			}
		
			Thread.sleep(1500);
			BrowserDriver.findElement(By.xpath("//span[text()='Prev']")).click();
			
		}
		
		List<WebElement> alldates = BrowserDriver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for(WebElement d:alldates) {
			String date = d.getText();
			if(date.equals(Date)) {
				d.click();
				break;
			}
			
		}
		System.out.println(Date+"/"+Month+"/"+Year);
		
	}

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://jqueryui.com/datepicker/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement frame = BrowserDriver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		BrowserDriver.switchTo().frame(frame);
		
		
		
		/** dont need
		String Month="September";
		String Year="2030";
		String Date="27";
		**/

		BrowserDriver.findElement(By.id("datepicker")).click();
		
		
		DatePickerFuture(BrowserDriver, "27", "September", "2025");
		
		System.out.println("Browser is closed");
		Thread.sleep(3000);

		BrowserDriver.quit();

	}

}
