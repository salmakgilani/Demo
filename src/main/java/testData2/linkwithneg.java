package testData2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class linkwithneg {
	@Test
	public void testB() throws IOException {
		try {
			URL url = new URL("https://selenium.dev/ddddownloads/");
			HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
			httpconnection.setConnectTimeout(2000);
			httpconnection.connect();
			if(httpconnection.getResponseCode() == 200) {
				System.out.println(httpconnection.getURL()+ " is working fine. Response Code is:" +httpconnection.getResponseCode() +"response mesage is " + httpconnection.getResponseMessage());
			}else {
				System.out.println(httpconnection.getURL()+ " is not working fine. Response Code is:" +httpconnection.getResponseCode() +"response mesage is " + httpconnection.getResponseMessage());	
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
