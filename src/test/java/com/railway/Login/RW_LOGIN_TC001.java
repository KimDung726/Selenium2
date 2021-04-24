package com.railway.Login;

import com.railway.utility.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import com.railway.listener.TestListener;
import com.railway.page.LoginPage;
import org.testng.Assert;
import com.railway.BaseTest;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.railway.utility.Log.*;

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
