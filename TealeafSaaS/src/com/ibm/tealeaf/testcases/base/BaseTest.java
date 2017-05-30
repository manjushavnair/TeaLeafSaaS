package com.ibm.tealeaf.testcases.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.ibm.tealeaf.commons.PropertyReader;

public class BaseTest {
	
	protected static WebDriver driver;
	protected static PropertyReader prpr;
	protected WebDriverWait wait;
	private static Logger logger = Logger.getLogger(BaseTest.class);

	@BeforeSuite
	  protected void setUpBeforeTestSuite(){
		    // initialize a browser driver, connect to servers
		  }
	   @AfterSuite
	  protected void tearDownAfterTestSuite(){
		   logger.info("Quiting the tearDownAfterTestSuite ::BaseTest ");
		   driver.quit();
		  }

	 /*
		@BeforeMethod
		  protected  void setUpBeforeTestMethod() {
		    // initialize testPage
		    // login to the app, if necessary
		  }
		@AfterMethod
		  protected  void tearDownAfterTestMethod() {
		    // logout of the app, if necessary
		  }

		 @BeforeClass
			protected void setUpBeforeTestClass(){
			    // initialize a browser driver, connect to servers
			  }
			  */
		@AfterClass
		  protected  void  tearDownAfterTestClass() {
		    // close connections, close browser as needed
			logger.info("Quiting browser  tearDownAfterTestClass  ::BaseTest");
			 driver.quit();
		  }
}
