package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features = "./src/test/resources/features/Login.feature",
                 glue = {"stepdefinitions", "hooks"},
                 plugin = {"pretty", 
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                		 "html:target/project-reports/project-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
