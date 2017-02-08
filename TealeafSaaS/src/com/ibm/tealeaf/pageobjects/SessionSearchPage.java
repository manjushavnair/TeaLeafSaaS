/**
 * 
 */
package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

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
		WebDriverWait wait = new WebDriverWait(driver,400);
		wait.until(ExpectedConditions.textToBePresentInElement(sess_search,
				"Session search"));
		sess_search.click();
		logger.info("In Session Search Page View");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// 2. Display default Session search view( for last 24 hrs )
	@FindBy(xpath = "//button[@ng-click='search()' and contains(text(),'Search')]")
	WebElement default_search;

	public void clickonSearchButton() throws InterruptedException {
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME120SEC);
		actions.moveToElement(default_search).click().perform();
		
		
		logger.info("Displayed search result view ");

		Thread.sleep(TeaLeafCONSTANTS.WAITTIME80SEC);

	}

	// 3. Select a BBR session for replay

	@FindBy(xpath = "//*[@id='sessions_list']/tbody/tr[3]/td[2]")
	WebElement firstsession;

	public void selectBBRsession() throws InterruptedException {
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME160SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		// 3.a Move cursor to the Main Menu Element
		builder.moveToElement(firstsession).perform();
		// 3.b Giving 5 Secs for submenu to be displayed
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME30SEC);
		// 3.c Clicking on the Hidden SubMenu
			firstsession.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		logger.info("BBR session is selected");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME30SEC);

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
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME30SEC);
	}

	// Select drop down option for Session End Time by clicking on 24hrs.Option-default search
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[1]//div[3][contains(@class, 'icon-container')]")
	WebElement last_24hrs;

	public void clickonDefaultOption_Last24hrs() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOf(last_24hrs));
				
		last_24hrs.click();
		logger.info("In default select option of 'Last 24 hrs'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME80SEC);
	}

	// Click on drop down option-Last 5 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[1]//a[@title='Last 5 minutes']")
	WebElement last_5min;

	public void clickonOption_Last5min() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_5min,
				"Last 5 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_5min).build().perform();
		last_5min.click();
		logger.info("Selected session end time 'Last 5 minutes'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		
	}
	
	// Click on drop down option-Last 15 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[2]//a[@title='Last 15 minutes']")
	WebElement last_15min;

	public void clickonOption_Last15min() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_15min,
				"Last 15 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_15min).build().perform();
		last_15min.click();
		logger.info("Selected session end time 'Last 15 minutes'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}
	
	
	// Click on drop down option-Last 30 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[3]//a[@title='Last 30 minutes']")
	WebElement last_30min;

	public void clickonOption_Last30min() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_30min,
				"Last 30 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_30min).build().perform();
		last_30min.click();
		logger.info("Selected session end time 'Last 30 minutes'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	
	// Click on drop down option-Last hour
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[4]//a[@title='Last hour']")
	WebElement last_hour;

	public void clickonOption_Lasthour() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_hour,
				"Last hour"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_hour).build().perform();
		last_hour.click();
		logger.info("Selected session end time 'Last hour'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	// Click on drop down option-Last 12 hours
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[5]//a[@title='Last 12 hours']")
	WebElement last_12hours;

	public void clickonOption_Last12hours() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_12hours,
				"Last 12 hours"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_12hours).build().perform();
		last_12hours.click();
		logger.info("Selected session end time 'Last 12 hours'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	// Click on drop down option-Last 7 days
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[7]//a[@title='Last 7 days']")
	WebElement last_7days;

	public void clickonOption_Last7days() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_7days,
				"Last 7 days"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_7days).build().perform();
		last_7days.click();
		logger.info("Selected session end time 'Last 7 days'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	// Click on drop down option-Last 14 days
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[8]//a[@title='Last 14 days']")
	WebElement last_14days;

	public void clickonOption_Last14days() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_14days,
				"Last 14 days"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_14days).build().perform();
		last_14days.click();
		logger.info("Selected session end time 'Last 14 days'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	// Click on drop down option-custom date range
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[9]//a[@title='Custom date range']")
	WebElement customdaterange;

	public void clickonOption_Customdaterange() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(customdaterange,
				"Custom date range"));
		Actions builder = new Actions(driver);
		builder.moveToElement(customdaterange).build().perform();
		customdaterange.click();
		logger.info("Selected session end time 'Custom Date Range'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		}
	
	
}
		