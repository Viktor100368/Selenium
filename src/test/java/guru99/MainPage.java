package guru99;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class MainPage extends BasePage {
    private WebDriver driver;
    private By namePage=By.className("barone");
    private By uid = By.name("uid");
    private By password = By.name("password");
    private By login = By.name("btnLogin");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void setUid(String userName){
        driver.findElement(uid).sendKeys(userName);
    }
    public void setPassword(String userPassword){
        driver.findElement(password).sendKeys(userPassword);
    }
    public void clickLogin(){
        driver.findElement(login).click();
    }
    public String getTitlePage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver.findElement(namePage).getText();
    }
}
