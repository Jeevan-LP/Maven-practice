package ShodowAndBroken;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class NestedShadow {

	public static void main(String[] args) {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://books-pwakit.appspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		SearchContext mainShadow = BrowserDriver.findElement(By.cssSelector("book-app[apptitle=\"BOOKS\"]")).getShadowRoot();
		
		mainShadow.findElement(By.cssSelector("#input")).sendKeys("Jeevan");
	}

}
