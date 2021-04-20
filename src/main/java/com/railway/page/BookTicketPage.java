package com.railway.page;

import com.railway.control.Button;
import com.railway.control.ComboBox;
import com.railway.control.Link;
import com.railway.utility.Constants;
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
    Link departStationInfoAfterBook = new Link("//table[@class='MyTable WideTable']//tr[@class='OddRow']/td[1]");
    Link arriveStationInfoAfterBook = new Link("//table[@class='MyTable WideTable']//tr[@class='OddRow']/td[2]");
    Link seatTypeInfoAfterBook = new Link("//table[@class='MyTable WideTable']//tr[@class='OddRow']/td[3]");
    Link departDateInfoAfterBook = new Link("//table[@class='MyTable WideTable']//tr[@class='OddRow']/td[4]");
    Link amountInfoAfterBook = new Link("//table[@class='MyTable WideTable']//tr[@class='OddRow']/td[7]");
    Link infoAfterBookTicket = new Link("css=.MyTable .TableSmallHeader + tr");
    Button btnBookTicket = new Button("css=input[value='Book ticket'][type='submit']");

    @Step("Click on the BookTicket tab")
    public void selectOnBookTicketTab() {
        selectOnTab(Constants.BOOK_TICKET_TAB);
    }

    @Step("Book Ticket")
    public void bookTicket(String date, String departFrom, String arriveAt, String seatType, int ticketAmount) {
        clickOnDate(date);
        cbbDepartFrom.select(departFrom);
        cbbArriveAt.select(arriveAt);
        cbbSeatType.select(seatType);
        cbbTicketAmount.select(Integer.toString(ticketAmount));
    }

    @Step("Click on Book Ticket button")
    public void clickOnBookTicketBtn() {
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
        bookingInfo.add(cbbTicketAmount.getFirstSelectedOption());
        bookingInfo.add(cbbDepartDate.getFirstSelectedOption());

        return bookingInfo;
    }

    @Step("VP: Get information of ticket after book")
    public List<String> getTicketInfoAfterBookSuccessfully() {
        List<String> bookingInfo = new ArrayList<String>();

        bookingInfo.add(departStationInfoAfterBook.getText());
        bookingInfo.add(arriveStationInfoAfterBook.getText());
        bookingInfo.add(seatTypeInfoAfterBook.getText());
        bookingInfo.add(amountInfoAfterBook.getText());
        bookingInfo.add(departDateInfoAfterBook.getText());

        return bookingInfo;
    }

    @Step("VP: Get information of ticket in table after book.")
    public String getInfoAfterBookTicket() {
        return infoAfterBookTicket.getText();
    }
}
