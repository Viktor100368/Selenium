package DemoQAAgain.web_driver_wait;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicityWait {
    private WebDriver driver;
  @Test
    public void waitExercise(){
      System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://demoqa.com/dynamic-properties");
      driver.findElement(By.id("visibleAfter")).click();

        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
      driver.quit();
  }
}
