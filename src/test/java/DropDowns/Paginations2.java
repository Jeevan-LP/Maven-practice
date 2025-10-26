package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Paginations2 {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://in.search.yahoo.com/search?fr=mcafee&type=E210IN826G0&p=google");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		List<WebElement> allinks = BrowserDriver.findElements(By.xpath("//div[@class=\"pages\"]//a"));
		for(int i=1;i<=allinks.size();i++) {
			if(i>1) {
				WebElement pagination = BrowserDriver.findElement(By.xpath("//div[@class=\"pages\"]//a["+i+"]"));
				pagination.click();
				Thread.sleep(5000);
				
			}
			
		}
		System.out.println("Browser is closed");
		BrowserDriver.quit();

	}

}
