package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkingWithPormptAlertDemo {
    @Test
    public void workingWithPromptAlert(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
      //  driver.findElement(By.id("promptButton")).click();
        WebElement element = driver.findElement(By.id("promtButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
        Alert promptAlert = driver.switchTo().alert();

        String textAlert = promptAlert.getText();
        System.out.println("Alert text is "+textAlert);
        promptAlert.sendKeys("text user");
        promptAlert.accept();

        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }driver.quit();
    }
    @Test
    public void workingWithConfirmAlert(){
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement element= driver.findElement(By.id("confirmButton"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",element);
        Alert confirmAlert = driver.switchTo().alert();
        String confirmText = confirmAlert.getText();
        System.out.println("Alert text is - "+ confirmText);
       // confirmAlert.accept();
        confirmAlert.dismiss();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
    @Test
    public void workingWithRandomAlert(){
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WebElement element = driver.findElement(By.id("timerAlertButton"));
            element.click();
            WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert expectedAlert = driver.switchTo().alert();
            expectedAlert.accept();
            System.out.println("unexpected alert accepted");
        } catch (Exception e) {
            System.out.println("unexpected alert is not present");
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
