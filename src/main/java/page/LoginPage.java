package page;

import control.*;

public class LoginPage {
    TextBox usernameTxt = new TextBox("id=username");
    TextBox passwordTxt = new TextBox("id=password");
    Button loginBtn = new Button("css=.form-actions input");

    public void login(String username, String password) {
        usernameTxt.enter(username);
        passwordTxt.enter(password);
        clickOnLoginBtn();
    }

    public void clickOnLoginBtn() {
        loginBtn.waitToBeClickable();
        loginBtn.click();
    }

}
