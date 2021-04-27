package com.tikivn.Register;

import com.tikivn.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tikivn.page.RegisterPage;

import java.util.Hashtable;

import static com.tikivn.utility.Log.*;

@Epic("Regression Tests")
@Feature("Register")
public class RW_REGISTER_TC001 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 1,
            description = "Verify that user can open the Register page",
            dataProvider = "getDataForTest")
    @Story("Register Page check")
    public void REGISTER_TC001(Hashtable<String, String> data) {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        String actualRegisterTitle = registerPage.getRegisterPageTitle();
        String expectedRegisterTitle = data.get("Title Register page");

        info("Step #3: Observe the destination page");
        Assert.assertEquals(actualRegisterTitle, expectedRegisterTitle);
    }
}
