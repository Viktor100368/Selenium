package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommand {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.toolsqa.com/selenium-training/");
        driver.findElement(By.xpath("//a[@href=\"#enroll-form\"][1]")).click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://www.toolsqa.com/selenium-training/");
        driver.navigate().refresh();
        driver.quit();
    }
}
