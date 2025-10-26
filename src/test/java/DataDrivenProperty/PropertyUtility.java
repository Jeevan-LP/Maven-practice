package DataDrivenProperty;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyUtility {

	public static FileInputStream fInput;
	public static Properties Pfile;
	
	public static String getKeyValue(String FilePath, String KeyName) throws Throwable {
		fInput=new FileInputStream(FilePath);
		Pfile= new Properties();
		Pfile.load(fInput);
		String Keyvalue = Pfile.getProperty(KeyName);
		System.out.println(Keyvalue);
		fInput.close();
		return Keyvalue;
	}
	
	public static Set<String> getKeyName(String FilePath) throws Throwable {
		fInput=new FileInputStream(FilePath);
		Pfile= new Properties();
		Pfile.load(fInput);
		Set<String> KeyName = Pfile.stringPropertyNames();
		for(String KName:KeyName) {
			System.out.println(KName);
		}
		fInput.close();
		return KeyName;
	}
	

}
