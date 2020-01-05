package Headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class phantomJS {
	static {
		WebDriverManager.phantomjs().setup();// to set system,set property
	}
	@Test
	public static void TestA() throws IOException {
		WebDriver driver = new PhantomJSDriver();//no need of creating an options class directly driver class of phantom
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		TakesScreenshot Ts = (TakesScreenshot) driver;
		  File src = Ts.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(src, new File("./screenshot/abc1.png"));
		String url1 = driver.getCurrentUrl();
		Reporter.log("current URL is: " +url1, true);
		Reporter.log("title of the webpage is" +title, true);
		driver.close();
	}
}
