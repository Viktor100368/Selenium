package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByLinkTextAndPartialLinkText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        String url = "https://demoqa.com/links";
        driver.get(url);

        WebElement element = driver.findElement(By.linkText("Home"));
        if(element != null)
            System.out.println("link found on linkText");
        element = driver.findElement(By.partialLinkText("Cre"));
        if(element != null)
            System.out.println("partial link found on partialLinkText");
        driver.quit();
    }
}
