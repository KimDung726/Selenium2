package testcase.Register;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.RegisterPage;
import testcase.BaseTest;
import testcase.TestListener;
import utility.*;

import static utility.Log.*;
import static utility.helper.DataHelper.*;

@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Register tests")
public class RW_REGISTER_TC002 extends BaseTest {

    RegisterPage registerPage = new RegisterPage();

    @Test(priority = 1, description = "Verify that user cannot create new account using Email that has been registered")
    @Story("Create new account using Email that has been registered")
    public void TC001() {

        startTestCase("RAILWAY_REGISTER_TC001");

        info("Random data for Username, Password and PID");
        String password = getRandomPassword();
        String PID = getRandomPID();

        info("Step #1 + #2: Navigate to Railway Page and Click on the Register tab");
        registerPage.selectOnRegisterTab();

        info("Step #3: Input a registered email in the Email field and Input valid data for all other field");
        registerPage.registerAccount(Constants.VALID_EMAIL, password, password, PID);

        String actualRegisterErrorMsg = registerPage.getRegisterErrorLabel();
        String expectedRegisterErrorMsg = Messages.EMAIL_HAS_BEEN_REGISTERED;

        info("Step #4: Verify that User cannot register new account");
        Assert.assertEquals(actualRegisterErrorMsg, expectedRegisterErrorMsg);
    }

}