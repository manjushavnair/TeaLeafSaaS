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
import com.ibm.tealeaf.pageobjects.StruggleAnalyticsPage;

public class StruggleAnalytics extends SaaSBasePage {

	private static Logger logger = Logger.getLogger(StruggleAnalytics.class);

	public StruggleAnalytics() {

		//super();

	}

	@Test(priority = 1)
	public void struggleAnalytics() {
		try {

			StruggleAnalyticsPage stru_page = PageFactory.initElements(driver,
					StruggleAnalyticsPage.class);
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

}
