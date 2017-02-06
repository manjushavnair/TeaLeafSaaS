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

public class SessionSearch extends SaaSBasePage {

	 
	private static Logger logger = Logger
			.getLogger(SessionSearch.class);

	 

	public SessionSearch() {

		super();

	}

	 
	@Test(priority = 1)
	public void sessionSearch() {

		try {

			SessionSearchPage sessionsearch_page = PageFactory.initElements(
					driver, SessionSearchPage.class);
			sessionsearch_page.sessSearch();
			// sessionsearch_page.clickonSearchButton();
			// sessionsearch_page.selectBBRsession();
			// sessionsearch_page.backToSearch();
			sessionsearch_page.clickonDefaultOption_Last24hrs();
			sessionsearch_page.clickonOption_Last5min();
			sessionsearch_page.clickonSearchButton();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	 

}
