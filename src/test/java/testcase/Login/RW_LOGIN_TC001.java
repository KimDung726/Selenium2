package testcase.Login;

import page.HomePage;
import page.LoginPage;
import utility.*;
import org.testng.Assert;
import testcase.BaseTest;
import org.testng.annotations.Test;

import static utility.Log.*;

public class RW_LOGIN_TC001 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(priority = 0, description = "Check User can login successfully with valid data for all fields")
    public void TC001() {

        startTestCase("TC_RAILWAY_LOGIN_001");

        info("Step #1: Navigate to Railway Page and select LoginTab");
        homePage.selectOnTab(Constants.LOGIN_TAB);

        info("Step #2: Login with valid username and password");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        info("Step #3: Verify that Dashboard Homepage appears");
    }
}
