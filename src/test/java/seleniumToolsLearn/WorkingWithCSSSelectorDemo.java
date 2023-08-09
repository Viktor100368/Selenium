package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithCSSSelectorDemo {
    @Test
    public void workingWithCSSSelector(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu;
        selectMenu= driver.findElement(By.cssSelector("select#oldSelectMenu>option:nth-of-type(2)"));
        selectMenu.click();
        try {
            Thread.sleep(2000);
            //driver.findElement(By.cssSelector("select[id='oldSelectMenu']>option:last-of-type")).click();
            //css find first elememt
            //driver.findElement(By.cssSelector("select[id='oldSelectMenu']>option:first-of-type")).click();
            //css locator find last element
            //driver.findElement(By.cssSelector("select[id='oldSelectMenu']>option:nth-of-type(4)")).click();
            //css locator find four element
            driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]/option[@value='6']")).click();
            //xpath locator find six element

            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
