package DemoQAAgain.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.toolsqa.com/selenium-training/");
        WebElement href = driver.findElement(By.xpath("//div[@class='col-12 col-lg-6 order-lg-0 d-flex flex-column justify-content-md-center']//a"));
        href.click();
        try {
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().forward();
            Thread.sleep(1000);
            driver.navigate().to("https://www.toolsqa.com/selenium-training/");
            Thread.sleep(1000);
            driver.navigate().refresh();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
