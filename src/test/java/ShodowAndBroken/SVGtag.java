package ShodowAndBroken;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SVGtag {

	public static void main(String[] args) {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://www.flipkart.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement svgTag = BrowserDriver.findElement(By.xpath("(//*[name()='svg'])[1]"));
		if(svgTag.isDisplayed()) {
			System.out.println(svgTag.getText());

		}
		else
			System.out.println("no icon");
	}

}
