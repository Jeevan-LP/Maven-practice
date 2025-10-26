package ScreenShot;

import java.io.File;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CapturingPage {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();

		BrowserDriver.get("https://www.amazon.in/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement logo = BrowserDriver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));		
		String TimeStamp = LocalTime.now().toString().replace(':', '-');
		//Specific element
		/**
		TakesScreenshot ts=(TakesScreenshot)BrowserDriver;
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./Capture/"+TimeStamp+"IMG.png");
		sourceFile.renameTo(targetFile);
		**/
		
		//Main page
		Scanner sc = new Scanner(System.in);
		System.out.println("please enter file name");

		String ScName = sc.next();
		Thread.sleep(5000);
		TakesScreenshot ts=(TakesScreenshot)BrowserDriver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		//File targetFile = new File("./Capture/"+TimeStamp+"IMG.png");		
		File targetFile = new File("./Capture/"+ScName+".png");////run time Screenshot name
		sourceFile.renameTo(targetFile);


		BrowserDriver.quit();
	}

}
