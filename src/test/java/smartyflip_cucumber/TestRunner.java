package smartyflip_cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "smartyflip_cucumber.stepDefinitions",
        tags = "@donate",
        plugin = {"pretty", "json:build/cucumber-report/cucumber.json"})
public class TestRunner {
}
