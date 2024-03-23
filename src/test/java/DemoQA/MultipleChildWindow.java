package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleChildWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/browser-windows/";
        driver.get(url);
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("mainWindowHandle is "+mainWindowHandle);
        driver.findElement(By.cssSelector("button#tabButton")).click();
        driver.findElement(By.cssSelector("button#windowButton")).click();
        driver.findElement(By.cssSelector("button#messageWindowButton")).click();
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("windowHandle is "+allWindowHandles);
        Iterator<String> iterator = allWindowHandles.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("childWindowHandle "+childWindow+" open");
            }
        }
        driver.switchTo().window(mainWindowHandle);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
