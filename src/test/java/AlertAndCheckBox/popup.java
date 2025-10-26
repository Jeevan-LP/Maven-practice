package AlertAndCheckBox;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.BrokenBarrierException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class popup {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new EdgeDriver();
		System.out.println("Browser launching");
		BrowserDriver.get("https://the-internet.herokuapp.com/javascript_alerts");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		///Normal alert
		BrowserDriver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert normalalert = BrowserDriver.switchTo().alert();
		Thread.sleep(3000);
		normalalert.accept();
		//System.out.println(normalalert.getText());

		///Confirmation alerts
		Thread.sleep(3000);
		BrowserDriver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert Conformationalert = BrowserDriver.switchTo().alert();
		Thread.sleep(3000);
		//Conformationalert.accept();
		Conformationalert.dismiss();
		//System.out.println(Conformationalert.getText());

		////prompt or authentication alerts
		Thread.sleep(3000);
		BrowserDriver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//		Alert Promptalert = BrowserDriver.switchTo().alert();
//		Thread.sleep(3000);
//		Promptalert.sendKeys("jeevan");
//		Promptalert.accept();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_J);
		robot.keyRelease(KeyEvent.VK_J);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_E);
		robot.keyRelease(KeyEvent.VK_E);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Browser closed");
		Thread.sleep(3000);
		BrowserDriver.quit();

	}
	

}
