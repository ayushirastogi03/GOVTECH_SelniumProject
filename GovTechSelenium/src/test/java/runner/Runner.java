package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue="stepDef"
        ,features="src/test/resources/FeatureFile"
        ,monochrome = true
        ,tags="@Regression"
        ,plugin=("com.cucumber.listener.ExtentCucumberFormatter:target/GovTech_Automation_Report.html")
        ,format={"json:target/cucumber.json","html:target/cucumber.html"}

)

public class Runner {
}
