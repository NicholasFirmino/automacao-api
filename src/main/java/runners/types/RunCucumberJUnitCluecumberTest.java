package runners.types;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"steps"},
        plugin = {"json:target/cluecumber-report/json/cucumber.json"},
        tags = "@Regressivo",
        monochrome = true
)
public class RunCucumberJUnitCluecumberTest {
}