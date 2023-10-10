package DemoQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommand {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url ="https://shop.demoqa.com";
        driver.get(url);
        String title = driver.getTitle();
        int lengthTitle = title.length();
        System.out.println("имя заголовка = "+title);
        System.out.println("длина имени заголовка = "+lengthTitle);
        String currentUrl = driver.getCurrentUrl();
        boolean flag = url.equals(currentUrl);
        if(flag) System.out.println("открыта правильная страница ");
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        System.out.println("length pageSource = "+pageSource.length());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
