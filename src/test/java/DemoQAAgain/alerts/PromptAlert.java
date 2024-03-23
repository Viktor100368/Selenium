package DemoQAAgain.alerts;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class PromptAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/alerts";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement alert= driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",alert);
       // alert.click();
        Alert pormptAlert = driver.switchTo().alert();
        String alertText = pormptAlert.getText();
        System.out.println("alert text is "+ alertText);
        pormptAlert.sendKeys("it is my text");
        pormptAlert.accept();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
