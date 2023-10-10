package seleniumToolsLearn.cacheLookUpInPageObjectModel;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CacheLookupInPageObjectModel {
@Test
    public void testAFirstAndLastNameField(){
    System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/automation-practice-form/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    // Initialize the Page object
    PracticeFormPageObject pageObject = PageFactory.initElements(driver, PracticeFormPageObject.class);
    pageObject.firsName.sendKeys("Virender");
    pageObject.lastName.sendKeys("Singh");
    pageObject.firsName.getText();
    pageObject.lastName.getText();

    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    driver.quit();

}
}
