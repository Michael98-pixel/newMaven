package lectie22;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.endsWith;

public class createAccountTest {
    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/JetBrains/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    @DisplayName("Create new account and login succesfully")
    public void testAccount() throws InterruptedException {
        String gender ="Mr.";

        driver.navigate().to("http://automationpractice.com");
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("/index.php"));

        driver.findElement(By.cssSelector("a.login")).click();
        Assertions.assertTrue(driver.getCurrentUrl().endsWith("/index.php?controller=authentication&back=my-account"));

        By loginFormLocator = By.id("login_form");
        By createAccountFormLocator= By.id("create-account_form");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.textToBe(By.className("page-heading"),"AUTHENTICATION"));

        WebElement loginForm =driver.findElement(loginFormLocator);
        WebElement createAccountForm= driver.findElement(createAccountFormLocator);

        Assertions.assertTrue(loginForm.isDisplayed());
        Assertions.assertTrue(createAccountForm.isDisplayed());

        WebElement emailInput= createAccountForm.findElement(By.id("email_create"));
        emailInput.sendKeys("mihai"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+"@gmail.com");

        createAccountForm.findElement(By.id("SubmitCreate")).click();


        new  WebDriverWait(driver,10)
                .until(ExpectedConditions.textToBe(By.className("page-heading"),"CREATE AN ACCOUNT"));
              new WebDriverWait(driver,3)
    .until(ExpectedConditions.urlContains("=my-account#account-creation"));


        WebElement creationAccountForm= driver.findElement(By.id("account-creation_form"));
        Assertions.assertTrue(creationAccountForm.isDisplayed());

        WebElement genderElement = creationAccountForm.findElement(By.xpath("//label[contains(@for,'id_gender') and normalize-space()='"+ gender +"']//input"));
        genderElement.click();

        WebElement date = creationAccountForm.findElement(By.id("days"));
        WebElement month = creationAccountForm.findElement(By.id("months"));
        WebElement year = creationAccountForm.findElement(By.id("years"));

        new Select(date).selectByValue("1");
        new Select(month).selectByIndex(7);
        new Select(year).selectByValue("1998");

 WebElement firstname = creationAccountForm.findElement(By.xpath("//input[@id='customer_firstname']"));
 firstname.click();
 firstname.sendKeys("Mihail");
        WebElement lastname = creationAccountForm.findElement(By.xpath("//input[@id='customer_lastname']"));
        lastname.click();
       lastname.sendKeys("Durnea");

        WebElement password = creationAccountForm.findElement(By.xpath("//input[@id='passwd']"));
        password.click();
        password.sendKeys("Secret98");

       WebElement company= creationAccountForm.findElement(By.xpath("//input[@id='company']"));
        company.click();
        company.sendKeys("Eurociment S.R.L");

       WebElement address= creationAccountForm.findElement(By.xpath("//input[@id='address1']"));
        address.sendKeys("Rezina, str. Viitorului, nr.1");

        WebElement address1= creationAccountForm.findElement(By.xpath("//input[@id='address2']"));
        address1.sendKeys("Scara1, ap.55");

        WebElement city= creationAccountForm.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Rezina");

        WebElement state= creationAccountForm.findElement(By.xpath("//select[@id='id_state']"));
       new Select(state).selectByValue("9");

        WebElement postcode= creationAccountForm.findElement(By.xpath("//input[@id='postcode']"));
        postcode.sendKeys("14785");

        WebElement country= creationAccountForm.findElement(By.xpath("//select[@id='id_country']"));
       new Select(country).selectByValue("21");

        WebElement mobile= creationAccountForm.findElement(By.xpath("//input[@id='phone_mobile']"));
        mobile.sendKeys("+37368134728");

        WebElement submit =driver.findElement(By.xpath("//button[@id='submitAccount']"));
        submit.click();

        //WebElement everythingIsGood= driver.findElement(By.className("header_user_info"));
       new WebDriverWait(driver,5)
               .until(ExpectedConditions.textToBe(By.className("header_user_info"), "Mihail Durnea"));
       //Assertions.assertTrue();
    }
    public void tearDown() {
        driver.quit();
    }
}
