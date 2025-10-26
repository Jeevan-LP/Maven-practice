package ActionClass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		
		Actions action = new Actions(BrowserDriver);
		WebElement rightClick = BrowserDriver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		Thread.sleep(2000);

		action.contextClick(rightClick).perform();
		
		List<WebElement> all = BrowserDriver.findElements(By.xpath("//ul[contains(@class,'context-menu-list')]//span"));
		for(WebElement a:all) {
			try {
			String list=a.getText();
			System.out.println(list);
			if(list.equals("Paste")) {
				Thread.sleep(2000);
				a.click();
			}
		}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		Thread.sleep(5000);

		try {
		BrowserDriver.switchTo().alert().accept();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Thread.sleep(2000);

		BrowserDriver.quit();
		
	}

}
