package com.tikivn.MyTicket;

import com.tikivn.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tikivn.page.BookTicketPage;
import com.tikivn.page.LoginPage;
import com.tikivn.page.MyTicketPage;

import java.util.ArrayList;
import java.util.Hashtable;

import static com.tikivn.utility.Log.info;
import static com.tikivn.utility.Log.startTestCase;
import static com.tikivn.utility.helper.DataHelper.getDate;

@Epic("Regression Tests")
@Feature("MyTicket")
public class RW_MYTICKET_TC002 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(priority = 1,
            description = "Verify that booking newly ticket does not make old booked ticket disappear",
            dataProvider = "getDataForTest")
    @Story("Test verify booking newly ticket does not make old booked ticket disappear")
    public void MYTICKET_TC002(Hashtable<String, String> data) {
        startTestCase("RAILWAY_MYTICKET_TC002");

        info("Step #1: Go to Login page");
        loginPage.selectOnLoginTab();

        info("Step #2: Log in with valid account");
        loginPage.login(data.get("username"), data.get("password"));

        info("Step #3: Book 1 ticket");
        bookTicketPage.selectOnBookTicketTab();
        String bookingDate = getDate(data.get("Number of days from the current"));
        bookTicketPage.bookTicket(bookingDate, data.get("Depart from"), data.get("Arrive at"), data.get("Seat type"), data.get("Ticket amount"));
        bookTicketPage.clickOnBookTicketBtn();

        info("Get information of ticket in table after book.");
        ArrayList<String> infoAfterBookTicket = bookTicketPage.getInfoAfterBookTicket();

        info("Step #4: Open the My Ticket page");
        myTicketPage.selectOnMyTicketTab();

        info("Get information of Newly ticket in table after book.");
        ArrayList<String> infoBookingNewlyTicket = myTicketPage.getInfoBookingNewlyTicket();

        info("VP: The ticket table must display all booked and expired tickets");
        Assert.assertEquals(infoAfterBookTicket, infoBookingNewlyTicket);
    }
}


