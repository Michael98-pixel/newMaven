package RunCucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber"},
            stepNotifications = true,
            tags = "@Scenario1",
            features = "src/test/resources/",
            glue = {"steps","hooks"}

    )
    public class runCucumberTest {
    }