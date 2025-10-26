package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScollPage {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Actions action = new Actions(BrowserDriver);
		Thread.sleep(3000);
		//action.scrollByAmount(0,2000).perform();
		action.scrollToElement(BrowserDriver.findElement(By.xpath("//h4[normalize-space()='Broken Links']"))).perform();
		
		Thread.sleep(3000);
		BrowserDriver.quit();
		
	}

}
