/**
 * 
 */
package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
 	//@FindBy(xpath = "//span[contains(@title,'Session search')]")
	@FindBy(xpath = "//span[@class='name sessionsearch sessionsearch-click']")

	WebElement sess_search;

	public void sessSearch() {
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.textToBePresentInElement(sess_search,"Session search"));
		logger.info("Entering Session Search Page View");
		sess_search.click();
		
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME1000MILLISEC);
		} catch (Exception e) {
			Assert.fail("Unable to navigate to Session Search page");
			e.printStackTrace();
		}
		logger.info("Exiting Session Search Page View");
	}

	// 2. Display default Session search view( for last 24 hrs )
	//@FindBy(xpath = "//button[text()='Search']")
	@FindBy(xpath = "//button[@class='btn btn-primary ng-binding']") 
	WebElement defaultsearch;

	public void clickonSearchButton() {
		
		logger.info("Entering search result view ");
		// driver.manage().timeouts().implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,TimeUnit.SECONDS);
		try {
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(defaultsearch,
				"Search"));
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", defaultsearch);

		logger.info("Displayed search result view ");

		
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
		} catch (Exception e) {
			Assert.fail("Unable to display session search list");
			e.printStackTrace();
		}

	}

	// 3. Select a BBR session for replay

	@FindBy(xpath = "//*[@id='sessions_list']/tbody/tr[3]/td[2]")
	WebElement firstsession;

	public void selectBBRsession() throws InterruptedException {
		logger.info("entering BBR session ");
		try {	
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME160SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		// 3.a Move cursor to the Main Menu Element
		builder.moveToElement(firstsession).perform();
		// 3.b Giving 5 Secs for submenu to be displayed
		
			//Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
			// 3.c Clicking on the Hidden SubMenu
			firstsession.click();

		} catch (Exception e) {
			Assert.fail("Unable to click on replay icon");
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
		logger.info("Entering navigated back to Home Page ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		builder.moveToElement(homepage).click(homepage);
		builder.perform();
		logger.info("Successfully navigated back to Home Page ");
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
		} catch (Exception e) {
			Assert.fail("Unable to return back to home page");
			e.printStackTrace();
		}
	}

	/**
	 * Navigating back to Session Search page
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = "//a[contains(@href,'/sessionsearch?result=false')and contains(.,'Session search')]")
	WebElement searchpage;

	public void backToSearch()  {
		logger.info("Entering into navigated back to Session search Page ");
		try {
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
		} catch (Exception e) {
			Assert.fail("Unable to return back to Session Search pageview");
			e.printStackTrace();
		}
	}

	// Select drop down option for Session End Time by clicking on
	// 24hrs.Option-default search
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[1]//div[3][contains(@class, 'icon-container')]")
	WebElement last_24hrs;

	public void clickonDefaultOption_Last24hrs()  {
		logger.info("In default select option of 'Last 24 hrs'");
		try {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOf(last_24hrs));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", last_24hrs);
		// last_24hrs.click();
		logger.info("In default End option of 'Last 24 hrs'");
		
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		} catch (Exception e) {
			Assert.fail("Unable to click the drop down menu for Session End Time");
			e.printStackTrace();
		}
	}

	// Click on drop down option-Last 5 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[1]//a[@title='Last 5 minutes']")
	WebElement last_5min;

	public void clickonOption_Last5min()  {
		logger.info("Selected session end time 'Last 5 minutes'");
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(last_5min,
				"Last 5 minutes"));
		try {
		Actions builder = new Actions(driver);
		builder.moveToElement(last_5min).build().perform();
		last_5min.click();
		logger.info("End session end time 'Last 5 minutes'");
	
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
		} catch (InterruptedException e) {
			Assert.fail("Unable to click the drop down menu option- Last 5 min for Session End Time");
			e.printStackTrace();
		}

	}

	// Click on drop down option-Last 15 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[2]//a[@title='Last 15 minutes']")
	WebElement last_15min;

	public void clickonOption_Last15min() throws InterruptedException {
		logger.info("Selected session end time 'Last 15 minutes'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_15min,
				"Last 15 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_15min).build().perform();
		last_15min.click();
		logger.info("End session end time 'Last 15 minutes'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last 30 min
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[3]//a[@title='Last 30 minutes']")
	WebElement last_30min;

	public void clickonOption_Last30min() throws InterruptedException {
		logger.info("Selected session end time 'Last 30 minutes'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_30min,
				"Last 30 minutes"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_30min).build().perform();
		last_30min.click();
		logger.info("End session end time 'Last 30 minutes'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last hour
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[4]//a[@title='Last hour']")
	WebElement last_hour;

	public void clickonOption_Lasthour() throws InterruptedException {
		logger.info("Selected session end time 'Last hour'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_hour,
				"Last hour"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_hour).build().perform();
		last_hour.click();
		logger.info("End session end time 'Last hour'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last 12 hours
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[5]//a[@title='Last 12 hours']")
	WebElement last_12hours;

	public void clickonOption_Last12hours() throws InterruptedException {
		logger.info("Selected session end time 'Last 12 hours'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_12hours,
				"Last 12 hours"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_12hours).build().perform();
		last_12hours.click();
		logger.info("End session end time 'Last 12 hours'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last 7 days
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[7]//a[@title='Last 7 days']")
	WebElement last_7days;

	public void clickonOption_Last7days() throws InterruptedException {
		logger.info("Selected session end time 'Last 7 days'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_7days,
				"Last 7 days"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_7days).build().perform();
		last_7days.click();
		logger.info("End session end time 'Last 7 days'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-Last 14 days
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[8]//a[@title='Last 14 days']")
	WebElement last_14days;

	public void clickonOption_Last14days() throws InterruptedException {
		logger.info("Selected session end time 'Last 14 days'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(last_14days,
				"Last 14 days"));
		Actions builder = new Actions(driver);
		builder.moveToElement(last_14days).build().perform();
		last_14days.click();
		logger.info("End session end time 'Last 14 days'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

	// Click on drop down option-custom date range
	@FindBy(xpath = "//div[contains(@class,'sess-endtime')]//filtering-select//div//div[2]//ul//li[9]//a[@title='Custom date range']")
	WebElement customdaterange;

	public void clickonOption_Customdaterange() throws InterruptedException {
		logger.info("Selected session end time 'Custom Date Range'");
		WebDriverWait wait = new WebDriverWait(driver, TeaLeafCONSTANTS.WAITTIME30SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(customdaterange,
				"Custom date range"));
		Actions builder = new Actions(driver);
		builder.moveToElement(customdaterange).build().perform();
		customdaterange.click();
		logger.info("End session end time 'Custom Date Range'");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME60SEC);
	}

}
