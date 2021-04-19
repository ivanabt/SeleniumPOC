package com.commerce.methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commerce.objects.RegisterResultObjects;

public class RegisterResult extends RegisterResultObjects {
	private WebDriver driver;
	
	public RegisterResult(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		// Initialise Elements
		//PageFactory.initElements(driver, this);
	}

	public String getAlertText() throws Exception{
		return register_result.getText();
	}


}
