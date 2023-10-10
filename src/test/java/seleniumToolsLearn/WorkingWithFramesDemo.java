package seleniumToolsLearn;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WorkingWithFramesDemo {
    @Test
   public void workingWithFrames(){
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    //    String homePage = driver.getWindowHandle();
        List<WebElement> frameList = driver.findElements(By.tagName("iframe"));
        System.out.println("list frame contains "+frameList.size()+" elements");
        System.out.println(frameList);
        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
       WebElement element1 = driver.findElement(By.tagName("h1"));
        System.out.println(element1.getText());

        //driver.switchTo().window(homePage);//можна вернуться по другому
        //не используя getWindowHandle()
        driver.switchTo().defaultContent();
        WebElement el=driver.findElement(By.xpath("//div[@class='main-header']"));
        System.out.println(el.getText());

        driver.switchTo().frame("frame2");
        WebElement element2 = driver.findElement(By.tagName("h1"));
        System.out.println(element2.getText());


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    @Test
    public void workingWithIFrame(){
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame(1);//переключиться по индексу iframe
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
