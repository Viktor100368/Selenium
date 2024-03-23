package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicityWaitUsing {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        String url = "https://demoqa.com/dynamic-properties";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("button#visibleAfter")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
