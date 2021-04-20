package com.railway.Login;

import com.railway.BaseTest;
import com.railway.TestListener;
import com.railway.utility.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import com.railway.page.RegisterPage;
import com.railway.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.railway.utility.Log.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login")
public class RW_LOGIN_TC002 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 3, description = "Verify that clicking on the hyperlink text 'registration page' will redirect to the Register page")
    @Story("Test verify Register page title")
    public void TC002() {

        startTestCase("RAILWAY_LOGIN_TC002");

        info("Step #1: Click on the Login tab");
        loginPage.selectOnLoginTab();

        info("Step #2: Click on the hyperlink text 'registration page'");
        loginPage.clickOnRegistrationPageLink();

        String actualRegisterTitle = registerPage.getRegisterPageTitle();
        String expectedRegisterTitle = Constants.TITLE_LOGIN_PAGE;

        info("VP: Verify Register page is displayed");
        Assert.assertEquals(actualRegisterTitle, expectedRegisterTitle);
    }
}
