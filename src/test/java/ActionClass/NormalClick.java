package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NormalClick {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://www.flipkart.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		Actions action = new Actions(BrowserDriver);
		WebElement login = BrowserDriver.findElement(By.xpath("//a[@href='/account/login?ret=/']"));
		WebElement whishlist = BrowserDriver.findElement(By.xpath("//a[@href='/account/login?ret=/']"));
		action.moveToElement(login).moveToElement(whishlist).click().perform();
		
	}

}
