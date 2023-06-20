import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RegisterForm {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl="https://demo.guru99.com/test/login.html";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(baseUrl);

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement submitButton=driver.findElement(By.id("SubmitLogin"));

        email.sendKeys("abc@gmail.com");
        password.sendKeys("abcdef");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        email.clear();
        password.clear();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        email.sendKeys("abc@gmail.com");
        password.sendKeys("abcdef");
        submitButton.submit();

//        driver.get(baseUrl);
//        driver.findElement(By.id("email")).sendKeys("vik@mail.ru");
//        driver.findElement(By.id("passwd")).sendKeys("abcd1234");
//        driver.findElement(By.id("SubmitLogin")).submit();

    }
}
