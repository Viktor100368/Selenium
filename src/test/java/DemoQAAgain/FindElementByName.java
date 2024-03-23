package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url ="https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        WebElement nameElement = driver.findElement(By.name("gender"));
        if(nameElement != null){
            System.out.println("element found by name");
        }
        driver.quit();
    }
}
