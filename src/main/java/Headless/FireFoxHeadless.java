package Headless;

	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class FireFoxHeadless {
		static {
			WebDriverManager.firefoxdriver().setup();// to set system,set property
		}
	@Test
	public void TestA() {
		FirefoxOptions co = new FirefoxOptions() ; //create ref for Chromeoptions as we ave to go headless
		co.setHeadless(true); // adv of this u can set true or false, so that u can witch between headless aand normal exec
		FirefoxDriver driver = new FirefoxDriver(co);
		driver.manage().window().maximize();
		driver.get("https://selenium.dev/");
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		Reporter.log("current URL is: " +url, true);
		Reporter.log("title of the webpage is" +title, true);
		driver.close();
	}
}
