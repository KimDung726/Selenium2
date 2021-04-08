package page;

import control.*;
import utility.Constants;

public class RegisterPage extends BasePage {

    TextBox PIDTxt = new TextBox("id=pid");
    TextBox emailTxt = new TextBox("id=email");
    TextBox passwordTxt = new TextBox("id=password");
    TextBox confirmPasswordTxt = new TextBox("id=confirmPassword");
    Link registrationConfirmedLabel = new Link("css=div#content>p");
    Link PIDErrorLabel = new Link("css=label.validation-error[for='pid']");
    Link passwordErrorLabel = new Link("css=label.validation-error[for='password']");
    Button registerBtn = new Button("css=input[value='Register'][type='submit']");

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

    public void selectOnRegisterTab() {
        selectOnTab(Constants.REGISTER_TAB);
    }

    public String getRegistrationConfirmedText() {
        registrationConfirmedLabel.waitForDisplay();
        return registrationConfirmedLabel.getText();
    }
}
