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

    @Test(priority = 0, description = "Verify that user can open the Register page")
    public void TC001() {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        String actualRegistrationConfirmedMsg = registerPage.getTitleRegisterPage();
        String expectedRegistrationConfirmedMsg = Constants.TITLE_REGISTER_PAGE;

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualRegistrationConfirmedMsg, expectedRegistrationConfirmedMsg);
    }

}
