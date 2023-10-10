package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class WorkingWithNewWindowsDemo {
    @Test
    public void workingWithNewWindows(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("windowButton")).click();
        String mainPage = driver.getWindowHandle();
        Set<String> allWindowHadle = driver.getWindowHandles();
        Iterator<String> iterator  = allWindowHadle.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            if(!mainPage.equalsIgnoreCase(element)){
                driver.switchTo().window(element);
                String text = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(text);
            }
        }



        try {

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
