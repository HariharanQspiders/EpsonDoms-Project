package com.Epsondoms.WebDriverLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 /* This Class  Provides the Resuable Method To Perform All Browser Related Actions
 *
 * 
 * @author Harry*/
public class WebDriverUtility {

	public WebDriver driver;
	public static WebDriver driver_static;
	public Select selectobj;
	public Actions actionsobj;
	public Robot robotobj;
	public WebDriverWait wait;

	/**
	 * This Method Uesd To Launch The Specfic Browser
	 * @param String BrowserName
	 * @return void*/
	public void launchBrowser(String browser) {

		// Step1:Launch the Browser---->Chrome,Edge,Safari
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver_static = driver;
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver_static = driver;
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver_static = driver;
			break;

		default:
			System.out.println("You Have Entered Incorrect Browser Name---You Stupid Fellow!!!!");
			break;
		}

	}

	public void NavigateToApplication(String url) {
		driver.get(url);
	}

	public void maximizeTheBrowser() {
		driver.manage().window().maximize();
	}

	public void closeTheBrowser() {
		driver.close();
	}

	public void closeAllBrowser() {
		driver.quit();
	}

	public void waitImplicitly(long duration) {
		driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
	}

	public void waitExplicitly(long duration, WebElement element) {
		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void selectOptionInDropdown(WebElement element, int index) {
		selectobj.selectByIndex(index);

	}

	public void selectOptionInDropdown(WebElement element, String visibletext) {
		selectobj.selectByVisibleText(visibletext);
	}

	public void selectOptionInDropdown(String value, WebElement element) {
		selectobj.selectByValue(value);
	}

	public void mouseHovering(WebElement element) {
		actionsobj.moveToElement(element).perform();
	}

	public void pressTheKey_pageDown() {
		robotobj.keyPress(KeyEvent.VK_PAGE_DOWN);

	}

	public void RelaeseTheKey_pageDown() {
		robotobj.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	public void alertPopupAccept() {
		driver.switchTo().alert().accept();

	}

	public void alertPopupDismiss() {
		driver.switchTo().alert().dismiss();

	}

	public void switchControlToFrame(int index) {
		driver.switchTo().frame(index);
	}

	public void switchControlToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchBackControlToMain() {
		driver.switchTo().defaultContent();
	}

	public void switchControlToWindow(String windowaddress) {

		driver.switchTo().window(windowaddress);

	}

}
