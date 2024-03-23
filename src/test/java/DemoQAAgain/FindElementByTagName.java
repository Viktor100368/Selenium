package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementByTagName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/text-box/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        List<WebElement> allInputList = driver.findElements(By.tagName("input"));
        if(allInputList.size() != 0){
            System.out.println(allInputList.size()+" elements found by tag name input");
            for(WebElement el:allInputList){
                System.out.println(el.getAttribute("placeholder"));
            }
        }

        driver.quit();

    }
}
