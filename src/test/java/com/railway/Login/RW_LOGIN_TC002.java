package com.railway.Login;

import com.railway.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import com.railway.page.RegisterPage;
import com.railway.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.railway.utility.Log.*;

@Epic("Regression Tests")
@Feature("Login")
public class RW_LOGIN_TC002 extends BaseTest {

    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 3,
            description = "Verify that clicking on the hyperlink text 'registration page' will redirect to the Register page",
            dataProvider = "getDataForTest")
    @Story("Test verify Register page title")
    public void LOGIN_TC002(Hashtable<String, String> data) {

        startTestCase("RAILWAY_LOGIN_TC002");

        info("Step #1: Click on the Login tab");
        loginPage.selectOnLoginTab();

        info("Step #2: Click on the hyperlink text 'registration page'");
        loginPage.clickOnRegistrationPageLink();

        String actualRegisterTitle = registerPage.getRegisterPageTitle();
        String expectedRegisterTitle = data.get("Title Register page");

        info("VP: Verify Register page is displayed");
        Assert.assertEquals(actualRegisterTitle, expectedRegisterTitle);
    }
}
