package com.tikivn.page;

import com.tikivn.control.Button;
import com.tikivn.control.ComboBox;
import com.tikivn.control.Link;
import com.tikivn.control.Table;
import com.tikivn.utility.Constants;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends BasePage {

    ComboBox cbbDepartDate = new ComboBox("css=li>select[name='Date']");
    ComboBox cbbDepartFrom = new ComboBox("css=select[name='DepartStation']");
    ComboBox cbbArriveAt = new ComboBox("css=select[name='ArriveStation']");
    ComboBox cbbSeatType = new ComboBox("css=select[name='SeatType']");
    ComboBox cbbTicketAmount = new ComboBox("css=select[name='TicketAmount']");
    Link lblPid = new Link("css=#content li:last-child strong:last-child");
    Table tableAfterBookTicket = new Table("css=.MyTable.WideTable");
    Button btnBookTicket = new Button("css=input[value='Book ticket'][type='submit']");

    @Step("Click on the BookTicket tab")
    public void selectOnBookTicketTab() {
        selectOnTab(Constants.BOOK_TICKET_TAB);
    }

    @Step("Book Ticket")
    public void bookTicket(String date, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        clickOnDate(date);
        cbbDepartFrom.select(departFrom);
        cbbArriveAt.select(arriveAt);
        cbbSeatType.select(seatType);
        cbbTicketAmount.select(ticketAmount);
    }

    @Step("Click on Book Ticket button")
    public void clickOnBookTicketBtn() {
        btnBookTicket.scrollToElement();
        btnBookTicket.click();
    }

    @Step("Select date")
    public void clickOnDate(String date) {
        cbbDepartDate.scrollToElement();
        cbbDepartDate.select(date);
    }

    @Step("VP: Get PID number")
    public String getTextPid() {
        return lblPid.getText();
    }

    @Step("VP: Get information of ticket before book")
    public List<String> getTicketInfoBeforeBook() {

        List<String> bookingInfo = new ArrayList<String>();
        bookingInfo.add(cbbDepartFrom.getFirstSelectedOption());
        bookingInfo.add(cbbArriveAt.getFirstSelectedOption());
        bookingInfo.add(cbbSeatType.getFirstSelectedOption());
        bookingInfo.add(cbbDepartDate.getFirstSelectedOption());
        bookingInfo.add(cbbTicketAmount.getFirstSelectedOption());

        return bookingInfo;
    }

    @Step("VP: Get information of ticket after book (any options)")
    public ArrayList<String> getTicketInfoAfterBookSuccessfully() {

        ArrayList<Integer> options = new ArrayList<Integer>();
        options.add(Constants.POSITION_OF_DEPART_FROM_IN_BOOKTICKET);
        options.add(Constants.POSITION_OF_ARRIVE_AT_IN_BOOKTICKET);
        options.add(Constants.POSITION_OF_SEAT_TYPE_IN_BOOKTICKET);
        options.add(Constants.POSITION_OF_DEPART_DATE_IN_BOOKTICKET);
        options.add(Constants.POSITION_OF_AMOUNT_IN_BOOKTICKET);

        return tableAfterBookTicket.getValueColumnInRowById(2, options);
    }

    @Step("VP: Get information of ticket after book (full options)")
    public ArrayList<String> getInfoAfterBookTicket() {

        ArrayList<Integer> options = new ArrayList<Integer>();
        options.add(Constants.POSITION_OF_BOOK_DATE_IN_BOOKTICKET);
        options.add(Constants.POSITION_OF_EXPIRED_DATE_BOOKTICKET);
        options.add(Constants.POSITION_OF_TOTAL_PRICE_IN_BOOKTICKET);
        ArrayList<String> infoAdd = tableAfterBookTicket.getValueColumnInRowById(2, options);

        ArrayList<String> ticket = getTicketInfoAfterBookSuccessfully();
        for (String info : infoAdd) {
            ticket.add(info);
        }

        return ticket;
    }

}
