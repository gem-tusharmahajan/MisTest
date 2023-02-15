package com.gemini.mis.runner;

import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
//        features = "src/test/resources/features/MySkills.feature"
        features = "src/test/resources/features"
        , glue = "com/gemini/mis/stepdefinitions"
        ,tags = "@T123"
//        , dryRun = true

)
public class TestSuiteRunner {
}
