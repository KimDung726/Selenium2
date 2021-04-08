package testcase.Login;

import utility.*;
import page.LoginPage;
import testcase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utility.Log.*;

public class RW_LOGIN_TC003 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 0, description = "User can NOT login with blank 'Username' text box.")
    public void TC003() {

        startTestCase("RAILWAY_LOGIN_TC003");

        info("Step #1: Navigate to Railway Page and select LoginTab");
        loginPage.selectOnLoginTab();

        info("Step #2: Login with blank Email and valid Password");
        loginPage.login("", Constants.VALID_PASSWORD);

        String actualLoginErrorMsg = loginPage.getLoginError();
        String expectedLoginErrorMsg = Messages.MISSING_DATA_IN_LOGIN_FORM;

        info("Step #3: Verify that Actual Login error message same as Expected Login error message.");
        Assert.assertEquals(actualLoginErrorMsg, expectedLoginErrorMsg);
    }
}
