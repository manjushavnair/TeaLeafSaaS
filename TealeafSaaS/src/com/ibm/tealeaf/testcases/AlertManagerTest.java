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
import com.ibm.tealeaf.pageobjects.AlertManagerPage;
import com.ibm.tealeaf.utils.ExcelUtil;

public class AlertManagerTest extends SaaSloginTest {

	private static Logger logger = Logger.getLogger(AlertManagerTest.class);

	public AlertManagerTest() {

		super();
		System.out.println("AlertManagerTest called");

	}

	/*
	 * Test Case 1 1.Log into tealeaf SaaS 2.Navigate to Session Search view 3.
	 * Click on Search button for the default session end time 4. Select one of
	 * the BBR session to replay. 5. Ensure session availability in default
	 * session search view 6. Naviagate back to Session Search page
	 */
	@Test(priority = 2)
	public void clickAlertManager() {

		try {

			logger.info("Entering into clickAlertManager ");
			AlertManagerPage alertmanager_page = PageFactory.initElements(
					driver, AlertManagerPage.class);
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME30000MILLISEC);

			alertmanager_page.invokeAlertManager();

			logger.info("Exiting from clickAlertManager");

		} catch (Exception e) {
			Assert.fail("Unable to click the  AlertManager Links");
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void searchAlert() {

		String searchString = null;
		try {
			ExcelUtil eu = new ExcelUtil();
			eu.setExcelFile(TeaLeafCONSTANTS.LOGINXLSDATAPATH, "AlertManager");
			searchString = eu.getCellData(1, 0);
			
			logger.info("searchString "+searchString);
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME30000MILLISEC);
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
