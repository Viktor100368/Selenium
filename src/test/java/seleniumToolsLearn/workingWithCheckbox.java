package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class workingWithCheckbox {
    @Test
    public void workingWithCheckbox(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement checkbox =driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
//        boolean boxIsDisplayed =checkbox.isDisplayed();
        boolean boxisEnable = checkbox.isEnabled();
//        boolean checkboxState ;
//        if(boxIsDisplayed == true ){
//            System.out.println("checkBox is displayed");
//           checkboxState= checkbox.isSelected();
//            if(checkboxState == false) {
//                checkbox.click();
//                System.out.println("checkbox is selected");
//            }
//        }
            if(boxisEnable == true){
                System.out.println("checkbox is enabled");
                checkbox.click();
            }


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
