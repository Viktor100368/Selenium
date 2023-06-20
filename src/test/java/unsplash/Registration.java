package unsplash;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Registration extends Data{
    private By login = By.xpath("//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By joinUnsplash = By.xpath("//a[text()='Join Unsplash']");
    private By splashFirstName = By.xpath("//input[@id='user_first_name']");
    private By splashLastName =By.xpath("//input[@id='user_last_name']");
    private By splashEmail = By.xpath("//input[@id='user_email']");
    private By splashUserName = By.xpath("//input[@id='user_username']");
    private By splashPassword = By.xpath("//input[@id='user_password']");
    private By joinButton = By.xpath("//input[@class='btn btn-default btn-block-level']");

    @Test
    public void registration(){
        WebDriver driver = new ChromeDriver();
        Data getDate = new Data();
        Registration reg = new Registration();
        driver.get(getDate.baseUrl);
        driver.manage().window().maximize();
        driver.findElement(login).click();
        driver.findElement(joinUnsplash).click();
        driver.findElement(splashFirstName).sendKeys(getDate.firstName);
        driver.findElement(splashLastName).sendKeys(getDate.lastName);
        driver.findElement(splashEmail).sendKeys(getDate.email);
        driver.findElement(splashUserName).sendKeys(getDate.userName);
        driver.findElement(splashPassword).sendKeys(getDate.password);
        driver.findElement(joinButton).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
