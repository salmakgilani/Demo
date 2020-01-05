package listenerspkg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo3 {
	@Test
	 public void TestF() {
		Reporter.log("TestA() ... " , true);
	}
	@Test
	 public void TestG() {
		Reporter.log("TestA() ... " , true);
	}
}
