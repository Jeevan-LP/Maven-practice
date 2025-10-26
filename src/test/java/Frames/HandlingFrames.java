package Frames;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://in.puma.com/in/en/sports?offset=384");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		
	}

}
