package com.commerce.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.commerce.basetests.BaseTests;
import com.commerce.methods.HomePage;

public class GuestVotesInHomePoll_Negative extends BaseTests{
	WebDriver driver;

	@BeforeTest
	public void startTest() throws MalformedURLException {
		// Create a new instance of a driver
		driver = BrowserEnvironment();
	}
	
	@Test
	public void guestVotesInHomePoll() throws Exception{
		// Create objects of page classes
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.voteOnPoll("Poor");
		
		//Validate error message
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homePage.validation_error_message));
		Assert.assertTrue(homePage.getAlertText().contains("Only registered users can vote."));
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
