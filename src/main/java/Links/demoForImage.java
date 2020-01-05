package Links;

	import java.net.MalformedURLException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class demoForImage {
	static {
		WebDriverManager.chromedriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws MalformedURLException {
		
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/AMEEN/Desktop/Automation/html/images.html");
		List<WebElement> allimages = driver.findElements(By.tagName("img"));
		System.out.println("Total no. of images:" + allimages.size());
		for (WebElement image: allimages) {
			String src = image.getAttribute("src");
		    imageUtility.responseForLink(src);
	       System.out.println("================================");
			
		}
	}
	}

