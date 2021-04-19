package com.commerce.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.commerce.basetests.BaseTests;
import com.commerce.methods.HomePage;
import com.commerce.methods.RegisterPage;
import com.commerce.objects.DataProviderClass;

public class RegisterExistingUser_Negative extends BaseTests {

	WebDriver driver;

	@BeforeTest
	public void startTest() throws MalformedURLException {
		// Create a new instance of a driver
		driver = BrowserEnvironment();
	}

	@Test(dataProvider="RegisterUser",dataProviderClass=DataProviderClass.class)
	public void registerExistingUser(String gender,String firstName, String lastName, String dayOfBirth, String monthOfBirth,String yearOfBirth,String email, String password,String confirmPassword) throws Exception {

		// Create objects of page classes
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

		// Navigate to register screen and validate it is presented
		homePage.navigateToRegister();
		Assert.assertEquals(registerPage.register_header.getText(), "Register");

		//Register user
		registerPage.registerUser(gender, firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, password, confirmPassword);
				
		// Validate redirect screen
		Assert.assertEquals(registerPage.validation_error_message.getText(), "The specified email already exists");
	}

	@AfterTest
	public void close() {
		driver.close();
	}
	
	
}
