package com.capg.mobilegames.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-report.html"},
		features ="src/test/java/resources",
		glue = "com.capg.mobilegames.cucumber",
		monochrome = true,
		publish = true
)
public class RunCucumberTests {

}
