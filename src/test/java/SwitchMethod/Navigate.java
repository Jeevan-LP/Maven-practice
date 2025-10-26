package SwitchMethod;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigate {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		System.out.println("Browser is launching");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//BrowserDriver.get("https://www.flipkart.com/account/login?ret=%2Fwishlist");
		
		URL url = new URL("https://www.flipkart.com/account/login?ret=%2Fwishlist");
		BrowserDriver.navigate().to(url);		
		
		
		BrowserDriver.findElement(By.xpath("//a[@class='CDJO0-']//span[contains(text(),'Become a Seller')]")).click();
		Thread.sleep(3000);
		
		BrowserDriver.navigate().back();
		Thread.sleep(3000);

		BrowserDriver.navigate().refresh();
		Thread.sleep(3000);


		BrowserDriver.navigate().forward();
		Thread.sleep(3000);
		
		BrowserDriver.close();

	}
	

}
