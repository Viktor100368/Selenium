package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FindSelectOldStyleAndUseWithHim {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver" , "C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Select oldSelect = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
        List<WebElement>listOptons = oldSelect.getOptions();
        for(WebElement we:listOptons){
            System.out.println("option is it - "+we.getText());
        }
        oldSelect.selectByIndex(7);
        System.out.println("select by index - "+oldSelect.getFirstSelectedOption().getText());
        try{
            Thread.sleep(1000);
            oldSelect.selectByVisibleText("Purple");
            System.out.println("select by visible text - "+oldSelect.getFirstSelectedOption().getText());
            Thread.sleep(1000);
            oldSelect.selectByValue("3");
            System.out.println("select by value - "+oldSelect.getFirstSelectedOption().getText());
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
