package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AbstractPage;
import selenium.Browser;
import utils.ReflectionUtils;
import utils.ScenarioContext;
import utils.ScreenshotUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static utils.ScenarioDataKey.CURRENT_PAGE;

public class MyStep {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ParameterType(value = "CLOTHES|GADGETS|TOYS", name = "type")
    public Type type(String type) {
        return Type.valueOf(type);
    }

    @Then("user is on the {string} page")
    public void userIsOnTheCheckoutPage(String pageName)
            throws InvocationTargetException, NoSuchMethodException, ClassNotFoundException, InstantiationException, IllegalAccessException,
            InterruptedException {
        Thread.sleep(3000);
        AbstractPage page = ReflectionUtils.getPageObject(pageName);
        MatcherAssert.assertThat(Browser.getBrowser().getCurrentUrl(), containsString(page.getPageUrl()));
        ScenarioContext.setContext(CURRENT_PAGE.name(), page);
        ScreenshotUtils.takeScreenshot(pageName);
        logger.info("User is on the {} page", pageName);
    }

    @When("user clicks to {string} button")
    @When("user click to {string} button")
    public void userClicksToAddToCartButton(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        ScreenshotUtils.takeScreenshotOfElement(buttonName, button);
        button.click();
        logger.info("User clicks to {} button", buttonName);
    }
    @Then("{string} button is displayed")
    public void addToCartButtonIsDisplayed(String buttonName) throws IllegalAccessException {
        WebElement button = ReflectionUtils.getWebElement(buttonName);
        MatcherAssert.assertThat(button.isDisplayed(), is(true));
    }
    @Then("{string} is on the right of the product")
    public void addToCartIsOnTheRightOfTheProduct(String buttonName) {
    }
    @Then("product is added to database")
    public void productIsAddedToDatabase() {
    }
    @And("product type is {type}")
    public void productTypeIsTOYS(Type type) {
        logger.info("Type of {}", type.name().toLowerCase());
    }
    @And("list of")
    public void listOf(DataTable dataTable) {
        List<Map<String, String>> listOfMaps = dataTable.asMaps();
        for (Map<String, String> map : listOfMaps) {
            String id = map.get("Id");
            String name = map.get("Name");
            String price = map.get("Price");
            String quantity = map.get("Quantity");
            logger.info("{} for id {} for price {} of quantity {}",
                    name, id, price, quantity);
        }
    }
    @And("product {string} is {string}")
    public void productFadedShortSleeveTShirtsIsInStock(String productName, String status) {
    }
//    @Given("user goes to the {string} page")
//    public void userGoesToTheProductPage(String pageName) {
//        if (pageName.equals("Product")) {
//            Browser.getBrowser()
//                    .get("http://automationpractice.com/index.php?id_product=1&controller=product#/size-s/color-orange");
//        } else {
//            throw new RuntimeException("Unkown link for page name: " + pageName);
//        }
//    }
    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        Browser.getBrowser().navigate().to(url);
        logger.info("User navigates to {}", url);
    }
    @And("user types new email into {string} field")
    public void userTypesNewEmailIntoField(String elementName) throws IllegalAccessException {
        WebElement element = ReflectionUtils.getWebElement(elementName);
        element.sendKeys("bivolconstantin" + System.currentTimeMillis() + "@getnada.com");
        ScreenshotUtils.takeScreenshotOfElement(elementName, element);
    }

}