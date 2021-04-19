package com.commerce.methods;

import org.openqa.selenium.WebDriver;

import com.commerce.objects.SearchResultsObjects;

public class SearchResults extends SearchResultsObjects {
	private WebDriver driver;

	// Constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}
}
