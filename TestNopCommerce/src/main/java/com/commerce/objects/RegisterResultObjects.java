package com.commerce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterResultObjects {
	
	private WebDriver driver;

	// Locators
	@FindBy(xpath = ".//div[@class='page-body']/div[text()]")
	public WebElement register_result;
	
	// Constructor
		public RegisterResultObjects(WebDriver driver) {
			this.driver = driver;		
			// Initialise Elements
			PageFactory.initElements(driver, this);
		}
}
