package Headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLUnit {
	//please note static block is not written here.
	@Test
	public static void TestB() throws IOException {
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		//TakesScreenshot Ts = (TakesScreenshot) driver;
		//  File src = Ts.getScreenshotAs(OutputType.FILE);
		 // FileUtils.copyFile(src, new File("./screenshot/abc2.png"));
		String url1 = driver.getCurrentUrl();
		Reporter.log("current URL is: " +url1, true);
		Reporter.log("title of the webpage is" +title, true);
		driver.close();
	}
	}
//htmlUnit is fastest. It is faster than phantomJS
//This and phantomJS both are exlicit headless browsers.
//1. We cannot use webdrivermanager.html....setup() - as we can see above this line is not written unlike other browsers. we dont have to explicily set the property.
//2. We cannot take screenshot. It gives error htmldriver cannot be cast to screenshot. above screenshot steps are commented. 
// this might b coz this is an explicit headless browser, only for data execution.
	


