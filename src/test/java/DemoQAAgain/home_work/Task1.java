package DemoQAAgain.home_work;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/browser-windows/");
        String titleName = driver.getTitle();
        int titleLength =titleName.length();
        System.out.println("title "+titleName);
        System.out.println("title Length  "+titleLength);
        String url = driver.getCurrentUrl();
        if(url.equals(driver.getCurrentUrl())){
            System.out.println("ok");
        }else{
            System.out.println("not ok");
        }
        String sourseCode = driver.getPageSource();
        System.out.println("length = "+sourseCode.length());
        WebElement clickWindow = driver.findElement(By.xpath("//button[@id='windowButton']"));
        clickWindow.click();
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
