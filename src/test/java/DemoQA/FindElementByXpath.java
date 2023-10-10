package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByXpath{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
        WebElement element = driver.findElement(By.xpath("//input[@id=\"uploadPicture\"]"));
        if(element != null)
            System.out.println("element found by xpath");
        driver.quit();
    }
}
