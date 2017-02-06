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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.SaaSBasePage;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.pageobjects.SessionSearchPage;

public class VerifyTealeafSaaSlogin extends SaaSBasePage {

	 
	private static Logger logger = Logger
			.getLogger(VerifyTealeafSaaSlogin.class);

	 

	public VerifyTealeafSaaSlogin( ) {

		super( );

	}

	@Test(priority = 1)
	public void verifyValidLogin() {

		// Created page object using Page Factory
		LoginPage login_page = PageFactory
				.initElements(driver, LoginPage.class);

		// Call the method

		login_page.login_tealeafSaaS(prpr.getProperty("LOGIN_USERNAME"),
				prpr.getProperty("LOGIN_PASSWORD"));
	}

	 

}
