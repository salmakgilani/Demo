package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class dataUtility {
	public static String getPropertyData(String key)
	{
		File f = new File("C:\\Users\\AMEEN\\Documents\\HealthCare\\Demo\\Data\\inputt.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			String data = p.getProperty(key);
			return data;
			
			
		}
		catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return " ";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return" ";
		}
		
	}

}
