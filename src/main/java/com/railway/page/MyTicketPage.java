package com.railway.page;

import com.railway.control.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import com.railway.utility.Constants;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTicketPage extends BasePage {
    Link totalNewTicketInNote = new Link("//div[@class='message']//li[contains(.,'currently book')]");
    Link totalTicketInTable = new Link("//tr[@class='TableSmallHeader']/..//following-sibling::tr/td[position()=9]");
    Link infoBookingNewlyTicket = new Link("css=.MyTable .TableSmallHeader + tr");

    @Step("Click on the MyTicket tab")
    public void selectOnMyTicketTab() {
        selectOnTab(Constants.MY_TICKET_TAB);
    }

    @Step("VP: Get total New Ticket in Note")
    public int getTotalNewTicketInNote() {
        String amountTickets = "";

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(totalNewTicketInNote.getText());
        while (m.find()) {
            amountTickets = m.group();
            break;
        }

        return Integer.parseInt(amountTickets);
    }

    @Step("VP: Get total Ticket in Table")
    public int getTotalTicketInTable() {
        int amountTickets = 0;
        List<WebElement> totalTickets = totalTicketInTable.totalElements();

        for (WebElement element : totalTickets) {
            amountTickets += Integer.parseInt(element.getText());
        }
        return amountTickets;
    }

    @Step("VP: Get information of Newly ticket in table after book.")
    public String getInfoBookingNewlyTicket() {
        String infoTicket = infoBookingNewlyTicket.getText();
        infoTicket = infoTicket.substring(2, infoTicket.length());
        infoTicket = infoTicket.replace(" New", "");

        return infoTicket;
    }

}
