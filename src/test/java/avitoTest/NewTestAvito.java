package avitoTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class NewTestAvito {
    private static final String baseUrl = "https://www.avito.ru/ulyanovsk";
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseUrl);


        driver.findElement(By.xpath("(//a[@href='/ulyanovsk/transport'])[1]")).click();
        driver.findElement(By.xpath("//ul[@class='rubricator-list-Sa1GS']//a[text()='Водный транспорт']")).click();
        driver.findElement(By.xpath("//h3[text()='Катер Rinker 250 EC']/..")).click();
        driver.findElement(By.xpath("//div[@data-marker='image-frame/right-button']/button")).click();

    }

}
