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
		WebDriverWait wait = new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.textToBePresentInElement(sess_search,
				"Session search"));
		sess_search.click();
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME120SEC);
		logger.info("In Session Search Page View");
	}

	// 2. Display default Session search view( for last 24 hrs )
	@FindBy(xpath = "//button[@ng-click='search()' and contains(text(),'Search')]")
	WebElement default_search;

	public void clickonSearchButton() throws InterruptedException {
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME120SEC,
						TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(default_search).click().perform();
		
		logger.info("Displayed search result view ");

		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);

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
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME100SEC);
	}

	// Select drop down option for Session End Time by clicking on 24hrs.Option-default search
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[1]//div[contains(@class, 'input-mask ng-scope')]")
	WebElement last_24hrs;

	public void clickonDefaultOption_Last24hrs() throws InterruptedException {
		driver.manage()
		.timeouts()
		.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
				TimeUnit.SECONDS);
		
		last_24hrs.click();
		logger.info("In default select option of 'Last 24 hrs'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last 5 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[1]//a//span[contains (text(),'Last 5 minutes')]")
	WebElement last_5min;

	public void clickonOption_Last5min() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.textToBePresentInElement(last_5min,
				"Last 5 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_5min).build().perform();
		last_5min.click();
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		
	}
	
}
		
		


