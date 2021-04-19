package testcase.MyTicket;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.LoginPage;
import page.MyTicketPage;
import testcase.BaseTest;
import testcase.TestListener;
import utility.Constants;

import static utility.Log.info;
import static utility.Log.startTestCase;
import static utility.helper.DataHelper.getDate;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("MyTicket")
public class RW_MYTICKET_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(priority = 1, description = "Verify that total tickets in the table must match with the message in the Note")
    @Story("Test verify total tickets match with the message in the Note")
    public void TC001() {
        startTestCase("RAILWAY_MYTICKET_TC001");

        info("Step #1: Go to Login page");
        loginPage.selectOnLoginTab();

        info("Step #2: Log in with valid account");
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);

        info("Step #3: Book 1 ticket");
        bookTicketPage.selectOnBookTicketTab();
        String bookingDate = getDate(Constants.NUMBER_OF_DAYS_FROM_THE_CURRENT);
        bookTicketPage.bookTicket(bookingDate);

        info("Step #4: Open the My Ticket page");
        myTicketPage.selectOnMyTicketTab();

        info("Get total tickets in Note and Table");
        int actualTotalTicketInTable = myTicketPage.getTotalTicketInTable();
        int expectedTotalNewTicketInNote = myTicketPage.getTotalNewTicketInNote();

        info("Step #5:  Compare the total new tickets with the message in the Note");
        Assert.assertEquals(actualTotalTicketInTable, expectedTotalNewTicketInNote);
    }
}


