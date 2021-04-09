package testcase.Register;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.RegisterPage;
import testcase.BaseTest;
import utility.*;

import static utility.Log.*;
import static utility.helper.DataHelper.*;

public class RW_REGISTER_TC002 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 0, description = "Verify that user cannot create new account using Email that has been registered")
    public void TC001() {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Random data for Username, Password and PID");
        String password = getRandomPassword();
        String PID = getRandomPID();

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        info("Step #3: Input a registered email in the Email field and Input valid data for all other field");
        registerPage.registerAccount(Constants.VALID_EMAIL, password, password, PID);

        String actualRegistrationConfirmedMsg = registerPage.getRegisterErrorLabel();
        String expectedRegistrationConfirmedMsg = Messages.EMAIL_HAS_BEEN_REGISTERED;

        info("Step #4: Verify that User cannot register new account");
        Assert.assertEquals(actualRegistrationConfirmedMsg, expectedRegistrationConfirmedMsg);
    }

}
