package WebElement;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SizeOfWebelement {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		Thread.sleep(2000);
		BrowserDriver.manage().window().minimize();
		Thread.sleep(2000);
		BrowserDriver.manage().window().fullscreen();
		Thread.sleep(2000);
		
		Dimension sizeOfWindow = BrowserDriver.manage().window().getSize();
		System.out.println("width of window = "+sizeOfWindow.width);
		System.out.println("height of window = "+sizeOfWindow.height);
		
		Thread.sleep(5000);
		Point point = new Point(200, 100);
		BrowserDriver.manage().window().setPosition(point);
		
		Point positionOfWindow = BrowserDriver.manage().window().getPosition();
		System.out.println("X axis of window = "+positionOfWindow.getX());
		System.out.println("Y axis of window = "+positionOfWindow.getY());

		
		
		
		

	}

}
