package testData;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class genericReadData {
	public static void ReadData()
	{
		File f = new File("C:\\Users\\AMEEN\\Documents\\HealthCare\\Demo\\Data\\inputt.properties");

			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			String data = p.getProperty(key);
			return data;

}
