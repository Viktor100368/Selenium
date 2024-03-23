package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyFirstTestClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = driver.getTitle();
        System.out.println(title);
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder = 'UserName']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder = 'Password']"));
        WebElement login = driver.findElement(By.xpath("//button[@id='login']"));
        userName.sendKeys("Testuser");
        password.sendKeys("Password@123");
        login.click();

        try {
            Thread.sleep(1000);
            WebElement logOut = driver.findElement(By.xpath("//div[@class = 'text-right col-md-5 col-sm-12']//button[@id='submit']"));
            if(logOut.isDisplayed()){
                logOut.click();
                System.out.println("log out is successful");
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
