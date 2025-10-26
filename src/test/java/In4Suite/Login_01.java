package In4Suite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_01 {
	@Test
	public void in4Login() throws Throwable {
			WebDriver BrowserDriver=new ChromeDriver();
			System.out.println("Browser is launching");
			BrowserDriver.get("https://vm-in4qa.in4suite.com");
			BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			BrowserDriver.manage().window().maximize();	
			
			BrowserDriver.findElement(By.xpath("//input[@id='txtLoginId']")).sendKeys("paramesha");
			Thread.sleep(1500);
			BrowserDriver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("appu@27");
			Thread.sleep(1500);
			BrowserDriver.findElement(By.xpath("//input[@id='cmbLogin']")).click();
			Thread.sleep(3000);
			BrowserDriver.findElement(By.xpath("//input[@id='btnYes']")).click();
			Thread.sleep(5000);
			
			WebDriverWait wait1=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='erpContainer']")));
			
			WebDriverWait wait2=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			wait2.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@name='mainmenuFrame']")));
			
			BrowserDriver.findElement(By.xpath("//span[text()='Expenses']")).click();
			System.out.println("Expenses module clicked");
			Thread.sleep(3000);
			BrowserDriver.switchTo().defaultContent();

			Thread.sleep(2000);
			
			WebDriverWait wait3=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			wait3.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='erpContainer']")));
			
			
			WebDriverWait wait4=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			wait4.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='slideleft']")));
			
			Thread.sleep(4000);
			BrowserDriver.findElement(By.cssSelector("body > form:nth-child(1) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(4)")).click();	
			System.out.println("Work Order clicked");
			BrowserDriver.switchTo().defaultContent();
			
			Thread.sleep(3000);
			System.out.println("create button clicking");
			//WebDriverWait wait5=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			//wait5.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='rightframe']")));
			
			
			WebDriverWait wait5=new WebDriverWait(BrowserDriver, Duration.ofSeconds(9000));
			wait5.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@id='erpContainer']")));
			
			
			WebElement frame1 = BrowserDriver.findElement(By.xpath("//iframe[@name='mainFrame']"));
			BrowserDriver.switchTo().frame(frame1);
			
			
			WebElement frame = BrowserDriver.findElement(By.xpath("//frame[@name='rightframe']"));
			BrowserDriver.switchTo().frame(frame);
			
			BrowserDriver.findElement(By.xpath("//input[@id='btnCreate']")).click();
			System.out.println("create button clicked");
			
			WebElement cdropdown = BrowserDriver.findElement(By.id("ddlCompany"));
			Select select = new Select(cdropdown);
			if(cdropdown.isDisplayed()) {
				select.selectByIndex(1);
				Assert.assertTrue(true);
			}

			Thread.sleep(3000);
			BrowserDriver.quit();

			
			}
}