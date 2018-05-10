package com.revature.profiletest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {"pretty","html:C:/Reports/CucumberTests"},tags= {"@ProfileTest,@tabAppear"},
		features = {"C:/Users/Bala/Documents/workspace-sts/cucumber/src/test/resources/profileTest.feature"}
		)


public class profileRun extends AbstractTestNGCucumberTests {

}
