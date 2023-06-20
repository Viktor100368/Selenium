import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindXpath {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/v1/");
        WebElement input= driver.findElement(By.xpath("(//input[contains(@name,'btn')])[1]"));
        input.click();
    }
}
