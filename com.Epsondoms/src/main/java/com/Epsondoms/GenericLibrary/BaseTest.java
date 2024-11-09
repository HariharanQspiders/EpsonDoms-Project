package com.Epsondoms.GenericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.Epsondoms.ExceLibrary.ReadExcelFile;
import com.Epsondoms.PageRepository.PageManagment;
import com.Epsondoms.PropertyFileLibrary.ReadPropertyFile;
import com.Epsondoms.WebDriverLibrary.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This Class is used for configure All PreCondition and Post Condition For
 * TestScript And Also Initializing All the Library-Utility class
 * 
 * 
 * @author Harry
 */

public class BaseTest {

	public PageManagment pageMangmentobj;
	public WebDriverUtility webdriverobj;
	public ReadExcelFile excelutilityobj;
	public ReadPropertyFile propertyfileobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	@BeforeSuite
	public void suiteSetup() {
		// Create the SparkReport
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regresstion Testing For the learningSeleniumPage");
		spark.config().setReportName("RegresstionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);

		// Create the Extent Report
		report = new ExtentReports();

		// Attach the Spark Report and ExtentReport
		report.attachReporter(spark);

		// Configure the System Information in Extent Report
		report.setSystemInfo("DeviceName:", "Harry");
		report.setSystemInfo("OperatingSystem:", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-128.0.6613.85 ");
	}

	@AfterSuite
	public void suiteTerminateSetup() {

		// Flush the Report Information
		report.flush();
	}

	@Parameters({ "browsername", "weburl" })
	@BeforeClass
	public void browserSetup(String browser, String url) {
		// Create Object for All the Repository/Utility
		createObjects();

		// Fetch The Username From Excel File
		username = excelutilityobj.readSingleData("RegisterData", 1, 1);

		// Step1:Launch the Browser
		webdriverobj.launchBrowser(browser);
		Reporter.log("Step1:Launch the Browser Success", true);

		// Maximize the Browser
		webdriverobj.maximizeTheBrowser();
		Reporter.log("Step1.1:Maximized Browser Success", true);

		// Step2:Navigating To the Application via URL
		webdriverobj.NavigateToApplication(url);
		Reporter.log("Step2:Navigating To the Application via URL Success", true);

	}

	@AfterClass
	public void terminateBrowser() {
		// Step10:Close the Browser
		webdriverobj.closeAllBrowser();
		Reporter.log("Step10:Close the Browser Success", true);
	}

	public void createObjects() {
		webdriverobj = new WebDriverUtility();
		excelutilityobj = new ReadExcelFile();
		propertyfileobj = new ReadPropertyFile();

	}

}
