package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementAndSetCheckbox {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url ="https://demoqa.com/automation-practice-form";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.id("firstName")).sendKeys("Viktor");
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        WebElement checkbox = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        boolean isSelected = checkbox.isSelected();
        boolean isDisplayed = checkbox.isDisplayed();
        boolean isEnabled = checkbox.isEnabled();
        System.out.println("isSelected - "+isSelected);
        if(isSelected == false && isDisplayed == true && isEnabled == true){
            checkbox.click();
        } else
            System.out.println("checkbox not seting");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
