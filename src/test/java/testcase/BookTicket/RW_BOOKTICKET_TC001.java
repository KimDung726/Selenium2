package testcase.BookTicket;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

    @Test(priority = 1, description = "Verify that the 'Ticket booked successfully!' page displays correct information")
    @Story("Test verify Ticket booked successfully")
    public void TC001() {

        startTestCase("RAILWAY_BOOKTICKET_TC001");

        info("Step #1: Go to Login page");
        loginPage.selectOnLoginTab();

        info("Step #2: Log in with valid account");
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);

        info("Step #3: Go to Book Ticket page");
        bookTicketPage.selectOnBookTicketTab();

        info("Step #4:  Book 1 ticket");
        String bookingDate = getDate(Constants.NUMBER_OF_DAYS_FROM_THE_CURRENT);
        bookTicketPage.bookTicket(bookingDate, Constants.NHA_TRANG, Constants.HUE, Constants.SOFT_SEAT, Constants.NUMBER_1);

        info("Get information of ticket before book.");
        List<String> ticketInfoBeforeBook = bookTicketPage.getTicketInfoBeforeBook();

        info("Click on Book Ticket button");
        bookTicketPage.clickOnBookTicketBtn();

        info("Get information of ticket after book.");
        List<String> ticketInfoAfterBook = bookTicketPage.getTicketInfoAfterBookSuccessfully();

        info("VP: Verify the ticket information matches with the booking data");
        Assert.assertEquals(ticketInfoBeforeBook, ticketInfoAfterBook);

        info("VP: Verify the PID/Passport number must be the one used for registered");
        Assert.assertEquals(bookTicketPage.getTextPid(), Constants.PID_NUMBER);
    }
}

