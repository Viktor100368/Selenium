package DemoQAAgain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindTable {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Tools\\chromedriver122\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.toolsqa.com/selenium-webdriver/handle-dynamic-webtables-in-selenium-webdriver/";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       List<WebElement> elements = driver.findElements(By.xpath("//table//tbody//tr[2]"));
//        for(WebElement el:elements){
//            System.out.println(el.getText());
//        }
        WebElement result;
            String str="Out";
        for(int i=1;i<3;i++){
            for(int k=1;k<4;k++){
               result= driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+k+"]"));
                System.out.println(result.getText()+" ");
                if(str.equals(result.getText())){
                    System.out.println("found finding element "+result.getText());
                }

            }
            System.out.println();
        }




        driver.quit();
    }
}
