package com.ibm.tealeaf.pageobjects;

/**
 * @author Manjusha Saju
 *
 */
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.ibm.tealeaf.exception.BusinessException;

public class LoginPage {
	WebDriver driver;
	private static Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Instead of above commented method we can call @FindBy

	@FindBy(id = "j_username")
	WebElement username;
	@FindBy(id = "j_password")
	WebElement password;
	@FindBy(className = "submit")
	WebElement login_button;
	@FindBy(xpath = "//a[contains(text(),'Forgot password')]")
	WebElement forgot_password;

	public void login_tealeafSaaS(String userName, String passWord)
			throws BusinessException {
		try {
			username.sendKeys(userName);
			password.sendKeys(passWord);
			login_button.click();
		} catch (Exception e) {
			Assert.fail("Login failed");
			throw new BusinessException("1002", e.getMessage());
		}

	}

}
