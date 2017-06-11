package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.base.BasePage;

public class AlertManagerPage extends BasePage {

	private static Logger logger = Logger.getLogger(AlertManagerPage.class);

	public AlertManagerPage() {

	}

	public AlertManagerPage(WebDriver driver) {
		super(driver);
	}

	// 1.Navigate toinvokeAlertManager page from home
 
	//@FindBy(xpath = "//span[contains(@class,'name alerts alerts-click firepath-matching-node')]")
	@FindBy(xpath = "//span[@title='Alert Manager']")
	
	WebElement alertmanager;

	public void invokeAlertManager() {
		logger.info("Entering into invokeAlertManager");
		WebDriverWait wait = new WebDriverWait(driver,
				TeaLeafCONSTANTS.WAITTIME20SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(alertmanager,
				"Alert Manager"));
		
		logger.info("Going to Click invokeAlertManager page");
		
		alertmanager.click();

		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME1000MILLISEC);
		} catch (Exception e) {
			Assert.fail("Unable to navigate to invokeAlertManager page");
			e.printStackTrace();
		}
		logger.info("In invokeAlertManager Page View");
	}

	/**
	 * 1. Search for the precreated alerts
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(css = "input[class^='global-search-input']")
	//@FindBy(xpath = "//input[@class='global-search-input form-control ng-valid ng-dirty ng-pristine ng-touched']")
 	WebElement searchAlert;

	public void searchAlert(String searchString) throws InterruptedException {
		logger.info("Navigating  to searchAlert ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME15SEC,
						TimeUnit.SECONDS);
		
		driver.
		findElement(By.cssSelector("input[class^='global-search-input']"))
		.sendKeys(searchString);
		
		logger.info("Going to searchAlert ");
 
		logger.info("Successfully searched searchAlert ");
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		} catch (Exception e) {
			Assert.fail("Unable to return back to searchAlert ");
			e.printStackTrace();
		}
	}

}