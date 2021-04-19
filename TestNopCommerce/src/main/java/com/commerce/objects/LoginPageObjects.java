package com.commerce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	private WebDriver driver;

	// Locators
	@FindBy(xpath = ".//div[@class='page-title']/h1[text()]")
	public WebElement login_header;
	
	@FindBy(xpath = ".//input[@class='email']")
	public WebElement login_email;
	
	@FindBy(xpath = ".//input[@class='password']")
	public WebElement login_password;
	
	@FindBy(xpath=".//input[contains(@class,'login-button')]")
	public WebElement login_button;
	
	@FindBy(xpath=".//div[contains(@class,'validation-summary-errors')]")
	public WebElement validation_error_message;
}
