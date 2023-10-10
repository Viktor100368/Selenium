package seleniumToolsLearn.cacheLookUp2;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CacheLookUp2 {
    @Test
    public void workingCacheLookUpInPage(){
        System.setProperty("webdriver.chrome.driver","C:/Tools/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        PracticeFormPageObject2 practic = PageFactory.initElements(driver, PracticeFormPageObject2.class);
        practic.firsName.sendKeys("Virender");
        long withoutCacheStartTime = System.currentTimeMillis();
        for(int i=0; i<1000; i++){
            practic.firsName.getText();
        }
        long withoutCacheEndTime = System.currentTimeMillis();
        System.out.println("time from working with firstName = "+(withoutCacheEndTime - withoutCacheStartTime));

        long timeCacheStart = System.currentTimeMillis();
        for(int i=0; i<1000; i++){
            practic.getFirsNameCached.getText();
        }
        long timeCacheEnd = System.currentTimeMillis();
        System.out.println("time from working with firstNameCached = "+(timeCacheEnd - timeCacheStart));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
