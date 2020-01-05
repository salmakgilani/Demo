package svg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bargraph {
	static {
		WebDriverManager.chromedriver().setup();
	}
	
	@Test
	public void testA() throws InterruptedException
	{
		int count = 0;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/AMEEN/Documents/svg.html");
		//Find out All elements in WebPage
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		Reporter.log("No of elements in WebPage are :"+allElements.size(),true);
		//Create an object of Actions Class
		Actions act = new Actions(driver);
		for (WebElement line : allElements) {
			
			String tagName = line.getTagName();
			if (tagName.equals("line")) 
			{
				count++;
				String bcolor = line.getCssValue("stroke");
				Reporter.log("Before Mouse Hoverover the Color is :"+bcolor,true);
				Thread.sleep(2000);
				act.moveToElement(line).perform();
				Thread.sleep(2000);
				
				WebElement tootTip = line.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				//WebElement tootTip = driver.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				String text = tootTip.getText();
				Reporter.log("Tool Tip Text is :"+text,true);
				
				
				String acolor = line.getCssValue("stroke");
				Reporter.log("After Mouse Hoverover the Color is :"+acolor,true);
				Reporter.log("--------------------------------------------------------",true);
			}
		}
		Reporter.log("No of Lines are :"+count,true);
		driver.close();
	}
}
