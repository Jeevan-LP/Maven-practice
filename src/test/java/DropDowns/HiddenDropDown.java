package DropDowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//button[contains(@class,\"oxd-button\")]")).click();
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//span[text()='PIM']")).click();
		





	}

}
