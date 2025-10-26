package ShodowAndBroken;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ShadowElement {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new EdgeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		System.out.println(BrowserDriver.findElement(By.xpath("//h2[normalize-space()='ShadowDOM']")).getText());
		SearchContext shadowHost = BrowserDriver.findElement(By.cssSelector("#shadow_host")).getShadowRoot();
		String mobile = shadowHost.findElement(By.cssSelector("#shadow_content")).getText();
		System.out.println(mobile);
//		String laptop = shadowHost.findElement(By.cssSelector("#nested_shadow_content")).getText();
//		System.out.println(mobile);
		shadowHost.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
		Thread.sleep(2000);
		shadowHost.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys("D:\\VTU Results\\Certificate\\Jeevan E-commerse.pdf");
		
		BrowserDriver.quit();

		
	}

}
