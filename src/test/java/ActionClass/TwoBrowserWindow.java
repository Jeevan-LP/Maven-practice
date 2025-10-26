package ActionClass;

import java.time.Duration;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoBrowserWindow {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");
		
		/**
		//Before its launching browser for amazon and navigate to flipkart
		//amazon tab will not display
		//flipkart tab will display
		BrowserDriver.get("https://www.amazon.in/");
		System.out.println(BrowserDriver.getTitle());
		BrowserDriver.get("https://www.flipkart.com/");
		System.out.println(BrowserDriver.getTitle());
		**/
		
		
		//amazon and flipkart page will display in single window with 2 tabs
		BrowserDriver.get("https://www.amazon.in/");
		System.out.println(BrowserDriver.getTitle());
		BrowserDriver.switchTo().newWindow(WindowType.TAB);
		BrowserDriver.get("https://www.flipkart.com/");
		System.out.println(BrowserDriver.getTitle());
		
		
		/**
		//both amazon and flipkart page will display in different window
		BrowserDriver.get("https://www.amazon.in/");
		System.out.println(BrowserDriver.getTitle());
		BrowserDriver.switchTo().newWindow(WindowType.WINDOW);
		BrowserDriver.get("https://www.flipkart.com/");
		System.out.println(BrowserDriver.getTitle());
		**/

		
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//BrowserDriver.manage().window().maximize();
		
		Thread.sleep(5000);
		BrowserDriver.quit();
	}

}
