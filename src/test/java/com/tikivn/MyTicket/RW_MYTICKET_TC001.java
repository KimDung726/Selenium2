package com.tikivn.MyTicket;

import com.tikivn.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.tikivn.page.BookTicketPage;
import com.tikivn.page.LoginPage;
import com.tikivn.page.MyTicketPage;
import com.tikivn.listener.TestListener;

import java.util.Hashtable;

import static com.tikivn.utility.Log.info;
import static com.tikivn.utility.Log.startTestCase;
import static com.tikivn.utility.helper.DataHelper.getDate;

@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("MyTicket")
public class RW_MYTICKET_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();

    @Test(priority = 1,
            description = "Verify that total tickets in the table must match with the message in the Note",
            dataProvider = "getDataForTest")
    @Story("Test verify total tickets match with the message in the Note")
    public void MYTICKET_TC001(Hashtable<String, String> data) {

        startTestCase("RAILWAY_MYTICKET_TC001");

        info("Step #1: Go to Login page");
        loginPage.selectOnLoginTab();

        info("Step #2: Log in with valid account");
        loginPage.login(data.get("username"), data.get("password"));

        info("Step #3: Book 1 ticket");
        bookTicketPage.selectOnBookTicketTab();
        String bookingDate = getDate(data.get("Number of days from the current"));
        bookTicketPage.bookTicket(bookingDate, data.get("Depart from"), data.get("Arrive at"), data.get("Seat type"), data.get("Ticket amount"));
        bookTicketPage.clickOnBookTicketBtn();

        info("Step #4: Open the My Ticket page");
        myTicketPage.selectOnMyTicketTab();

        info("Get total tickets in Note and Table");
        int actualTotalTicketInTable = myTicketPage.getTotalTicketInTable();
        int expectedTotalNewTicketInNote = myTicketPage.getTotalNewTicketInNote();

        info("VP: The total tickets match the message");
        Assert.assertEquals(actualTotalTicketInTable, expectedTotalNewTicketInNote);
    }
}


