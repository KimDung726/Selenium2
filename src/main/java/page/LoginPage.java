package page;

import control.*;
import io.qameta.allure.Step;
import utility.Constants;

public class LoginPage extends BasePage {
    TextBox usernameTxt = new TextBox("id=username");
    TextBox passwordTxt = new TextBox("id=password");
    Button loginBtn = new Button("css=.form-actions input");
    Link loginTitleLabel = new Link("css=#content h1");
    Link registrationPageLink = new Link("css=div#content ul li a[href*=Register]");

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

    @Step("Click on the hyperlink text \"registration page\"")
    public void clickOnRegistrationPageLink() {
        registrationPageLink.waitToBeClickable();
        registrationPageLink.click();
    }

    @Step("Click on the Login tab")
    public void selectOnLoginTab() {
        selectOnTab(Constants.LOGIN_TAB);
    }

    @Step("VP: Title of Login page displayed")
    public String getLoginTitlePage() {
        loginTitleLabel.waitForDisplay();
        return loginTitleLabel.getText();
    }
}
