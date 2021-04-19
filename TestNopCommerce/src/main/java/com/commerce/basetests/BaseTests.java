package com.commerce.basetests;


import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.applitools.eyes.config.Configuration;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.visualgrid.model.ChromeEmulationInfo;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.IosDeviceInfo;
import com.applitools.eyes.visualgrid.model.IosDeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import java.net.MalformedURLException;

public class BaseTests {

	private WebDriver driver;
	private static String PAGE_URL = "";
	public static int DRIVER_WAIT_SECONDS;
	public static String strBrowser;
	public static Boolean useVisualGrid=true;
	private static EyesManager eyesManager;
	private static String eyesAPIKey;
	private Configuration suiteConfig;
	private final int viewPortWidth = 1028;
	private final int viewPortHeight = 607;
	
	//used for selenium grid
	//String nodeURL="http://192.168.0.105:4444/wd/hub";
	
	//Set browser properties based on chosen driver
	public WebDriver BrowserEnvironment() throws MalformedURLException {
		readPropertyFile();
		
		if (strBrowser.toLowerCase().equals("firefox"))
		{
			//This config is used for regular selenium run
			System.setProperty("webdriver.gecko.driver","D:\\Workspace\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_SECONDS, TimeUnit.SECONDS);
			driver.get(PAGE_URL);
			
//			//This config is used for running on selenium grid
//			DesiredCapabilities capability = DesiredCapabilities.firefox();
//			FirefoxOptions options = new FirefoxOptions();
//			options.addArguments("disable-infobars");
//			capability.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
//			driver=new RemoteWebDriver(new URL(nodeURL),capability);
//			driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_SECONDS, TimeUnit.SECONDS);
//			driver.get(PAGE_URL);
			
		}
		else if (strBrowser.toLowerCase().equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Workspace\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_SECONDS, TimeUnit.SECONDS);
			driver.get(PAGE_URL);
		}
		else if (strBrowser.toLowerCase().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(DRIVER_WAIT_SECONDS, TimeUnit.SECONDS);
			driver.get(PAGE_URL);
		} 
		else 
		{
			System.out.println("[INFO] YOUR BROWSER IS CURRENTLY NOT SUPPORTED!");
		}
		return driver;
	}
	
	public void readPropertyFile() {
		Properties props = new Properties();
		try {
			FileInputStream objfile=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/application.properties");
			props.load(objfile);
			strBrowser = props.getProperty("strBrowser");
			DRIVER_WAIT_SECONDS= Integer.parseInt(props.getProperty("DRIVER_WAIT_SECONDS"));
			PAGE_URL=props.getProperty("PAGE_URL");
			eyesAPIKey=props.getProperty("applitools.api.key");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public EyesManager eyesManager() {
		if(useVisualGrid) {
			//This config is used for Ultrafast Grid
			int concurentSessions=5;
			VisualGridRunner runner = new VisualGridRunner(concurentSessions);
			suiteConfig = (Configuration) new Configuration()
			        // Visual Grid configurations
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME_ONE_VERSION_BACK))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME_TWO_VERSIONS_BACK))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.FIREFOX))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.SAFARI))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.IE_10))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.IE_11))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.EDGE_CHROMIUM))
			        .addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.EDGE_LEGACY))
			        .addBrowser(new IosDeviceInfo(IosDeviceName.iPhone_X, ScreenOrientation.LANDSCAPE))
			        .addBrowser(new ChromeEmulationInfo(DeviceName.Galaxy_S5, ScreenOrientation.PORTRAIT));
			eyesManager=new EyesManager(driver, "nopCommerce",eyesAPIKey,runner,suiteConfig);
		}
		else {
			//This config is used for regular Eyes run
			ClassicRunner runner = new ClassicRunner();
			eyesManager=new EyesManager(driver, "nopCommerce",eyesAPIKey,runner);
		}		
		
		return eyesManager;
	}
}
