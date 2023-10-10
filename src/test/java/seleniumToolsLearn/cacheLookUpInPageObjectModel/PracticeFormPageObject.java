package seleniumToolsLearn.cacheLookUpInPageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PracticeFormPageObject {
    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    public WebElement firsName;

    @FindBy(how = How.XPATH, using = "//input[@id='lastName']")
    public WebElement lastName;
}
