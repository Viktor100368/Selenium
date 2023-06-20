import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTests {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        driver.get("https://www.google.com/search?q=java&oq=java&aqs=chrome..69i57j69i59l2j0i131i433i512j0i433i512j0i131i433i512l4j0i433i512.1559j0j15&sourceid=chrome&ie=UTF-8");
        WebElement element;
        element=driver.findElement(By.xpath("//h3[text()='Java - Википедия']/.."));
        element.click();
        element=driver.findElement(By.xpath("//div[@class='cnotice-button cnotice-button1']"));
        element.click();
        element=driver.findElement(By.xpath("//div[@class='thumb']//a[@class='mw-file-description'][contains(@href,'COVID_6')]"));
        element.click();
        element=driver.findElement(By.xpath("//div[@class='mw-mmv-stripe-button-container']/a"));
        element.click();




    }
}
