package DemoQA;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyFirstTestClass {
    public static void main(String[] args) {
       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        String url = driver.getCurrentUrl();
        System.out.println("curremt url is - "+url);
        String title = driver.getTitle();
        System.out.println("title this brouser it is "+title);
        WebElement userName = driver.findElement(By.xpath("//input[@id='userName']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@id='login']"));
        userName.sendKeys("testuser");
        password.sendKeys("Password@123");
        loginBtn.click();
        try{
        WebElement logout = driver.findElement(By.xpath("//div[@class='text-right col-md-5 col-sm-12']//button[text()='Log out']"));
            if(logout.isDisplayed())
                Thread.sleep(2000);
                logout.click();
            System.out.println("button is pressed");
        }catch (Exception e){
            System.out.println("неправильный локатор");
        }



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
