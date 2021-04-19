package com.commerce.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.commerce.basetests.BaseTests;
import com.commerce.methods.HomePage;
import com.commerce.methods.LoginPage;
import com.commerce.methods.RegisterPage;
import com.commerce.methods.RegisterResult;
import com.commerce.objects.DataProviderClass;

public class UserVotesInHomePoll extends BaseTests{
	WebDriver driver;

	@BeforeTest
	public void startTest() throws MalformedURLException {
		// Create a new instance of a driver
		driver = BrowserEnvironment();
	}
	
	@Test(dataProvider="RegisterUser",dataProviderClass=DataProviderClass.class)
	public void userVotesInHomePoll(String gender,String firstName, String lastName, String dayOfBirth, String monthOfBirth,String yearOfBirth,String email, String password,String confirmPassword) throws Exception{
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
		
		homePage.navigateToHomePage();
		
//		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//		homePage.navigateToLogin();
//		Assert.assertTrue(loginPage.login_header.getText().contains("Please Sign In"));
//		loginPage.loginUser("ivana@test.com", "ivanabitola");
		WebDriverWait wait=new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(homePage.logout_locator));
		homePage.voteOnPoll("Good");
		wait.until(ExpectedConditions.visibilityOf(homePage.poll_results_locator));
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
