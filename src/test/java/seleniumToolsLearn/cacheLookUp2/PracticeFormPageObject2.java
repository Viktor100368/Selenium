package seleniumToolsLearn.cacheLookUp2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormPageObject2 {
    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    public WebElement firsName;
    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    @CacheLookup
    public WebElement getFirsNameCached;

}
