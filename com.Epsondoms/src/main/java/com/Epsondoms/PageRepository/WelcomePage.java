package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	// Intialization
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Declaration
	@FindBy(id = "name")
	private WebElement nametextfield;

	@FindBy(id = "email")
	private WebElement emailtextfield;

	@FindBy(id = "password")
	private WebElement passwordtextfield;

	@FindBy(id = "mobile")
	private WebElement mobilenotextfield;

	@FindBy(partialLinkText = "Us")
	private WebElement contactuslink;

	// Utilization
	public WebElement getNametextfield() {
		return nametextfield;
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getMobilenotextfield() {
		return mobilenotextfield;
	}

	public WebElement getContactuslink() {
		return contactuslink;
	}

}
