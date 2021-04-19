package com.commerce.basetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

public class EyesManager {
	private Eyes eyes;
	private String appName;
	private WebDriver driver;
	private EyesRunner runner;
	
	public EyesManager(WebDriver driver, String appName, String apiKey, ClassicRunner runner) {
		this.driver=driver;
		this.appName=appName;
		this.runner=runner;
		
		eyes=new Eyes(runner);
		eyes.setApiKey(apiKey);	
	}
	
	public EyesManager(WebDriver driver, String appName, String apiKey, VisualGridRunner runner, Configuration suiteConfig) {
		this.driver=driver;
		this.appName=appName;
		this.runner=runner;
		
		eyes=new Eyes(runner);
		eyes.setApiKey(apiKey);
		eyes.setConfiguration(suiteConfig);
	}
	
	public void setBatchName(String batchName) {
		eyes.setBatch(new BatchInfo(batchName));
	}
	
	public void validateWindow() {
		eyes.open(driver,appName,Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkWindow();
		eyes.closeAsync();
	}
	
	public void validateWindow(String testName) {
		eyes.open(driver,appName,testName);
		eyes.checkWindow();
		eyes.closeAsync();
	}
	
	public void validateEntireScreen(String testName) {
		eyes.open(driver,appName,testName);
		eyes.setForceFullPageScreenshot(true);
		eyes.checkWindow();
		eyes.closeAsync();
	}
	
	public void validateEntireScreen(ITestResult result) {		
		eyes.open(driver,appName,Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.setForceFullPageScreenshot(true);
		eyes.checkWindow();
		eyes.closeAsync();
	}
	
	public void validateElement(WebElement locator) {
		eyes.open(driver,appName,Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkElement(locator);
		eyes.closeAsync();
	}
	
	public void validateElement(WebElement locator, String testName) {
		eyes.open(driver,appName,testName);
		eyes.checkElement(locator);
		eyes.closeAsync();
	}
	
	public void validateFrame(String locator) {
		eyes.open(driver,appName,Thread.currentThread().getStackTrace()[2].getMethodName());
		eyes.checkFrame(locator);
		eyes.closeAsync();
	}
	
	public void closeEyesAsync() {
		eyes.closeAsync();
	}
	
	public void abortEyesAsync() {
		eyes.abortAsync();
	}
	
	public void abort() {
		eyes.abortIfNotClosed();
	}
	
	public Eyes getEyes() {
		return eyes;
	}
	
	public void eyesAwaitTestResults() {
		this.runner.getAllTestResults();
	}
}
