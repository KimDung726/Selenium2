package page;

import control.Link;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utility.Constants;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTicketPage extends BasePage {
    Link totalNewTicketInNote = new Link("//div[@class='message']//li[contains(.,'currently book')]");
    Link totalTicketInTable = new Link("//tr[@class='TableSmallHeader']/..//following-sibling::tr/td[position()=9]");

    @Step("Click on the MyTicket tab")
    public void selectOnMyTicketTab() {
        selectOnTab(Constants.MY_TICKET_TAB);
    }

    @Step("Get total New Ticket in Note")
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

    @Step("Get total Ticket in Table")
    public int getTotalTicketInTable() {
        int amountTickets = 0;
        List<WebElement> totalTickets = totalTicketInTable.totalElements();

        for (WebElement element : totalTickets) {
            amountTickets += Integer.parseInt(element.getText());
        }
        return amountTickets;
    }


}
