package com.tikivn.page;

import com.tikivn.control.Link;
import com.tikivn.control.Table;
import io.qameta.allure.Step;
import com.tikivn.utility.Constants;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTicketPage extends BasePage {
    Link totalNewTicketInNote = new Link("//div[@class='message']//li[contains(.,'currently book')]");
    Table tableManageTicket = new Table("css=.MyTable");

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

    @Step("VP: Get total Ticket in Manage Ticket Table")
    public int getTotalTicketInTable() {
        int amountTickets = 0;

        ArrayList<String> amountValues = tableManageTicket.getValueOfColumnsById(Constants.POSITION_OF_AMOUNT_IN_MYTICKET);
        for (String value : amountValues) {
            amountTickets += Integer.parseInt(value);
        }
        return amountTickets;
    }

    @Step("VP: Get information of Newly ticket in Manage table")
    public ArrayList<String> getInfoBookingNewlyTicket() {

        ArrayList<Integer> options = new ArrayList<Integer>();
        options.add(Constants.POSITION_OF_DEPART_FROM_IN_MYTICKET);
        options.add(Constants.POSITION_OF_ARRIVE_AT_IN_MYTICKET);
        options.add(Constants.POSITION_OF_SEAT_TYPE_IN_MYTICKET);
        options.add(Constants.POSITION_OF_DEPART_DATE_IN_MYTICKET);
        options.add(Constants.POSITION_OF_AMOUNT_IN_MYTICKET);
        options.add(Constants.POSITION_OF_BOOK_DATE_IN_MYTICKET);
        options.add(Constants.POSITION_OF_EXPIRED_DATE_IN_MYTICKET);
        options.add(Constants.POSITION_OF_TOTAL_PRICE_IN_MYTICKET);

        return tableManageTicket.getValueColumnInRowById(2, options);
    }
}
