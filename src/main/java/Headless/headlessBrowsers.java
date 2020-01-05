package Headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessBrowsers {
	static {
		WebDriverManager.chromedriver().setup();// to set system,set property
	}
@Test
public void TestA() throws InterruptedException, IOException {
	ChromeOptions co = new ChromeOptions(); //create ref for Chromeoptions as we ave to go headless
	co.setHeadless(true); // adv of this u can set true or false, so that u can witch between headless aand normal exec
	WebDriver driver = new ChromeDriver(co);
	driver.manage().window().maximize();
	driver.get("https://selenium.dev/");
	Thread.sleep(2000);
	  TakesScreenshot Ts = (TakesScreenshot) driver;
	  File src = Ts.getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src, new File("./screenshot/abc.png"));
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	Reporter.log("current URL is: " +url, true);
	Reporter.log("title of the webpage is" +title, true);
	driver.close();
}
}
//we need the proof that in bg it is executing, so we take screenshot(line 29 to 31). 
//Adv: it is fast
//It is used in beta not system test
//we have two more browsers/; phantomjs - this is outdated, for IQ, this is purely made for headless browser. In case we want to work headless for 
//chromebrowser we have to use chromeOptions. In headless we dont have to use an extra class(No pre-conditions, no need to create a class). It is specifically for that.
