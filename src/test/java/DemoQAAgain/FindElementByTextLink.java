package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementByTextLink {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/links";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement element = driver.findElement(By.partialLinkText("simple"));
        if(element != null){
            System.out.println("link is found");
        }else{
            System.out.println("link is not found");
        }
        driver.quit();
    }
}
