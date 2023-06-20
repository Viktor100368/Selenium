package unsplash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindImage {
//    System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    Data reqData= new Data();
    private By btnImage= By.xpath("(//button[@class='r7Rbd jpBZ0'])[4]");
    private By openFile=By.xpath("//input[@id='visual-search-form-dropbox-input']");
    private By getText= By.xpath("//span[text()='Trending Searches']");

    @Test
    public void findImage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(reqData.baseUrl);
        driver.findElement(btnImage).click();
        driver.findElement(openFile).sendKeys(reqData.pathImage,Keys.ENTER);
        String getTextTrendingSearches = driver.findElement(getText).getText();
        Assert.assertEquals("Trending Searches",getTextTrendingSearches);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
