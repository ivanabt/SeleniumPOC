package com.commerce.tests;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.commerce.basetests.BaseTests;
import com.commerce.methods.HomePage;
import com.commerce.methods.RegisterPage;
import com.commerce.methods.RegisterResult;
import com.commerce.objects.DataProviderClass;

public class RegisterNewUserTest extends BaseTests {
	
	WebDriver driver;	
	
	@BeforeTest
	public void startTest() throws MalformedURLException {
		// Create a new instance of a driver
		driver = BrowserEnvironment();
	}
	
	@Test(dataProvider="RegisterUser",dataProviderClass=DataProviderClass.class)
	public void registerNewUser(String gender,String firstName, String lastName, String dayOfBirth, String monthOfBirth,String yearOfBirth,String email, String password,String confirmPassword) throws Exception {
		
		//Create objects of page classes
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
		RegisterResult registerResult = PageFactory.initElements(driver, RegisterResult.class);		
		
		//Navigate to register screen and validate it is presented
		homePage.navigateToRegister();
		Assert.assertEquals(registerPage.register_header.getText(), "Register");		
		
		//Register user
		registerPage.registerUser(gender, firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, email, password, confirmPassword);
		
		//Validate redirect screen
		Assert.assertEquals(registerResult.getAlertText(), "Your registration completed");
		Reporter.log("User was succesfully registered");
		
		homePage.logOutUser();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
