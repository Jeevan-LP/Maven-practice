package ShodowAndBroken;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new EdgeDriver();

		BrowserDriver.get("http://www.deadlinkcity.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		List<WebElement> brokenLinks = BrowserDriver.findElements(By.tagName("a"));
		int count=0;
		for(WebElement AllLinks:brokenLinks) {
				@Nullable
				String attribute = AllLinks.getAttribute("href");
				if(attribute==null ||attribute.isEmpty()) {
				System.out.println("Empty or null links");
				/**
				1. if block is true then continue keyword will skip next line of execution
				2. it will again go into the for until if block false
				**/
				continue;
				}
			
				try {
				URL url = new URL(attribute);
				HttpURLConnection opencon =(HttpURLConnection) url.openConnection();
				opencon.connect();
				if(opencon.getResponseCode()>=400) {
				System.out.println("broken link =>>>> "+attribute);
				count++;
				}
				else {
				System.out.println("not a broken link =>>>> "+attribute);

				}
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			
		}
		
		System.out.println("no of broken links = "+count);
		System.out.println("browser closed");
		BrowserDriver.quit();
	}

}
