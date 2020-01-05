package testData2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class allLinks {
	static {
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws IOException
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://selenium.dev/downloads/");
	List<WebElement> alllinks = driver.findElements(By.xpath("//a"));
	System.out.println("No. of links are" +alllinks.size());
	for (WebElement link : alllinks) {
		String href = link.getAttribute("href");
		try {
			URL url = new URL(href);
		HttpURLConnection httpconnection = (HttpURLConnection) url.openConnection();
	
		httpconnection.connect();
		if(httpconnection.getResponseCode() == 200) {
			System.out.println(httpconnection.getURL()+ " is working fine. Response Code is:" +httpconnection.getResponseCode() +"response mesage is " + httpconnection.getResponseMessage());
		}else {
			System.out.println(httpconnection.getURL()+ " is not working fine. Response Code is:" +httpconnection.getResponseCode() +"response mesage is " + httpconnection.getResponseMessage());	
		}
		
	}
		 catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();

		 }
		System.out.println("====");
	}
	}
}
