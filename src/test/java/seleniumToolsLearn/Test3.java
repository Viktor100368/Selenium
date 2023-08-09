package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test3 {
    @Test
    public  void test3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://demoqa.com/text-box/");
        List<WebElement> elements = driver.findElements(By.tagName("input"));
        if(elements.size()!=0){
            System.out.println("elements size = "+elements.size());
            for(WebElement el:elements){
                System.out.println(el.getAttribute("placeholder"));
            }
        }
        WebElement submit = driver.findElement(By.id("submit"));
        if(submit!=null){
            System.out.println("element submit found by page");
        }

        driver.quit();
    }
}
