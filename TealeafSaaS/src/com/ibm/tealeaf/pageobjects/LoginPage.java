package com.ibm.tealeaf.pageobjects;

/**
 * @author Manjusha Saju
 *
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage {
    WebDriver driver;
    	  
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    
    }
    
     //Instead of above commented method we can call @FindBy
    
    @FindBy(id="j_username") WebElement username;
	@FindBy(id="j_password")WebElement password;
	@FindBy(className="submit")WebElement login_button;
	@FindBy(xpath="//a[contains(text(),'Forgot password')]")WebElement forgot_password;

	public void login_tealeafSaaS(String userName,String passWord)
	{
		username.sendKeys(userName);
		password.sendKeys(passWord);
		login_button.click();
		
    }

	
}
