package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindCheckBoxWithUsingID {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement firstName =driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Viktor");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Viktorov");
        WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
        email.sendKeys("viktor@gmail.com");
        WebElement male = driver.findElement(By.xpath("//label[text()='Male']"));
        male.click();
        WebElement hobby = driver.findElement(By.xpath("//label[text()='Sports']"));
        hobby.click();
//        if(checkbox.isSelected()){
//            System.out.println("check box is selected");
//        }else{
//            System.out.println("check box is not selected");
//        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
