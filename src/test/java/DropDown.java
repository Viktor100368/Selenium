import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement first = driver.findElement(By.name("firstName"));
        WebElement last = driver.findElement(By.name("lastName"));
        WebElement phone = driver.findElement(By.name("phone"));
        WebElement email = driver.findElement(By.name("userName"));
        WebElement address = driver.findElement(By.name("address1"));
        WebElement city = driver.findElement(By.name("city"));
        WebElement state = driver.findElement(By.name("state"));
        WebElement code = driver.findElement(By.name("postalCode"));
        WebElement UserName=driver.findElement(By.name("email"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement confirm = driver.findElement(By.name("confirmPassword"));
        WebElement submit =driver.findElement(By.name("submit"));
        //заполняем форму
        first.sendKeys("Viktor");
        last.sendKeys("Baranov");
        phone.sendKeys("9033362222");
        email.sendKeys("vik@gmail.com");
        address.sendKeys("Moskovskaja 5");
        city.sendKeys("Moskow");
        state.sendKeys("Moskow. area");
        code.sendKeys("443900");
        UserName.sendKeys("vik@gmail.com");
        password.sendKeys("903450-304");
        confirm.sendKeys("903450-304");

        //заполняем dropDown
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        //drpCountry.selectByVisibleText("ANGOLA");
        drpCountry.selectByIndex(2);
        submit.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }
}
