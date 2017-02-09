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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.SaaSBasePage;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.pageobjects.SessionSearchPage;

public class SessionSearchTest extends SaaSBasePage {

	private static Logger logger = Logger.getLogger(SessionSearchTest.class);

	public SessionSearchTest() {

		// super();

	}
	/*Test Case 1
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3. Click on Search button for the default session end time
	 * 4. Select one of the BBR session to replay.
	 * 5. Ensure session availability in default session search view
	 * 6. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast24hrs() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToSearch();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	
	/*Test Case 2
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 5 minutes
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast5Min() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last5min();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	
	/*Test Case 3
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 15 minutes
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast15Min() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last15min();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}


	
	/*Test Case 4
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 30 minutes
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast30Min() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last30min();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	
	/*Test Case 5
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last hour
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLasthour() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Lasthour();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	/*Test Case 6
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 12 hours
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast12hours() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last12hours();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	

	/*Test Case 7
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 7 days
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast7days() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last7days();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	

	/*Test Case 8
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Last 14 days
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearchLast14days() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last14days();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	

	/*Test Case 9
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3.Click on the option for session end time-Custom date range
	 * 4. Click on Search button
	 * 5.Select one of the BBR session to replay.
	 * 6. Ensure session availability in this session search view
	 * 7. Naviagate back to Session Search page
	 */
	@Test
	public void sessionSearch_Customdaterange() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();

			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Customdaterange();
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToHome();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}
	
	
	
	
	
}
