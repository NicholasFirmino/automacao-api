package runners.types;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class RunCucumberJUnit5Test {
    // Esta classe agora utiliza a configuração correta para JUnit 5
}
