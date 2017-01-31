/**
 * 
 */
package com.ibm.tealeaf.commons;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author manjusha saju
 * 
 */
public class BrowserFactory {

	private static WebDriver driver;
	private static PropertyReader prpr;
	
	private static Logger  logger = Logger.getLogger(BrowserFactory.class);
	

	public static WebDriver startBrowser(String browserName, String url) {
		BasicConfigurator.configure();
		 
		logger.info("starting Browser");
		logger.debug("starting Browser 2");
		logger.error("starting Browser 3");
		prpr = PropertyReader.readProperty();

		/*
		 * Preconditions.checkNotNull(browserName,
		 * "Target browser parameter is null"); if (BrowserFactory.driver !=
		 * null) { throw new
		 * AssertionError("WebDriver instance  re-initialized"); }
		 */

		if (browserName.equalsIgnoreCase(TeaLeafCONSTANTS.FIREFOX))

		{

			if (driver == null)
				driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase(TeaLeafCONSTANTS.CHROME)) {
			System.setProperty("webdriver.chrome.driver",
					prpr.getProperty("CHROME_DRIVER_SERVER_PATH"));
			if (driver == null)

				driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase(TeaLeafCONSTANTS.IE)) {
			System.setProperty("webdriver.ie.driver",
					prpr.getProperty("IE_DRIVER_SERVER_PATH"));
			if (driver == null)

				driver = new InternetExplorerDriver();
		}

		// driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);

		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TeaLeafCONSTANTS.WAITTIME30SEC, TimeUnit.SECONDS);
		driver.get(url);
		return driver;

	}
	public static WebDriver getDriver() {
        return driver;
    }

	public static void stopDriver() {
		if (driver !=  null) {
			driver.quit();
		}
	}
}
