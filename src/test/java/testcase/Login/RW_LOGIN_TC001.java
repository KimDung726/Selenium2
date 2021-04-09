package testcase.Login;

import utility.*;
import page.LoginPage;
import org.testng.Assert;
import testcase.BaseTest;
import org.testng.annotations.Test;

import static utility.Log.*;

public class RW_LOGIN_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 0, description = "Verify that user can open the Login page")
    public void TC001() {

        startTestCase("RAILWAY_LOGIN_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Login tab");
        loginPage.selectOnLoginTab();

        String actualRegistrationConfirmedMsg = loginPage.getTitleLoginPage();
        String expectedRegistrationConfirmedMsg = Constants.TITLE_LOGIN_PAGE;

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualRegistrationConfirmedMsg, expectedRegistrationConfirmedMsg);

    }
}
