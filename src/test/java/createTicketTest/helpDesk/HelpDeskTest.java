package createTicketTest.helpDesk;


import createTicketTest.core.BaseSeleniumTest;
import org.junit.Test;

public class HelpDeskTest extends BaseSeleniumTest {
@Test
    public void checkTicket(){
    String title = "Виктор Пупкин 1 проблема";
    String textArea= "сообщение в техподдержку";
    String email ="vasja@mail.ru";
    MainPage mainPage = new MainPage();
    mainPage.createTicket(title,textArea,email);
}
}
