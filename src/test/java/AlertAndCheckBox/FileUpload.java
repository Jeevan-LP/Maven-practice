package AlertAndCheckBox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUpload {

	public static void main(String[] args) throws Throwable {

		WebDriver BrowserDriver=new EdgeDriver();
		System.out.println("Browser launching");
		BrowserDriver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		BrowserDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		BrowserDriver.manage().window().maximize();
		
		WebElement ChooseFile = BrowserDriver.findElement(By.xpath("//input[@id='filesToUpload']"));
		//Single File
		
		ChooseFile.sendKeys("D:\\VTU Results\\Resume\\Api.pdf");
		String name = BrowserDriver.findElement(By.xpath("//ul[@id=\"fileList\"]//li")).getText();
		if(name.equals("Api.pdf")) {
			System.out.println("File uploaded successfully");
		}
		else
			System.out.println("failed");
			
			/**
		//multiple file upload
		//ChooseFile.sendKeys("D:\\VTU Results\\Resume\\Api.pdf"+"\n"+"D:\\VTU Results\\Resume\\CHINGARI.docx");
		String file1="D:\\VTU Results\\Resume\\Api.pdf";
		String file2="D:\\VTU Results\\Resume\\CHINGARI.docx";
		ChooseFile.sendKeys(file1+"\n"+file2);
		
		int Twofile=BrowserDriver.findElements(By.xpath("//ul[@id=\"fileList\"]//li")).size();
		if(Twofile==2) {
			System.out.println("Two files are uploaded successfully");
		}
		else
			System.out.println("Filed");
		**/
		Thread.sleep(3000);
		System.out.println("Browser closed");
		Thread.sleep(3000);
		BrowserDriver.quit();
	}

}
