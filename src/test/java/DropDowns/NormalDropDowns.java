package DropDowns;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalDropDowns {
	
	public static void main(String[] args) throws Throwable {
		

	WebDriver BrowserDriver=new ChromeDriver();
	System.out.println("Browser is launching");

	BrowserDriver.get("https://testautomationpractice.blogspot.com/");
	BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	BrowserDriver.manage().window().maximize();
	
	WebElement dropdown = BrowserDriver.findElement(By.xpath("//select[@id=\"country\"]"));
	
	Select select = new Select(dropdown);
	if(select.isMultiple()) {
		System.out.println("Multiple");
	}
	else
		System.out.println("single");
	Thread.sleep(3000);
	//select.selectByVisibleText("Canada");
	//select.selectByIndex(2);
	select.selectByValue("india");
	Thread.sleep(3000);
	//select.deselectAll();

	List<WebElement> selectedAlloptions = select.getAllSelectedOptions();
	System.out.println(selectedAlloptions.size());
	for(int i=0;i<=selectedAlloptions.size()-1;i++) {
		System.out.println(selectedAlloptions.get(i).getText());
	}
	
	/**
	List<WebElement> allDropDowns = select.getOptions();
	System.out.println("No of drop downs "+allDropDowns.size());
	//System.out.println(allDropDowns);/////We can't print like this directly
	
	
	for(int i=0;i<allDropDowns.size();i++) {
		//System.out.println(allDropDowns.get(i).getText());
		String dropDown = allDropDowns.get(i).getText();
		if(dropDown.equals("India")) {
			select.selectByVisibleText("India");
		}
	}
	
	
	for(WebElement DD:allDropDowns) {
		//System.out.println(DD.getText());
		String dropDown = DD.getText();
		if(dropDown.equals("India")) {
			select.selectByVisibleText("India");
		}
	}
	**/
	
	System.out.println("Browser closed");
	}

}
