package DatePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerYear {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://jqueryui.com/datepicker/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		//using send key method
		Thread.sleep(3000);
		BrowserDriver.findElement(By.id("datepicker")).sendKeys("27/09/2001");
	
		
	}

}
