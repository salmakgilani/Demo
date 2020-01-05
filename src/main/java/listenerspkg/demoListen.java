package listenerspkg;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class demoListen implements ITestListener, ISuiteListener{ //u have to inherit from itestlistener and wen error comes, implement unimplemented method, below methods come automatically

	public void onFinish(ITestContext res) {
		Reporter.log(res.getName() + "is finished", true);
		
	}

	public void onStart(ITestContext res) {
		Reporter.log(res.getName() + "is started", true);
		
	}

	//public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// no point of using this, very old
		
	//}

	public void onTestFailure(ITestResult res) {
		Reporter.log(res.getName() + "is failed", true);
		
	}

	public void onTestSkipped(ITestResult res) {
		Reporter.log(res.getName() + "is skipped", true);
		
	}

	public void onTestStart(ITestResult res) {
		Reporter.log(res.getName() + "is started", true);
		
	}

	public void onTestSuccess(ITestResult res) {
		Reporter.log(res.getName() + "is passed", true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite res) {
		Reporter.log(res.getName() + " suite is finished", true);
		
	}

	public void onStart(ISuite res) {
		Reporter.log(res.getName() + " suite is started", true);
		
	}
}
//this is for one class, in real time we have multiple classes, in order to track the execution of all the classes (i.e project level), u can
//listen it at suite level
//implements iTest
//changed this program only . add multiple classes like demo1, emo2
// instead of adding listener annotation in a class, u have to add in testng.xml file
