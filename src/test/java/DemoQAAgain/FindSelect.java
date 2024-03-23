package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FindSelect {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Select select = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
//        List<WebElement> list = select.getOptions();
//        for(WebElement el:list){
//            System.out.println(el.getText());
//        }
        if(select.isMultiple()){
            select.selectByIndex(1);
            select.selectByIndex(2);

        }
        try {
            Thread.sleep(2000);
            select.deselectAll();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
