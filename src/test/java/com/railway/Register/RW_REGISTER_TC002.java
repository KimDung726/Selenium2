package com.railway.Register;

import com.railway.BaseTest;
import com.railway.utility.Constants;
import com.railway.utility.Messages;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.railway.page.RegisterPage;
import com.railway.listener.TestListener;

import java.util.Hashtable;

import static com.railway.utility.Log.*;
import static com.railway.utility.helper.DataHelper.*;

@Epic("Regression Tests")
@Feature("Register")
public class RW_REGISTER_TC002 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 1,
            description = "Verify that user cannot create new account using Email that has been registered",
            dataProvider = "getDataForTest")
    @Story("Create new account using Email that has been registered")
    public void REGISTER_TC002(Hashtable<String, String> data) {

        startTestCase("RAILWAY_REGISTER_TC002");

        info("Random data for Username, Password and PID");
        String password = getRandomPassword();
        String PID = getRandomPID();

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        info("Step #3: Input a registered email in the Email field and Input valid data for all other field");
        registerPage.registerAccount(data.get("username"), password, password, PID);

        String actualRegisterErrorMsg = registerPage.getRegisterErrorLabel();
        String expectedRegisterErrorMsg = data.get("message");

        info("Step #4: Verify that User cannot register new account");
        Assert.assertEquals(actualRegisterErrorMsg, expectedRegisterErrorMsg);
    }

}
