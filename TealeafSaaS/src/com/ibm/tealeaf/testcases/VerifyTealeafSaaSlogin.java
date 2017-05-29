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
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.pageobjects.SaaSBasePage;
import com.ibm.tealeaf.utils.ExcelUtil;

public class VerifyTealeafSaaSlogin extends SaaSBasePage {

	private static Logger logger = Logger
			.getLogger(VerifyTealeafSaaSlogin.class);

	public VerifyTealeafSaaSlogin() {

		super();

	}

	@Test(priority = 1)
	public void verifyValidLogin() {

		// Created page object using Page Factory
		LoginPage login_page = PageFactory
				.initElements(driver, LoginPage.class);
		
		
 	    // Call the method
		String userName = "";
		String password = "";
		try {

			ExcelUtil eu = new ExcelUtil();

			eu.setExcelFile(TeaLeafCONSTANTS.LOGINXLSDATAPATH,
					TeaLeafCONSTANTS.LOGINXLSDATASHEETNAME);
			userName = eu.getCellData(1, 1);
			password = eu.getCellData(1, 2);
			logger.info("username" + userName + "password " + password);
		} catch (Exception e) {
			Assert.fail("Unable to login");

			e.printStackTrace();
		}
		login_page.login_tealeafSaaS(userName, password);
	}

}
