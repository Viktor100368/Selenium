package DemoQAAgain.find_element_with_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EffectiveXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/text-box";
        driver.get(url);

        //contains() method
        WebElement element = driver.findElement(By.xpath("//input[contains(@placeholder,'Name')]"));
        element.sendKeys("Petrov");

        //starts-with() method
        element = driver.findElement(By.xpath("//input[starts-with(@id,'userE')]"));
        element.sendKeys("petrov@gmail.com");

        

        //text() method with using operator and, or
        element = driver.findElement(By.xpath("//button[text()='Submit' and @type='button']"));
        element.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
