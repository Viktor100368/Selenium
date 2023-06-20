package unsplash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autorization {
    private By login = By.xpath("//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By splashEmail = By.xpath("//input[@id='user_email']");
    private By splashPassword = By.xpath("//input[@id='user_password']");
    private By inputlogin = By.xpath("//input[@class='btn btn-default btn-block-level' and @value='Login']");
    private By badAutorization = By.xpath("//div[@class='col-xs-10 col-sm-6 center-block flash__message']");
    @Test
    public void autorization(){
        Data regData= new Data();
        WebDriver driver = new ChromeDriver();
        driver.get(regData.baseUrl);
        driver.findElement(login).click();
        driver.findElement(splashEmail).sendKeys(regData.email);
        driver.findElement(splashPassword).sendKeys(regData.password);
        driver.findElement(inputlogin).click();
        String badAutoriz = driver.findElement(badAutorization).getText();
        Assert.assertEquals("Invalid email or password.",badAutoriz);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
