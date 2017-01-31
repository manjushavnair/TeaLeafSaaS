/**
 *  
 */
package com.ibm.tealeaf.testcases;

/**
 * @author Manjusha Saju
 *
 */


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.pageobjects.SessionSearchPage;
import com.ibm.tealeaf.pageobjects.StruggleAnalyticsPage;

public class VerifyTealeafSaaSlogin {

	private static WebDriver driver;
	private static Logger  logger = Logger.getLogger(BrowserFactory.class);
	
	private static PropertyReader prpr;

	@BeforeClass
	public void initatebrowser() {

		prpr = PropertyReader.readProperty();
		
		driver = BrowserFactory.startBrowser(prpr.getProperty(TeaLeafCONSTANTS.BROWSER_TYPE),
				prpr.getProperty(TeaLeafCONSTANTS.APPLICATION_URL));
		
		 
	}

	@Test(priority = 1)
	public void verifyValidLogin() {
		 
		
		// Created page object using Page Factory
		LoginPage login_page = PageFactory
				.initElements(driver, LoginPage.class);

		// Call the method
		login_page.login_tealeafSaaS(prpr.getProperty("LOGIN_USERNAME"), prpr.getProperty("LOGIN_PASSWORD"));

	}

	@Test(priority = 2)
	public void sessionSearch() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();
			sessionsearch_page.sessEndTime_last24hrs();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority=3)
	public void struggleAnalytics() {
		try {

			
			StruggleAnalyticsPage stru_page = PageFactory.initElements(
					driver, StruggleAnalyticsPage.class);
			stru_page.strugAnalytics();
			stru_page.registration();
			stru_page.backToStruggleAnalytics();
			stru_page.shoppingCart();
		    stru_page.backToStruggleAnalytics();
			stru_page.checkOut();
			stru_page.backToStruggleAnalytics();
			stru_page.bannerLandingPage();
			stru_page.backToStruggleAnalytics();
			
			

		} catch (Exception e) {
			e.printStackTrace();

		}	

	}

	@AfterSuite
	public void testDown() {
		BrowserFactory.stopDriver();
	

	}

}
