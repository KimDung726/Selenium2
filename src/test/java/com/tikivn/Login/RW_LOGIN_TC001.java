package com.tikivn.Login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import com.tikivn.page.LoginPage;
import org.testng.Assert;
import com.tikivn.BaseTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.tikivn.utility.Log.*;

@Epic("Regression Tests")
@Feature("Login")
public class RW_LOGIN_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 2,
            description = "Verify that user can open the Login page",
            dataProvider = "getDataForTest")
    @Story("Test verify Login page title")
    public void LOGIN_TC001(Hashtable<String, String> data) {
        startTestCase("RAILWAY_LOGIN_TC001");

        info("Step #1: Click on the Login tab");
        loginPage.selectOnLoginTab();

        String actualLoginTitle = loginPage.getLoginPageTitle();
        String expectedLoginTitle = data.get("Title Login page");

        info("VP: Verify Login page is displayed");
        Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
    }
}
