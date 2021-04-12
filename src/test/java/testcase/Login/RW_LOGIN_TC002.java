package testcase.Login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import page.RegisterPage;
import testcase.TestListener;
import utility.*;
import page.LoginPage;
import testcase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utility.Log.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login")
public class RW_LOGIN_TC002 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 1, description = "Verify that clicking on the hyperlink text \"registration page\" will redirect to the Register page")
    @Story("Clicking on the register hyperlink will redirect to the Register Page")
    public void TC002() {

        startTestCase("RAILWAY_LOGIN_TC002");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Login tab");
        loginPage.selectOnLoginTab();

        info("Step #3: Click on the hyperlink text \"registration page\"");
        loginPage.clickOnRegistrationPageLink();

        String actualRegisterTitle = registerPage.getRegisterTitlePage();
        String expectedRegisterTitle = Constants.TITLE_REGISTER_PAGE;

        info("Step #4: Verify that User is redirected to the Register page");
        Assert.assertEquals(actualRegisterTitle, expectedRegisterTitle);
    }
}
