package lectie22;

import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class freebitcoinTest {
    public static WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/hp/IdeaProjects/newMaven/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void freebitcoinTest() throws InterruptedException {
        driver.get("https://freebitco.in/?op=signup_page");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//li[@class='login_menu_button']//a"));
        search.click();
        Thread.sleep(5000);
        WebElement search00 = driver.findElement(By.cssSelector("div.allow_button.pushpad_allow_button"));
        search00.click();

        WebElement search1 = driver.findElement(By.xpath("//input[@id='login_form_btc_address']"));
        search1.click();
        search1.sendKeys("mihai52191821@gmail.com");
        WebElement search2 = driver.findElement(By.xpath("//input[@id='login_form_password']"));
        search2.click();
        search2.sendKeys("GwCFO7th57ZlFDkd");

        WebElement search6 = driver.findElement(By.xpath("//a[@class='cc_btn cc_btn_accept_all']"));
        search6.click();

        WebElement search3 = driver.findElement(By.xpath("//button[@class='new_button_style profile_page_button_style center']"));
        search3.click();

        Thread.sleep(5000);

        WebElement search0 = driver.findElement(By.xpath("//div[@class='allow_button pushpad_allow_button']"));
        search0.click();
        Thread.sleep(4000);
    }

    @Test(priority = 2)
    public void RollAndBonus() throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            WebElement bonusContainer = driver.findElement(By.xpath("//div[@id='bonus_container_free_points']"));
            WebElement firstResult = new WebDriverWait(driver, 3630)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='free_play_form_button']")));
            if (bonusContainer.isDisplayed()) {
                firstResult.click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//h4[@id='multiply_now_text']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@class='free_play_link']")).click();
            } else {
                WebElement more = driver.findElement(By.cssSelector("a.dropbtn"));
                more.click();
                driver.findElement(By.cssSelector("a.rewards_link")).click();
                driver.findElement(By.cssSelector("div.reward_category_container:nth-child(6) > div.reward_category_name")).click();
                Thread.sleep(2000);
                driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(14) > div:nth-child(5) > div:nth-child(4) > div:nth-child(6) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > button:nth-child(1)")).click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//a[@class='free_play_link']")).click();
                Thread.sleep(10000);
                firstResult.click();
                Thread.sleep(5000);
                driver.findElement(By.xpath("//h4[@id='multiply_now_text']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//a[@class='free_play_link']")).click();
            }
        }
    }
        @AfterClass
        public void tearDown () {
            driver.quit();
        }
    }