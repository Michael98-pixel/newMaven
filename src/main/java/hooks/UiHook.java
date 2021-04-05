package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selenium.Browser;
import utils.ScenarioContext;
import utils.ScreenshotUtils;

import java.util.concurrent.TimeUnit;

public class UiHook {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before
    public void creatNewEmail() {
        String email = "bivolconstantin" + System.currentTimeMillis() + "@getnada.com";
        ScenarioContext.setContext("New Email", email);
    }
    @Before
    public void setupWebDriver() {
        logger.debug("Chrome driver Set UP");
        WebDriver driver = Browser.getBrowser();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Window is maximized");
    }
    @Before
    public void setupReport(Scenario scenario) {
        System.setProperty("cucumber.reporting.config.file", "src/test/resources/cucumber-reporting.properties");
        ScreenshotUtils.setScenario(scenario);
    }
    @After(order = 100)
    public void onFail(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.takeScreenshot("onFail");
        }
    }

    @After(order = 1)
    public void tearDown() {
        Browser.quitDriver();
        ScenarioContext.clearContext();
    }
}