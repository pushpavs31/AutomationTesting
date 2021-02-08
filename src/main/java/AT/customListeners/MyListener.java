package AT.customListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import AT.Base.BaseClass;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution has Started : " + result.getName());
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("Test execution has Finished : " + context.getName());
	}

	public void onTestFailure(ITestResult result) {
		String methodname = result.getName();
		System.out.println("Test execution has failed : " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution has skipped :" + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Method execution has passed successfully : " + result.getName());
	}

}
