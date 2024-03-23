package DemoQAAgain.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleMultiplyWindowHomeWork {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        String mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        Iterator<String> iterator = set.iterator();
        WebElement text;
        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                text = driver.findElement(By.id("sampleHeading"));
                System.out.println(text.getText());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        driver.findElement(By.id("messageWindowButton")).click();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> it = s1.iterator();
        while(it.hasNext()){
            String childWin = it.next();
            if(!mainWindow.equalsIgnoreCase(childWin)){
                driver.switchTo().window(childWin);
                WebElement el = driver.findElement(By.xpath("//body"));
                System.out.println(el.getText());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
