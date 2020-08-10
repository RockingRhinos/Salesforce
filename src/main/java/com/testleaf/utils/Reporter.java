package com.testleaf.utils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testleaf.selenium.api.base.DriverInstance;

public abstract class Reporter extends DriverInstance {

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public String testcaseName, testcaseDec, author, category;
	public String excelFileName;
	private String fileName = "reports/extent.html";

	@BeforeSuite(alwaysRun = true)
	public synchronized void beforeSuite() {
		File f = new File("./reports");
		if (!f.exists()) {
			f.mkdir();
		}
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(!true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("TestLeaf BootCamp");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("TestLeaf");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass(alwaysRun = true)
	public synchronized void report() throws IOException {
		ExtentTest parent = extent.createTest(testcaseName, testcaseDec);
		parent.assignCategory(category);
		parent.assignAuthor(author);
		parentTest.set(parent);
	}

	public synchronized void setNode() {
		ExtentTest child = parentTest.get().createNode(testcaseName);
		test.set(child);
	}

	public abstract long takeSnap();

	public void reportStep(String dec, String status, boolean bSnap) {
		synchronized (test) {
			MediaEntityModelProvider img = null;
			if (bSnap && !status.equalsIgnoreCase("INFO")) {
				long snapNumber = 100000L;
				snapNumber = takeSnap();
				try {
					img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg")
							.build();
				} catch (IOException e) {
				}
			}
			if (status.equalsIgnoreCase("pass")) {
				test.get().pass(dec, img);
			} else if (status.equalsIgnoreCase("fail")) {
				test.get().fail(dec, img);
				throw new RuntimeException("See the reporter");
			} else if (status.equalsIgnoreCase("warning")) {
				test.get().warning(dec, img);
			} else if (status.equalsIgnoreCase("INFO")) {
				test.get().info(dec);
			}
		}
	}

	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	@AfterSuite(alwaysRun = true)
	public synchronized void stopReport() {
		if (getDriver() != null) {
			getDriver().quit();
		}
		extent.flush();

	}
}