package testcase.MyTicket;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MyTicketPage;
import testcase.BaseTest;
import testcase.TestListener;
import utility.Constants;

import static utility.Log.info;
import static utility.Log.startTestCase;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("MyTicket")
public class RW_MYTICKET_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(priority = 1, description = "Verify that total tickets in the table must match with the message in the Note")
    @Story("Login Page check")
    public void TC001() {
        startTestCase("RAILWAY_MYTICKET_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Login tab");
        loginPage.selectOnLoginTab();

        String actualLoginTitle = loginPage.getLoginTitlePage();
        String expectedLoginTitle = Constants.TITLE_REGISTER_PAGE;

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
    }
}


