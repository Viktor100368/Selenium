package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByClassName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/text-box";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(By.className("btn"));
        if(element != null){
            System.out.println("Element found by class name");
        }
        driver.quit();
    }
}
