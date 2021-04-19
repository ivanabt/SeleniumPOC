package com.commerce.objects;

import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	static String currentUsersEmail="ivana"+RandomStringUtils.randomAlphabetic(8)+"@test.com";
	
	@DataProvider(name="RegisterUser")
	public static Object[][] registerUserDataProvider(Method m){
		Object[][] data=null;
		if(m.getName().equals("registerExistingUser"))
		{
			data=new Object[][]
					{
				{"female","Ivana","Ivanovska","12","3","1992","ivana@test.com","ivanabitola","ivanabitola"}
					};
		}
		else if(m.getName().equals("registerNewUser") || m.getName().equals("userVotesInHomePoll"))
		{
			
			data=new Object[][]
					{
				{"female","Ivana","Ivanovska","12","3","1992",currentUsersEmail,"ivanabitola","ivanabitola"}
					};
		}
		else if(m.getName().equals("registerUserWithInvalidEmail"))
		{
			
			data=new Object[][]
					{
				{"female","Ivana","Ivanovska","12","3","1992","ivana@test","ivanabitola","ivanabitola"}
					};
		}
		return data;
	}
	
	@DataProvider(name="LoginUser")
	public static Object[][] loginUserDataProvider(Method m){
		Object[][] data=null;
		if(m.getName().equals("loginUserWithIncorrectPassword")) {
			data=new Object[][]
					{
				{"ivana@test.com","wrongpassword"}
					};
		}
		return data;
	}
	
	@DataProvider(name="SearchProduct")
	public static Object[][] searchProductDataProvider(Method m){
		Object[][] data=null;
		if(m.getName().equals("guestSearchesForShoeProductAddsToWishlist")) {
			data=new Object[][]
					{
//				{"adidas","11","Silver"}, TODO:Fails when executing with multiple test values
				{"adidas","9","Silver"}
					};
		}
		return data;
	}
}
