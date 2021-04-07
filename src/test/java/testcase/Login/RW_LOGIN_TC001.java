package testcase.Login;

import utility.*;
import page.LoginPage;
import org.testng.Assert;
import testcase.BaseTest;
import org.testng.annotations.Test;

import static utility.Log.*;

public class RW_LOGIN_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 0, description = "Verify that User can login successfully with valid data for all fields")
    public void TC001() {

        startTestCase("RAILWAY_LOGIN_TC001");

        info("Step #1: Navigate to Railway Page and select LoginTab");
        loginPage.selectOnLoginTab();

        info("Step #2: Login with valid username and password");
        loginPage.login(Constants.VALID_EMAIL, Constants.VALID_PASSWORD);

        info("Step #3: Verify that Actual WelcomeUser message same as Expected WelcomeUser message.");
        String actualWelcomeUserMsg = loginPage.getWelcomeMessage();
        String expectedWelcomeUserMsg = Constants.WELCOME_USER;
        Assert.assertEquals(actualWelcomeUserMsg, expectedWelcomeUserMsg);
    }
}
