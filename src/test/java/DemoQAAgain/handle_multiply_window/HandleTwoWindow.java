package DemoQAAgain.handle_multiply_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandleTwoWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton"));
        String mainWindow = driver.getWindowHandle();
        Set<String> chWindow = driver.getWindowHandles();
        Iterator<String> iterator = chWindow.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.close();
                System.out.println("child window closed");
            }
        }
        driver.quit();
    }
}
