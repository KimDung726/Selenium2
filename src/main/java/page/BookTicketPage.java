package page;

import control.Button;
import control.ComboBox;
import control.Link;
import io.qameta.allure.Step;
import utility.Constants;

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
    Button btnBookTicket = new Button("css=input[value='Book ticket'][type='submit']");

    @Step("Click on the BookTicket tab")
    public void selectOnBookTicketTab() {
        selectOnTab(Constants.BOOK_TICKET_TAB);
    }

    @Step("Book Ticket: date [{0}]")
    public void bookTicket(String date) {
        clickOnDate(date);
        btnBookTicket.click();
    }

    @Step("Book Ticket Several Times: date [{1}], times [{0}]")
    public void bookTicketSeveralTimes(int time, String date) {
        for (int i = 0; i <= time; i++) {
            selectOnTab(Constants.BOOK_TICKET_TAB);
            bookTicket(date);
        }
    }

    @Step("Select date: {0}")
    public void clickOnDate(String date) {
        cbbDepartDate.scrollToElement();
        cbbDepartDate.select(date);
    }

    @Step("VP: Get PID number")
    public String getTextPid() {
        return lblPid.getText();
    }

    @Step("VP: Get information of ticket before book")
    public List<String> getTicketInfoBeforeBook(String date) {
        List<String> bookingInfo = new ArrayList<String>();

        bookingInfo.add(cbbDepartFrom.getFirstSelectedOption());
        bookingInfo.add(cbbArriveAt.getFirstSelectedOption());
        bookingInfo.add(cbbSeatType.getFirstSelectedOption());
        bookingInfo.add(cbbTicketAmount.getFirstSelectedOption());
        bookingInfo.add(date);

        return bookingInfo;
    }

    @Step("Get amount of ticket after book")
    public int getAmountTickets(){
        return Integer.parseInt(amountInfoAfterBook.getText());
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
}
