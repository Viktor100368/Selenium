package seleniumToolsLearn;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        String title = driver.getTitle();
        int lengthTitle = driver.getTitle().length();
        System.out.println("title = "+title);
        System.out.println("title length = "+lengthTitle);
        String currentUrl = driver.getCurrentUrl();
        if(url.equals(currentUrl)){
            System.out.println("ok url");
        }else{
            System.out.println("not ok url");
        }
        String pageSourse = driver.getPageSource();
        int pageSourseLength = driver.getPageSource().length();
        System.out.println("length current page = "+pageSourseLength);
        driver.quit();

    }
}
