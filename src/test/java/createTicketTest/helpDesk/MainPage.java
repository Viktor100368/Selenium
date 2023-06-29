package createTicketTest.helpDesk;

import createTicketTest.core.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//select[@id='id_queue']/option[@value='1']")
    private WebElement queeList;
    @FindBy(xpath = "//input[@name='title']")
    private WebElement problemField;
    @FindBy(xpath = "//*[@id='id_body']")
    private WebElement textArea;
    @FindBy(xpath = "//select[@name='priority']/option[@value='3']")
    private WebElement priorityField;
    @FindBy(xpath = "//input[@id='id_due_date']")
    private WebElement run_up_to_field;


    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//a[text()='26']")
    private WebElement run_up_to_data;
    @FindBy(xpath = "//input[@id='id_submitter_email']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    public MainPage() {
        driver.get("https://ft-sandbox.workbench.lanit.ru/tickets/submit/");
        PageFactory.initElements(driver,this);
    }
    public MainPage createTicket(String problemValue,String textAreaValue, String emailValue){
        queeList.click();
        problemField.sendKeys(problemValue);
        textArea.sendKeys(textAreaValue);
        problemField.click();
        run_up_to_field.click();
        run_up_to_data.sendKeys(Keys.ENTER);
        emailField.sendKeys(emailValue);
        submit.sendKeys(Keys.ENTER);
        return this;
    }
}
