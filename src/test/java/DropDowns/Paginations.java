package DropDowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Paginations {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		List<WebElement> allPagination = BrowserDriver.findElements(By.xpath("(//ul[@id='pagination'])//li"));

		for(int i=1;i<=allPagination.size();i++) {
			if(i>1) {
				
				WebElement click = BrowserDriver.findElement(By.xpath("//ul[@id='pagination']//a[text()="+i+"]"));
				click.click();
				Thread.sleep(3000);
			}
			int rows = BrowserDriver.findElements(By.xpath("//table[@id='productTable']//tr")).size();
			int column=BrowserDriver.findElements(By.xpath("//table[@id=\"productTable\"]//tr//th")).size();

			for(int j=1;j<=rows;j++) {
				/**
				 for(int k=1;k<=column;k++) {
					try {
					String alldata=BrowserDriver.findElement(By.xpath("//table[@id=\"productTable\"]//tr["+j+"]//td["+k+"]")).getText();
					System.out.print(" "+alldata+" ");
					}
					catch (Exception e) {
						// TODO: handle exception
					}
				}
				
				System.out.println();
				**/
				try {
				String ID = BrowserDriver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[1]")).getText();
				String name = BrowserDriver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[2]")).getText();
			
				System.out.println(ID+" "+name);
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				try {
				WebElement checkbox = BrowserDriver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[4]//input"));
				
				//////not a mandatory just for printing purpose
				String ID1 = BrowserDriver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[1]")).getText();
				String name1 = BrowserDriver.findElement(By.xpath("//table[@id='productTable']//tr["+j+"]//td[2]")).getText();
			
				
				if(checkbox.isDisplayed()) {
					Thread.sleep(3000);

					checkbox.click();
					System.out.println("chech box selcted for ID no "+ID1+" and Name of "+name1);
					///System.out.println("check box selcted");
				}
				else {
					System.out.println("No check box present");
				}
				}
				catch (Exception e1) {
					// TODO: handle exception
				}
		
			}

		System.out.println();
		}	
		System.out.println("closed");
		BrowserDriver.quit();
	}
	}

