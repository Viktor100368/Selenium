package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElementRadioAndSetHis {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/radio-button";
        driver.get(url);
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        WebElement radio = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        boolean isDisplayed = radio.isDisplayed();
        boolean isEnabled = radio.isEnabled();
        boolean isSelected=radio.isSelected();
        if(isDisplayed == true && isEnabled == true && isSelected == false){
            radio.click();
            System.out.println("radio is selected");
        }
        WebElement radio3 = driver.findElement(By.xpath("//input[@id='noRadio']"));
        isEnabled = radio3.isEnabled();
        if(isEnabled == false){
            System.out.println("noRadio is disabled");
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
