import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Proba {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        WebElement element=null;
        driver.get("https://demo.guru99.com/test/ajax.html");
//        driver.findElement(By.id("no")).click();
//        driver.findElement(By.id("buttoncheck")).click();
        List<WebElement> elements = driver.findElements(By.name("name"));
        System.out.println("numbers of elements = "+elements.size());
        for(int i=0;i<elements.size();i++){
            System.out.println("Radio button text : "+elements.get(i).getAttribute("value"));
        }
        driver.quit();
    }

}
