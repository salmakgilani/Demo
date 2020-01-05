package Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.helper.HttpConnection;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class responsecode {
	@Test
	public void testA() throws IOException {
		//specify the URL to be tetsted// to pass the URL URL class is used
		URL url = new URL("https://selenium.dev/downloads/");
		HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
		//to get the connection
		httpconnection.connect();
		//to get response code
		int code = httpconnection.getResponseCode();
		//to get response method
		String msg = httpconnection.getResponseMessage();
		URL url1 = httpconnection.getURL();
		System.out.println("code is:" +code);
		System.out.println("message is:" +msg);
		System.out.println("URL is:" +url1);
	}
	
}
//
