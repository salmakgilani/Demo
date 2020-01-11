package com.windowpopu;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowPopupScreenshot {
	static {
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void testA() throws InterruptedException, AWTException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[3]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		Thread.sleep(2000);
		/* Incase of normal procedure to take screenshot(this does not take window pop-up)
		 * TakeScreenshot ts = (TakeScreenshot) driver;
		 * File src = ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("./screenshot/popup.png"));*/
		
		//create object of robot class - In order to take screenshot of window pop-up as well
		Robot r = new Robot();
		//Get the size of the screen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize(); //to get the dimensions of the screen we use getscreensize met under Toolkit class
		// create rectangle class
		Rectangle rect = new Rectangle(d); // to take screenshot, we have to use createscreencapture class which takes the arg obj ref of rectangle class so that it gets the screen dim.hence we create obj of rect class
		
		//Take the screenshot
		BufferedImage img = r.createScreenCapture(rect);// this is a method of robot class and returns an buffered image
		//Store in the location
		ImageIO.write(img, "png", new File("./screenshot/popup1.png"));//make sure to choose the right overloaded method with 3 arg - image, its format and path
		driver.close();
	
	} 
}
