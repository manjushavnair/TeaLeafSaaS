package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;
import com.ibm.tealeaf.pageobjects.base.BasePage;

public class HomePage extends BasePage {

	
	private static Logger logger = Logger.getLogger(HomePage.class);

	 
 
	public HomePage() {
		 
	}

	public HomePage(WebDriver driver) {
		super(driver);
	}
	/**
	 * 1. Navigating back to home page from BBR replay view
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = "//a[contains(@href,'/home')and contains(.,'IBM Tealeaf Customer Experience')]")
	//@FindBy(xpath = "//a[@class='active']") 
	WebElement homepage;

	public void backToHome() throws InterruptedException {
		logger.info("Navigating back to Home Page ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME15SEC,
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

}