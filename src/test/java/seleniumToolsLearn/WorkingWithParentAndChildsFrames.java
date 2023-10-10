package seleniumToolsLearn;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class WorkingWithParentAndChildsFrames {
    @Test
    public void workingWithChildFrame(){
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int element = driver.findElements(By.id("frame1")).size();
        System.out.println("колиество фреймов = "+element);
        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);//переключились на iframe
        WebElement frameElement = driver.findElement(By.tagName("body"));
        String frameText = frameElement.getText();
        System.out.println(frameText);
        int countFrameInParentFrame = driver.findElements(By.tagName("iframe")).size();//проверяем сколько
        //в родительском iframe дочерних iframe
        System.out.println("колиество элементов в родительском фрейме = "+countFrameInParentFrame);
        driver.switchTo().frame(0);
        int countFrameInFrame2  =driver.findElements(By.tagName("iframe")).size();
        System.out.println("колиество элементов в дочернем фрейме = "+countFrameInFrame2);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        //теперь нужно вернуться на родительский фрейм
        driver.switchTo().parentFrame();
        System.out.println("-> " +driver.findElement(By.tagName("body")).getText());
        //возвращаемся на основную страницу
        driver.switchTo().defaultContent();
        WebElement mainPageText=driver.findElement(By.xpath("//*[@id='framesWrapper']/div[1]"));
        System.out.println(mainPageText.getText());

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
