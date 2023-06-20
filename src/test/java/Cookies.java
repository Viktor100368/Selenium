import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {
    WebDriver driver = new ChromeDriver();
    @Test
    public void getCookie(){
        driver.get("https://github.com/Viktor100368");
        Cookie getCookie = new Cookie("user_session","dV0Y_t8wEGjfJOuTB7TfNTJwpaBwrNPTrjYRzq1ns0qfjksu");
        driver.manage().addCookie(getCookie);
        driver.navigate().refresh();

    }
}
