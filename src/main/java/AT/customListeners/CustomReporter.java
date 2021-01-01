package AT.customListeners;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter {

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		for (ISuite suite : suites) {
			// gets suite name
			String suiteName = suite.getName();
			// getting the result for the said suite

			Map<String, ISuiteResult> suiteResults = suite.getResults();

			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				System.out.println(
						"Passed tests for suite " + suiteName + " is " + tc.getPassedTests().getAllResults().size());
				System.out.println(
						"Failed tests for suite " + suiteName + " is " + tc.getFailedTests().getAllResults().size());
				System.out.println(
						"Skipped tests for suite " + suiteName + " is " + tc.getSkippedTests().getAllResults().size());
			}

		}
	}

}
