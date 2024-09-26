package runners.types;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"steps"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/cucumber-html-report.html"},
        tags = "@Regressivo",
        monochrome = true
)
public class RunCucumberTestNGTest extends AbstractTestNGCucumberTests {

}
