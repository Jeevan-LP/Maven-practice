package Options;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class IncognitoMode {
	public static void main(String[] args) throws Throwable {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		WebDriver BrowserDriver=new ChromeDriver(options);
		System.out.println("Browser is launching");

		BrowserDriver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		WebElement Continuetosite = BrowserDriver.findElement(By.id("proceed-button"));
		if(Continuetosite.isDisplayed()) {
			 Thread.sleep(2000);
			 Continuetosite.click();
		}
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Actions action = new Actions(BrowserDriver);
		WebElement whashington = BrowserDriver.findElement(By.xpath("//div[@id='box3']"));
		WebElement US = BrowserDriver.findElement(By.xpath("//div[@id='box103']"));
		
		WebElement Norway = BrowserDriver.findElement(By.xpath("//div[@id='box101']"));
		WebElement Oslo = BrowserDriver.findElement(By.xpath("//div[@id='box1']"));
		
		WebElement Rome = BrowserDriver.findElement(By.xpath("//div[@id='box6']"));
		WebElement Italy = BrowserDriver.findElement(By.xpath("//div[@id='box106']"));
		
		 
		 action.dragAndDrop(whashington, US).perform();
		 Thread.sleep(2000);
		 action.dragAndDrop(Oslo,Norway ).perform();
		 Thread.sleep(2000);
		 action.dragAndDrop(Rome, Italy).perform();
		 Thread.sleep(5000);
		 BrowserDriver.quit();

	}
}
