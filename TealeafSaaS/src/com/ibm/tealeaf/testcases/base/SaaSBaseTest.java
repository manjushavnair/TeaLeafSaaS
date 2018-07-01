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
import org.testng.annotations.*;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
 

public class SaaSBaseTest extends BaseTest {

	private static Logger logger = Logger.getLogger(SaaSBaseTest.class);

	public SaaSBaseTest() {
	 	logger.info("readProperty ");
		prpr = PropertyReader.readProperty();


	}

	public   WebDriver setDriver(String browserType, String appURL) {
	 	logger.info("browserType"+browserType + " : appURL "+appURL);
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
