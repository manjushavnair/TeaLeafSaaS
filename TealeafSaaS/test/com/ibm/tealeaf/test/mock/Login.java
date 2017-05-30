package com.ibm.tealeaf.test.mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login {
	
	String username;
	String password;
	
	public Login() {
		this.username = "";
		this.password = "";
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String login() {
		if (this.username.toLowerCase().equals("bas") && this.password.toLowerCase().equals("ok")) {
			return "login_ok";
		} else {
			return "login_nok";
		}
	}
}