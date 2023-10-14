package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FindMultiSelectAndUseHiim{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Select mulSel = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        boolean isMultipli = mulSel.isMultiple();
        System.out.println("is multipli - "+isMultipli);
        List<WebElement> listOp = mulSel.getOptions();
        for(WebElement we: listOp){
            System.out.println("option is - "+we.getText());
        }
        mulSel.selectByIndex(1);
        System.out.println("selected - "+mulSel.getFirstSelectedOption().getText());
        mulSel.deselectByIndex(1);

        mulSel.selectByVisibleText("Opel");
        System.out.println("Selected is - "+mulSel.getFirstSelectedOption().getText());
        mulSel.deselectByVisibleText("Opel");

        mulSel.selectByValue("saab");
        System.out.println("Selected is - "+mulSel.getFirstSelectedOption().getText());
        mulSel.deselectAll();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
