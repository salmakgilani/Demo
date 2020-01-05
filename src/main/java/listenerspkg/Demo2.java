package listenerspkg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo2 {
	@Test
	 public void TestD() {
		Reporter.log("TestD() ... " , true);
	}

	@Test
	 public void TestE() {
		Reporter.log("TestE() ... " , true);
	}
}
