package testcase.Login;

import page.HomePage;
import page.LoginPage;
import utility.*;
import org.testng.Assert;
import testcase.BaseTest;
import org.testng.annotations.Test;

public class RW_LOGIN_TC001 extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test(description = "Check User can login successfully with valid data for all fields")
    public void TC001() {

        Log.info("Step #1: Navigate to Railway Page");

        Log.info("Step #2: Select LoginTab");

        Log.info("Step #3: Login with valid username and password");
        loginPage.login(Constants.USERNAME, Constants.PASSWORD);

        Log.info("Step #4: Verify that Dashboard Homepage appears");
    }
}
