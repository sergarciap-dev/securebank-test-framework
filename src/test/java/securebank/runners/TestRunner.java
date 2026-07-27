package securebank.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"securebank.stepdefinitions", "securebank.hooks"},
    tags = "@regression",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
