package Sycronazations;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sycronazation {

	public static void main(String[] args) {

		ChromeDriver BrowserDriver = new ChromeDriver();
		
		////implicitly wait
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		////Explicitly wait
		WebDriverWait Explicitlywait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(5));
		
		////Fluent wait
		Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(BrowserDriver)
		.withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		
		BrowserDriver.get("https://www.flipkart.com/account/login?ret=%2Fwishlist");
		
		////Explicitly wait start
		WebElement username=Explicitlywait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("******"))));
		username.sendKeys("jeevan L P");
		//WebElement username = BrowserDriver.findElement(By.xpath("******"));
		
		WebElement password = Explicitlywait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("******"))));
		password.sendKeys("jeevan@123");
		//WebElement password = BrowserDriver.findElement(By.xpath("******"));
		
		WebElement loginbutton = Explicitlywait.until(ExpectedConditions.elementToBeClickable(BrowserDriver.findElement(By.xpath("******"))));
		loginbutton.click();
		//WebElement loginbutton = BrowserDriver.findElement(By.xpath("******"));
		////Explicitly wait end
		
		
		fluentwait.until(new Function<WebDriver, WebElement>(){
		public WebElement Wait(WebDriver BrowserDriver) {
			return BrowserDriver.findElement((By.xpath("******")));
		}

		@Override
		public WebElement apply(WebDriver t) {
			// TODO Auto-generated method stub
			return null;
		}});
		
	
	}
}
