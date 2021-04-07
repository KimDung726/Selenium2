package testcase.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegisterPage;
import testcase.BaseTest;
import utility.*;

import static utility.Log.*;
import static utility.helper.DataHelper.*;

public class RW_REGISTER_TC001 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 0, description = "User can create new account")
    public void TC001() {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Step #1: Random data for Username, Password and PID");
        String username = getRandomEmail();
        String password = getRandomPassword();
        String PID = getRandomPID();

        info("Step #2: Navigate to Railway Page and select RegisterTab");
        registerPage.selectOnRegisterTab();

        info("Step #3: Register a new account");
        registerPage.registerAccount(username, password, password, PID);

        info("Step #4: Verify that Actual Registration Confirmed message same as Expected Registration Confirmed message");
        String actualRegistrationConfirmedMsg = registerPage.getRegistrationConfirmedText();
        String expectedRegistrationConfirmedMsg = Messages.REGISTER_SUCCESSFULLY;
        Assert.assertEquals(actualRegistrationConfirmedMsg, expectedRegistrationConfirmedMsg);
    }

}
