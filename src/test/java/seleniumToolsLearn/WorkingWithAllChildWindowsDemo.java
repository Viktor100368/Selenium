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

public class WorkingWithAllChildWindowsDemo {
    @Test
    public void workingWithAllChildWindows(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.get("https://demoqa.com/browser-windows/");
        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();
        //driver.findElement(By.id("messageWindowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allChildWindows = driver.getWindowHandles();
        Iterator<String> iterator = allChildWindows.iterator();
        System.out.println("mainWindow -> "+mainWindow);
        System.out.println("childWindows -> "+allChildWindows);
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);

                String currentUrl = driver.getCurrentUrl();
                if(currentUrl.equalsIgnoreCase("https://demoqa.com/sample")){
                    System.out.println(driver.findElement(By.id("sampleHeading")).getText());
                }
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.findElement(By.xpath("//div[@class=\"main-header\"]")).getText());
        driver.quit();


    }
}
