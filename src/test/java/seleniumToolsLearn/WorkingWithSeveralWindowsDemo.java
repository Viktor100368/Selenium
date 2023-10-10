package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WorkingWithSeveralWindowsDemo {
@Test
    public void workingWithSeveralWindows(){
  //  WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    driver.get("https://demoqa.com/browser-windows/");
    driver.findElement(By.id("windowButton")).click();
    driver.findElement(By.id("messageWindowButton")).click();

    String mainWindow = driver.getWindowHandle();
    System.out.println("main Window - "+mainWindow);
    Set<String> allWindowHandle = driver.getWindowHandles();
    System.out.println("child Windows - "+allWindowHandle);
    Iterator<String> iterator = allWindowHandle.iterator();
    while(iterator.hasNext()){
        String childWindow = iterator.next();
        if(!mainWindow.equalsIgnoreCase(childWindow)){
            driver.switchTo().window(childWindow);
            driver.close();
            System.out.println("close child Window ");
        }
    }
    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.quit();
}
}
