package lectie22;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumTest {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\IdeaProjects\\newMaven");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//input[@name='q' ]")).sendKeys("IT Step ACademyt");
driver.findElement(By.xpath("//input[@name='btnk'and @type='submit']")).click();;
int i =0;
    }
}
