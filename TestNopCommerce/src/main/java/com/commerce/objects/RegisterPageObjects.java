package com.commerce.objects;

import java.awt.Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPageObjects {

	private WebDriver driver;

	// Locators
	@FindBy(xpath = ".//div[@class='page-title']/h1[text()]")
	public WebElement register_header;
	
	@FindBy(xpath = ".//div[@id='gender']/span[@class=\"male\"]")
	public WebElement male_radiobutton;
	
	@FindBy(xpath = ".//div[@id='gender']/span[@class=\"female\"]")
	public WebElement female_radiobutton;
	
	@FindBy(id = "FirstName")
	public WebElement firstName_input;
	
	@FindBy(id = "LastName")
	public WebElement lastName_input;
	
	@FindBy(name = "DateOfBirthDay")
	public WebElement dayOfBirth_dropdown;
	
	@FindBy(name = "DateOfBirthMonth")
	public WebElement monthOfBirth_dropdown;
	
	@FindBy(name = "DateOfBirthYear")
	public WebElement yearOfBirth_dropdown;
	
	@FindBy(name = "Email")
	public WebElement email_input;
	
	@FindBy(name = "Company")
	public WebElement company_input;
	
	@FindBy(id = "Newsletter")
	public WebElement newsletter_checkbox;
	
	@FindBy(id = "Password")
	public WebElement password_input;
	
	@FindBy(id = "ConfirmPassword")
	public WebElement confirmPassword_input;
	
	@FindBy(id="register-button")
	public WebElement register_button;
	
	@FindBy(xpath=".//div[contains(@class,'validation-summary-errors')]")
	public WebElement validation_error_message;
	
	@FindBy(xpath=".//span[contains(@class,'field-validation-error')]")
	public WebElement field_validation_message;
	
	// Constructor
	public RegisterPageObjects(WebDriver driver) {
		this.driver = driver;		
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}
}
