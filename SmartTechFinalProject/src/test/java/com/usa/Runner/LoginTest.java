package com.usa.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		
		features = "C:\\Users\\refat\\eclipse-workspace\\SmartTechFinalProject\\Features\\Login.feature",tags = "@Login",
		plugin = {"pretty", "html:target/cucumber-reports/cucumber.json",
		"json:target/cucumber.json"},
		dryRun = false,
		monochrome  = true,
		strict = true,
		glue = "com.usa.StepDef"
		)

public class LoginTest extends AbstractTestNGCucumberTests{

}
