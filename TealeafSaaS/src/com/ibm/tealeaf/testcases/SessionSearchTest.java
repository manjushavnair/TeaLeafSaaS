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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.PropertyReader;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.LoginPage;
import com.ibm.tealeaf.pageobjects.SaaSBasePage;
import com.ibm.tealeaf.pageobjects.SessionSearchPage;

public class SessionSearchTest extends SaaSlogin {

	private static Logger logger = Logger.getLogger(SessionSearchTest.class);

	public SessionSearchTest() {

		 super();
		 System.out.println("SessionSearchTest called");

	}
	/*Test Case 1
	 * 1.Log into tealeaf SaaS
	 * 2.Navigate to Session Search view
	 * 3. Click on Search button for the default session end time
	 * 4. Select one of the BBR session to replay.
	 * 5. Ensure session availability in default session search view
	 * 6. Naviagate back to Session Search page
	 */
	@Test(priority = 2)
	public void sessionSearchLast24hrs() {

		try {
			 System.out.println("sessionSearchLast24hrs called");
			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			 System.out.println("sessionSearchLast24hrs 1");
			sessionsearch_page.sessSearch();
			 System.out.println("sessionSearchLast24hrs 2");
			sessionsearch_page.clickonSearchButton();
			sessionsearch_page.selectBBRsession();
			sessionsearch_page.backToSearch();

		} catch (Exception e) {
			Assert.fail("Unable to execute default search with BBR session replay");
			e.printStackTrace();

		}

	}
}	
	
	
	
	


