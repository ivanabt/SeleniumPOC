package com.commerce.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsObjects {
	private WebDriver driver;

	// Locators
	
	@FindBy(className="search-results")
	public WebElement search_results_locator;
}
