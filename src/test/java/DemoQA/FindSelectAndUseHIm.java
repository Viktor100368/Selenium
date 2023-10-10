package DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class FindSelectAndUseHIm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //получение элемента-Select select = new Select(Webdriver driver);
        Select se = new Select(driver.findElement(By.xpath("//select[@id=\"oldSelectMenu\"]")));
        //se.selectByIndex(3);
        //se.selectByValue("3");
        se.selectByVisibleText("Yellow");
        //standart multiSelect choise
        WebElement select = driver.findElement(By.xpath("//select[@id=\"cars\"]"));
        Select mulSe = new Select(select);
      //  boolean isMultiple = mulSe.isMultiple();
        if(mulSe.isMultiple()){
            mulSe.selectByIndex(1);
            mulSe.selectByIndex(2);
            System.out.println("two values selected");
        }

        List<WebElement> options = mulSe.getOptions();
        for(WebElement we:options) {
            System.out.println("all options - "+ we.getText());
        }
        WebElement firstSelectOption = mulSe.getFirstSelectedOption();
        System.out.println("firstSelectOption - "+firstSelectOption.getText());
        List<WebElement> selectedOptions = mulSe.getAllSelectedOptions();
        for(WebElement we: selectedOptions) {
            System.out.println("selected options - "+we.getText());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        mulSe.deselectByIndex(2);
        selectedOptions = mulSe.getAllSelectedOptions();
        for(WebElement we:selectedOptions)
        System.out.println("after deselect = "+we.getText());


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
