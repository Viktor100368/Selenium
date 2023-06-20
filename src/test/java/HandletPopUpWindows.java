import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandletPopUpWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/popup.php");
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        String MainWindow= driver.getWindowHandle();
        //to handle all opened window
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> it = s1.iterator();
        while(it.hasNext()){
            String childWindow=it.next();
            if(!MainWindow.equalsIgnoreCase(childWindow)) {
                // Switching to Child window
                driver.switchTo().window(childWindow);

               driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc@gmail.com");
                driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
                driver.close();
            }
        }

        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);

    }
}
