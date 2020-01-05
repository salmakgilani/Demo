package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class demo {
@Test
	public void testA() throws IOException
	{
		File f = new File("C:\\Users\\AMEEN\\Documents\\HealthCare\\Demo\\Data\\inputt.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			String un = p.getProperty("un");
			System.out.println(un);
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
