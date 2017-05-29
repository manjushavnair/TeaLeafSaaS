/**
 *  
 */
package com.ibm.tealeaf.testcases;

/**
 * @author Manjusha Saju
 *
 */
//http://www.webtoolkitonline.com/xml-xpath-tester.html

//	http://xmltoolbox.appspot.com/xpath_generator.html




import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.StruggleAnalyticsPage;

public class StruggleAnalyticsTest extends SaaSlogin {

	private static Logger logger = Logger.getLogger(StruggleAnalyticsTest.class);

	public StruggleAnalyticsTest() {

		 super();

	}

	@Test(priority = 2)
	public void struggleAnalytics() {
		try {

			StruggleAnalyticsPage stru_page = PageFactory.initElements(driver,
					StruggleAnalyticsPage.class);
			
			try {
				Thread.sleep(TeaLeafCONSTANTS.WAITTIME30SEC);
			} catch (Exception e) {
				 
				e.printStackTrace();
			}
			
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
