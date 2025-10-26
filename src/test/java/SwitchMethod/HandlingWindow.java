package SwitchMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindow {

	public static void main(String[] args) {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		//Approach 1
		Set<String> windowID = BrowserDriver.getWindowHandles();
		List<String> list = new ArrayList(windowID);
		
		String parent = list.get(0);
		String child = list.get(1);
		
		BrowserDriver.switchTo().window(child);
		System.out.println(BrowserDriver.getTitle());
		
		BrowserDriver.switchTo().window(parent);
		System.out.println(BrowserDriver.getTitle());
		
		//Approach 2
		/**
		for(String w:windowID) {
			@Nullable
			String title = BrowserDriver.switchTo().window(w).getTitle();
			if(title.equals("jeevan")) {
				System.out.println(BrowserDriver.getCurrentUrl());
			}
		}
		**/
		
		
	}

}
