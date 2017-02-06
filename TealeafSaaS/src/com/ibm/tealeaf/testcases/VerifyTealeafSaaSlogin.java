/**
 *  
 */
package com.ibm.tealeaf.testcases;

/**
 * @author Manjusha Saju
 *
 */

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.SaaSBasePage;
import com.ibm.tealeaf.pageobjects.LoginPage;

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
