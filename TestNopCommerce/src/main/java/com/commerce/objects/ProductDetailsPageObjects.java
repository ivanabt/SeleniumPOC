package com.commerce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPageObjects {
	private WebDriver driver;

	// Locators
	
	@FindBy(xpath=".//div[@class='product-essential']/div[@class='gallery']//img")
	public WebElement product_img_locator;
	
	@FindBy(className="picture-thumbs")
	public WebElement picture_thumbs_locator;
	
	@FindBy(xpath=".//div[@class='product-name']/h1")
	public WebElement product_title_locator;
	
	@FindBy(xpath=".//div[@class='product-reviews-overview']//div[@class='rating']")
	public WebElement product_rating_locator;
	
	@FindBy(xpath=".//select[@id='product_attribute_9']")
	public WebElement shoe_size_select_locator;	
	
	@FindBy(xpath=".//*[@id='product_attribute_input_10']//li//span[@title='Red']")
	public WebElement shoe_color_red_locator;
	
	@FindBy(xpath=".//*[@id='product_attribute_input_10']//li//span[@title='Blue']")
	public WebElement shoe_color_blue_locator;
	
	@FindBy(xpath=".//*[@id='product_attribute_input_10']//li//span[@title='Silver']")
	public WebElement shoe_color_silver_locator;
	
	@FindBy(xpath=".//label[@class='qty-label']")
	public WebElement add_to_cart_quantity_locator;
	
	@FindBy(className="add-to-cart-button")
	public WebElement add_to_cart_button_locator;
	
	
	@FindBy(className="add-to-wishlist")
	public WebElement whishlist_button_locator;
	
	@FindBy(className="add-to-compare-list-button")
	public WebElement compare_list_button_locator;
	
	@FindBy(className="email-a-friend-button")
	public WebElement email_friend_button_locator;
	
	@FindBy(className="product-tags-box")
	public WebElement product_tags_locator;
	
	@FindBy(className="product-essential")
	public WebElement product_essential_locator;
}
