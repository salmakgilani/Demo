package listenerspkg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//@Listeners(listenerspkg.demoListen.class) - commenting as running for suite level

public class Demo {
@Test
 public void TestA() {
	Reporter.log("TestA() ... " , true);
}

@Test
public void TestB() {
	Reporter.log("TestB() ... " , true);
	Assert.fail();
}

@Test(dependsOnMethods = "TestB")
public void TestC() {
	Reporter.log("TestC() ... " , true);
	Assert.fail();
}
}
