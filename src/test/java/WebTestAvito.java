import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTestAvito {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/ulyanovsk");
        driver.findElement(By.xpath("(//div/span[text()='Авто']/../..)[1]")).click();
        driver.findElement(By.xpath("(//ul[@class='rubricator-list-item-submenu-bQ0A4']/li)[1]/div/a")).click();
        driver.findElement(By.xpath("(//a[text()='ГАЗ'])[1]")).click();
        driver.findElement(By.xpath("(//a[text()='Соболь 2752'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='iva-item-title-py3i_']//h3[contains(text(),2017)]/..)[1]")).click();


    }
}
