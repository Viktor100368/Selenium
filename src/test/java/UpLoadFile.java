import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UpLoadFile {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement element = driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
}
