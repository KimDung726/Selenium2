package com.railway.MyTicket;

import com.railway.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.railway.page.BookTicketPage;
import com.railway.page.LoginPage;
import com.railway.page.MyTicketPage;
import com.railway.listener.TestListener;
import com.railway.utility.Constants;

import static com.railway.utility.Log.info;
import static com.railway.utility.Log.startTestCase;
import static com.railway.utility.helper.DataHelper.getDate;

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
        bookTicketPage.bookTicket(bookingDate, Constants.NHA_TRANG, Constants.HUE, Constants.SOFT_SEAT, Constants.NUMBER_1);
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


