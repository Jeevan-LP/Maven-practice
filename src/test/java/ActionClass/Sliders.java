package ActionClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliders {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement slider = BrowserDriver.findElement(By.xpath("//div[@class='ui-slider-range ui-corner-all ui-widget-header']"));
		System.out.println("X axis = "+slider.getRect().getX());
		System.out.println("Y axis = "+slider.getRect().getY());

		Actions action = new Actions(BrowserDriver);
		WebElement startSlider = BrowserDriver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		WebElement endSlider = BrowserDriver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		action.dragAndDropBy(startSlider, 80, 0).perform();
		Thread.sleep(2000);
		action.dragAndDropBy(endSlider, -50, 0).perform();
		
		System.out.println("after slider drag X axis = "+slider.getRect().getX());
		System.out.println("after slider drag Y axis = "+slider.getRect().getY());


		Thread.sleep(5000);
		BrowserDriver.quit();


		

	}

}
