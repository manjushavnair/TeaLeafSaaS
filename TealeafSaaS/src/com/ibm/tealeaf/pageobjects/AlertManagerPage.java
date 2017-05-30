package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.basepage.BasePage;

public class AlertManagerPage extends BasePage {

	private static Logger logger = Logger.getLogger(AlertManagerPage.class);

	public AlertManagerPage() {

	}

	public AlertManagerPage(WebDriver driver) {
		super(driver);
	}

	// 1.Navigate toinvokeAlertManager page from home
 
	@FindBy(xpath = "//span[contains(@class,'name alerts alerts-click firepath-matching-node')]")
	WebElement alertmanager;

	public void invokeAlertManager() {
		logger.info("Entering into invokeAlertManager Page");
		WebDriverWait wait = new WebDriverWait(driver,
				TeaLeafCONSTANTS.WAITTIME60SEC);
		wait.until(ExpectedConditions.textToBePresentInElement(alertmanager,
				"Alert Manager"));
		logger.info("Entering into invokeAlertManager page");
		alertmanager.click();

		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		} catch (Exception e) {
			Assert.fail("Unable to navigate to invokeAlertManager page");
			e.printStackTrace();
		}
		logger.info("In invokeAlertManager Page View");
	}

	/**
	 * 1. Search for the pre created alerts
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = "//a[contains(@href,'/home')and contains(.,'IBM Tealeaf Customer Experience')]")
	// @FindBy(xpath = "//a[@class='active']")
	WebElement homepage;

	public void searchAlert() throws InterruptedException {
		logger.info("Navigating back to searchAlert ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME15SEC,
						TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
		builder.moveToElement(homepage).click(homepage);
		builder.perform();
		logger.info("Successfully navigated back to searchAlert ");
		try {
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10SEC);
		} catch (Exception e) {
			Assert.fail("Unable to return back to home page");
			e.printStackTrace();
		}
	}

}