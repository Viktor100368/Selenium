package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitUsingWithFunction {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url="https://demoqa.com/dynamic-properties";
        driver.get(url);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(NoSuchElementException.class);

        Function<WebDriver ,WebElement> function = new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element =driver.findElement(By.cssSelector("button#visibleAfter"));
                System.out.println("button visible after has name is "+ element.getText());
                if(element != null) {
                    System.out.println("button visible after found");
                }
                else System.out.println("button visible after not found");
                return element;
            }
        };
        wait.until(function);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
