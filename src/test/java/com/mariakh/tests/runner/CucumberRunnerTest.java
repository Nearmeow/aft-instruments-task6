package com.mariakh.tests.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/scenario",
        glue = "com/mariakh/framework/steps",
        tags = "@firstTest"
)
public class CucumberRunnerTest {
}
