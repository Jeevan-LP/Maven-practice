package DataDrivenProperty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiniProject {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser launched");
		
		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)BrowserDriver;
		Thread.sleep(2000);	

		js.executeScript("document.body.style.zoom='70%';");
		Thread.sleep(2000);	
		
		///reading data from properties file
		String FilePath=System.getProperty("user.dir")+"\\TestData\\MiniPropertyProject.properties";
		String Name=PropertyUtility.getKeyValue(FilePath, "Name");
		String Email=PropertyUtility.getKeyValue(FilePath, "Email");
		String Phone=PropertyUtility.getKeyValue(FilePath, "Phone");
		String Address=PropertyUtility.getKeyValue(FilePath, "Address");
		
		///sent data into application
		BrowserDriver.findElement(By.xpath("//input[@id='name']")).sendKeys(Name);
		Thread.sleep(1000);	
		BrowserDriver.findElement(By.xpath("//input[@id='email']")).sendKeys(Email);
		Thread.sleep(1000);	
		BrowserDriver.findElement(By.xpath("//input[@id='phone']")).sendKeys(Phone);
		Thread.sleep(1000);	
		BrowserDriver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys(Address);
		Thread.sleep(1000);	

		BrowserDriver.findElement(By.xpath("//button[@name='start']")).click();
		Thread.sleep(1000);	
		BrowserDriver.quit();
		System.out.println("Browser closed");

	}

}
