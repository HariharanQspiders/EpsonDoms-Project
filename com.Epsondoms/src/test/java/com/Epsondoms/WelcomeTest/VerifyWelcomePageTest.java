package com.Epsondoms.WelcomeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Epsondoms.GenericLibrary.BaseTest;
import com.Epsondoms.JavaLibrary.JavaUtility;
import com.Epsondoms.PageRepository.PageManagment;
import com.aventstack.extentreports.Status;

public class VerifyWelcomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyWelcomepageWithValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");

		// Steps Information
		test.log(Status.INFO, "<<---Execution Started Sucessfully---->>");

		// Execute the Precondition--->1.Launch the Browser, 2.Navigate To URL
		test.log(Status.INFO, "Step1: Launching The Browser Sucessful");

		// Implicit Wait
		webdriverobj.waitImplicitly(20);

		// Verify The Welcome Page Using Title
		Assert.assertEquals("Learning Selenium", webdriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified ");

		// Create an Object For PageManager
		pageMangmentobj = new PageManagment(webdriverobj.driver);

		// Verify the Name TextField
		boolean result = pageMangmentobj.initWelcomepage().getNametextfield().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified:Name TextField is Displayed");

		// Step3:Perform Action--Clear
		pageMangmentobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.PASS, "Step3:Clear Action Done Successfully -NameTextField");

		// Step4:Perform Action--Sendkeys
		pageMangmentobj.initWelcomepage().getNametextfield().sendKeys(username);
		test.log(Status.PASS, "Step4:Sendkeys Action Done Successfully -NameTextField");

		// See the Execution
		JavaUtility.pause(3000);

		// Soft Asset Statement
		SoftAssert softassertobj = new SoftAssert();

		// Step5:Verify The "Contact Us " HyperLink
		softassertobj.assertEquals("Contact Us", pageMangmentobj.initWelcomepage().getContactuslink().getText());
		test.log(Status.PASS, "Step4:Verified Text  Successfully -Contact Us HyperLink");

		softassertobj.assertAll();

		// Execution Log or Status
		test.log(Status.INFO, "<<---Execution Completed Sucessfully--->>");

	}

	@Test(priority = 2, invocationCount = 2, dependsOnMethods = "verifyWelcomepageWithValidInput")
	public void verifyWelcomepageWithInValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithInValidInput");

		// Steps Inforamtion
		test.log(Status.INFO, "<<---Execution Started Sucessfully---->>");
		// Execute the Precondition--->1.Launch the Browser, 2.Navigate To URL

		// Implicit Wait
		webdriverobj.waitImplicitly(20);

		// Verify The Welcome Page Using Title
		String exptitle = "Learning Selenium";
		String acttitle = webdriverobj.driver.getTitle();

		Assert.assertEquals(acttitle, exptitle);
		test.log(Status.PASS, "Title Verified :" + acttitle);

		// Create an Object For PageManager
		pageMangmentobj = new PageManagment(webdriverobj.driver);

		// Verify the Name TextField
		boolean result = pageMangmentobj.initWelcomepage().getNametextfield().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified:Name TextField is Displayed");

		// Step3:Perform Action--Clear
		pageMangmentobj.initWelcomepage().getNametextfield().clear();
		test.log(Status.PASS, "Step3:Clear Action Done Successfully -NameTextField");

		// Step4:Perform Action--Sendkeys
		pageMangmentobj.initWelcomepage().getNametextfield().sendKeys("qwesgrujhikuysradasdfjyx dvfg");
		test.log(Status.PASS, "Step4:Sendkeys Action Done Successfully -NameTextField");

		// See the Execution
		JavaUtility.pause(3000);

		// To Make The Explicit TestScript Fail
		// Assert.fail();

		// Execute the Postcondition--->1.Terminate The Browser
		// Execution Log or Status
		test.log(Status.INFO, "<<---Execution Completed Sucessfully ---->>");

	}

}
