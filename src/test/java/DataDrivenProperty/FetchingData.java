package DataDrivenProperty;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class FetchingData {

	public static void main(String[] args) throws Throwable {

		String FilePath=System.getProperty("user.dir")+"\\TestData\\PropertyData.properties";
		FileInputStream FI = new FileInputStream(FilePath);
		
		Properties pro = new Properties();
		pro.load(FI);
		
		//all only key attribute value
		String Username = pro.getProperty("Username");
		System.out.println("Username="+Username);
		String Password = pro.getProperty("Password");
		System.out.println("Password="+Password);
		String URL = pro.getProperty("URL");
		System.out.println("URL="+URL);
		String Browser = pro.getProperty("Browser");
		System.out.println("Browser="+Browser);
		String Version = pro.getProperty("Version");
		System.out.println("Version="+Version);
		String Team = pro.getProperty("Team");
		System.out.println("Team="+Team);
		
		//all only key Name Approach 1
		Set<String> keysName = pro.stringPropertyNames();
		System.out.println(keysName); ////Approach 1
		for(String name:keysName) {	 ////Approach 2
			System.out.println(name);
		}
		
		//all only key Name Approach 2
		Set<Object> keysName1 = pro.keySet();
		System.out.println(keysName1);
		for(Object name1:keysName1) {
			System.out.println(name1);
		}
		
		String all = pro.toString();
		System.out.println(all);
		
		FI.close();
	}

}
