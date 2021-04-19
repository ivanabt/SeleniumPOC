package com.commerce.methods;

import org.openqa.selenium.WebDriver;

import com.commerce.objects.LoginPageObjects;

public class LoginPage extends LoginPageObjects{
	private WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public void loginUser(String email, String password) {
		try {
			insertEmail(email);
			insertPassword(password);
			clickLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void insertEmail(String email) throws Exception
	{
		try {
			login_email.sendKeys(email);
		}catch(Exception e) {
			System.out.println("Unable to insert login email.");
			throw(e);
		}		
	}
	
	private void insertPassword(String password) throws Exception
	{
		try {
			login_password.sendKeys(password);
		}catch(Exception e) {
			System.out.println("Unable to insert password.");
			throw(e);
		}		
	}
	
	private void clickLogin() throws Exception
	{
		try {
			login_button.click();
		}catch(Exception e) {
			System.out.println("Unable to click login button.");
			throw(e);
		}		
	}
	
	public String getAlertText() throws Exception{
		return validation_error_message.getText();
	}
}
