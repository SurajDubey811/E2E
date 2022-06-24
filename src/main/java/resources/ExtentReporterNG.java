package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports report;
	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Suraj Test results");
		reporter.config().setReportName("Web Automation results");
		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Suraj");
		return report;
		
	}
}
