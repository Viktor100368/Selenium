import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxRadioButton {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));
        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        radio1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        radio2.click();
        WebElement checkbox = driver.findElement(By.id("vfb-6-0"));
        for(int i=0;i<2;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            checkbox.click();
            System.out.println("checkbox is selected "+checkbox.isSelected());
        }
        WebElement el = driver.findElement(By.xpath("//img[@alt='Guru99 Demo Sites']/.."));
        if(el.getTagName().equals("a")){
            System.out.println("it is Home");
        }else{
            System.out.println("it is not Home");
        }
        driver.quit();
    }
}
