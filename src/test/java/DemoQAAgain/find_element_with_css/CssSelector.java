package DemoQAAgain.find_element_with_css;

import DemoQAAgain.InitClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector extends InitClass {
    public static void main(String[] args) {

        CssSelector selector =new CssSelector();
        String url = "https://demoqa.com/automation-practice-form";
        WebDriver driver= selector.init(url);
        //css selector for id
        WebElement element = driver.findElement(By.cssSelector("input#firstName"));
        element.sendKeys("Viktor");
        //css selector for class
        element=driver.findElement(By.cssSelector("input[class =' mr-sm-2 form-control'][id = 'lastName']"));
        element.sendKeys("Petrov");



        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
