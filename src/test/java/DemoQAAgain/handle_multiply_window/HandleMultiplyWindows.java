package DemoQAAgain.handle_multiply_window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandleMultiplyWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/browser-windows";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button [@id = 'windowButton']")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> otherWindows = driver.getWindowHandles();
        Iterator<String> iterator = otherWindows.iterator();
        while(iterator.hasNext()){
            String childWindow = iterator.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println(text.getText());
            }
        }


        driver.quit();
    }
}
