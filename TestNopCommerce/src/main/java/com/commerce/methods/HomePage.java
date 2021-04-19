package com.commerce.methods;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.commerce.objects.HomePageObjects;

public class HomePage extends HomePageObjects {

	private WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods
	public HomePage navigateToHomePage() throws Exception {
		try {
			home_page_logo_locator.click();
			return new HomePage(driver);
		}catch (Exception e) {
			System.out.println("NopCommerce logo was not found");
			throw(e);
		}
		
	}
	
	public RegisterPage navigateToRegister() throws Exception {
		try {
			register_locator.click();
			return new RegisterPage(driver);
		}catch (Exception e) {
			System.out.println("Register element is not found");
			throw(e);
		}
		
	}
	
	public LoginPage navigateToLogin() throws Exception {
		try {
			login_locator.click();
			return new LoginPage(driver);
		}catch (Exception e) {
			System.out.println("Login element is not found");
			throw(e);
		}
		
	}

	public void navigateThroughMenu(WebElement screenLocator) throws Exception {
		try {
			screenLocator.click();
		}catch (Exception e) {
			System.out.println("Element "+screenLocator+" cannot be found");
			throw(e);
		}
		
	}

	public void clickLink(WebElement linkLocator) throws Exception {
		try {
			linkLocator.click();
		}catch (Exception e) {
			System.out.println("Link element "+linkLocator+" cannot be found");
			throw(e);
		}		
	}

	public void clickButton(WebElement linkLocator) {
		linkLocator.click();
	}

	public void populateInputField(WebElement inputLocator, String inputText) {
		inputLocator.sendKeys(inputText);
	}

	public boolean isPageOpened(WebElement headingLocator, String headingText) {
		// Assertion
		return headingLocator.getText().toString().contains(headingText);
	}

	public void logOutUser() throws Exception {
		try {
			logout_locator.click();
		}catch (Exception e) {
			System.out.println(logout_locator+" cannot be found");
			throw(e);
		}		
	}
	
	public void voteOnPoll(String vote) throws Exception {
		try {
			switch(vote) {
			case "Excellent": excellent_radiobutton_locator.click();
			break;
			case "Good": good_radiobutton_locator.click();
			break;
			case "Poor": poor_radiobutton_locator.click();
			break;
			case "Bad": verybad_radiobutton_locator.click();
			break;
			default: System.out.println("Unsupported vote value");
			}
			vote_poll_button_locator.click();
		}catch(Exception e) {
			throw(e);
		}		
	}
	
	public String getAlertText() throws Exception{
		return validation_error_message.getText();
	}

//	public String generateUniqueEmail() {
//		// String shortUUID=RandomStringUtils.randomAlphabetic(5);
//		DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
//		Date date = new Date(0);
//		String todaysDate = dateFormat.format(date);
//
//		return "ivana" + todaysDate + "@test.com";
//	}
}
