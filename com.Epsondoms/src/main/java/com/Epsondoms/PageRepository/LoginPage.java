package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Intialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
