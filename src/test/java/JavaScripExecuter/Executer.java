package JavaScripExecuter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Executer {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement Name=BrowserDriver.findElement(By.xpath("//input[@id='name']"));
		WebElement Email=BrowserDriver.findElement(By.xpath("//input[@id='email']"));
		WebElement phone = BrowserDriver.findElement(By.xpath("//input[@id='phone']"));
		WebElement startbutton = BrowserDriver.findElement(By.xpath("//button[@name='start']"));
		WebElement item = BrowserDriver.findElement(By.xpath("//input[@id='comboBox']"));
		
		JavascriptExecutor js=(JavascriptExecutor)BrowserDriver;
		Thread.sleep(2000);	

		js.executeScript("document.body.style.zoom='70%';");
		Thread.sleep(2000);	

		js.executeScript("arguments[0].value='Jeevan L P';", Name);
		Thread.sleep(2000);	
		js.executeScript("arguments[0].value='Appu@123';", Email);
		Thread.sleep(2000);
		js.executeScript("arguments[0].style.border='5px solid blue';", phone);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", startbutton);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(2000);	
		//js.executeScript("scrollBy(0,2000);");
		js.executeScript("scrollTo(0,1500);");
		System.out.println(js.executeScript("return window.pageYOffset;"));

		Thread.sleep(2000);	
		js.executeScript("arguments[0].scrollIntoView();",item);

		String title = (String)js.executeScript("return document.title");
		System.out.println(title);
		String url = (String)js.executeScript("return document.URL");
		System.out.println(url);
		Thread.sleep(2000);	
		
		//using scrollTo Method
		/**
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));///2383.333251953125
		Thread.sleep(2000);	
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		**/
		
		
		//using scrollBy Method
				
		js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));///2383.333251953125
		Thread.sleep(2000);	
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		/**
		//without window
		js.executeScript("scrollTo(0,document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(2000);	
		js.executeScript("scrollTo(0,-document.body.scrollHeight);");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		**/	
				
			
		Thread.sleep(5000);	
		BrowserDriver.quit();


	}

}
