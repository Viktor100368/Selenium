package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WorkingWithAlertDemo {

    public static WebDriver setDriver(){
       // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void closeDriver(){
        WebDriver driver=setDriver();
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    @Test
    public void workingWithAlert(){
        WebDriver driver = setDriver();

        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.id("alertButton")).click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();
        driver.switchTo().window(mainWindow);

        closeDriver();
    }
//    @Test
//    public void alertApperAfterFiveSeconds(){
//        WebDriver driver = setDriver();
//        driver.findElement(By.id("timerAlertButton")).click();
//        Alert timerSimpleAlert = driver.switchTo().alert();
//        timerSimpleAlert.accept();
//        closeDriver();
//    }

}
