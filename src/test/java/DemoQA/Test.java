package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver" , "C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/browser-windows/";
        driver.get(url);
        String mainWindowHamdle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        driver.findElement(By.cssSelector("button#tabButton")).click();
        driver.findElement(By.cssSelector("button#windowButton")).click();
        driver.findElement(By.cssSelector("button#messageWindowButton")).click();

        Iterator<String> iterator = allWindowHandles.iterator();
        while(iterator.hasNext()){
            String childWindow =iterator.next();
            if(!mainWindowHamdle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                String title = driver.getTitle();
                System.out.println(title);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
            driver.switchTo().window(mainWindowHamdle);
            System.out.println(driver.getTitle());

        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
