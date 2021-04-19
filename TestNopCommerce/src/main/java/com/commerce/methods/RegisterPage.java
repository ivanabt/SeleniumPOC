package com.commerce.methods;

import java.awt.Checkbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;

import com.commerce.objects.RegisterPageObjects;

public class RegisterPage extends RegisterPageObjects {

	WebDriver driver;
	
	// Constructor
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;		
		// Initialise Elements
		//PageFactory.initElements(driver, this);
	}		
	
	//Methods
	public void registerUser(String gender,String firstName,String lastName,String dayOfBirth,String monthOfBirth,String yearOfBirth,String email,String password,String confirmPassword) throws Exception{
		//Insert input details
		selectGender(gender);
		insertFirstName(firstName);
		insertLastName(lastName);
		selectDayOfBirth(dayOfBirth);
		selectMonthOfBirth(monthOfBirth);
		selectYearOfBirth(yearOfBirth);		
		insertEmail(email);
		//Do not want to receive newsletter
		if(newsletter_checkbox.isSelected()) {
			uncheck_newsletter();
		}
		insertPassword(password);
		confirmPassword(confirmPassword);		
		clickRegister();
	}
	
	
	private void selectGender(String gender) throws Exception
	{
		try {
			if(gender.equalsIgnoreCase("male"))
			{
				male_radiobutton.click();
			}
			if(gender.equalsIgnoreCase("female"))
			{
				female_radiobutton.click();
			}
		}catch(Exception e) {
			System.out.println("Unable to select gender.");
			throw(e);
		}
		
	}
	
	private void insertFirstName(String firstName) throws Exception
	{
		try {
			firstName_input.sendKeys(firstName);
		}catch(Exception e) {
			System.out.println("Unable to insert first name.");
			throw(e);
		}		
	}
	
	private void insertLastName(String lastName) throws Exception
	{
		try {
			lastName_input.sendKeys(lastName);
		}catch(Exception e) {
			System.out.println("Unable to insert last name.");
			throw(e);
		}
	}
	
	
	private void selectDayOfBirth(String dayOfBirth_value) throws Exception
	{
		try {
			Select dayOfBirth=new Select(dayOfBirth_dropdown);
			dayOfBirth.selectByValue(dayOfBirth_value);
		}catch(Exception e) {
			System.out.println("Unable to select day of birth.");
			throw(e);
		}		
	}
	
	private void selectMonthOfBirth(String monthOfBirth_value) throws Exception
	{
		try {
			Select monthOfBirth=new Select(monthOfBirth_dropdown);
			monthOfBirth.selectByValue(monthOfBirth_value);
		}catch(Exception e) {
			System.out.println("Unable to select month of birth.");
			throw(e);
		}		
	}
	
	private void selectYearOfBirth(String yearOfBirth_value) throws Exception
	{
		try {
			Select yearOfBirth=new Select(yearOfBirth_dropdown);
			yearOfBirth.selectByValue(yearOfBirth_value);
		}catch(Exception e) {
			System.out.println("Unable to select year of birth.");
			throw(e);
		}		
	}
	
	private void insertEmail(String email) throws Exception
	{
		try {
			email_input.sendKeys(email);
		}catch(Exception e) {
			System.out.println("Unable to insert registration email.");
			throw(e);
		}		
	}
		
	private void check_newsletter() throws Exception
	{
		try {
			newsletter_checkbox.click();
		}catch(Exception e) {
			System.out.println("Unable to click newsletter checkbox.");
			throw(e);
		}		
	}
	
	private void uncheck_newsletter() throws Exception
	{
		try {
			newsletter_checkbox.click();
		}catch(Exception e) {
			System.out.println("Unable to click newsletter checkbox.");
			throw(e);
		}	
	}
	
	private void insertPassword(String password) throws Exception
	{
		try {
			password_input.sendKeys(password);
		}catch(Exception e) {
			System.out.println("Unable to insert password.");
			throw(e);
		}		
	}
	
	private void confirmPassword(String password) throws Exception
	{
		try {
			confirmPassword_input.sendKeys(password);
		}catch(Exception e) {
			System.out.println("Unable to confirm password.");
			throw(e);
		}
		
	}
	
	private RegisterResult clickRegister() throws Exception
	{
		try {
			register_button.click();
			return new RegisterResult(driver);
		}catch(Exception e) {
			System.out.println("Unable to click register button.");
			throw(e);
		}		
	}
}
