/**
 * 
 */
package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

/**
 * @author tealeaf
 *
 */
public class SessionSearchPage {
	
	private WebDriver driver;
 
	
	
	public SessionSearchPage()
    {
   System.out.println("default constructor called");
    
    }
    public SessionSearchPage(WebDriver driver)
    {
    this.driver=driver;
    
    }
    @FindBy(xpath="//span[contains(@title,'Session search')]")WebElement sess_search;
    
    public void SessSearch()
    {
    	WebDriverWait wait = new WebDriverWait(driver,200);
	    System.out.println("Session Search Page View step 1");
	    wait.until(ExpectedConditions.textToBePresentInElement(sess_search, "Session search"));
	    System.out.println("Session Search Page View step 2");
	    sess_search.click();
    	
    }
  
    
    //a[contains(@href,'/home')and contains(.,'IBM Tealeaf Customer Experience')]
    
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
		System.out
				.println("Successfully navigated back to Home Page ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
	}

    
}
