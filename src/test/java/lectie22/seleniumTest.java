package lectie22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class seleniumTest {
    public static WebDriver driver;
 public Logger logger =LoggerFactory.getLogger(this.getClass());
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/IdeaProjects/newMaven/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://freebitco.in/?op=signup_page");
        Thread.sleep(4000);

        WebElement search = driver.findElement(By.xpath("//li[@class='login_menu_button']//a"));
        search.click();
        Thread.sleep(3000);
        WebElement search00 = driver.findElement(By.cssSelector("div.allow_button.pushpad_allow_button"));
         search00.click();

        WebElement search1 = driver.findElement(By.xpath("//input[@id='login_form_btc_address']"));
        search1.click();
        search1.sendKeys("mihai52191821@gmail.com");
        WebElement search2 = driver.findElement(By.xpath("//input[@id='login_form_password']"));
        search2.click();
        search2.sendKeys("GSCyqB7MAXCTbDdu");


        WebElement search6 = driver.findElement(By.xpath("//a[@class='cc_btn cc_btn_accept_all']"));
        search6.click();

        WebElement search3 = driver.findElement(By.xpath("//button[@class='new_button_style profile_page_button_style center']"));
        search3.click();

        Thread.sleep(5000);

        WebElement search0 = driver.findElement(By.xpath("//div[@class='allow_button pushpad_allow_button']"));
        search0.click();
//
//        WebElement search4 = driver.findElement(By.xpath("//input[@id='free_play_form_button']"));
//        search4.click();
//
//
//        Thread.sleep(10000);
//
//        driver.findElement(By.xpath("//h4[@id='multiply_now_text']")).click();
//        Thread.sleep(4000);
//          driver.findElement(By.xpath("//a[@class='free_play_link']")).click();

        // WebElement  search =  driver.findElement(By.xpath("//input[@name='q' ]"));
        //driver.findElement(By.xpath("//input[@name='q' ]")).sendKeys("IT Step Academy");
        //driver.findElement(By.xpath("//input[@name='btnk' and @type='submit']")).click();;
//search.sendKeys("It Step Academy");
//search.sendKeys(Keys.ENTER);
//
//Actions action = new Actions(driver);

        for (int i = 0; i < 100; i++){

            WebElement firstResult = new WebDriverWait(driver, 3630)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='free_play_form_button']")));
            firstResult.click();
            Thread.sleep(10000);

            driver.findElement(By.xpath("//h4[@id='multiply_now_text']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//a[@class='free_play_link']")).click();
        }
    }
    public void tearDown() {
        driver.quit();
    }
}