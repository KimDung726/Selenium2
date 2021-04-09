package page;

import control.*;
import io.qameta.allure.Step;
import utility.Constants;

public class LoginPage extends BasePage {
    TextBox usernameTxt = new TextBox("id=username");
    TextBox passwordTxt = new TextBox("id=password");
    Button loginBtn = new Button("css=.form-actions input");
    Link loginErrorLabel = new Link("css=p.message.error.LoginForm");
    Link loginTitleLabel = new Link("css=#content h1");

    @Step("Login with account: Email [{0}], Password [{1}]")
    public void login(String strEmail, String strPwd) {
        usernameTxt.enter(strEmail);
        passwordTxt.enter(strPwd);
        clickOnLoginBtn();
    }

    public void clickOnLoginBtn() {
        loginBtn.waitToBeClickable();
        loginBtn.click();
    }

    @Step("Click on the Login tab")
    public void selectOnLoginTab() {
        selectOnTab(Constants.LOGIN_TAB);
    }

    public void loginSeveralTimes(String strEmail, String strPwd, int time) {
        for (int i = 0; i <= time; i++) {
            selectOnLoginTab();
            login(strEmail, strPwd);
        }
    }

    public String getLoginError() {
        loginErrorLabel.waitForDisplay();
        return loginErrorLabel.getText();
    }

    @Step("VP: Title of Login page displayed")
    public String getTitleLoginPage() {
        loginTitleLabel.waitForDisplay();
        return loginTitleLabel.getText();
    }
}
