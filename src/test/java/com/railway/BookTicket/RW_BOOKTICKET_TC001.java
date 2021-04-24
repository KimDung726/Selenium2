package com.railway.BookTicket;

import com.railway.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.railway.page.BookTicketPage;
import com.railway.page.LoginPage;
import com.railway.listener.TestListener;
import com.railway.utility.Constants;

import java.util.Hashtable;
import java.util.List;

import static com.railway.utility.Log.info;
import static com.railway.utility.Log.startTestCase;
import static com.railway.utility.helper.DataHelper.*;

@Epic("Regression Tests")
@Feature("BookTicket")
public class RW_BOOKTICKET_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(priority = 1,
            description = "Verify that the 'Ticket booked successfully!' page displays correct information",
            dataProvider = "getDataForTest")
    @Story("Test verify Ticket booked successfully")
    public void BOOKTICKET_TC001(Hashtable<String, String> data) {

        startTestCase("RAILWAY_BOOKTICKET_TC001");

        info("Step #1: Go to Login page");
        loginPage.selectOnLoginTab();

        info("Step #2: Log in with valid account");
        loginPage.login(data.get("username"), data.get("password"));

        info("Step #3: Go to Book Ticket page");
        bookTicketPage.selectOnBookTicketTab();

        info("Step #4:  Book 1 ticket");
        String bookingDate = getDate(data.get("Number of days from the current"));
        bookTicketPage.bookTicket(bookingDate, data.get("Depart from"),
                data.get("Arrive at"), data.get("Seat type"), data.get("Ticket amount"));

        info("Get information of ticket before book.");
        List<String> ticketInfoBeforeBook = bookTicketPage.getTicketInfoBeforeBook();

        info("Click on Book Ticket button");
        bookTicketPage.clickOnBookTicketBtn();

        info("Get information of ticket after book.");
        List<String> ticketInfoAfterBook = bookTicketPage.getTicketInfoAfterBookSuccessfully();

        info("VP: Verify the ticket information matches with the booking data");
        Assert.assertEquals(ticketInfoBeforeBook, ticketInfoAfterBook);

        info("VP: Verify the PID/Passport number must be the one used for registered");
        Assert.assertEquals(bookTicketPage.getTextPid(), data.get("pid"));
    }
}

