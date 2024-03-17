package makeup.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/makeup/tests"}, glue = {"makeup.steps"},
        plugin = {"pretty"})
public class LoginPageRunner extends AbstractTestNGCucumberTests {
}
