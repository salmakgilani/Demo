package Links;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleLinksinaPage {
	static {
		WebDriverManager.chromedriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws MalformedURLException{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/AMEEN/Desktop/Automation/html/links.html");
		List<WebElement> alllinks = driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		for (WebElement link : alllinks) {
			String href = link.getAttribute("href");
			LinkUtility.responseForLink(href);
			System.out.println("==================");
		}
	}
	
}
