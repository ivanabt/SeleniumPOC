package com.commerce.methods;

import org.openqa.selenium.WebDriver;

import com.commerce.objects.ProductDetailsPageObjects;

public class ProductDetailsPage extends ProductDetailsPageObjects{
	private WebDriver driver;

	// Constructor
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
}
