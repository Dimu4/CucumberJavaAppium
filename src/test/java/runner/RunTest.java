package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        tags = "@login,@signup",
        glue = {"step_definitions", "hooks"},
        features = {
                "classpath:cucumber"
        },
        format = {"pretty", "html:target/cucumber.html", "junit:target/junit.xml"}
//        dryRun = true
)

public class RunTest extends AbstractTestNGCucumberTests {
}
