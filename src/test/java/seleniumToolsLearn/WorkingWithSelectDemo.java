package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithSelectDemo {
    @Test
    public void workingWithSelect() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        try {
            Select se = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
            List<WebElement> elementList = se.getOptions();
            for (WebElement el : elementList) {
                System.out.println(el.getText());
            }


            se.selectByIndex(2);
            Thread.sleep(3000);
            se.selectByValue("6");
            Thread.sleep(3000);
            se.selectByVisibleText("Magenta");
            WebElement firstOption;
            firstOption = se.getFirstSelectedOption();
            System.out.println("first selected option = " + firstOption.getText());


            Select mulSe = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
            if (mulSe.isMultiple()) {
//            mulSe.selectByIndex(1);
//            mulSe.selectByIndex(2);
//            mulSe.selectByValue("saab");
//            mulSe.selectByValue("volvo");
                mulSe.selectByVisibleText("Volvo");
                mulSe.selectByVisibleText("Audi");
                List<WebElement> options = mulSe.getAllSelectedOptions();
                for (WebElement el : options) {
                    System.out.println("selected -> "+el.getText());
                }
                Thread.sleep(2000);

                mulSe.deselectByVisibleText("Audi");
               options= mulSe.getAllSelectedOptions();
                for (WebElement el : options) {
                    System.out.println("selected -> "+el.getText());
                }

            }


            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
