package AlertAndCheckBox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkBox {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		List<WebElement> allCheckBox = BrowserDriver.findElements(By.xpath("//div[@class=\"form-check form-check-inline\"]/input[@type=\"checkbox\"]"));
		
		//All check box
		/**
		for(int i=0;i<=allCheckBox.size()-1;i++) {
			allCheckBox.get(i).click();
			
		}
		**/
		
		for(int i=0;i<allCheckBox.size()-3;i++) {
			
			allCheckBox.get(i).click();
			 }
		 
		Thread.sleep(9000);
		
		 for(int i=0;i<=allCheckBox.size()-1;i++) {
				
			 if(allCheckBox.get(i).isSelected()) {
				 allCheckBox.get(i).click();
			 }
		 }
		 //BrowserDriver.quit();
		 System.out.println("Closed");

	}
	
}
