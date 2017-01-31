/**
 * tessting 
 */
package com.ibm.tealeaf.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ibm.tealeaf.commons.TeaLeafCONSTANTS;

/**
 * @author ManjushaSaju
 * 
 */
public class StruggleAnalyticsPage {

	WebDriver driver;

	public StruggleAnalyticsPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//span[contains(@title,'Struggle analytics')]")
	WebElement struggleanalytics;

	public void strugAnalytics() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.textToBePresentInElement(
				struggleanalytics, "Struggle analytics"));

		System.out.println("Struggle Analytics PageView");
		
		struggleanalytics.click();
		System.out.println("Struggle Analytics PageView clicked");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		 
	}

	// Method to call StruggleAnalytics->Registration
	@FindBy(xpath = "//label[contains(.,'Registration')]")
	WebElement reglabel;

	public void registration() throws InterruptedException  {
		
		 
			Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		 
		try{
			reglabel.click();
		}catch(WebDriverException e)
		{
			Assert.fail("No such element");
		}
				
		System.out.println("In Registration struggle report");
	}

 
	 

	/**
	 * Method to call StruggleAnalytics->Shopping cart
	 * 
	 * @throws InterruptedException
	 */

	@FindBy(xpath = "//label[contains(.,'Shopping cart')]")
	WebElement shoppingcartlabel;

	public void shoppingCart() throws InterruptedException {

		 
		 
		System.out.println("In Shopping cart struggle report yet to click");
		
		driver.manage()
		.timeouts()
		.implicitlyWait(TeaLeafCONSTANTS.WAITTIME30SEC,
				TimeUnit.SECONDS);
		 
		
		shoppingcartlabel.click();
		System.out.println("In Shopping cart struggle report clicked");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		
		System.out.println("In Shopping cart struggle report clicked ");

		
	}

	

	/**
	 * Method to call StruggleAnalytics->Checkout
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = ("//label[contains(.,'Checkout')]"))
	WebElement checkoutlabel;

	public void checkOut() throws InterruptedException {
		
		//Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		checkoutlabel.click();
		 
		System.out.println("In Checkout struggle report");
	}

	 
	/**
	 * Method to call StruggleAnalytics->BannerLandingPage
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = ("//label[contains(.,'Banner Landing Page')]"))
	WebElement bannerlabel;

	public void bannerLandingPage() throws InterruptedException {
		
		//Thread.sleep(TeaLeafCONSTANTS.WAITTIME10000MILLISEC);
		bannerlabel.click();
		 
		System.out.println("In Banner landing page report");
	}

	
	
	
	/**
	 * Navigating back to StruggleAnalytics view
	 * 
	 * @throws InterruptedException
	 */
	@FindBy(xpath = ("//a[contains(@href,'/struggle-analytics')and contains(@ui-sref,'struggles({})')]"))
	WebElement menustruggle;

	public void backToStruggleAnalytics() throws InterruptedException {
		//Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
		/*driver.manage()
				.timeouts()
				.implicitlyWait(TeaLeafCONSTANTS.WAITTIME60SEC,
						TimeUnit.SECONDS);*/
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(menustruggle).click(menustruggle);
		builder2.perform();
		System.out
				.println("Successfully navigated back to Struggle Analytics ");
		Thread.sleep(TeaLeafCONSTANTS.WAITTIME5000MILLISEC);
	}

}
