package seleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GooglestartTest {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("selenium");
        element.submit();
        (new WebDriverWait(driver, Duration.ofSeconds(10))).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("selenium");
            }
        });
        System.out.println("page is name "+driver.getTitle());


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
