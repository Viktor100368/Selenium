package DemoQAAgain.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TaskMultipleSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url= "https://demoqa.com/select-menu";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Select select = new Select(driver.findElement(By.id("cars")));
        if(select.isMultiple()){
            select.selectByVisibleText("Opel");
            select.deselectByIndex(2);
            select.selectByVisibleText("Saab");
            select.deselectByIndex(1);
            select.deselectAll();
        }
        driver.quit();
    }
}
