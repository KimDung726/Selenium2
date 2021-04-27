package com.tikivn.page;

import com.tikivn.control.Button;
import com.tikivn.control.TextBox;
import io.qameta.allure.Step;

public class HomePage extends BasePage {
    TextBox searchFieldTxt = new TextBox("css=.FormSearch__Form-sc-1fwg3wo-1.gUJHDL input");
    Button searchBtn = new Button("css=.FormSearch__Form-sc-1fwg3wo-1.gUJHDL button");

    @Step("VP: 'Tìm sản phẩm...' textbox is displayed")
    public boolean isSearchFieldTxtDisplayed() {
        return searchFieldTxt.isVisible();
    }

    @Step("VP: 'Tim kiem' button is displayed")
    public boolean isSearchBtnDisplayed() {
        return searchBtn.isVisible();
    }

    @Step("Enter value in 'Tìm sản phẩm...' textbox")
    public void enterSearchFieldTxt(String value) {
        searchFieldTxt.enter(value);
    }

    @Step("Click 'Tìm kiếm' button")
    public void clickOnSearchBtn() {
        searchBtn.click();
    }
}
