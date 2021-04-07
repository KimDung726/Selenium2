package page;

import control.*;
import utility.Constants;

public class LoginPage extends BasePage {
    TextBox usernameTxt = new TextBox("id=username");
    TextBox passwordTxt = new TextBox("id=password");
    Button loginBtn = new Button("css=.form-actions input");
    Link loginErrorLabel = new Link("css=p.message.error.LoginForm");
    Link welcomeMessageLink = new Link("css=#banner .account>strong");

    public void login(String strEmail, String strPwd) {
        usernameTxt.enter(strEmail);
        passwordTxt.enter(strPwd);
        clickOnLoginBtn();
    }

    public void clickOnLoginBtn() {
        loginBtn.waitToBeClickable();
        loginBtn.click();
    }

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

    public String getWelcomeMessage() {
        welcomeMessageLink.waitForDisplay();
        return welcomeMessageLink.getText();
    }
}
