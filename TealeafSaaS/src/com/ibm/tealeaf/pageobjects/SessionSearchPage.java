/**
 * 
 */
package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.exception.BusinessException;

/**
 * @author Manjusha Saju
 * 
 */
public class SessionSearchPage {

	private static Logger logger = Logger.getLogger(SessionSearchPage.class);

	private WebDriver driver;

	public SessionSearchPage() {
		logger.info("default constructor called");

	}

	public SessionSearchPage(WebDriver driver) {
		this.driver = driver;

	}

	// 1.Navigate to session search page view from home
	@FindBy(xpath = "//span[contains(@title,'Session search')]")
	WebElement sess_search;

	public void sessSearch() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.textToBePresentInElement(sess_search,
				"Session search"));
		sess_search.click();
		logger.info("In Session Search Page View");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME30SEC);
	}

	// 2. Display default Session search view( for last 24 hrs )
	@FindBy(xpath = "//button[@ng-click='search()'and text()='Search']")
	WebElement default_search;

	public void selectDefaultView() throws InterruptedException {
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);
		default_search.click();

		logger.info("Displayed search result view for last 24 hrs ");

		Thread.sleep(TeaLeafCONSTANTS.WAITTIME300SEC);

	}

	// 3. Select a BBR session for replay

	@FindBy(xpath = "//*[@id='sessions_list']/tbody/tr[3]/td[2]")
	WebElement firstsession;

	public void selectBBRsession() {
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME160SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		// 3.a Move cursor to the Main Menu Element
		builder.moveToElement(firstsession).perform();
		// 3.b Giving 5 Secs for submenu to be displayed
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3.c Clicking on the Hidden SubMenu
		firstsession.click();

		logger.info("BBR session is selected");

	}

	/**
	 * 4. Navigating back to home page from BBR replay view
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = "//a[contains(@href,'/home')and contains(.,'IBM Tealeaf Customer Experience')]")
	WebElement homepage;

	public void backToHome() throws InterruptedException {
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		builder.moveToElement(homepage).click(homepage);
		builder.perform();
		logger.info("Successfully navigated back to Home Page ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
	}

	/**
	 * Navigating back to Session Search page
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = "//a[contains(@href,'/sessionsearch?result=false')and contains(.,'Session search')]")
	WebElement searchpage;

	public void backToSearch() throws InterruptedException {
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		builder.moveToElement(searchpage).click(searchpage);
		builder.perform();
		logger.info("Successfully navigated back to Session search Page ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
	}

	// To get the drop down option for Session End Time and click on Last 5 min

	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[1]//div[contains(@class, 'input-mask ng-scope')]")
	WebElement last_24hrs;

	public void sessEndTime_last24hrs() throws BusinessException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.titleContains("Last 24 hours"));

		try {
			last_24hrs.click();

		} catch (WebDriverException e) {

			Assert.fail("Element is not clickable at point");
			throw new BusinessException("2001", e.getMessage());
		}
		logger.info("clicked on default selection");
	}

}
