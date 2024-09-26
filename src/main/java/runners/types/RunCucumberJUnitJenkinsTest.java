package runners.types;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"steps"},
        plugin = {"junit:target/cucumber-junit.xml", "json:target/cucumber.json"},
        tags = "@Regressivo",
        monochrome = true
)
public class RunCucumberJUnitJenkinsTest {
    
}
