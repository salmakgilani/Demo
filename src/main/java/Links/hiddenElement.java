package Links;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hiddenElement {
	static {
		WebDriverManager.chromedriver().setup();
	}
	WebDriver driver;
	@Test
	public void testA() throws IOException, InterruptedException {
		
	 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/guest/home.do");
		WebElement fromplace = driver.findElement(By.id("fromPlaceName"));
		Actions act = new Actions(driver);
		// click method of actions class is used. instead of directly giving sendkeys, we use action class, move to that elemnt and click and den we send 
		//the text. Instead of sending ban we gotta send BAN so we press shift and en enter keys. for this we use keydown function and press the key shift
		act.moveToElement(fromplace).click().keyDown(Keys.SHIFT).sendKeys("ban").perform();
		for(int i=0; i <= 5; i++)
		{
			fromplace.sendKeys(Keys.DOWN);
			
		}
		fromplace.click();
		Thread.sleep(2000);
		//hidden elements cannot be accesed via java/ selenium hence we use javascript
		// now we want to get the text after keydown for 5 times, the text is not accessible via getText(). it does not give any result. so we go for js
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// in js we can put "document.getElementById('fromPlaceName')" here v put .value to get the text as we need to print the text.here 
		// using the js object, return type is object but we want a text so we cast to string type.
		String text = (String) js.executeScript("return document.getElementById('fromPlaceName').value");
		System.out.println("Selected place is: "+ text);
		driver.close();
		
		}

}
