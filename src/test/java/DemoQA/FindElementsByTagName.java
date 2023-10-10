package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsByTagName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String url = "https://demoqa.com/text-box/";
        driver.get(url);
        List<WebElement> allInputElement = driver.findElements(By.tagName("input"));
        if(allInputElement.size()!= 0)
            System.out.println("quantity input elements = "+allInputElement.size());
        for(WebElement we: allInputElement){
            System.out.println(we.getAttribute("placeholder"));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
