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

import com.ibm.tealeaf.commons.BrowserFactory;
import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

/**
 * @author Manjusha Saju
 *
 */
public class SessionSearchPage {
	
	private static Logger  logger = Logger.getLogger(BrowserFactory.class);
	
	private WebDriver driver;
 
	
	
	public SessionSearchPage()
    {
   logger.info("default constructor called");
    
    }
    public SessionSearchPage(WebDriver driver)
    {
    this.driver=driver;
    
    }
    @FindBy(xpath="//span[contains(@title,'Session search')]")WebElement sess_search;
    
    public void SessSearch()
    {
    	WebDriverWait wait = new WebDriverWait(driver,200);
	    logger.info("Session Search Page View step 1");
	    wait.until(ExpectedConditions.textToBePresentInElement(sess_search, "Session search"));
	    logger.info("Session Search Page View step 2");
	    sess_search.click();
    	
    }
  
           
    /**
	 * Navigating back to home page
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = ("//a[contains(@href,'/home')and contains(.,'IBM Tealeaf Customer Experience')]"))
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
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
	}

    
}
