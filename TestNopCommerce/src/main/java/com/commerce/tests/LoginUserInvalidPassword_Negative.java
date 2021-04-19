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
import com.commerce.methods.LoginPage;
import com.commerce.objects.DataProviderClass;
import com.commerce.objects.LoginPageObjects;

public class LoginUserInvalidPassword_Negative extends BaseTests {
	WebDriver driver;

	@BeforeTest
	public void startTest() throws MalformedURLException {
		// Create a new instance of a driver
		driver = BrowserEnvironment();
	}

	@Test(dataProvider="LoginUser",dataProviderClass=DataProviderClass.class)
	public void loginUserWithIncorrectPassword(String email, String password) throws Exception {
		// Create objects of page classes
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		//Navigate to login page and validate it is displayed
		homePage.navigateToLogin();
		Assert.assertEquals(loginPage.login_header.getText(), "Welcome, Please Sign In!");
		
		// Insert input details
		loginPage.loginUser(email, password);
		
		//Validate error message
		Assert.assertTrue(loginPage.getAlertText().contains("Login was unsuccessful. Please correct the errors and try again."));				
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
