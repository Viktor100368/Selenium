package DemoQAAgain.web_driver_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class FluentWaitDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/dynamic-properties";
        driver.get(url);
//        Wait<WebDriver> wait = new FluentWait<>(driver)
//        .withTimeout(Duration.ofSeconds(2))
//        .pollingEvery(Duration.ofMillis(250));
        //или по другому

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
                wait.withTimeout(Duration.ofSeconds(2));
                wait.pollingEvery(Duration.ofMillis(250));
        Function<WebDriver,Boolean> function = new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                WebElement element = webDriver.findElement(By.xpath("//button[@id=\"colorChange\"]"));
                //код не работает т.к. атрибут color не существует
                String color = element.getAttribute("color");
                System.out.println("color is "+color);
                if(color.equals("red")){
                    return true;
                }

                return false;
            }
        };


        wait.until(function);
//        try{
//       WebElement result = new WebDriverWait(driver, Duration.ofSeconds(6))
//            .until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
//       result.click();
//            System.out.println("element found");
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();

    }
}
