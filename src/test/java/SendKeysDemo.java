import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/ulyanovsk");
        WebElement element=driver.findElement(By.xpath("(//input[@class='input-input-Zpzc1'])[1]"));
        element.sendKeys("Соболь", Keys.ENTER);
       driver.findElement(By.xpath("(//a[text()='Животные'])[2]")).click();

    }
}
