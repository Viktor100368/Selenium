package guru99;

import org.junit.Test;

public class MainPageTests extends BaseTests{
    private final static String titlePage = "Guru99 Bank";
    @Test
    public void loginPage(){
        driver.get("https://demo.guru99.com/v4/");
        MainPage mainPage = new MainPage(driver);
        if(mainPage.getTitlePage()==titlePage) {
            mainPage.setUid("demo");
            mainPage.setPassword("password");
            mainPage.clickLogin();
        }else {
            System.out.println("Error in titlePage");
        }
    }
}
