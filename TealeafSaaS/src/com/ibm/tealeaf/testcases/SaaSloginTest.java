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
import org.testng.Assert;
import org.testng.annotations.*;


import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
//import com.ibm.tealeaf.listener.LoginListener;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.testcases.base.SaaSBaseTest;
import com.ibm.tealeaf.utils.ExcelUtil;

//@Listeners(com.ibm.tealeaf.listener.LoginListener.class)

public class SaaSloginTest extends SaaSBaseTest {

	private static Logger logger = Logger
			.getLogger(SaaSloginTest.class);

	public SaaSloginTest() {

		 setDriver(prpr.getProperty(TeaLeafCONSTANTS.BROWSER_TYPE),
				prpr.getProperty(TeaLeafCONSTANTS.APPLICATION_URL));


	}

	@Test(priority = 1)
	public void verifyValidLogin() {

		logger.info("Entering verifyValidLogin");

		logger.info("Starting Browser");
 
		// Created page object using Page Factory
		LoginPage login_page = PageFactory
				.initElements(driver, LoginPage.class);
		
		
 	    // Call the method
		String userName = "";
		String password = "";
		try {

			ExcelUtil eu = new ExcelUtil();

			eu.setExcelFile(TeaLeafCONSTANTS.LOGINXLSDATAPATH,
					TeaLeafCONSTANTS.LOGINXLSDATASHEETNAMELOGIN);
			userName = eu.getCellData(1, 1);
			password = eu.getCellData(1, 2);
	 	} catch (Exception e) {
			Assert.fail("Unable to login");

			e.printStackTrace();
		}
	 	logger.info("Exiting verifyValidLogin");
		login_page.login_tealeafSaaS(userName, password);
	}
	 

}
