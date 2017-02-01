/**
 * 
 */
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
    
    public void sessSearch()
    {
    	WebDriverWait wait = new WebDriverWait(driver,200);
	    wait.until(ExpectedConditions.textToBePresentInElement(sess_search, "Session search"));
	    sess_search.click();
	    logger.info("Session Search Page View");
    }
    
   @FindBy(xpath="//button[@ng-click='search()'and text()='Search']")WebElement last_24;
         
   //Session search for last 24 hrs 
     public void sessEndTime_last24hrs() throws InterruptedException 
     {
    	 driver.manage().timeouts().implicitlyWait(TeaLeafCONSTANTS.WAITTIME30SEC, TimeUnit.SECONDS);
    	 last_24.click();
    	    	 
    	 logger.info("Search result view for last 24 hrs");
    	 
    	 Thread.sleep(TeaLeafCONSTANTS.WAITTIME300SEC);
    	 
     }
     
     @FindBy(xpath="//*[@id='sessions_list']/tbody/tr[3]/td[2]")WebElement firstsession;
     public void selectBBRsession(){
      driver.manage().timeouts().implicitlyWait(TeaLeafCONSTANTS.WAITTIME160SEC, TimeUnit.SECONDS); 
      Actions builder = new Actions(driver);
   // Move cursor to the Main Menu Element
   builder.moveToElement(firstsession).perform();
   // Giving 5 Secs for submenu to be displayed
   try {
	Thread.sleep(5000L);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
   // Clicking on the Hidden SubMenu
   firstsession.click();

   	  
   	  logger.info("BBR session is selected");
   	  
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
