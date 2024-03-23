package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class ChildWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/browser-windows/";
        driver.get(url);
        String title = driver.getTitle();
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("title of size is "+title);
        WebElement element = driver.findElement(By.cssSelector("button#windowButton"));
        element.click();
        Set<String> allWindowHandle= driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandle.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!parentWindowHandle.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println(text.getText());
            }
        }



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
