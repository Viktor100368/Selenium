package createTicketTest.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));//ожидание загрузки страницы
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// ожидание взаимодействия с элементами страницы
        BaseSeleniumPage.setDriver(driver);
    }
    @After
    public void tearDown(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();//закрывает ChromeDriver
        driver.quit();// закрваем браузер
    }
}
