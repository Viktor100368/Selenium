package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementById {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver122/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String url = "https://demoqa.com/text-box/";
        driver.get(url);
        WebElement element = driver.findElement(By.id("submit"));
        if(element != null)
            System.out.println("element found by id");

        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
