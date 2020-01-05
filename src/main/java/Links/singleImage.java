package Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class singleImage {
	static {
		WebDriverManager.chromedriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws IOException {
		URL url = new URL("https://demo.actitime.com/favicon2.ico");
		HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
		httpurlconnection.connect();
		int code = httpurlconnection.getResponseCode();
		System.out.println(code);
		
	}

}
