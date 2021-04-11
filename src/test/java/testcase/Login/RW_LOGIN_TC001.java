package testcase.Login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import testcase.TestListener;
import utility.*;
import page.LoginPage;
import org.testng.Assert;
import testcase.BaseTest;
import org.testng.annotations.Test;

import static utility.Log.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login tests")
public class RW_LOGIN_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 1, description = "Verify that user can open the Login page")
    @Story("Login Page check")
    public void TC001() {
        startTestCase("RAILWAY_LOGIN_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Login tab");
        loginPage.selectOnLoginTab();

        String actualLoginTitle = loginPage.getLoginTitlePage();
        String expectedLoginTitle = Constants.TITLE_LOGIN_PAGE;

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
    }
}
