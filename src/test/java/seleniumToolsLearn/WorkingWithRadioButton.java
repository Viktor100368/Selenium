package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithRadioButton {

    @Test
    public void radioButton(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/automation-practice-form");
        //WebElement element1 = driver.findElement(By.id("\"gender-radio-2\""));
        WebElement element2 = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
       // if(element1.isEnabled()) System.out.println("id is enabled = "+element1);
        boolean result =element2.isSelected();
        if(result == false){
            System.out.println("element is selected = "+result);
            element2.click();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
