package SwitchMethod;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWindowsWithClose {

		public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		WebDriverWait explicitywait = new WebDriverWait(BrowserDriver, Duration.ofSeconds(30));

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		BrowserDriver.manage().window().maximize();
		
		 BrowserDriver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("jeevan");
		 Thread.sleep(2000);
		 
		 explicitywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
		 
		 //BrowserDriver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 List<WebElement> links = BrowserDriver.findElements(By.xpath("//div[@id=\"wikipedia-search-result-link\"]/a"));
		 System.out.println("number of Links "+links.size());
		 
		 for(int i=0;i<=links.size()-1;i++) {
			 links.get(i).click();

			 }

		 Set<String> AllWindowID = BrowserDriver.getWindowHandles();	

		 for(String l:AllWindowID) {
			 @Nullable
			String title = BrowserDriver.switchTo().window(l).getTitle();
			 System.out.println(title);
			 if(title.equals("Automation Testing Practice")||title.equals("Jeevan Badwal - Wikipedia")|| title.equals("Jeevansathi.com - Wikipedia" )) {
					Thread.sleep(2000);
					BrowserDriver.close();
					Thread.sleep(2000);

				}
		 }

		 System.out.println("Closed");
		 
	 }

		
		 
		 /**
		 /////drop downs
			 for(int i=0;i<3;i++) {
	
				 links.get(i).click();
				 }
			 
			 for(int i=0;i<=links.size()-1;i++) {
					
				 if(links.get(i).isSelected()) {
					 links.get(i).click();
				 }
				 
			 }**/
		 }	
		 

	

