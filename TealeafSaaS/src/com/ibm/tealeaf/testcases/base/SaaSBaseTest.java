/**
 *  
 */
package com.ibm.tealeaf.testcases.base;

/**
 * @author Manjusha Saju
 *
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

public class SaaSBaseTest extends BaseTest {

	protected static WebDriver driver;
	private static Logger logger = Logger.getLogger(SaaSBaseTest.class);

	protected static PropertyReader prpr;
	private WebDriverWait wait;

	public SaaSBaseTest() {

		prpr = PropertyReader.readProperty();
		
		setDriver(prpr.getProperty(TeaLeafCONSTANTS.BROWSER_TYPE),
				prpr.getProperty(TeaLeafCONSTANTS.APPLICATION_URL));

	}

	public WebDriver setDriver(String browserType, String appURL) {
		if (driver == null)
			driver = BrowserFactory.startBrowser(browserType, appURL);
		return driver;
	}

	/*
	@AfterSuite
	public void testDown() {
		BrowserFactory.stopDriver();

	}
	
	
	@Parameters({ "browserType", "appURL" })
	@BeforeSuite
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(prpr.getProperty(TeaLeafCONSTANTS.BROWSER_TYPE),
				prpr.getProperty(TeaLeafCONSTANTS.APPLICATION_URL));
		} catch (Exception e) {
			logger.info("Cannot Identoify the WebDriver");
			e.printStackTrace();
		}
	}
	*/

}
