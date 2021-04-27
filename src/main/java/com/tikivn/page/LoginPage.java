package com.tikivn.page;

import com.tikivn.control.Button;
import com.tikivn.control.Link;
import com.tikivn.control.TextBox;
import com.tikivn.utility.Constants;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {
    TextBox usernameTxt = new TextBox("id=username");
    TextBox passwordTxt = new TextBox("id=password");
    Button loginBtn = new Button("css=.form-actions input");
    Link loginTitleLabel = new Link("css=#content h1");
    Link registrationPageLink = new Link("css=div#content ul li a[href*=Register]");

    @Step("Login with account")
    public void login(String strEmail, String strPwd) {
        usernameTxt.enter(strEmail);
        passwordTxt.enter(strPwd);
        clickOnLoginBtn();
    }

    public void clickOnLoginBtn() {
        loginBtn.waitToBeClickable();
        loginBtn.click();
    }

    @Step("Click on the hyperlink text 'registration page'")
    public void clickOnRegistrationPageLink() {
        registrationPageLink.waitToBeClickable();
        registrationPageLink.click();
    }

    @Step("Click on the Login tab")
    public void selectOnLoginTab() {
        selectOnTab(Constants.LOGIN_TAB);
    }

    @Step("VP: Title of Login page displayed")
    public String getLoginPageTitle() {
        loginTitleLabel.waitForDisplay();
        return loginTitleLabel.getText();
    }
}
