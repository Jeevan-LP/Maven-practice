package DataDrivenProperty;

public class demo {

	public static void main(String[] args) throws Throwable {

		PropertyUtility.getKeyValue(System.getProperty("user.dir")+"\\TestData\\PropertyData.properties", "Team");
		PropertyUtility.getKeyName(System.getProperty("user.dir")+"\\TestData\\PropertyData.properties");
	}

}
