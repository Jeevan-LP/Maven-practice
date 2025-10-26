package DropDowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTables {

	public static void main(String[] args) throws Throwable {
		

		WebDriver BrowserDriver=new ChromeDriver();
		System.out.println("Browser is launching");

		BrowserDriver.get("https://testautomationpractice.blogspot.com/");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		///no of rows
		int rows = BrowserDriver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
		System.out.println("No of rows = "+rows);
		
		///no of columns
		int column=BrowserDriver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr//th")).size();
		System.out.println("No of colums = "+column);
		
		///single data extraction from table
		WebElement singledata = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[3]//td[4]"));
		System.out.println(singledata.getText());
		
		///onlycolumnsrows
		for(int r=2;r<=rows;r++) {
			String onlycolumrows = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td[3]")).getText();
			System.out.println(onlycolumrows);

			
		}
		
		System.out.println("BookName      "+"\t"+"Author    "+"\t"+"Subject   "+"\t"+"Price  ");
		for(int i=2;i<=rows;i++) {
			for(int j=1;j<=column;j++) {
				WebElement Alldata = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+i+"]//td["+j+"]"));
				System.out.print(Alldata.getText()+"\t ");
			}
			System.out.println();
		}
		
		for(int x=2;x<=rows;x++) {
			WebElement pricecolumn = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+x+"]//td[4]"));
			String price=pricecolumn.getText();
			if(price.equals("300")) {
				String subject=BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+x+"]//td[3]")).getText();
				System.out.println(subject+" "+price);

			}
		}
		
		
		for(int k=2;k<=rows;k++) {
			WebElement author = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+k+"]//td[2]"));
			String name=author.getText();
			//System.out.println(name);
			if(name.equals("Mukesh")) {
				String book = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+k+"]//td[1]")).getText();
				System.out.println(name+" "+book);
			}
		}
		
		for(int l=2;l<=rows;l++) {
			WebElement author = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+l+"]//td[1]"));
			String name1=author.getText();
			//System.out.println(name);
			if(name1.equals("Master In JS")) {
				String book1 = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+l+"]//td[2]")).getText();
				System.out.println(book1+" "+name1);
			}
		}
		
		int y=0;
		for(int m=2;m<=rows;m++) {
			WebElement author = BrowserDriver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+m+"]//td[4]"));
			String name1=author.getText();
			//System.out.println(name1);
			
			Integer z = new Integer(name1);
			y=y+z;
		}
		System.out.println(y);
		
		
		System.out.println("Browser is closed");
		Thread.sleep(3000);
		BrowserDriver.quit();

	}
}
