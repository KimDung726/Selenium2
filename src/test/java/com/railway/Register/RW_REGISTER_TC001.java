package com.railway.Register;

import com.railway.BaseTest;
import com.railway.listener.TestListener;
import com.railway.utility.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.railway.page.RegisterPage;

import static com.railway.utility.Log.*;

@Epic("Regression Tests")
@Feature("Register")
public class RW_REGISTER_TC001 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 1, description = "Verify that user can open the Register page")
    @Story("Register Page check")
    public void TC001() {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        String actualRegisterTitle = registerPage.getRegisterPageTitle();
        String expectedRegisterTitle = Constants.TITLE_REGISTER_PAGE;

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualRegisterTitle, expectedRegisterTitle);
    }

}
