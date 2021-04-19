package com.commerce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	
	private WebDriver driver;

	// Locators
	
	@FindBy(className="header-logo")
	public WebElement home_page_logo_locator;

	@FindBy(className = "ico-register")
	public WebElement register_locator;

	@FindBy(className = "ico-login")
	public WebElement login_locator;

	@FindBy(className = "ico-logout")
	public WebElement logout_locator;

	@FindBy(className = "wishlist-label")
	public WebElement wishlist_locator;
	
	@FindBy(className="wishlist-qty")
	public WebElement wishlist_qty_locator;

	@FindBy(className = "cart-label")
	public WebElement shopping_cart_locator;
	
	@FindBy(xpath=".//*[@id='bar-notification']//p")
	public WebElement notification_bar_locator;


	// Main menu locators
	@FindBy(linkText = "/computers")
	public WebElement menu_computers;

	@FindBy(linkText = "/electronics")
	public WebElement menu_electronics;

	@FindBy(linkText = "/apparel")
	public WebElement menu_apparel;

	@FindBy(linkText = "/digital-downloads")
	public WebElement menu_digitalDownloads;

	@FindBy(linkText = "/books")
	public WebElement menu_books;

	@FindBy(linkText = "/jewelry")
	public WebElement menu_jewelry;

	@FindBy(linkText = "/gift-cards")
	public WebElement menu_giftCards;

	// Submenu locators
	@FindBy(linkText = "/desktops")
	public WebElement submenu_desktops;

	@FindBy(linkText = "/notebooks")
	public WebElement submenu_notebooks;

	@FindBy(linkText = "/software")
	public WebElement submenu_software;
	
	//Search product section
	@FindBy(id = "small-searchterms")
	public WebElement search_store_locator;
	
	@FindBy(className = "search-box-button")
	public WebElement search_button_locator;
	
	@FindBy(xpath = ".//div[@class='search-results']//h2[@class='product-title']//a[text()]")
	public WebElement search_product_result_locator;
	
	@FindBy(xpath = ".//div[@class='product-item']/div/a/img")
	public WebElement product_img_locator;
	
	@FindBy(xpath = ".//div[@class='item-grid']/div[1]")
	public WebElement first_product_result_locator;
	
	@FindBy(xpath = ".//div[@class='item-grid']/div[2]")
	public WebElement second_product_result_locator;
	
	//Community poll section
	@FindBy(className="poll-display-text")
	public WebElement poll_label_locator;
	
	@FindBy(xpath=".//li[@class='answer']//*[text()='Excellent']")
	public WebElement excellent_radiobutton_locator;
	
	@FindBy(xpath=".//li[@class='answer']//*[text()='Good']")
	public WebElement good_radiobutton_locator;
	
	@FindBy(xpath=".//li[@class='answer']//*[text()='Poor']")
	public WebElement poor_radiobutton_locator;
	
	@FindBy(xpath=".//li[@class='answer']//*[text()='Very bad']")
	public WebElement verybad_radiobutton_locator;
	
	@FindBy(id="vote-poll-1")
	public WebElement vote_poll_button_locator;
	
	@FindBy(className="poll-vote-error")
	public WebElement validation_error_message;
	
	@FindBy(className="poll-results")
	public WebElement poll_results_locator;
}
