package runners.types;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"steps"},
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" // Plugin para Extent Reports
        },
        tags = "@Regressivo",
        monochrome = true
)
public class RunCucumberTestNGExtentTest extends AbstractTestNGCucumberTests {

}
