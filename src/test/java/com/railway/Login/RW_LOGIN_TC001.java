package com.railway.Login;

import com.railway.utility.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import com.railway.TestListener;
import com.railway.page.LoginPage;
import org.testng.Assert;
import com.railway.BaseTest;
import org.testng.annotations.Test;

import static com.railway.utility.Log.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login")
public class RW_LOGIN_TC001 extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test(priority = 2, description = "Verify that user can open the Login page")
    @Story("Test verify Login page title")
    public void TC001() {
        startTestCase("RAILWAY_LOGIN_TC001");

        info("Step #1: Click on the Login tab");
        loginPage.selectOnLoginTab();

        String actualLoginTitle = loginPage.getLoginPageTitle();
        String expectedLoginTitle = Constants.TITLE_REGISTER_PAGE;

        info("VP: Verify Login page is displayed");
        Assert.assertEquals(actualLoginTitle, expectedLoginTitle);
    }
}
