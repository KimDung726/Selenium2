package page;

import control.*;
import io.qameta.allure.Step;
import utility.Constants;

public class RegisterPage extends BasePage {

    TextBox PIDTxt = new TextBox("id=pid");
    TextBox emailTxt = new TextBox("id=email");
    TextBox passwordTxt = new TextBox("id=password");
    TextBox confirmPasswordTxt = new TextBox("id=confirmPassword");
    Link registerErrorLabel = new Link("css=p.message.error");
    Link registerTitleLabel = new Link("css=#content h1");
    Button registerBtn = new Button("css=input[value='Register'][type='submit']");

    @Step("Register account")
    public void registerAccount(String strEmail, String strPassword, String strConfirmPassword, String strPID) {
        emailTxt.enter(strEmail);
        passwordTxt.enter(strPassword);
        confirmPasswordTxt.enter(strConfirmPassword);
        PIDTxt.enter(strPID);
        clickOnRegisterBtn();
    }

    public void clickOnRegisterBtn() {
        registerBtn.scrollToElement();
        registerBtn.waitToBeClickable();
        registerBtn.click();
    }

    @Step("Click on the Register tab")
    public void selectOnRegisterTab() {
        selectOnTab(Constants.REGISTER_TAB);
    }

    @Step("VP: Title of Register page displayed")
    public String getRegisterPageTitle() {
        registerTitleLabel.waitForDisplay();
        return registerTitleLabel.getText();
    }

    @Step("VP: Error message displayed")
    public String getRegisterErrorLabel() {
        registerErrorLabel.waitForDisplay();
        return registerErrorLabel.getText();
    }
}
