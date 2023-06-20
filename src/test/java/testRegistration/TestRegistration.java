package testRegistration;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import unsplash.Registration;

import java.util.ArrayList;


public class TestRegistration {
    WebDriver driver = new ChromeDriver();
    private By login = By.xpath("//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By joinUnsplash = By.xpath("//a[text()='Join Unsplash']");
    private By splashFirstName = By.xpath("//input[@id='user_first_name']");
    private By splashLastName =By.xpath("//input[@id='user_last_name']");
    private By splashEmail = By.xpath("//input[@id='user_email']");
    private By splashUserName = By.xpath("//input[@id='user_username']");
    private By splashPassword = By.xpath("//input[@id='user_password']");
    private By joinButton = By.xpath("//input[@class='btn btn-default btn-block-level']");
    private By btnCopyEmail = By.xpath("//button[@id='pre_copy']");
    @Test
    public void testRegistration(){
        driver.get("https://unsplash.com/");
        //driver.manage().window().maximize();
        driver.findElement(login).click();
        driver.findElement(joinUnsplash).click();
        driver.findElement(splashFirstName).sendKeys("andrew");
        driver.findElement(splashLastName).sendKeys("Petrov");
        driver.switchTo().newWindow(WindowType.TAB).get("https://tempmail.plus/ru/#!");
        driver.findElement(btnCopyEmail).click();
        ArrayList<String> newTab= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));
        driver.findElement(splashEmail).sendKeys(Keys.LEFT_CONTROL+"V");
        driver.findElement(splashUserName).sendKeys("filipok");
        driver.findElement(splashPassword).sendKeys("abc123456778");
        driver.findElement(joinButton).click();

    }


}
