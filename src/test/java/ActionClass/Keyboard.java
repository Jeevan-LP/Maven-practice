package ActionClass;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keyboard {

	public static void main(String[] args) throws Throwable {
		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://www.amazon.in/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Actions action = new Actions(BrowserDriver);

		WebElement AmazonPay = BrowserDriver.findElement(By.xpath("//a[normalize-space()='Amazon Pay']"));
		Thread.sleep(2000);
		action.keyDown(Keys.CONTROL).click(AmazonPay).keyUp(Keys.CONTROL).perform();

		ArrayList<String> windowIDS = new ArrayList(BrowserDriver.getWindowHandles());
		BrowserDriver.switchTo().window(windowIDS.get(1));
		BrowserDriver.findElement(By.xpath("//span[contains(text(),'Flights')]")).click();

		
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//a[@id='createAccountSubmit']")).click();
		Thread.sleep(2000);
		BrowserDriver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("Jeevan27092001");
		Thread.sleep(2000);
		action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		action.keyDown(Keys.TAB).keyDown(Keys.TAB).perform();
		Thread.sleep(2000);
		action.keyDown(Keys.TAB).keyDown(Keys.TAB).perform();
		Thread.sleep(2000);
		WebElement MobilenumberTxtfied = BrowserDriver.findElement(By.xpath("//input[@id='ap_phone_number']"));
		action.keyDown(Keys.CONTROL).sendKeys(MobilenumberTxtfied, "V").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		
		BrowserDriver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(5000);
		BrowserDriver.quit();
		System.out.println("Closed");

	}

}
