package com.commerce.tests;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.commerce.basetests.BaseTests;
import com.commerce.basetests.EyesManager;
import com.commerce.methods.HomePage;
import com.commerce.methods.ProductDetailsPage;
import com.commerce.objects.DataProviderClass;
import com.commerce.methods.SearchResults;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.Eyes;

public class GuestSearchesForProductAddsToWishlist extends BaseTests {
	WebDriver driver;
	EyesManager eyesManager;
	
	@BeforeTest
	public void startTest() throws MalformedURLException {
		driver = BrowserEnvironment();
		eyesManager=eyesManager();
	}
	
	@Test(dataProvider="SearchProduct",dataProviderClass=DataProviderClass.class)
	public void guestSearchesForShoeProductAddsToWishlist(String product,String product_size,String product_color) throws Exception{
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class); 
		
		//Search for product and validate results
		homePage.populateInputField(homePage.search_store_locator, product);
		homePage.clickButton(homePage.search_button_locator);
		Assert.assertTrue(homePage.search_product_result_locator.getText().contains(product));
		Assert.assertTrue(homePage.product_img_locator.getAttribute("title").contains(product));
		eyesManager.setBatchName("Search product and add product to whishlist");
		eyesManager.validateEntireScreen("Search product");
		
		//click product link to view details
		homePage.search_product_result_locator.click();
		//validate product details are displayed
		Assert.assertTrue(productDetailsPage.product_img_locator.getAttribute("title").contains(product));
		Assert.assertTrue(productDetailsPage.picture_thumbs_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.product_title_locator.getText().contains(product));
		Assert.assertTrue(productDetailsPage.product_rating_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.shoe_size_select_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.shoe_color_red_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.shoe_color_blue_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.shoe_color_silver_locator.isDisplayed());		
		Assert.assertTrue(productDetailsPage.add_to_cart_button_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.whishlist_button_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.compare_list_button_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.email_friend_button_locator.isDisplayed());
		Assert.assertTrue(productDetailsPage.product_tags_locator.isDisplayed());
		//... and many more assertions
		eyesManager.validateEntireScreen("Product details");

		
		//Choose size and color and validate chosen product
		Select drpSize = new Select(productDetailsPage.shoe_size_select_locator);
		drpSize.selectByVisibleText(product_size);
		if(product_color.equals("Red"))
		{
			productDetailsPage.shoe_color_red_locator.click();
		}
		else if(product_color.equals("Blue")) {
			productDetailsPage.shoe_color_red_locator.click();
		}
		else if(product_color.equals("Silver")) {
			productDetailsPage.shoe_color_silver_locator.click();
		}
		eyesManager.validateElement(productDetailsPage.product_essential_locator, "Validate chosen product");
		
		//Add product to whishlist
		productDetailsPage.whishlist_button_locator.click();
		//wait for success notification bar
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(homePage.notification_bar_locator));	
		//validate product was added to wishlist
		Assert.assertEquals(homePage.wishlist_qty_locator.getText(), "(1)");
	}
	
	@AfterTest
	public void close() {
		driver.close();
		eyesManager.eyesAwaitTestResults();
	}
	
}
