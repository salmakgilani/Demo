package Links;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoforLink {
static {
	WebDriverManager.chromedriver().setup();
}
WebDriver driver;
@Test
public void testA() throws IOException {
	
 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://selenium.dev/downloads");
	List<WebElement> alllinks = driver.findElements(By.tagName("a"));
	System.out.println("No.of links are:" + alllinks.size());
	for (WebElement links : alllinks) {
		String href = links.getAttribute("href");
       LinkUtility.responseForLink(href);
       System.out.println("================================");
		
	}
}
}
