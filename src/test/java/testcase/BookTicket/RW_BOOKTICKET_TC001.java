package testcase.BookTicket;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.BookTicketPage;
import page.LoginPage;
import testcase.BaseTest;
import testcase.TestListener;
import utility.Constants;

import java.util.List;

import static utility.Log.info;
import static utility.Log.startTestCase;
import static utility.helper.DataHelper.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("BookTicket")
public class RW_BOOKTICKET_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(priority = 1, description = "Verify that the \"Ticket booked successfully!\" page displays correct information")
    public void TC001() {

        startTestCase("RAILWAY_BOOKTICKET_TC001");

        info("Pre-Condition: User is logged in");
        loginPage.selectOnLoginTab();
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);

        info("Step #1 + #2: Navigate to Railway Page and Click on the BookTicket tab");
        bookTicketPage.selectOnBookTicketTab();

        info("Get information of ticket before book.");
        String bookingDate = getDate(Constants.NUMBER_OF_DAYS_FROM_THE_CURRENT);
        List<String> ticketInfoBeforeBook = bookTicketPage.getTicketInfoBeforeBook(bookingDate);

        info("Step #3:  Book ticket(s) successfully");
        bookTicketPage.bookTicket(bookingDate);

        info("Get information of ticket after book.");
        List<String> ticketInfoAfterBook = bookTicketPage.getTicketInfoAfterBookSuccessfully();

        info("Step #4:  Observe information in the \"Ticket booked successfully!\" page");
        Assert.assertEquals(ticketInfoBeforeBook, ticketInfoAfterBook);
    }
}

