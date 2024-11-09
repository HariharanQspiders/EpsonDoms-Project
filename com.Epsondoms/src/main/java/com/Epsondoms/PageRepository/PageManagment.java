package com.Epsondoms.PageRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageManagment {

	public WebDriver driver ;
	public LoginPage loginpageobj;
	public RegisterPage registerpageobj;
	public WelcomePage welcomepageobj;

	// Intialization
	public PageManagment(WebDriver driver) {

	this.driver=driver;
	}

	public LoginPage initloginpage() {
	loginpageobj = new LoginPage(driver);
		return loginpageobj;
	}

	public WelcomePage initWelcomepage() {
		welcomepageobj = new WelcomePage(driver);
		return this.welcomepageobj;
	}

	public RegisterPage initRegisterpage() {
		registerpageobj = new RegisterPage(driver);
		return registerpageobj;
	}

}
