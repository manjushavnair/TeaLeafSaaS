package cucumbertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
		public static WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://50.23.117.115/webapp/login");
	}

	@When("^User Navigate to LogIn Page$")
	 public void user_Navigate_to_LogIn_Page() throws Throwable {
     System.out.println("Login Page appeared");
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
		driver.findElement(By.id("j_username")).sendKeys(username); 	 
	    driver.findElement(By.id("j_password")).sendKeys(password);
	    driver.findElement(By.className("submit")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath("//a[contains(@class,'dropdown-toggle with-lsep ng-binding')]")).click();
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[@ng-click='logout()']"))).
		click();
				
		builder.perform();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}

}