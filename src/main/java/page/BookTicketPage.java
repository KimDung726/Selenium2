package page;

import control.Button;
import control.ComboBox;
import control.Link;
import io.qameta.allure.Step;
import utility.Constants;

import java.util.ArrayList;
import java.util.List;

public class BookTicketPage extends BasePage {

    ComboBox _cbbDepartDate = new ComboBox("css=li>select[name='Date']");
    ComboBox _cbbDepartFrom = new ComboBox("css=select[name='DepartStation']");
    ComboBox _cbbArriveAt = new ComboBox("css=select[name='ArriveStation']");
    ComboBox _cbbSeatType = new ComboBox("css=select[name='SeatType']");
    ComboBox _cbbTicketAmount = new ComboBox("css=select[name='TicketAmount']");
    Link ticketInfo = new Link("css=table.MyTable.WideTable tr.OddRow td");
    Button _btnBookTicket = new Button("css=input[value='Book ticket'][type='submit']");

    @Step("Click on the BookTicket tab")
    public void selectOnBookTicketTab() {
        selectOnTab(Constants.BOOK_TICKET_TAB);
    }

    @Step("Book Ticket")
    public void bookTicket(String date) {
        clickOnDate(date);
        _btnBookTicket.click();
    }

    @Step("Book Ticket Several Times")
    public void bookTicketSeveralTimes(int time, String date) {
        for (int i = 0; i <= time; i++) {
            selectOnTab(Constants.BOOK_TICKET_TAB);
            bookTicket(date);
        }
    }

    public void clickOnDate(String date) {
        _cbbDepartDate.scrollToElement();
        _cbbDepartDate.select(date);
    }

    public List<String> getTicketInfoBeforeBook() {
        List<String> bookingInfo = new ArrayList<String>();

        bookingInfo.add(_cbbDepartFrom.getFirstSelectedOption());
        bookingInfo.add(_cbbArriveAt.getFirstSelectedOption());
        bookingInfo.add(_cbbSeatType.getFirstSelectedOption());
        bookingInfo.add(_cbbTicketAmount.getFirstSelectedOption());

        return bookingInfo;
    }

    public List<String> getTicketInfoAfterBookSuccessfully() {
        List<String> bookingInfo = new ArrayList<String>();

        ticketInfo.getText();

        return bookingInfo;
    }
}
