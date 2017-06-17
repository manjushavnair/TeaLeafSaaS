package com.ibm.tealeaf.cucumber.login;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature"
		,glue={"com.ibm.tealeaf.cucumber.login"}
		,monochrome = false
		)
 
public class TestRunner {
 
}


