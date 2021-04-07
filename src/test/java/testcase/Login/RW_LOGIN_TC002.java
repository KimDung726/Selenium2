package testcase.Login;

import utility.*;
import page.LoginPage;
import testcase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utility.Log.*;

public class RW_LOGIN_TC002 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 0, description = "System shows message when user enters wrong password several times.")
    public void TC002() {

        startTestCase("RAILWAY_LOGIN_TC002");

        info("Step #1: Navigate to Railway Page and select LoginTab");
        loginPage.selectOnLoginTab();

        info("Step #2: Login with valid username and invalid Password several times");
        loginPage.loginSeveralTimes(Constants.VALID_EMAIL, Constants.INVALID_PASSWORD, Constants.RUNNING_INTERVAL);

        info("Step #3: Verify that Actual Login error message same as Expected Login error message.");
        String actualLoginErrorMsg = loginPage.getLoginError();
        String expectedLoginErrorMsg = Messages.LOGIN_FAILED;
        Assert.assertEquals(actualLoginErrorMsg, expectedLoginErrorMsg);
    }
}
