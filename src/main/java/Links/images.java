package Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class images {
	static {
		WebDriverManager.chromedriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws IOException {
		
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver. get("file:///C:/Users/AMEEN/Desktop/Automation/html/images.html");
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		System.out.println("Total no. of images:" + allimages.size());
		for (WebElement image: allimages) {
			String src = image.getAttribute("src");
			
			URL url = new URL(src);
				HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
				httpUrlConnection.setConnectTimeout(2000);// handling the sync between URL class and httpurlconect class. 
				httpUrlConnection.connect();
				int code = httpUrlConnection.getResponseCode();
				String msg = httpUrlConnection.getResponseMessage();
				String value = image.getAttribute("value");
				System.out.println("value is" +value);
				if (code == 200) {
					System.out.println(src + "is working fine. And the response code is: " +code+ "response msg is: " + msg);
				}
				else {
					System.out.println(src + "is not working fine. And the response code is: " +code+ "response msg is: " + msg);
			
				}
		}	
}
}
