package Options;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCerts {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver BrowserDriver=new ChromeDriver(options);
		System.out.println("Browser is launching");

		BrowserDriver.get("https://expired.badssl.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		System.out.println("title of the page "+BrowserDriver.getTitle());
		
	}

}
