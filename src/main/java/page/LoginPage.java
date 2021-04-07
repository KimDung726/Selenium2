package page;

import control.*;

public class LoginPage {
    TextBox usernameTxt = new TextBox("#username");
    TextBox passwordTxt = new TextBox("#password");
    Button loginBtn = new Button(".form-actions input");

    public void login(String username, String password) {
        usernameTxt.enter(username);
        usernameTxt.waitForDisplay();
        passwordTxt.enter(password);
        passwordTxt.waitForDisplay();
        clickBtnLogin();
    }

    public void clickBtnLogin() {
        loginBtn.waitForVisibility();
        loginBtn.click();
    }

}
