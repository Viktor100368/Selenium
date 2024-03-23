//import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsInWebsiteDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://crossbrowsertesting.github.io/drag-and-drop.html");
            Thread.sleep(2000);
            WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
            WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(element1).clickAndHold(element1).moveToElement(element2).release().build().perform();
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
           driver.close();
            driver.quit();
        }

    }
}
