package SwitchMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabs {

	public static void main(String[] args) {
		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		BrowserDriver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).click();
		
		Set<String> allWindowID = BrowserDriver.getWindowHandles();
		System.out.println(allWindowID);
		
		List<String> list = new ArrayList(allWindowID);	
		String Window1 = list.get(0);
		String Window2 = list.get(1);
		String Window3 = list.get(2);
		String Window4 = list.get(3);
		
		
		BrowserDriver.switchTo().window(Window2);
		System.out.println(BrowserDriver.getTitle());
		
		
		BrowserDriver.switchTo().window(Window1);
		System.out.println(BrowserDriver.getTitle());
		
		BrowserDriver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).click();
		Set<String> allWindowID1 = BrowserDriver.getWindowHandles();
		
		BrowserDriver.switchTo().window(Window3);
		System.out.println(BrowserDriver.getTitle());

	}

}
