import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fluentWait {
	static {
		WebDriverManager.chromedriver().setup();// to set system,set property
	}
@Test
public void TestA() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("div[id='start']button")).click();
	//create a object of fluent class
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	
	WebElement eEle = wait.until(new Function<WebDriver, WebElement>() {

		public WebElement apply(WebDriver driver) {
			if(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
				return driver.findElement(By.cssSelector("div[id='finish'] h4"));
			}else {
			return null;
			}
		}
	});
	System.out.println("Element is Dislayed and text is"  +eEle.getText()+ "" +eEle.isDisplayed());
	driver.close();
}
}
