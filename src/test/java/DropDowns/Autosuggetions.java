package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggetions {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://www.amazon.in/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		String search="shirt";
		BrowserDriver.findElement(By.id("twotabsearchtextbox")).sendKeys(search);
		Thread.sleep(9000);
		List<WebElement> autosuggetion = BrowserDriver.findElements(By.xpath("//div[contains(@class,\"left-pane-resul\")]//span"));
		System.out.println(autosuggetion.size());
		
		for(int i=0;i<autosuggetion.size();i++) {
			System.out.println(search+" "+autosuggetion.get(i).getText());
//			if(autosuggetion.get(i).equals(" cider vinegar with the mother")) {
//				Thread.sleep(3000);
//
//				autosuggetion.get(i).click();
//			}
		}
		System.out.println("Browser is closed");

	}
	

}
