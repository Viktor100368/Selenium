package DemoQAAgain.handle_multiply_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchBackParrentWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> iterator = s1.iterator();
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(childWindow);
                driver.close();
                System.out.println(childWindow + " closed");
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());
        System.out.println(mainWindow +" closed");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
